function sendMessage() {
	var userInput = document.getElementById('userInput').value;
	if (userInput.trim() === '') return;

	appendMessage('user', userInput);

	setTimeout(function() {
		talk(); // Call your talk function here.
	}, 500);
}

// Add event listener for "Enter" key press
document.getElementById('userInput').addEventListener('keypress', function(e) {
	if (e.key === 'Enter') {
		talk();
	}
});

function appendMessage(sender, message) {
	var chatBody = document.getElementById('chatBody');
	var messageDiv = document.createElement('div');
	messageDiv.className = sender + '-message message';
	messageDiv.innerText = message;
	chatBody.appendChild(messageDiv);

	// Clear user input
	document.getElementById('userInput').value = '';

	// Scroll to the bottom of the chat body
	chatBody.scrollTop = chatBody.scrollHeight;
}

// Add your talk function here
function talk() {
	var know = {
		"hi": "Hello! Dobby here. Of course, sir. I'm chatbot, and I would be delighted to assist you.",
		"who are you": "Dobby, sir. Dobby the chatbot. I would be delighted to assist you",
		"how are you": "Good :), How can I help you today?",
		"i'm having problem with sign-in": "For technical assistance, call our customer service agent :+1 (800) 123-416",
		"i'm having problem with checkout": "For technical assistance, call our customer service agent :+1 (800) 123-416",
		"ok": "Thank You So Much, Anything, sir ",
		"bye": "Okay! Will meet soon.. Dobby has no master. Dobby is a free chatbot",
		"i'm having problem with filtering vehicles": "For technical assistance, call our customer service agent :+1 (800) 123-416",
		"how to view vehicle details": "Go to the home page with all the vehicle lists -> then there's a view more button -> click the button to view details of your liked car",
		"how to view deals on vehicles": "Go to the home page with all the vehicle lists -> on top in the header with all buttons -> click on Deals -> to assess all the latest vehicle deals",
		"thank you": "Dobby is happy to help you. Dobby is... free!",
		"problem with loan calculator": "For technical assistance, call our customer service agent :+1800 123 416",
		"problem with giving reviews": "For technical assistance, call our customer service agent :+1800 123 416",
		"getting payment error": "Enter a valid card and for technical assistance, call our customer service agent :+1800 123 416",
		"getting vehicle comparing error": "Select 3 vehicles only and then click on compare button on the header bar and for technical assistance, call our customer service agent :+1800 123 416",
		"how to give feedback about the website": "There's a feedback button on the top header bar. Click on feedback and it will open a text input section. Add your feedback and click the send button",
		"getting error with view cart button": "For technical assistance, call our customer service agent :+1800 123 416",
		"how to sort vehicles with good mileage": "There is a selection option after filtering -> select mileage LTH option -> and then click on the sort button. It will give you a sorted list of vehicles with the best mileage to worst mileage",
		"tell me a joke": "Why don't scientists trust atoms? Because they make up everything!",
		"favorite color": "I'm a chatbot, so I don't have a favorite color, but I can help you with any questions you have!",
		"hi": "Hello! Dobby here. Of course, sir. I'm a chatbot, and I would be delighted to assist you.",
		"hello": "Greetings! Dobby at your service.",
		"hey": "Hey there! How can I assist you today?",
		"greetings": "Greetings, sir! Dobby is ready to help.",
		"howdy": "Howdy! Dobby is here to assist you.",
		"hi there": "Hi there! Dobby is ready for your questions.",
		"good day": "Good day! Dobby is here to provide assistance.",
		"yo": "Yo! Dobby is at your service.",
		"how to place an order": "To place an order, browse through our available products, select the items you want, and proceed to checkout. Follow the on-screen instructions to complete your purchase.",
		"can I order by phone": "Certainly! You can place an order by calling our customer service hotline at +1 (800) 123-416. Our representatives will assist you with the ordering process.",
		"is there a minimum order amount": "Yes, we have a minimum order amount of $50 for all purchases. This helps us ensure a smooth ordering and delivery process.",
		"how long does shipping take": "Shipping times vary depending on your location. Standard shipping usually takes 3-5 business days. You can choose expedited shipping options during checkout for faster delivery.",
		"what payment methods are accepted": "We accept various payment methods, including credit cards, PayPal, and bank transfers. You can choose your preferred payment option during the checkout process.",
		"can I track my order": "Yes, you can track your order by logging into your account on our website. Once your order is shipped, you will receive a tracking number to monitor the delivery status.",
		"do you offer international shipping": "Yes, we offer international shipping. During the checkout process, provide your international shipping address, and shipping options and costs will be displayed.",
		"what is your return policy": "Our return policy allows you to return items within 30 days of purchase. Please visit our 'Returns' page on the website for detailed instructions on how to initiate a return.",
		"are there any discounts available": "We regularly offer discounts and promotions. Check our 'Deals' section on the website or subscribe to our newsletter to stay updated on the latest discounts and special offers.",
		"how do I contact customer service": "You can reach our customer service team by calling +1 (800) 123-416 during our business hours. Alternatively, you can send an email to support@example.com, and we'll get back to you as soon as possible.",
		"what are your customer service hours": "Our customer service is available Monday to Friday, 9 AM to 6 PM. Feel free to reach out during these hours for assistance.",
		"is there a live chat support": "Yes, we offer live chat support on our website. Look for the chat icon in the bottom right corner to connect with a representative instantly.",
		"where can I find the FAQ section": "Our Frequently Asked Questions (FAQ) section is available on the website's homepage. You can find helpful information and answers to common queries there.",
		"what's your return policy": "Our return policy allows you to return items within 30 days of purchase. Please visit our 'Returns' page on the website for detailed instructions on how to initiate a return.",
		"do you have a physical store": "Currently, we operate exclusively online. You can explore our products and make purchases on our website.",
		"can I provide feedback": "Absolutely! We value your feedback. You can submit your feedback through the 'Feedback' section on our website, or feel free to email us at feedback@example.com.",
		"what's your mailing address": "Our corporate office is located at 123 Main Street, Cityville, State, Zip Code. However, for specific inquiries, it's best to contact us through phone or email.",
		"how can I escalate an issue": "If you have an urgent matter or need to escalate an issue, please call our customer service hotline at +1 (800) 123-416 and ask to speak with a supervisor.",
		"can I request a call back": "Certainly! If you prefer a callback, please leave your name, contact number, and a brief description of your inquiry on our website's 'Request a Callback' form, and we'll get back to you at your convenience.",
		"nice to meet you": "Nice to meet you as well! Let me know if you needed any help!"
	};


	var user = document.getElementById('userInput').value.toLowerCase().trim();
	console.log("User input:", user);
	appendMessage('user', user);

	// Iterate through the keys in the know object
	for (var key in know) {
		if (key.includes(user.toLowerCase())) {
			console.log("User input is in know object");
			var botResponse = know[key];
			appendMessage('bot', botResponse);
			return; // Exit the function after finding a match
		}
	}

	console.log("User input is NOT in know object");
	appendMessage('bot', "Sorry, I didn't understand");
}