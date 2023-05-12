package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.out;

class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request;
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while ((request = in.readLine()) != null) {
                if (request.equals("stop")) {
                    out.println("Server stopped");
                    System.out.println("Server stopped");
                    out.flush();
                    break;
                }
                else {
                    System.out.println(request);
                    out.println("Server received the request ... " + request + "!");
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        }
    }
}