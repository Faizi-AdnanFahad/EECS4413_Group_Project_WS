/**
 * 
 */
const MAX_COMPARABLE_VEHICLES = 3;

var checkboxes = document.querySelectorAll('input[type="checkbox"]');
// Convert the NodeList to an array for easier manipulation
var checkboxArray = Array.from(checkboxes);
var counter = 0;

var checkedCheckboxes = [];
// Array to store checked checkbox ids
var compareAnchor = document
	.getElementById("compareButtonHref");
var compareHref = compareAnchor
	.getAttribute('href');

var comparables = "";
// Function to update the list when a checkbox is checked or unchecked
function updateCheckedCheckboxes(checkboxId) {
	var index = checkedCheckboxes.indexOf(checkboxId[checkboxId.length - 1]);
	if (index === -1) {
		// Checkbox is checked, add to the list
		if (checkedCheckboxes.length < MAX_COMPARABLE_VEHICLES) {
			checkedCheckboxes.push(checkboxId[checkboxId.length - 1]);

			comparables = checkedCheckboxes.join(",");

			var modifiedHref = compareHref + comparables;
			compareAnchor.setAttribute('href', modifiedHref);
		}
		else {
			document.getElementById(checkboxId).checked = false;
			alert("You can not compare more than *" + MAX_COMPARABLE_VEHICLES + "* vehicles!")
		}
	} else {
		// Checkbox is unchecked, remove from the list
		checkedCheckboxes.splice(index, 1);
	}
}

// Add event listener to each checkbox
for (var j = 0; j < checkboxArray.length; j++) {

	checkboxArray[j].addEventListener('change', function() {
		updateCheckedCheckboxes(this.id);
	});
}