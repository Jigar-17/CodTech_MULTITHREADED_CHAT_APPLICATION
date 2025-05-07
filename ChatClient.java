import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        System.out.println("Connected to the chat server.");

        // Reading incoming messages
        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                String serverMsg;
                while ((serverMsg = in.readLine()) != null) {
                    System.out.println(serverMsg);
                }
            } catch (IOException e) {
                System.out.println("Disconnected from server.");
            }
        }).start();

        // Sending messages
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userMsg = scanner.nextLine();
            out.println(userMsg);
        }
    }
}
 
