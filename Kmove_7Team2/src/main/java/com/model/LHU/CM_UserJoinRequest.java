package com.model.LHU;

import java.util.Map;

public class CM_UserJoinRequest {
	
		private String emp_no;
		private String password;
		private String confirmPassword;
		
		public String getEmp_no() {
			return emp_no;
		}
		public void setEmp_no(String emp_no) {
			this.emp_no = emp_no;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		public boolean isPasswordEqualToConfirm() {
			return password != null && password.equals(confirmPassword);	
		}
		
		public void validate(Map<String, Boolean> errors) {
			checkEmpty(errors, emp_no, "emp_no");
			checkEmpty(errors, password, "password");
			checkEmpty(errors, confirmPassword, "confirmPassword");
			if (!errors.containsKey("confirmPassword")) {
				if(!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
				}
			
			}
		}
		
		private void checkEmpty(Map<String, Boolean> errors,
				String value, String fieldName) {
			if(value == null || value.isEmpty())
				errors.put(fieldName, Boolean.TRUE);
		}

}
