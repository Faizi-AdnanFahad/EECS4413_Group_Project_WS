/**
 * 
 */
// Function to handle the search button click


function performSearch() {
	// Get the input value from the search box
	var searchText = document.getElementById("search").value;
	console.log(searchText)
	// Construct the URL with the filter parameter
	var url = "?sorting=" + encodeURIComponent(searchText);

	// Redirect the user to the new URL
	window.location.href = url;
}