package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Enter address: ");
        Scanner myScanner = new Scanner(System.in);
        String address = myScanner.next();
        System.out.println("Enter port: ");
        int port = myScanner.nextInt();
        Client client = new Client(address, port);
        myScanner.nextLine();
        while(client.isConnected){
            System.out.println("Enter message: ");
            String message = myScanner.nextLine();
            client.sendMessage(message);
        }
    }

}





