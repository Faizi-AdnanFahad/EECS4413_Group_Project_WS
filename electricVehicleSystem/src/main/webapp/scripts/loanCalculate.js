function calculateWithAjax() {
	const TAX_RATE = 0.13;

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

	// Calculate the monthly payment using the loan formula without tax
	let loanAmount = vehiclePrice - downPayment;
	let monthlyInterestRate = (interestRate * 100) / 12 / 100;
	let numberOfPayments = loanDuration;
	let monthlyPayment =
		(loanAmount * monthlyInterestRate) /
		(1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
	// Calculate weekly payment
	let weeklyPayment = monthlyPayment * 12 / 52;
	let biWeeklyPayment = weeklyPayment * 2;
	let totalCostWithoutTax = monthlyPayment * numberOfPayments;
	let costOfBorrowing = totalCostWithoutTax - loanAmount;

	// Display the results in both columns

	let resultWithoutTax =
		"<h4>Payments Without Tax</h4>" +
		"<h6>Vehicle Price:</h6> $" + vehiclePrice + "<br>" +
		"<h6>Monthly Payment:</h6> $" + monthlyPayment.toFixed(2) + "<br>" +
		"<h6>Bi-Weekly Payment:</h6> $" + biWeeklyPayment.toFixed(2) + "<br>" +
		"<h6>Weekly Payment:</h6> $" + weeklyPayment.toFixed(2) + "<br>" +
		"<h6>Cost of Borrowing:</h6> $" + costOfBorrowing.toFixed(2) + "<br>";

	document.getElementById('loanValueWithoutTax').innerHTML = resultWithoutTax;

	let vehiclePriceWithTax = vehiclePrice * (1 + TAX_RATE);
	let loanAmountWithTax = vehiclePriceWithTax - downPayment;
	let monthlyInterestRateWithTax = (interestRate * 100) / 12 / 100;
	let numberOfPaymentsWithTax = loanDuration;
	let monthlyPaymentWithTax =
		(loanAmountWithTax * monthlyInterestRateWithTax) /
		(1 - Math.pow(1 + monthlyInterestRateWithTax, -numberOfPaymentsWithTax));
	// Calculate weekly payment
	let weeklyPaymentWithTax = monthlyPaymentWithTax * 12 / 52;
	let biWeeklyPaymentWithTax = weeklyPaymentWithTax * 2;
	let totalCostWithTax = monthlyPaymentWithTax * numberOfPayments;
	let costOfBorrowingWithTax = totalCostWithTax - loanAmount;

	let resultWithTax =
		"<h4>Payments With Tax</h4>" +
		"<h6>Vehicle Including Tax:</h6> $" + vehiclePriceWithTax.toFixed(2) + "<br>" +
		"<h6>Monthly Payment (with tax):</h6> $" + monthlyPaymentWithTax.toFixed(2) + "<br>" +
		"<h6>Bi-Weekly Payment:</h6> $" + biWeeklyPaymentWithTax.toFixed(2) + "<br>" +
		"<h6>Weekly Payment (with tax):</h6> $" + weeklyPaymentWithTax.toFixed(2) + "<br>" +
		"<h6>Cost of Borrowing:</h6> $" + costOfBorrowingWithTax.toFixed(2) + "<br>";

	document.getElementById('loanValueWithTax').innerHTML = resultWithTax;
}
