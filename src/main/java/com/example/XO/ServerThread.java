package com.example.XO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread  extends Thread{
    ServerSocket listener = null;
    Socket socketOfServer = null;
    BufferedReader inputStream =null;
    BufferedWriter outputStream =null ;
    final int serverPort = 8081;
    private int query = 0;
    private XOServerController serverController;
    public int getQuery() {
        return query;
    }

    public void setQuery(int query) {
        this.query = query;
    }

    public ServerThread(XOServerController xoServerController){
        super();
        this.serverController = xoServerController;
    }
    @Override
    public void run() {

        switch (query){
            case 1 -> {

                try {
                    listener = new ServerSocket(serverPort);

                    socketOfServer = listener.accept();
                     inputStream  = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
                     outputStream = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
                } catch (IOException e) {
                    System.out.println(e);
                }catch (Exception e){
                    System.out.println(e);

                }
                System.out.println("setup server ok");
            }
        }
    }
}
