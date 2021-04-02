/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blayde
 */

import com.illposed.osc.OSCPacketListener;
import com.illposed.osc.OSCMessageListener;
import com.illposed.osc.transport.udp.OSCPortIn;
import com.illposed.osc.transport.udp.OSCPortOut;
import com.illposed.osc.OSCMessageEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewClass {
    static public OSCPortOut sender = null;
    static private OSCPortIn  receiver;
    static public InetAddress targetIP;
    static int port = 5001;

     public static void main(String[] args){
        System.out.println("GI");
        try {
            targetIP = InetAddress.getByName("127.0.0.1");
            sender = new OSCPortOut(targetIP, 4000);
            receiver = new OSCPortIn(4000);
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        OSCMessageListener listener = new OSCMessageListener() {@Override
            public void acceptMessage(OSCMessageEvent message) {

                System.out.println("myMessage_received!");              
                //Object [] args = message.getArguments();
                //String myTitle = args[0].toString();
                //int currentValue = (Integer)args[1];
            }
        };
        receiver.startListening();
    }
}
