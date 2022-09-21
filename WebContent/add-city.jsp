<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Add City - GoCheetha Taxi</title>
	<jsp:include page="Shared/header.html"></jsp:include>
</head>
<body class="sidebar-dark">

	<%
	   response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("employee_Id") == null  ){
			response.sendRedirect("login.jsp");
			
		}
	%> 
	<div class="main-wrapper">

		<jsp:include page="Shared/sidebar.jsp">
			<jsp:param name="city" value="active"/>
		</jsp:include>
		<div class="page-wrapper">
					
		<jsp:include page="Shared/searchbar.jsp"></jsp:include>

		<div class="page-content">
	
	        <div class="d-flex justify-content-between align-items-center flex-wrap grid-margin">
		          <div>
		            <h4 class="mb-3 mb-md-0">Add City</h4>
		          </div>
            </div>
            
            
    <div class="row">
        <div class="col-md-6 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
					 <form action="CityControllerServlet" method="post">
	                   <div class="alert alert-danger col-md-12 ${exceptionerrorshow}" id="divShowError" role="alert">
							<span id="showerrormsg"class="text-danger">${exceptionerror}</span>
						</div>
	
	                 	<div class="form-group row d-none">
	                       <input type="hidden" name="command" value="ADDDATA">
	                    </div>
	
                        <div class="form-group row d-none">
                            <label class="col-4 col-form-label" for="txtcity_Id">City ID</label>
                            <div class="col-8">
                                <input type="text" class="form-control" name="city_Id" id="txtcity_Id" value="${city.city_Id }">

                            </div>
                        </div>
	
	                    <div class="form-group row">
                             <label class="col-4 col-form-label" for="txtcity_Name">City Name</label>
                             <div class="col-8">
                                 <input type="text" class="form-control" name="city_Name" id="txtcity_Name" value="${city.city_Name }" placeholder="Enter City">

                             </div>
                         </div>
                         
                         <div class="form-group row ">
                             <code>${error }</code>
                         </div>
	                    
	
	                    <div class="form-group row">
	                        <div class="col-4">
	                        </div>
	                        <div class="col-8">
	                            <button type="submit" class="btn btn-primary mr-2">Add</button>
	                            &nbsp;
	                            <a href="CityControllerServlet">Cancel</a>
	                        </div>
	                    </div>
 					</form>

                </div>
            </div>
        </div>
    </div>
            
			
		</div>

			<jsp:include page="Shared/footer.html"></jsp:include>
		
		</div>
	</div>
 	 <script type="text/javascript">

	$(document).ready(function () {

		show_Error();
    });

	function show_Error() {
		var showerror = $("#showerrormsg").text();
		if(showerror ==""){
			$("#divShowError").hide();
		}


	}


    </script>

</body>
</html>
 
