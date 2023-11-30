function sendMessage() {
    var userInput = document.getElementById('userInput').value;
    if (userInput.trim() === '') return;

    appendMessage('user', userInput);

    // Your existing message processing and response logic here.

    // For demonstration purposes, let's simulate a bot response after a short delay.
    setTimeout(function () {
      talk(); // Call your talk function here.
    }, 500);
}

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
    "i'm having problem with sign-in": "For technical assistence call our customer service agent :+1800 123 416",
    "i'm having problem with checkout": "For technical assistence call our customer service agent :+1800 123 416",
    "ok": "Thank You So Much,Anything,sir ",
    "bye": "Okay! Will meet soon..Dobby has no master.Dobby is free chatbot",
    "i'm having problem with filtering vehicles": "For technical assistence call our customer service agent :+1800 123 416",
    "how to view vechile details" : "Go to home page with all the vehicle list->then there's a view more button->click button to view detail of your liked car",
    "how to view deals on vehicle" : "Go to home page with all the vehicle list->on top in header with all buttons->click on Deals->to assess all the latest vehicle deals",
    "thank you" : "Dobby is happy to help you.Dobby is...free!",
    "problem with loan calculator" : "For technical assistence call our customer service agent :+1800 123 416",
    "problem with giving reviews" : "For technical assistence call our customer service agent :+1800 123 416",
    "getting payment error" : "Enter valid card and for technical assistence call our customer service agent :+1800 123 416",
    "getting vehicle camparing error" : "Select 3 vehicles only and then click on campare button on header bar and for technical assistence call our customer service agent :+1800 123 416",
    "how to give feedback about website" : "There's a feedback button on top header bar click on feedback and it will open  text input section add your feedback and click send button",
    "getting error with view cart button" : "For technical assistence call our customer service agent :+1800 123 416",
   	"how to sort vehicle with good mileage" : "There is a selection option after filtering->select mileage LTH option ->and then click on sort button it will give you sorted list of vehicle with best mileage to worst mileage"
   	
  };

  var user = document.getElementById('userInput').value.toLowerCase().trim();
  console.log("User input:", user);
  appendMessage('user', user);

  if (know.hasOwnProperty(user)) {
    console.log("User input is in know object");
    var botResponse = know[user];
    appendMessage('bot', botResponse);
  } else {
    console.log("User input is NOT in know object");
    appendMessage('bot', "Sorry, I didn't understand");
  }
}