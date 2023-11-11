var checkboxes = document.querySelectorAll('input[type="checkbox"]');
// Convert the NodeList to an array for easier manipulation
var checkboxArray = Array.from(checkboxes);
var counter = 0;

// change the href of the button that reroutes to each single page by a specific id
function changeTheOneItemURLBtn(data, id) {
	// refer each vehicle to its page by setting appending its id as an attribute
	var linkElement = document
		.getElementById(id);
	var currentHref = linkElement
		.getAttribute('href');
	var modifiedHref = currentHref
		+ data.vid;
	linkElement.setAttribute('href',
		modifiedHref);
}

function populateMain() {
	// Create an instance of XMLHttpRequest
	var xhr = new XMLHttpRequest();
	// Configure the request
	xhr
		.open(
			"GET",
			"http://localhost:8080/electricVehicleSystem/rest/items",
			true);
	// Set up event handlers
	xhr.onload = function() {
		if (xhr.status >= 200 && xhr.status < 300) {
			// Request was successful
			var jsonResponse = JSON
				.parse(xhr.responseText);
			for (i = 0; i < 5; i++) {
				var data = jsonResponse[i];

				changeTheOneItemURLBtn(data, "viewMoreBtn_" + i);

				document
					.getElementById("itemName_" + i).textContent += data.name;
				document.getElementById("itemModel_"
					+ i).textContent += data.model;
				document.getElementById("itemPrice_"
					+ i).textContent += data.price;
				document.getElementById("itemMilage_"
					+ i).textContent += data.mileage;

				checkboxArray[counter].id = "compareCheckbox_" + data.vid;
				counter++;
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
populateMain()