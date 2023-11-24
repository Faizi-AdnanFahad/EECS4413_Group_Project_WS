// Select all checkboxes and convert NodeList to an array
var checkboxes = document.querySelectorAll('input[type="checkbox"]');
var checkboxArray = Array.from(checkboxes);

// Counter for checkboxes
var counter = 0;

// Function to change the URL of the button that redirects to each single page by a specific ID
function changeOneItemURLBtn(data, id) {
	var linkElement = document.getElementById(id);
	var currentHref = linkElement.getAttribute('href');
	var modifiedHref = currentHref + data.vid;
	linkElement.setAttribute('href', modifiedHref);
}

// Function to populate the main content
function populateMain() {

	// Get the current URL
	var currentURL = window.location.href; 

	// Parse the URL
	var urlObject = new URL(currentURL);
	var searchParams = new URLSearchParams(urlObject.search);

	// Get the value of the "vid" parameter
	var model = searchParams.get("model");
	console.log(model)
	
	// Create an instance of XMLHttpRequest
	var xhr = new XMLHttpRequest();
	
	let urlBackend = "http://localhost:8080/electricVehicleSystem/rest/items"
	
	if (model != null) {
		urlBackend += "/filter?model=" + model;
	}
	
	// Configure the request
	xhr.open(
		"GET",
		urlBackend,
		true
	);

	// Set up event handlers
	xhr.onload = function() {
		if (xhr.status >= 200 && xhr.status < 300) {
			// Request was successful
			var jsonResponse = JSON.parse(xhr.responseText);
			for (var i = 0; i < 6; i++) {
				var data = jsonResponse[i];

				// Change the URL of the button
				changeOneItemURLBtn(data, "viewMoreBtn_" + i);

				// Update item details
				updateItemDetails(i, "itemName_", data.name);
				updateItemDetails(i, "itemModel_", data.model);
				updateItemDetails(i, "itemPrice_", data.price);
				updateItemDetails(i, "itemMilage_", data.mileage);

				// Assign an ID to the checkbox
				checkboxArray[counter].id = "compareCheckbox_" + data.vid;
				counter++;
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
}

// Helper function to update item details
function updateItemDetails(index, elementIdPrefix, value) {
	document.getElementById(elementIdPrefix + index).textContent += value;
}

// Run the function
populateMain();
