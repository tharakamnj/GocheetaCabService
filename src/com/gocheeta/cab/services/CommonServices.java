package com.gocheeta.cab.services;

import javax.sql.DataSource;


import com.gocheeta.cab.dao.CommonDao;
import com.gocheeta.cab.entities.NumberFomart;


public class CommonServices {
	
	
	public static String getNumberFormat(DataSource dataSource, String tableName) {
			
		NumberFomart numberFormat = CommonDao.getNumberFormat(dataSource,tableName);
		int numberPart = numberFormat.getNumberPart();
		String prefix = numberFormat.getPrefix();
		String RetVal = prefix + (String.format("%05d" , ++numberPart));
			 
		
		return RetVal;
	}

	
	public static void setNumberFormat(DataSource dataSource, String tableName ) {
		
		NumberFomart numberFormat = CommonDao.getNumberFormat(dataSource,tableName);
		int numberPart = numberFormat.getNumberPart();
		
		CommonDao.setNumberFormat(dataSource,tableName,++numberPart );
		
	}
	
	
		

}
