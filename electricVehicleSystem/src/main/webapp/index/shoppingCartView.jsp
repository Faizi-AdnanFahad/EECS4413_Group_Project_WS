<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shopping Cart</title>
<link rel="stylesheet"
	href="/electricVehicleSystem/styles/shoppingCartView.css">

<!-- Bootstrap Links -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"></link>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<header>
		<!-- Fixed Navbar -->
		<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
			<a class="navbar-brand nav-link"
				href="/electricVehicleSystem/index/home.html">Home</a> <a
				class="navbar-brand nav-link"
				href="/electricVehicleSystem/index/allItems.jspx">Vehicles</a> <a
				class="navbar-brand nav-link"
				href="/electricVehicleSystem/DealsController">Deals</a> <a
				class="navbar-brand nav-link"
				href="/electricVehicleSystem/index/SignUpView.html">Sign Up</a> <a
				class="navbar-brand nav-link"
				href="/electricVehicleSystem/index/chatbot.html">Chatbot</a>

			<div class="ms-auto">

				<a class="btn btn-primary"
					href="/electricVehicleSystem/index/shoppingCartView.jsp">View
					Cart</a>

			</div>
		</nav>
	</header>
	<div class="container">
		<input id="userID" type="hidden"
			value="<%=session.getAttribute("id")%>" />
		<h1>Shopping Cart</h1>
		<table id="cartTable" border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Model</th>
				<th>Price</th>
				<th>Mileage</th>
				<th></th>
			</tr>
			<!-- Rows will be dynamically added here -->
		</table>
		<!-- Add more items as needed -->
		<a href="checkoutView.jsp" class="checkout-btn">Proceed to
			Checkout</a>
	</div>
	<script>
		var idValue = $("#userID").val();
		$.ajax({
			url : "/electricVehicleSystem/rest/cart/" + idValue,
			type : 'GET',
			success : function(result) {
				var table = $("#cartTable");
				result.forEach(function(cart) {
					var row = $("<tr></tr>");
					row.append($("<td></td>").text(cart.vid));
					row.append($("<td></td>").text(cart.name));
					row.append($("<td></td>").text(cart.model));
					row.append($("<td></td>").text(cart.price));
					row.append($("<td></td>").text(cart.mileage));
					// Add a "Remove" button with a unique ID for each row
					var removeButton = $("<button></button>").text("Remove")
							.attr("class", "btn btn-danger removeBtn").attr(
									"data-vid", cart.vid).attr("onclick",
									"removeItemFromCart(" + "<%=session.getAttribute("id")%>, " + cart.vid + ")");
									row.append($("<td></td>").append(
											removeButton));

									table.append(row);
								});
					},
					error : function(error) {
						console.log(error);
					}
				});

		function removeItemFromCart(userId, vid) {

			// Get the current URL
			var currentURL = window.location.href;

			// Parse the URL
			var urlObject = new URL(currentURL);
			var searchParams = new URLSearchParams(urlObject.search);

			// Create an instance of XMLHttpRequest
			var xhr = new XMLHttpRequest();

			// Configure the request for adding to the cart
			xhr.open("DELETE", "/electricVehicleSystem/rest/cart/" + userId
					+ "?vid=" + vid, true);
			xhr.setRequestHeader("Content-Type", "application/json");

			// Set up event handlers
			xhr.onload = function() {
				if (xhr.status >= 200 && xhr.status < 300) {
					// Request was successful
					var jsonResponse = JSON.parse(xhr.responseText);
					window.location.reload();

					// You can perform additional actions after adding to the cart here
				} else {
					// Request had an error
					console.error("Request failed with status: " + xhr.status);
				}
			};

			xhr.onerror = function() {
				// Handle network errors
				console.error("Network error");
			};

			// Create a payload to send with the POST request
			var payload = {
				vid : vid,
			};

			// Send the POST request with the payload
			xhr.send(JSON.stringify(payload));
		}
	</script>
	<script src="/electricVehicleSystem/scripts/removeFromCart.js"></script>
	<script>
	<!-- allows the script before it to work somehow-->
		console.log("");
	</script>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
		crossorigin="anonymous"></script>
	<script>
	<!-- allows the script before it to work somehow-->
		console.log("");
	</script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
		integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
		crossorigin="anonymous"></script>
	<script>
	<!-- allows the script before it to work somehow-->
		console.log("");
	</script>
</body>
</html>
