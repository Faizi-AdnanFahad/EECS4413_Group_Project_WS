/**
 * 
 */
// Create an instance of XMLHttpRequest
var xhr = new XMLHttpRequest();

// Configure the request
xhr.open("GET",
	"http://localhost:8080/electricVehicleSystem/rest/items", true);
// <![CDATA[
// Set up event handlers
xhr.onload = function() {
	if (xhr.status >= 200 && xhr.status < 300) {
		// Request was successful
		var jsonResponse = JSON.parse(xhr.responseText);
		for (i = 0; i < 4; i++) {
			var data = jsonResponse[i];

			document.getElementById("itemId_" + i).textContent += data.vid;
			document.getElementById("itemName_" + i).textContent += data.name;
			document.getElementById("itemModel_" + i).textContent += data.model;
			document.getElementById("itemDescription_" + i).textContent += data.description;
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
		// ]]>