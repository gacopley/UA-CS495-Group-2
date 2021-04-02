/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
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
public class TestIP {
    
    public TestIP() {
    }
    
    DatagramSocket ds;
    
    @AfterEach
    public void tearDown() {
        ds.close();
    }
    
    @Test
    public void testIP() throws SocketException, IOException {
        ds = new DatagramSocket(7000, InetAddress.getLocalHost());
        assertEquals(ds.getLocalAddress(), InetAddress.getLocalHost());
    }
}
