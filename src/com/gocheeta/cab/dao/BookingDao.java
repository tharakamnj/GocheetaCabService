package com.gocheeta.cab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.gocheeta.cab.entities.Booking;
import com.gocheeta.cab.utils.CustomException;


public class BookingDao {
	
	
	public static List<Booking> getCheckBooking(DataSource dataSource,String bookingStatus,String driverId){
		 
		List<Booking> bookings = new ArrayList<Booking>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  booking.bookingID,booking.DriverID,booking.customerID,booking.vehicleCategoryID, \r\n"
					+ "sourceLocation ,destinationationLocation,pickupTime,dropTime,bookingStatusNew,bookingDateNew,\r\n"
					+ "(select street_Name from street where street_Id = sourceLocation) as source,\r\n"
					+ "(select street_Name from street where street_Id = destinationationLocation) as destinationation,\r\n"
					+ "\r\n"
					+ "city.cityName,\r\n"
					+ "driver.driverName,driver.vehicleNoNew,driver.phoneNoNw as driverPhoneNo,\r\n"
					+ "vehicle_category.vehicleType,\r\n"
					+ "customer.customerName,customer.phoneNoNw,customer.email,vehicle_category.serviceCharge,vehicle_category.chargePerKm,"
					+ "payment.chargesCalculated, payment.kmCovered \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID "
					+ "left JOIN payment on booking.bookingID = payment.bookingID \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew=? and booking.DriverID =?"
					+ "ORDER BY bookingDateNew DESC";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookingStatus);
			
			stmt.setString(2, driverId);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String bookingID = rset.getString(1);
				String DriverID = rset.getString(2);
				String customerID = rset.getString(3);
				String vehicleCategoryID = rset.getString(4);
				String cityID = "";
				String sourceLocation = rset.getString(5);
				String destinationationLocation = rset.getString(6);
				String pickupTime = rset.getString(7);
				String dropTime = rset.getString(8);
				String bookingStatusNew = rset.getString(9);
			
				java.sql.Date bookingDateNew = rset.getDate(10);
				
				
			
				String source = rset.getString(11);
				String destinationation = rset.getString(12);
				String cityName = rset.getString(13);
				String driverName = rset.getString(14);
				String vehicleNoNew = rset.getString(15);
				String driverPhoneNo = rset.getString(16);
				String vehicleType = rset.getString(17);
				String customerName = rset.getString(18);
				String phoneNoNw = rset.getString(19);
				String email = rset.getString(20);
				Double serviceCharge = rset.getDouble(21);
				Double chargePerKm = rset.getDouble(22);
				Double chargesCalculated = rset.getDouble(23);
				Double kmCovered = rset.getDouble(24);
				
				
				
				Booking booking = new Booking(bookingID,DriverID,customerID,sourceLocation,
						 destinationationLocation,pickupTime,dropTime,bookingStatusNew,
						 vehicleCategoryID,bookingDateNew,cityID,
						 source,destinationation,cityName,driverName,vehicleNoNew,
						 driverPhoneNo,vehicleType,customerName,phoneNoNw,email,serviceCharge,chargePerKm,
						 chargesCalculated,kmCovered);
				bookings.add(booking);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return bookings;
}
	
	public static List<Booking> getCheckBooking(DataSource dataSource,String bookingStatus){
		 
		List<Booking> bookings = new ArrayList<Booking>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  booking.bookingID,booking.DriverID,booking.customerID,booking.vehicleCategoryID, \r\n"
					+ "sourceLocation ,destinationationLocation,pickupTime,dropTime,bookingStatusNew,bookingDateNew,\r\n"
					+ "(select street_Name from street where street_Id = sourceLocation) as source,\r\n"
					+ "(select street_Name from street where street_Id = destinationationLocation) as destinationation,\r\n"
					+ "\r\n"
					+ "city.cityName,\r\n"
					+ "driver.driverName,driver.vehicleNoNew,driver.phoneNoNw as driverPhoneNo,\r\n"
					+ "vehicle_category.vehicleType,\r\n"
					+ "customer.customerName,customer.phoneNoNw,customer.email,vehicle_category.serviceCharge,vehicle_category.chargePerKm,"
					+ "payment.chargesCalculated, payment.kmCovered \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID "
					+ "inner JOIN payment on payment.bookingID = booking.bookingID  \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew=?"
					+ "ORDER BY bookingDateNew DESC";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookingStatus);
		
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String bookingID = rset.getString(1);
				String DriverID = rset.getString(2);
				String customerID = rset.getString(3);
				String vehicleCategoryID = rset.getString(4);
				String cityID = "";
				String sourceLocation = rset.getString(5);
				String destinationationLocation = rset.getString(6);
				String pickupTime = rset.getString(7);
				String dropTime = rset.getString(8);
				String bookingStatusNew = rset.getString(9);
			
				java.sql.Date bookingDateNew = rset.getDate(10);
				
				
			
				String source = rset.getString(11);
				String destinationation = rset.getString(12);
				String cityName = rset.getString(13);
				String driverName = rset.getString(14);
				String vehicleNoNew = rset.getString(15);
				String driverPhoneNo = rset.getString(16);
				String vehicleType = rset.getString(17);
				String customerName = rset.getString(18);
				String phoneNoNw = rset.getString(19);
				String email = rset.getString(20);
				Double serviceCharge = rset.getDouble(21);
				Double chargePerKm = rset.getDouble(22);
				Double chargesCalculated = rset.getDouble(23);
				Double kmCovered = rset.getDouble(24);
				
				
				
				Booking booking = new Booking(bookingID,DriverID,customerID,sourceLocation,
						 destinationationLocation,pickupTime,dropTime,bookingStatusNew,
						 vehicleCategoryID,bookingDateNew,cityID,
						 source,destinationation,cityName,driverName,vehicleNoNew,
						 driverPhoneNo,vehicleType,customerName,phoneNoNw,email,serviceCharge,chargePerKm,
						 chargesCalculated,kmCovered);
				bookings.add(booking);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return bookings;
}
	
	public static List<Booking> getAllBooking(DataSource dataSource,String bookingStatus,String branch,String bookingDate){
		 
		List<Booking> bookings = new ArrayList<Booking>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  booking.bookingID,booking.DriverID,booking.customerID,booking.vehicleCategoryID, \r\n"
					+ "sourceLocation ,destinationationLocation,pickupTime,dropTime,bookingStatusNew,bookingDateNew,\r\n"
					+ "(select street_Name from street where street_Id = sourceLocation) as source,\r\n"
					+ "(select street_Name from street where street_Id = destinationationLocation) as destinationation,\r\n"
					+ "\r\n"
					+ "city.cityName,\r\n"
					+ "driver.driverName,driver.vehicleNoNew,driver.phoneNoNw as driverPhoneNo,\r\n"
					+ "vehicle_category.vehicleType,\r\n"
					+ "customer.customerName,customer.phoneNoNw,customer.email,vehicle_category.serviceCharge,vehicle_category.chargePerKm,"
					+ "payment.chargesCalculated, payment.kmCovered \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID "
					+ "inner JOIN payment on payment.bookingID = booking.bookingID  \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew=? and driver.branch_Id =? and bookingDateNew=?"
					+ "ORDER BY bookingDateNew DESC";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookingStatus);
			stmt.setString(2, branch);
			stmt.setString(3, bookingDate);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String bookingID = rset.getString(1);
				String DriverID = rset.getString(2);
				String customerID = rset.getString(3);
				String vehicleCategoryID = rset.getString(4);
				String cityID = "";
				String sourceLocation = rset.getString(5);
				String destinationationLocation = rset.getString(6);
				String pickupTime = rset.getString(7);
				String dropTime = rset.getString(8);
				String bookingStatusNew = rset.getString(9);
			
				java.sql.Date bookingDateNew = rset.getDate(10);
				
				
			
				String source = rset.getString(11);
				String destinationation = rset.getString(12);
				String cityName = rset.getString(13);
				String driverName = rset.getString(14);
				String vehicleNoNew = rset.getString(15);
				String driverPhoneNo = rset.getString(16);
				String vehicleType = rset.getString(17);
				String customerName = rset.getString(18);
				String phoneNoNw = rset.getString(19);
				String email = rset.getString(20);
				Double serviceCharge = rset.getDouble(21);
				Double chargePerKm = rset.getDouble(22);
				Double chargesCalculated = rset.getDouble(23);
				Double kmCovered = rset.getDouble(24);
				
				
				
				Booking booking = new Booking(bookingID,DriverID,customerID,sourceLocation,
						 destinationationLocation,pickupTime,dropTime,bookingStatusNew,
						 vehicleCategoryID,bookingDateNew,cityID,
						 source,destinationation,cityName,driverName,vehicleNoNew,
						 driverPhoneNo,vehicleType,customerName,phoneNoNw,email,serviceCharge,chargePerKm,
						 chargesCalculated,kmCovered);
				bookings.add(booking);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return bookings;
}

	public static Double getAllBookingTotal(DataSource dataSource,String bookingStatus,String branch,String bookingDate){
		 
		
		Double Total=0.0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  "
					+"sum(payment.chargesCalculated) \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID "
					+ "inner JOIN payment on payment.bookingID = booking.bookingID  \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew=? and driver.branch_Id =? and bookingDateNew=?";
				
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookingStatus);
			stmt.setString(2, branch);
			stmt.setString(3, bookingDate);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				Total = rset.getDouble(1);
				
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return Total;
}
	
	public static List<Booking> getDriverBooking(DataSource dataSource,String bookingStatus,String driverId,String bookingDate){
		 
		List<Booking> bookings = new ArrayList<Booking>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  booking.bookingID,booking.DriverID,booking.customerID,booking.vehicleCategoryID, \r\n"
					+ "sourceLocation ,destinationationLocation,pickupTime,dropTime,bookingStatusNew,bookingDateNew,\r\n"
					+ "(select street_Name from street where street_Id = sourceLocation) as source,\r\n"
					+ "(select street_Name from street where street_Id = destinationationLocation) as destinationation,\r\n"
					+ "\r\n"
					+ "city.cityName,\r\n"
					+ "driver.driverName,driver.vehicleNoNew,driver.phoneNoNw as driverPhoneNo,\r\n"
					+ "vehicle_category.vehicleType,\r\n"
					+ "customer.customerName,customer.phoneNoNw,customer.email,vehicle_category.serviceCharge,vehicle_category.chargePerKm,"
					+ "payment.chargesCalculated, payment.kmCovered \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID "
					+ "inner JOIN payment on payment.bookingID = booking.bookingID  \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew=? and booking.DriverID =? and bookingDateNew=?"
					+ "ORDER BY bookingDateNew DESC";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookingStatus);
			stmt.setString(2, driverId);
			stmt.setString(3, bookingDate);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String bookingID = rset.getString(1);
				String DriverID = rset.getString(2);
				String customerID = rset.getString(3);
				String vehicleCategoryID = rset.getString(4);
				String cityID = "";
				String sourceLocation = rset.getString(5);
				String destinationationLocation = rset.getString(6);
				String pickupTime = rset.getString(7);
				String dropTime = rset.getString(8);
				String bookingStatusNew = rset.getString(9);
			
				java.sql.Date bookingDateNew = rset.getDate(10);
				
				
			
				String source = rset.getString(11);
				String destinationation = rset.getString(12);
				String cityName = rset.getString(13);
				String driverName = rset.getString(14);
				String vehicleNoNew = rset.getString(15);
				String driverPhoneNo = rset.getString(16);
				String vehicleType = rset.getString(17);
				String customerName = rset.getString(18);
				String phoneNoNw = rset.getString(19);
				String email = rset.getString(20);
				Double serviceCharge = rset.getDouble(21);
				Double chargePerKm = rset.getDouble(22);
				Double chargesCalculated = rset.getDouble(23);
				Double kmCovered = rset.getDouble(24);
				
				
				
				Booking booking = new Booking(bookingID,DriverID,customerID,sourceLocation,
						 destinationationLocation,pickupTime,dropTime,bookingStatusNew,
						 vehicleCategoryID,bookingDateNew,cityID,
						 source,destinationation,cityName,driverName,vehicleNoNew,
						 driverPhoneNo,vehicleType,customerName,phoneNoNw,email,serviceCharge,chargePerKm,
						 chargesCalculated,kmCovered);
				bookings.add(booking);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return bookings;
}

	public static Double getDriverBookingTotal(DataSource dataSource,String bookingStatus,String driverId,String bookingDate){
		 
		
		Double Total=0.0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  "
					+"sum(payment.chargesCalculated) \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID "
					+ "inner JOIN payment on payment.bookingID = booking.bookingID  \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew=? and booking.DriverID =? and bookingDateNew=?";
				
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookingStatus);
			stmt.setString(2, driverId);
			stmt.setString(3, bookingDate);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				Total = rset.getDouble(1);
				
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return Total;
}
	
	public static Double getDriverTotal(DataSource dataSource,String bookingStatus,String driverId){
		 
		
		Double Total=0.0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  "
					+"sum(payment.chargesCalculated) \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID "
					+ "inner JOIN payment on payment.bookingID = booking.bookingID  \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew=? and booking.DriverID =?";
				
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookingStatus);
			stmt.setString(2, driverId);
			
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				Total = rset.getDouble(1);
				
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return Total;
}
	
	
	public static Double getBookingTotal(DataSource dataSource,String bookingStatus){
			 
			
			Double Total=0.0;
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rset  = null;
			String sql = null;
			
			try {
				con = dataSource.getConnection();
				sql= "SELECT  "
						+"sum(payment.chargesCalculated) \r\n"
						+ "FROM booking \r\n"
						+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
						+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
						+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID "
						+ "inner JOIN payment on payment.bookingID = booking.bookingID  \r\n"
						+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew=? ";
					
				stmt = con.prepareStatement(sql);
				stmt.setString(1, bookingStatus);
				
				rset= stmt.executeQuery();
				
				while(rset.next()) {
					Total = rset.getDouble(1);
					
					
				}	
				
			} catch (Exception e) {
				throw new CustomException(e.getMessage());
			}finally {
				
				close(con,stmt,null);
			}
			
			return Total;
	}

	
	
	public static Booking bookingList(DataSource dataSource,String bookingId){
		 
		Booking bookings = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  bookingID,booking.DriverID,booking.customerID,booking.vehicleCategoryID, \r\n"
					+ "sourceLocation ,destinationationLocation,pickupTime,dropTime,bookingStatusNew,bookingDateNew,\r\n"
					+ "(select street_Name from street where street_Id = sourceLocation) as source,\r\n"
					+ "(select street_Name from street where street_Id = destinationationLocation) as destinationation,\r\n"
					+ "\r\n"
					+ "city.cityName,\r\n"
					+ "driver.driverName,driver.vehicleNoNew,driver.phoneNoNw as driverPhoneNo,\r\n"
					+ "vehicle_category.vehicleType,\r\n"
					+ "customer.customerName,customer.phoneNoNw,customer.email,vehicle_category.serviceCharge,vehicle_category.chargePerKm \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingID=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookingId);
			
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String bookingID = rset.getString(1);
				String DriverID = rset.getString(2);
				String customerID = rset.getString(3);
				String vehicleCategoryID = rset.getString(4);
				String cityID = "";
				String sourceLocation = rset.getString(5);
				String destinationationLocation = rset.getString(6);
				String pickupTime = rset.getString(7);
				String dropTime = rset.getString(8);
				String bookingStatusNew = rset.getString(9);
			
				java.sql.Date bookingDateNew = rset.getDate(10);
				
				
			
				String source = rset.getString(11);
				String destinationation = rset.getString(12);
				String cityName = rset.getString(13);
				String driverName = rset.getString(14);
				String vehicleNoNew = rset.getString(15);
				String driverPhoneNo = rset.getString(16);
				String vehicleType = rset.getString(17);
				String customerName = rset.getString(18);
				String phoneNoNw = rset.getString(19);
				String email = rset.getString(20);
				Double serviceCharge = rset.getDouble(21);
				Double chargePerKm = rset.getDouble(22);
				
				
				
				 bookings = new Booking(bookingID,DriverID,customerID,sourceLocation,
						 destinationationLocation,pickupTime,dropTime,bookingStatusNew,
						 vehicleCategoryID,bookingDateNew,cityID,
						 source,destinationation,cityName,driverName,vehicleNoNew,
						 driverPhoneNo,vehicleType,customerName,phoneNoNw,email,serviceCharge,chargePerKm
						);
				
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return bookings;
}
	
	public static List<Booking> getOnGoingBooking(DataSource dataSource,String driverId){
		 
		List<Booking> bookings = new ArrayList<Booking>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  bookingID,booking.DriverID,booking.customerID,booking.vehicleCategoryID, \r\n"
					+ "sourceLocation ,destinationationLocation,pickupTime,dropTime,bookingStatusNew,bookingDateNew,\r\n"
					+ "(select street_Name from street where street_Id = sourceLocation) as source,\r\n"
					+ "(select street_Name from street where street_Id = destinationationLocation) as destinationation,\r\n"
					+ "\r\n"
					+ "city.cityName,\r\n"
					+ "driver.driverName,driver.vehicleNoNew,driver.phoneNoNw as driverPhoneNo,\r\n"
					+ "vehicle_category.vehicleType,\r\n"
					+ "customer.customerName,customer.phoneNoNw,customer.email,vehicle_category.serviceCharge,vehicle_category.chargePerKm \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew !='Pending' and bookingStatusNew !='Rejected' and bookingStatusNew !='Completed' and booking.DriverID =?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, driverId);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String bookingID = rset.getString(1);
				String DriverID = rset.getString(2);
				String customerID = rset.getString(3);
				String vehicleCategoryID = rset.getString(4);
				String cityID = "";
				String sourceLocation = rset.getString(5);
				String destinationationLocation = rset.getString(6);
				String pickupTime = rset.getString(7);
				String dropTime = rset.getString(8);
				String bookingStatusNew = rset.getString(9);
			
				java.sql.Date bookingDateNew = rset.getDate(10);
				
				
			
				String source = rset.getString(11);
				String destinationation = rset.getString(12);
				String cityName = rset.getString(13);
				String driverName = rset.getString(14);
				String vehicleNoNew = rset.getString(15);
				String driverPhoneNo = rset.getString(16);
				String vehicleType = rset.getString(17);
				String customerName = rset.getString(18);
				String phoneNoNw = rset.getString(19);
				String email = rset.getString(20);
				Double serviceCharge = rset.getDouble(21);
				Double chargePerKm = rset.getDouble(22);
				
				
				Booking booking = new Booking(bookingID,DriverID,customerID,sourceLocation,
						 destinationationLocation,pickupTime,dropTime,bookingStatusNew,
						 vehicleCategoryID,bookingDateNew,cityID,
						 source,destinationation,cityName,driverName,vehicleNoNew,
						 driverPhoneNo,vehicleType,customerName,phoneNoNw,email,serviceCharge,chargePerKm
						);
				bookings.add(booking);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return bookings;
}

	public static List<Booking> getPendingBooking(DataSource dataSource,String bookingStatus,String vehiclecategoryId, String cityId){
		 
		List<Booking> bookings = new ArrayList<Booking>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT  booking.bookingID,booking.DriverID,booking.customerID,booking.vehicleCategoryID, \r\n"
					+ "sourceLocation ,destinationationLocation,pickupTime,dropTime,bookingStatusNew,bookingDateNew,\r\n"
					+ "(select street_Name from street where street_Id = sourceLocation) as source,\r\n"
					+ "(select street_Name from street where street_Id = destinationationLocation) as destinationation,\r\n"
					+ "\r\n"
					+ "city.cityName,\r\n"
					+ "driver.driverName,driver.vehicleNoNew,driver.phoneNoNw as driverPhoneNo,\r\n"
					+ "vehicle_category.vehicleType,\r\n"
					+ "customer.customerName,customer.phoneNoNw,customer.email,vehicle_category.serviceCharge,vehicle_category.chargePerKm,"
					+ "payment.chargesCalculated, payment.kmCovered,booking.cityID \r\n"
					+ "FROM booking \r\n"
					+ "INNER JOIN city on city.cityID = booking.cityID \r\n"
					+ "inner JOIN customer on booking.customerID=customer.customerID\r\n"
					+ "inner JOIN vehicle_category on booking.vehicleCategoryID=vehicle_category.vehicleCategoryID "
					+ "left JOIN payment on booking.bookingID = payment.bookingID  \r\n"
					+ "left JOIN driver on booking.DriverID=driver.DriverID where bookingStatusNew=? and vehicle_category.vehicleCategoryID =? and booking.cityID=? "
					+ "ORDER BY bookingDateNew   and booking.bookingID  asc";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, bookingStatus);
			stmt.setString(2, vehiclecategoryId);
			stmt.setString(3, cityId);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				String bookingID = rset.getString(1);
				String DriverID = rset.getString(2);
				String customerID = rset.getString(3);
				String vehicleCategoryID = rset.getString(4);
				
				String sourceLocation = rset.getString(5);
				String destinationationLocation = rset.getString(6);
				String pickupTime = rset.getString(7);
				String dropTime = rset.getString(8);
				String bookingStatusNew = rset.getString(9);
			
				java.sql.Date bookingDateNew = rset.getDate(10);
				
				
			
				String source = rset.getString(11);
				String destinationation = rset.getString(12);
				String cityName = rset.getString(13);
				String driverName = rset.getString(14);
				String vehicleNoNew = rset.getString(15);
				String driverPhoneNo = rset.getString(16);
				String vehicleType = rset.getString(17);
				String customerName = rset.getString(18);
				String phoneNoNw = rset.getString(19);
				String email = rset.getString(20);
				Double serviceCharge = rset.getDouble(21);
				Double chargePerKm = rset.getDouble(22);
				Double chargesCalculated = rset.getDouble(23);
				Double kmCovered = rset.getDouble(24);
				String cityID = rset.getString(25);
				
				
				Booking booking = new Booking(bookingID,DriverID,customerID,sourceLocation,
						 destinationationLocation,pickupTime,dropTime,bookingStatusNew,
						 vehicleCategoryID,bookingDateNew,cityID,
						 source,destinationation,cityName,driverName,vehicleNoNew,
						 driverPhoneNo,vehicleType,customerName,phoneNoNw,email,serviceCharge,chargePerKm,
						 chargesCalculated,kmCovered);
				bookings.add(booking);
				
			}	
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
			close(con,stmt,null);
		}
		
		return bookings;
}
	
	public static int checkPendingBooking(DataSource dataSource, String driverId) {
			
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rset  = null;
			String sql = null;
			int returnVal = 0;
			
			try {
				con = dataSource.getConnection();
				sql= "select * from Booking where  DriverID=? and bookingStatusNew ='Confirmed' or bookingStatusNew ='PickedUp' or bookingStatusNew ='Dropped' ";
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1, driverId);
				rset= stmt.executeQuery();
				
				if(rset.next()) {
					returnVal = 1;
					
				}	
				else {
					returnVal = 0;
				}
				
				
			} catch (Exception e) {
				throw new CustomException(e.getMessage());
			}finally {
				
				close(con,stmt,null);
			}
			
			return returnVal;
		}
	
	public static void updatePendingBooking(DataSource dataSource, String DriverID, String bookingStatusNew,String bookingID) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			
			try {
				
				con = dataSource.getConnection();
				sql= "UPDATE booking Set DriverID =?,bookingStatusNew=? where bookingID=?";
						
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, DriverID);
				pstmt.setString(2, bookingStatusNew);
				pstmt.setString(3, bookingID);
				
				pstmt.execute();
				
			} catch (Exception e) {
				throw new CustomException(e.getMessage());
			}finally {
				
					close(con,pstmt,null);
			}
			
		}

	public static void updatePickupTimeBooking(DataSource dataSource, String pickup, String bookingStatusNew,String bookingID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			
			con = dataSource.getConnection();
			sql= "UPDATE booking Set pickupTime =?,bookingStatusNew=? where bookingID=?";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pickup);
			pstmt.setString(2, bookingStatusNew);
			pstmt.setString(3, bookingID);
			
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}

	public static void updateDropTimeBooking(DataSource dataSource, String dropTime, String bookingStatusNew,String bookingID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			
			con = dataSource.getConnection();
			sql= "UPDATE booking Set dropTime =?,bookingStatusNew=? where bookingID=?";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dropTime);
			pstmt.setString(2, bookingStatusNew);
			pstmt.setString(3, bookingID);
			
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}
	
	public static void updateCompleteBooking(DataSource dataSource, String bookingStatusNew,String bookingID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			
			con = dataSource.getConnection();
			sql= "UPDATE booking Set bookingStatusNew=? where bookingID=?";
					
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bookingStatusNew);
			pstmt.setString(2, bookingID);
			
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}

	public static void addPayment(DataSource dataSource,String payment_Id,String bookingID,Double chargesCalculated,Double kmCovered) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			
			con = dataSource.getConnection();
			sql= "INSERT INTO payment (payment_Id, bookingID,chargesCalculated,kmCovered) VALUES (?,?,?,?)";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, payment_Id);
			pstmt.setString(2, bookingID);
			pstmt.setDouble(3, chargesCalculated);
			pstmt.setDouble(4, kmCovered);
			pstmt.execute();
			
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}finally {
			
				close(con,pstmt,null);
		}
		
	}

	
	private static void close(Connection con,Statement stmt,ResultSet rset) {
		try {
			if(rset != null)
			{
				rset.close();
			}
			if(stmt != null)
			{
				stmt.close();
			}
			
			if(con != null)
			{
				con.close();
			}
			
		} catch (SQLException e) {
			throw new CustomException(e.getMessage());
		}
		
	}


	
}
