async function getUserNameWithFetch(id) {
	try {
		const response = await fetch(`/electricVehicleSystem/rest/users/${id}`);

		if (!response.ok) {
			throw new Error(`Request failed with status: ${response.status}`);
		}

		const jsonResponse = await response.json();
		const firstName = jsonResponse.firstName;

		return firstName;
	} catch (error) {
		console.error(error.message);
		throw error; // Re-throw the error to indicate failure
	}
}

async function populateReview() {
	// Get the current URL
	var currentURL = window.location.href;

	// Parse the URL
	var urlObject = new URL(currentURL);
	var searchParams = new URLSearchParams(urlObject.search);

	// Get the value of the "vid" parameter
	var vid = searchParams.get("id");

	try {
		// Create an instance of XMLHttpRequest
		var xhr = new XMLHttpRequest();

		// Configure the request
		xhr.open(
			"GET",
			"/electricVehicleSystem/rest/rating/" + vid,
			true
		);

		// Set up event handlers
		xhr.onload = async function() {
			if (xhr.status >= 200 && xhr.status < 300) {
				// Request was successful
				var jsonResponse = JSON.parse(xhr.responseText);

				for (i = 0; i < jsonResponse.length; i++) {
					var data = jsonResponse[i];

					// get the firstname associated with the user id of a rating
					const firstName = await getUserNameWithFetch(data.userId);

					document.getElementById("user_" + i).innerHTML = "<h5>" + firstName + "</h5>";

					var element = document.getElementById("rating_" + i);
					element.setAttribute("data-rating", data.rateNum);
					element.textContent = "Rated: " + data.rateNum + " stars";

					document.getElementById("description_" + i).textContent = data.reviewDescription;
				}
			} else {
				// Request had an error
				console.error("Request failed with status: " + xhr.status);
			}
		};

		xhr.onerror = function() {
			// Handle network errors
			console.error("Network error");
		};

		// Send the request
		xhr.send();
	} catch (error) {
		console.error("An error occurred in populateReview:", error);
	}
}

// run the function
populateReview();
