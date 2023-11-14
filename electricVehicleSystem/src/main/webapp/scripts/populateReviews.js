
function populateReview() {

	// Get the current URL
	var currentURL = window.location.href;

	// Parse the URL
	var urlObject = new URL(currentURL);
	var searchParams = new URLSearchParams(urlObject.search);

	// Get the value of the "vid" parameter
	var vid = searchParams.get("id");
	console.log(vid)
	// Create an instance of XMLHttpRequest
	var xhr = new XMLHttpRequest();
	// Configure the request
	xhr
		.open(
			"GET",
			"http://localhost:8080/electricVehicleSystem/rest/rating/" + vid,
			true);
	// Set up event handlers
	xhr.onload = function() {
		if (xhr.status >= 200 && xhr.status < 300) {
			// Request was successful
			var jsonResponse = JSON
				.parse(xhr.responseText);
			for (i = 0; i < jsonResponse.length; i++) {
				var data = jsonResponse[i];

				document
					.getElementById("user_" + i).textContent += data.userId;
				document.getElementById("rating_"
					+ i).textContent += data.rateNum;
				document.getElementById("description_"
					+ i).textContent += data.reviewDescription;
			}

		} else {
			// Request had an error
			console
				.error("Request failed with status: "
					+ xhr.status);
		}
	};

	xhr.onerror = function() {
		// Handle network errors
		console.error("Network error");
	};

	// Send the request
	xhr.send();
}

// run the function
populateReview()