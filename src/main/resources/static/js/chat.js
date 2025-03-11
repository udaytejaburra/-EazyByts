let stompClient = null;
function connect() {
    const socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, (frame) => {
        console.log("✅ Connected to WebSocket:", frame);

        stompClient.subscribe('/topic/public', (message) => {
            console.log("📩 Received message:", message.body);
            displayMessage(JSON.parse(message.body));
        });

    }, (error) => {
        console.error("❌ WebSocket Connection Failed:", error);
    });
}


  // ✅ Correct ID

  function displayMessage(message) {
      const messageArea = document.getElementById('messageArea');

      if (!messageArea) {
          console.error("❌ messageArea not found!");
          return;
      }

      const messageElement = document.createElement('div');
      messageElement.className = 'message';
      messageElement.innerHTML = `<strong>${message.sender}:</strong> ${message.content}`;
      messageArea.appendChild(messageElement);
      messageArea.scrollTop = messageArea.scrollHeight;
  }

  function sendMessage() {
      const messageInput = document.getElementById("messageInput");

      if (!messageInput) {
          console.error("❌ Error: messageInput element not found!");
          return;
      }

      const messageContent = messageInput.value.trim();

      if (messageContent !== "" && stompClient && stompClient.connected) {
          console.log("🚀 Sending message:", messageContent);

          stompClient.send("/app/chat.sendMessage", {}, JSON.stringify({ 
              sender: "User1", 
              content: messageContent 
          }));

          console.log("✅ Message sent successfully!");

          messageInput.value = "";
      } else {
          console.error("❌ Error: Empty message or WebSocket not connected.");
      }
  }


window.onload = function () {
    if (document.getElementById('messageArea')) {
        connect();
    }
};

