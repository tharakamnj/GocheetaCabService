package com.gocheeta.cab.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.gocheeta.cab.entities.Branch;
import com.gocheeta.cab.entities.Driver;
import com.gocheeta.cab.entities.Employee;
import com.gocheeta.cab.services.BranchService;
import com.gocheeta.cab.services.DriverService;
import com.gocheeta.cab.services.EmployeeService;
import com.gocheeta.cab.services.LoginService;



@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name ="jdbc/cabservise_app")
    private DataSource dataSource;
    
    public LoginControllerServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginAuthentication(request, response);
	}


	private void LoginAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		
		try {
		
		if(LoginService.checkAuthentication(dataSource,type,userName,password)) {
			
			if(type.equals("Driver")) {
				
				Driver driver = DriverService.getList(dataSource, userName);
				Branch branch = BranchService.get(dataSource, driver.getBranchId());
				session.setAttribute("DriverId", driver.getDriverId());
				session.setAttribute("DriverName", driver.getDriverName());
				session.setAttribute("UserDisplayName", driver.getDriverName());
				session.setAttribute("UserContact", driver.getLicenceNo());
				session.setAttribute("LicenceNo", driver.getLicenceNo());
				session.setAttribute("vehiclecategoryId", driver.getvehicle_category_Id());
				session.setAttribute("CityId", branch.getCityId());
				response.sendRedirect("BookingControllerServlet?command=SHOW-OnGoing");
				
			}
			if(type.equals("Administration"))
			{
				Employee employee = EmployeeService.getList(dataSource, userName);
				
				session.setAttribute("employeeId", employee.getEmployeeId());
				session.setAttribute("UserDisplayName", employee.getDisplayName());
				session.setAttribute("UserContact", employee.getEmail());
				session.setAttribute("UserType", employee.getUserType());
				response.sendRedirect("index.jsp");
			}			
			
		}
		else {
			request.setAttribute("exceptionerror","User Credinatial incorrect");
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	} catch (Exception e) {
		
		request.setAttribute("exceptionerror", e.toString());
		request.setAttribute("exceptionerrorshow", "");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
		
	}

}
