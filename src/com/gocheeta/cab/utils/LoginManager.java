package com.gocheeta.cab.utils;

import com.gocheeta.cab.patterns.AdministratorLoginDao;
import com.gocheeta.cab.patterns.DriverLoginDao;
import com.gocheeta.cab.patterns.LoginDao;

public class LoginManager {
	
	public static LoginDao factory(String type){
        if(type.equals("Driver")){
            
            return new DriverLoginDao();
            
        }else if(type.equals("Administration")){
            
            return new AdministratorLoginDao();
            
        }else{
            /**
             * It would be more appropriate to throw a custom exception here
             */
            throw new RuntimeException("No login type found");
        }
    }

}
