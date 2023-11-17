
function calculateWithAjax() {
	// Get values from the form
	let vehiclePrice = document.getElementById('vehiclePrice').value;
	let downPayment = document.getElementById('downPayment').value;
	let interestRate = document.getElementById('interestRate').value;
	let loanDuration = document.getElementById('loanDuration').value;

	// Validate the values
	if (isNaN(vehiclePrice) || vehiclePrice < 0 || isNaN(downPayment) || downPayment < 0 || isNaN(interestRate) || interestRate < 0 || isNaN(loanDuration) || loanDuration < 0) {
		alert("Please enter valid numeric values.");
		return;
	}

	// Calculate the monthly payment using the loan formula
	let loanAmount = vehiclePrice - downPayment;
	let monthlyInterestRate = (interestRate * 100) / 12 / 100; // Convert annual rate to monthly
	let numberOfPayments = loanDuration;

	let monthlyPayment =
		(loanAmount * monthlyInterestRate) /
		(1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

	// Display the result
	let resultMessage = "Monthly Payment: $" + monthlyPayment.toFixed(2);
	document.getElementById('loanValue').innerText = resultMessage;
}