package com.java.ee.lesson2.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerCustomSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket clientSocket = serverSocket.accept();

        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
        printWriter.println("hello from server");
        printWriter.flush();
        String msgFromClient;
        while (!"stop".equals(msgFromClient = reader.readLine())) {
            System.out.println("msg from client = " + msgFromClient);
            String serverMsg = scanner.nextLine();
            printWriter.println(serverMsg);
            printWriter.flush();
        }
    }
}
