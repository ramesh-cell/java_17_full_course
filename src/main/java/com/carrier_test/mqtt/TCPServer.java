package com.carrier_test.mqtt;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("TCP Server started on port 5000...");

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String receivedData = input.readLine();
            System.out.println("Received: " + receivedData);

            output.println("ACK: " + receivedData);
            socket.close();
        }
    }
}
