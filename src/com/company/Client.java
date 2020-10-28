package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    Socket clientSocket;
    Boolean isConnected = false;

     public Client(String address, int port) {
        try {
            this.clientSocket = new Socket(address, port);
            this.isConnected = true;
            System.out.println("Connected to server.");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

   public void sendMessage(String message) {
        try {
            DataOutputStream msgToSend = new DataOutputStream(this.clientSocket.getOutputStream());
            byte[] messageBuffer = message.getBytes(StandardCharsets.UTF_8);
            msgToSend.write(messageBuffer);
            DataInputStream msgToReceive = new DataInputStream(this.clientSocket.getInputStream());
            byte[] bytes = new byte[1024];
            int bytesRead = msgToReceive.read(bytes);
            String messageReceived = new String(bytes, 0, bytesRead);
            System.out.println("Received from server: " + messageReceived + " (" + bytesRead + " bytes)");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            Disconnect();
        }
    }

    public void Disconnect() {
        try {
            this.clientSocket.close();
            this.isConnected = false;
            System.out.println("Disconnected from server.");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
