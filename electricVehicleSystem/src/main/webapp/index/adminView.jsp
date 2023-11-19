<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin View</title>
    <link rel="stylesheet" type="text/css" href="/electricVehicleSystem/styles/adminView.css">
</head>

<body>
    <header>Admin Access View</header>
    <div class="container">
    	<h1>Welcome Back <%= request.getAttribute("firstname") %>, <%= request.getAttribute("lastname") %></h1>
        <div class="options">
            <form action="profile.jsp">
                <input type="submit" value="Profile"/>
            </form>
            <form action="vehicleSalesReport.jsp">
                <input type="submit" value="Vehicle Sales Report"/>
            </form>
            <form action="appUsageReport.jsp">
                <input type="submit" value="App Usage Report" onclick="generate()"/>
            </form>
            <form action="/electricVehicleSystem/SignOutServlet"  method="post">
                <input type="submit" value="Sign Out"/>
            </form>
        </div>
    </div>

    <footer>
        <p>© 2023 Admin View</p>
    </footer>
    <script>
    	function generate()
    	{
    		
    	}
    </script>
</body>
</html>
