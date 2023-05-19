package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream())) ) {

            Scanner scanner = new Scanner(System.in);
            String request;
            System.out.println("Write a command");
            System.out.println("Create a new game (new game)");
            System.out.println("Participate to a new game (participate)");
            System.out.println("Make a new move(make a move)");
            System.out.println("exit");
            System.out.print("Your command: ");
            while (!(request = scanner.nextLine()).equals("exit")) {

                out.println(request);
                String response;
                while ((response = in.readLine()) != null) {
                    if (response.equals("EndOfResponse")) {
                        break;
                    }
                    System.out.println(response);
                }
                System.out.println("Write a command");
                System.out.println("Create a new game (new game)");
                System.out.println("Participate to a new game (participate)");
                System.out.println("Make a new move(make a move)");
                System.out.println("exit");
                System.out.print("Your command: ");
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}

