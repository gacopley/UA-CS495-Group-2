/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import static java.time.Duration.ofMillis;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Blayde
 */
public class TestDisconnect {

    public TestDisconnect() {
    }

    DatagramSocket ds;

    @AfterEach
    public void tearDown() {
        ds.disconnect();
        ds.close();
    }
    
    private static final int MIN_TIMEOUT = 100;

    @Test
    public void testTimeout() throws IOException, InterruptedException {
        ds = new DatagramSocket();
        ds.connect(InetAddress.getLocalHost(), 7000);
        Thread.sleep(1000);
        ds.disconnect();
        assertFalse(ds.isConnected());
    }

}
