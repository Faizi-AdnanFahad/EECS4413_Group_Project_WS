<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin View</title>
    <link rel="stylesheet" type="text/css" href="/electricVehicleSystem/styles/adminView.css">
    <!-- Include jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>

<body>
    <header>Admin Access View</header>
    <div class="container">
    	<div class="myHeader">
    		<div class="headLeft"></div>
        	<h1>Welcome Back <%= session.getAttribute("firstname") %>, <%= request.getAttribute("lastname") %></h1>
        	<div class="headRight"></div>
        </div>
        <div class="options">
        	<div class="opLeft"></div>
	        <div class="adminForm">
	            <form action="profile.jsp">
	                <input type="submit" value="Profile"/>
	            </form>
	            <form action="vehicleSalesReport.jsp">
	                <input type="submit" value="Vehicle Sales Report"/>
	            </form>
	            <form id="frmAppUsage">
	                <input type="submit" value="App Usage Report"/>
	            </form>
	            <form action="/electricVehicleSystem/SignOutServlet" method="post">
	                <input type="submit" value="Sign Out"/>
	            </form>
            </div>
            <div class="opRight"></div>
        </div>
    </div>

    <footer>
        <p>© 2023 Admin View</p>
    </footer>
    <script>
        $(document).ready(function(){
            $("#frmAppUsage").submit(function(e){
                e.preventDefault(); // prevent the form from submitting normally

                $.ajax({
                    url: "/electricVehicleSystem/rest/users/usage",
                    type: 'GET',
                    success: function(result){
                        alert("Number of user logins: " + result);
                    },
                    error: function(error){
                        console.log(error);
                    }
                });
            });
        });
    </script>
</body>
</html>
