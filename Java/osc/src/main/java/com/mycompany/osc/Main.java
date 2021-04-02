/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.osc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

/**
 *
 * @author Blayde
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        // Step 1 : Create a socket to listen at port 1234
        String s = InetAddress.getLocalHost().toString();
        DatagramSocket ds = new DatagramSocket(7000);
        byte[] receive = new byte[65535];
  
        DatagramPacket DpReceive = null;
        while (true)
        {
                
            // Step 2 : create a DatgramPacket to receive the data.
            DpReceive = new DatagramPacket(receive, receive.length);
  
            // Step 3 : revieve the data in byte buffer.
            ds.receive(DpReceive);
            System.out.println(ds.getLocalPort());
            System.out.println("Client:-" + data(receive));
 
  
            // Clear the buffer after every message.
            receive = new byte[65535];
            //Thread.sleep(1000);
        }
    }
  
    // A utility method to convert the byte array
    // data into a string representation.
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
