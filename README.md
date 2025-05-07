## MULTITHREADED CHAT APPLICATION
* COMPANY * : CODTECH IT SOLUTIONS
* NAME * : JIGAR DABHI
* INTERN ID * : CT04DK114
* DOMAIN * : JAVA PROGRAMMING
* MENTOR * : NEELA SANTOSH
* DESCRIPTION TASK-3 : MULTITHREADED CHAT APPLICATION
  This is a basic real-time chat system developed as part of an internship task using **Java Sockets** and **Multithreading**.
  The system includes a **server** that listens for incoming client connections and multiple **clients** that can communicate with each other through the server.

The main goal of this project is to demonstrate understanding of:
- **Socket programming in Java**
- **Multithreading for concurrent connections**
- **Client-server communication model**

Each client runs on a separate thread and sends/receives messages to/from the server, enabling real-time group chat between multiple users in a terminal-based interface.
This is a basic real-time chat system developed as part of an internship task using **Java Sockets** and **Multithreading**. The system includes a **server** that listens for incoming client connections and multiple **clients** that can communicate with each other through the server.

The main goal of this project is to demonstrate understanding of:
- **Socket programming in Java**
- **Multithreading for concurrent connections**
- **Client-server communication model**

Each client runs on a separate thread and sends/receives messages to/from the server, enabling real-time group chat between multiple users in a terminal-based interface.

## 🚀 Features

- Multi-client chat support using threads  
- Real-time message broadcasting  
- Simple command-line interface (CLI)  
- Based on Java sockets (TCP)

## 🧱 Project Structure
ChatApp/
├── ChatServer.java # Server code
└── ChatClient.java # Client code

## ⚙️ How to Run
 1. Compile the code:
javac ChatServer.java
javac ChatClient.java
 2. Start the Server
java ChatServer
 3.Output:
Server started on port 1234
 4. Start one or more clients (in new terminal windows):
java ChatClient
Each client will see:
Connected to the chat server.
Welcome to the Chat Server!
💬 How It Works
The Server listens on port 1234.
Each Client connects to the server.
The server creates a new thread for every connected client.
Messages typed by any client are broadcasted to all other clients.

📸 Example Output
Client 1:
Connected to the chat server.
Welcome to the Chat Server!
Hello from Client 1
Message: Hello from Client 2
Client 2:
Connected to the chat server.
Welcome to the Chat Server!
Message: Hello from Client 1
Hello from Client 2

