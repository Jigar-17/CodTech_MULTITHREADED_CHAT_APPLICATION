import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 1234;
    private static Set<Socket> clientSockets = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);
            System.out.println("New client connected: " + clientSocket);

            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Welcome to the Chat Server!");

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                broadcast(message, clientSocket);
            }

        } catch (IOException e) {
            System.out.println("Client disconnected: " + clientSocket);
        } finally {
            try {
                clientSockets.remove(clientSocket);
                clientSocket.close();
            } catch (IOException e) {}
        }
    }

    private static void broadcast(String message, Socket senderSocket) {
        for (Socket socket : clientSockets) {
            if (socket != senderSocket) {
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Message: " + message);
                } catch (IOException e) {}
            }
        }
    }
}
