function addToCart(userId) {
	// Get the current URL
	var currentURL = window.location.href;

	// Parse the URL
	var urlObject = new URL(currentURL);
	var searchParams = new URLSearchParams(urlObject.search);

	// Get the value of the "vid" parameter
	var vid = searchParams.get("id");

	// Create an instance of XMLHttpRequest
	var xhr = new XMLHttpRequest();

	// Configure the request for adding to the cart
	xhr.open("POST", "/electricVehicleSystem/rest/cart/" + userId + "?vid=" + vid, true);
	xhr.setRequestHeader("Content-Type", "application/json");

	// Set up event handlers
	xhr.onload = function() {
		if (xhr.status >= 200 && xhr.status < 300) {
			// Request was successful
			var jsonResponse = JSON.parse(xhr.responseText);
			console.log("Item added to cart:", jsonResponse);
			alert("ITEM ADDED TO CART!")
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
		vid: vid,
	};

	// Send the POST request with the payload
	xhr.send(JSON.stringify(payload));
}