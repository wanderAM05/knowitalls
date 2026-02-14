package com.example;
import java.io.IOException;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

public class ArduinoConnectBluetoothNew {
    
    private static OutputStream os;
    private static StreamConnection streamConnection;
    public static void connect () throws InterruptedException, IOException{
        String hc05Url = "btspp://98D311FD2017:1;authenticate=false;encrypt=false;master=false";
       // System.out.println(hc05device.getBluetoothAddress());
        System.out.println(hc05Url);

         //if you know your hc05Url this is all you need:
        streamConnection = (StreamConnection) Connector.open(hc05Url);
        os = streamConnection.openOutputStream();
    }
    public static void send() throws IOException{
        double d = Math.random();
        Integer x = (int) Math.round(d);
        x++;
        System.out.println(d);
        os.write(x.toString().getBytes()); 
        System.out.println("sent data: ");
    }
    public static void disconnect() throws IOException{
        os.close();
        streamConnection.close();
    }


    /*
     *         hc05Url = "btspp://98D311FD2017:1;authenticate=false;encrypt=false;master=false";
       // System.out.println(hc05device.getBluetoothAddress());
        System.out.println(hc05Url);

         //if you know your hc05Url this is all you need:
        StreamConnection streamConnection = (StreamConnection) Connector.open(hc05Url);
        OutputStream os = streamConnection.openOutputStream();
        InputStream is = streamConnection.openInputStream();
        double d = Math.random();
        Integer x = (int) Math.round(d);
        x++;
         System.out.println(d);
         os.write(x.toString().getBytes()); 
           
      
        System.out.println("sent data: ");
        os.close();
        is.close();
        streamConnection.close();

    }
    RemoteDevice hc05device;
    String hc05Url;
    boolean scanFinished;
    public void Send() throws Exception {
    }
     */
    
}
