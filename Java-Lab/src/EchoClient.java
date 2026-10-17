import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5001);

            BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);

            System.out.println("Connected to Echo Server.");
            System.out.println("Enter a message (bye to exit):");

            String message;

            while (true) {
                System.out.print("Client: ");
                message = keyboard.readLine();

                output.println(message);

                if (message.equalsIgnoreCase("bye"))
                    break;

                String response = input.readLine();
                System.out.println("Server Echo: " + response);
            }

            socket.close();
            keyboard.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
