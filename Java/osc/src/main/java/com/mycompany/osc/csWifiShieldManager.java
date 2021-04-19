/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.osc;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Blayde
 */
public class csWifiShieldManager {
    public  InetAddress addr;
    
    public csWifiShieldManager(InetAddress add){
        addr = add;        
    } 
    
    public void SetupStream() throws MalformedURLException, IOException{
        URL url = new URL("http://"+addr.toString()+"/udp");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);
        byte[] out = ("{\"delimiter\":false,\"ip\":\""+addr.toString()+"\",\"latency\":10000,\"output\":\"raw\",\"port\":80,\"sample_numbers\":true,\"timestamps\":true}").getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try ( OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
        http.disconnect();
    }
    
    public void StartStream() throws MalformedURLException, IOException{
        URL url = new URL("http://"+addr.toString()+"/stream/start");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("GET");
        http.connect();
        http.disconnect();
    }
    
    public void StopStream() throws MalformedURLException, IOException{
        URL url = new URL("http://"+addr.toString()+"/stream/stop");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("GET");
        http.connect();
        http.disconnect();
    }
}
