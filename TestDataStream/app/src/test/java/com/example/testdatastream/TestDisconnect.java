package com.example.testdatastream;

import org.junit.Test;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestDisconnect{
    @Test
    public void test() throws SocketException, UnknownHostException, InterruptedException {
        DatagramSocket ds = new DatagramSocket();
        ds.connect(InetAddress.getLocalHost(), 7100);
        Thread.sleep(1000);
        ds.disconnect();
        assertFalse(ds.isConnected());
    }
}
