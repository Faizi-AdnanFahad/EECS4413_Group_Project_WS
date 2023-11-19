
function customizeWithAjax() {
	// Get values from the form
	let color = document.getElementById('interiorColor').value;
	console.log(color);

	updateItemDetails("item.interiorColor", data.color);
	
}