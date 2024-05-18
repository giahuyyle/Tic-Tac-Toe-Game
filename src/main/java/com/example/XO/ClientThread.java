package com.example.XO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientThread extends Thread{
    final String serverHost = "localhost";

    private Socket socketOfClient = null;
    private BufferedWriter outputStream = null;
    private BufferedReader inputStream = null;
    private XOClientController clientController;

    private int query = 0;
    public ClientThread(XOClientController xoClientController){
        super();
        this.clientController = xoClientController;
    }

    public int getQuery() {
        return query;
    }

    public void setQuery(int query) {
        this.query = query;
    }

    @Override
    public void run() {
        switch (query){
            case 1 -> {
                try {
                    socketOfClient = new Socket(serverHost, Integer.valueOf (clientController.portTextField.getText()));
                    outputStream = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
                    inputStream = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));

                } catch (UnknownHostException e) {
                    System.err.println("Don't know about host " + serverHost);
                } catch (IOException e) {
                    System.err.println("Couldn't get I/O for the connection to " + serverHost);
                }catch (Exception e){

                }

                try {
                    outputStream.write(getQuery() + " " + clientController.nameTextField.getText());
                    outputStream.newLine();
                    outputStream.flush();
                } catch (UnknownHostException e) {
                    System.err.println("Trying to connect to unknown host: " + e);
                } catch (IOException e) {
                    System.err.println("IOException:  " + e);
                }catch (Exception e){

                }

            }
        }

    }
}
