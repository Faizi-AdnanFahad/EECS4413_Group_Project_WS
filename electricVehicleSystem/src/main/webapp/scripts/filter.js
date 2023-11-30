/**
 * 
 */
// Function to handle the search button click


function performFilter() {
	// Get the input value from the search box
	var searchText = document.getElementById("searchInput").value;
	console.log(searchText)
	// Construct the URL with the filter parameter
	var url = "?model=" + encodeURIComponent(searchText);

	// Redirect the user to the new URL
	window.location.href = url;
}

