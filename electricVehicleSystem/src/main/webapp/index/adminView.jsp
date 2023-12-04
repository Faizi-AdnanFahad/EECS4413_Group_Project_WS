<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="/electricVehicleSystem/styles/adminView.css">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="/electricVehicleSystem/scripts/adminView.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    
</head>
<body>

    <header>
        <h1>Admin Panel</h1>
    </header>

    <nav>
        <button onclick="showProfile()">View Profile</button>
        <button onclick="showAppUsage()">App Usage</button>
        <button id="vehicleSaleButton" onclick="showVehicleSales()">Vehicle Sales</button>
        <button id="signOutButton"onclick="signOut()">Sign Out</button>
    </nav>

    <section id="profileSection">
        <h2>View Profile</h2>
        <!-- Add content for viewing profile here -->
        <%= session.getAttribute("id") %>
        </br>
        <%= session.getAttribute("firstname") %>
        </br>
        <%= session.getAttribute("lastname") %>
    </section>

    <section id="appUsageSection" style="display: none;">
        <h2>App Usage</h2>
        <!-- Add content for app usage here -->
    </section>

    <section id="vehicleSalesSection" style="display: none;">
        <h2>Vehicle Sales</h2>
        <!-- Add content for vehicle sales here -->
        <table id="vehiclesSold" border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Model</th>
                <th>Price</th>
                <th>Mileage</th>
            </tr>
            <!-- Rows will be dynamically added here -->
        </table>
         <table id="report" border="1">
            <tr>
                <th>Total Items Sold</th>
                <th>Total Revenue</th>
            </tr>
            <!-- Rows will be dynamically added here -->
        </table>
    </section>

    <footer>
        &copy; 2023 Admin Panel
    </footer>
    <script>

    
    document.getElementById('signOutButton').addEventListener('click',function() {
    	// Use JavaScript to trigger the logout process
    	// You can redirect to the servlet URL or perform any other actions here
    	window.location.href = '/electricVehicleSystem/SignOutServlet';
    })
    
    document.getElementById('vehicleSaleButton').addEventListener('click',function() {
    	// Use JavaScript to trigger the logout process
    	// You can redirect to the servlet URL or perform any other actions here
    	var totalRevenue = 0;
    	var totalRows = 0;
        $.ajax({
            url: "/electricVehicleSystem/rest/feedback/vehiclesSale",
            type: 'GET',
            success: function(result){
                var table = $("#vehiclesSold");
                result.forEach(function(vSold){
                    var row = $("<tr></tr>");
                    row.append($("<td></td>").text(vSold.vid));
                    row.append($("<td></td>").text(vSold.name));
                    row.append($("<td></td>").text(vSold.model));
                    row.append($("<td></td>").text(vSold.price));
                    row.append($("<td></td>").text(vSold.mileage));
                    table.append(row);
                    totalRows++;
                    totalRevenue += vSold.price;
                });
                
                var reportTable = $("#report");
                var reportRow = $("<tr></tr>");
                reportRow.append($("<td></td>").text(totalRows));
                reportRow.append($("<td></td>").text(totalRevenue));
                reportTable.append(reportRow);
            },
            error: function(error){
                console.log(error);
            }
        });
    })
    function showAppUsage()
    {
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
    }
    </script>
</body>
</html>

