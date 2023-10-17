package com.dbcp;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class CM_DBCPInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	
	// 프로퍼티 생성
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
		Properties prop = new Properties();
		try {
			prop.load(new StringReader(poolConfig));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		loadJDBCDriver(prop);
		initConnectionPool(prop);
	}
	
	private void loadJDBCDriver(Properties prop) {
		// xml에 등록한 파라미터를 갖고온다. 드라이버 생성
		String driverClass = prop.getProperty("jdbcdriver");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail jdbc driver");
		}
	}

	private void initConnectionPool(Properties prop) {
		try {
			String jdbcUrl = prop.getProperty("jdbcUrl");
			String username = prop.getProperty("dbUser");
			String pw = prop.getProperty("dbPass");

			// 커넥션 풀이 새로운 커넥션을 생성할 때 사용할 커넥션 팩토리를 생성한다. DB에 연결힐 때 사용할 JDBC URL id pw 를 생성자로
			// 지정한다
			ConnectionFactory connFac = new DriverManagerConnectionFactory(jdbcUrl, username, pw);
			// PoolableConnection을 생성하는 팩토리를 생성한다. DBCP는 커넥션 풀에 커넥션을 보관할 때
			// PoolableConnection을 사용한다. 이클래스는 내부적으로
			// 실제 커넥션을 담고 있으며 커넥션 풀을 관리하는데 필요한 기능을 추가로 제공한다.
			PoolableConnectionFactory poolableConnFac = new PoolableConnectionFactory(connFac, null);
			// 커넥션이 유효한지 여부를 검사할때 사용할 쿼리를 지정한다.
			poolableConnFac.setValidationQuery("select 1");

			// 커넥션 풀의 설정정보를 생성한다.
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			// 유효 커넥션 검사주기
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			// 풀에 보관중인 커넥션이 유휴한지 검사할지 여부
			poolConfig.setTestWhileIdle(true);
			// 커넥션 최소 개수
			poolConfig.setMinIdle(4);
			// 커넥션 최대 개수
			poolConfig.setMaxTotal(50);
			// 커넥션 풀을 생성한다. 생성자는 PoolableConnection을 생성할 때 사용할 팩토리와 커넥션 풀 설정을 파라미터로 전달받는다.
			GenericObjectPool<PoolableConnection> connecPool = new GenericObjectPool<>(poolableConnFac, poolConfig);
			// poolavbleConnectionFactory 에도 생성한 커넥션 풀을 연결한다.
			poolableConnFac.setPool(connecPool);

			// 커넥션 풀을 제공하는 JDBC 드라이버를 등록한다.
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			
			String poolName = prop.getProperty("poolName");
			// 커넥션 풀 드라이버에 생성한 커넥션 풀을 등록한다. 이름을 정해주고 이 경우 프로그램에서 사용할 이름을 드라이버 마지막에 붙힌다.
			driver.registerPool(poolName, connecPool);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

}
