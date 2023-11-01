package com.dbcp.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CM_ConvertHelper {
	static public Date toDate(String data) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(data);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	static public Date toTimeDate(String data) {

		SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = inputFormat.parse(data);
			String formattedDate = outputFormat.format(date);
			Date kDate = outputFormat.parse(formattedDate);
			return kDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	static public Date toEDate(Date date) {
		try {
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formatDate = outputFormat.format(date);
			Date kDate = outputFormat.parse(formatDate);
			return kDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	static public String toString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	static public String toTimeString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	static public Date forStamp(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}
}
