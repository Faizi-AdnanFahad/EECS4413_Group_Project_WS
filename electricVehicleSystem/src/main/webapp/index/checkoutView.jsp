<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <!-- Include your existing head content -->
    <title>Checkout</title>
    <link rel="stylesheet" type="text/css" href="/electricVehicleSystem/styles/checkoutView.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <header>
        <!-- Include your existing header content -->
    </header>

    <div class="container mt-5">
    	<input id="userID" type="hidden" value="<%= session.getAttribute("id") %>"/>
        <h2>Checkout</h2>

        <div class="card-container card-deck">
           
        </div>

        <!-- Form for user information and payment details -->
        <form action="/electricVehicleSystem/index/checkoutConfirmation.html" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>

            <!-- Add more form fields for address details -->
            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <input type="text" class="form-control" id="address" name="address" required>
            </div>

            <!-- Add form fields for card information -->
            <div class="mb-3">
                <label for="cardNumber" class="form-label">Card Number</label>
                <input type="text" class="form-control" id="cardNumber" name="cardNumber" required>
            </div>

            <div class="mb-3">
                <label for="expiryDate" class="form-label">Expiry Date</label>
                <input type="text" class="form-control" id="expiryDate" name="expiryDate" placeholder="MM/YYYY" required>
            </div>

            <div class="mb-3">
                <label for="cvv" class="form-label">CVV</label>
                <input type="text" class="form-control" id="cvv" name="cvv" required>
            </div>

            <!-- Submit button -->
            <button type="submit" class="btn btn-primary">Place Order</button>
        </form>
    </div>

    <!-- Include your existing scripts and JavaScript libraries -->
<script>
var idValue = $("#userID").val();
$.ajax({
    url: "/electricVehicleSystem/rest/cart/" + idValue,
    type: 'GET',
    success: function (result) {
        var cardContainer = $(".card-container");
		var totalPrice = 0;
        result.forEach(function (cart) {
            var card = $("<div></div>").addClass("card mb-3");
            var cardBody = $("<div></div>").addClass("card-body");

            // Your existing card content
            cardBody.append($("<h5></h5>").addClass("card-title").text(cart.name));
            cardBody.append($("<p></p>").addClass("card-text").html("<span>Model:</span> " + cart.model));
            cardBody.append($("<p></p>").addClass("card-text").html("<span>Price:</span> " + cart.price));
            totalPrice += cart.price;
            card.append(cardBody);
            cardContainer.append(card);
        });
        var totalPriceLabel = $("<div></div>").addClass("card mb-3");
        totalPriceLabel.append($("<h5></h5>").addClass("card-title").text("CART TOTAL: " + totalPrice));
        cardContainer.append(totalPriceLabel);
    },
    error: function (error) {
        console.log(error);
    }
});

</script>
</body>
</html>
