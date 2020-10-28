package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter address: ");
        String address = myScanner.next();
        System.out.println("Enter port: ");
        int port = myScanner.nextInt();
        Client client = new Client(address, port);
        myScanner.nextLine(); // clear scanner after taking int input
        while(client.isConnected){
            System.out.println("Enter message: ");
            String message = myScanner.nextLine();
            client.sendMessage(message);
            if(message.contains("closeConnection")) {
                break;
            }
        }
    }

}





