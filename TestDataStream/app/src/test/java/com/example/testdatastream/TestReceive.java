package com.example.testdatastream;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestReceive{
    @Test
    public void test() throws IOException, InterruptedException {
        DatagramSocket ds = new DatagramSocket(7100, InetAddress.getLocalHost());
        byte[] receive = new byte[65535];

        DatagramPacket DpReceive = null;

        // Step 2 : create a DatgramPacket to receive the data.
        DpReceive = new DatagramPacket(receive, receive.length);

        // Step 3 : revieve the data in byte buffer.
        ds.receive(DpReceive);

        System.out.println("Client:-" + data(receive));

        assertTrue(!data(receive).toString().isEmpty());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestPort.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static StringBuilder data(byte[] a) {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}