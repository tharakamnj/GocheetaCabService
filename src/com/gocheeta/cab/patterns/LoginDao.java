package com.gocheeta.cab.patterns;

import javax.sql.DataSource;

public interface LoginDao {
	
	public int verify(DataSource dataSource,String UserName , String password);
}
