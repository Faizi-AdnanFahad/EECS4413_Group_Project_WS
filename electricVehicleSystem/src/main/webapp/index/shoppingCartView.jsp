<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="/electricVehicleSystem/styles/shoppingCartView.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div class="container">
    	<input id="userID" type="hidden" value="<%= session.getAttribute("id") %>"/>
        <h1>Shopping Cart</h1>
        <table id="cartTable" border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Model</th>
                <th>Price</th>
                <th>Mileage</th>
            </tr>
            <!-- Rows will be dynamically added here -->
        </table>
        <!-- Add more items as needed -->
        <a href="checkoutView.jsp" class="checkout-btn">Proceed to Checkout</a>
    </div>
    <script>
    	var idValue = $("#userID").val();
        $.ajax({
            url: "/electricVehicleSystem/rest/cart/" + idValue,
            type: 'GET',
            success: function(result){
                var table = $("#cartTable");
                result.forEach(function(cart){
                    var row = $("<tr></tr>");
                    row.append($("<td></td>").text(cart.vid));
                    row.append($("<td></td>").text(cart.name));
                    row.append($("<td></td>").text(cart.model));
                    row.append($("<td></td>").text(cart.price));
                    row.append($("<td></td>").text(cart.mileage));
                    table.append(row);
                });
            },
            error: function(error){
                console.log(error);
            }
        });
    </script>
</body>
</html>
