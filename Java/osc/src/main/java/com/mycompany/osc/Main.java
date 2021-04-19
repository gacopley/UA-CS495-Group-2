/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.osc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 *
 * @author Blayde
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        String s = InetAddress.getLocalHost().toString();
        System.out.println(s);
        DatagramSocket ds = new DatagramSocket(8000);
        byte[] receive = new byte[65535];
  
        DatagramPacket DpReceive = null;
        while (true)
        {
                
            // Step 2 : create a DatgramPacket to receive the data.
            DpReceive = new DatagramPacket(receive, receive.length);
  
            // Step 3 : revieve the data in byte buffer.
            ds.receive(DpReceive);
            System.out.println(ds.getLocalPort()+"  "+ds.getLocalSocketAddress().toString());
            String s1 = data(receive).toString();
            System.out.println(s1.replace("[", "").split(":")[2].split(",")[0]);
            //float val = Float.parseFloat(s1.split("[")[2].split(",")[0]);
            
            
  
            // Clear the buffer after every message.
            receive = new byte[65535];
            //Thread.sleep(1000);
        }
//
        // 1 : Create a socket to listen at port 1234
//        DatagramSocket ds = null;
//        try {
//            System.out.println(InetAddress.getLocalHost().toString());
//            ds = new DatagramSocket();
//            ds.connect(InetAddress.getLocalHost(), 7000);
//
//        } catch (SocketException e) {
//            e.printStackTrace();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        while (true) {
//            byte[] receive = new byte[65535];
//
//            DatagramPacket DpReceive = null;
//
//            // Step 2 : create a DatgramPacket to receive the data.
//            DpReceive = new DatagramPacket(receive, receive.length);
//
//            // Step 3 : revieve the data in byte buffer.
//            try {
//                ds.receive(DpReceive);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("Client:-" + data(receive));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
    //Thread.sleep(1000);

    // A utility method to convert the byte array
    // data into a string representation.
    public static StringBuilder data(byte[] a) {
        if (a == null) {
            return null;
        }
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
