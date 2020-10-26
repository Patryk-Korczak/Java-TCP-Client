package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Enter address: ");
        Scanner myScanner = new Scanner(System.in);
        String address = myScanner.next();
        System.out.println("Enter port: ");
        int port = myScanner.nextInt();
        int messagesSent = 0;
        Client client = new Client(address, port);
        while(client.isConnected){
            messagesSent++;
            client.sendMessage("Message number: " + messagesSent);
        }
    }

}





