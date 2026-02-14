package com.example.speech;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

public class ArduinoConnectBluetooth {

    public ArduinoConnectBluetooth() throws InterruptedException, IOException{

                //scan for all devices:
    /*      scanFinished = false;
        LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, new DiscoveryListener() {
            @Override
            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                try {
                    String name = btDevice.getFriendlyName(false);
                    System.out.format("%s (%s)\n", name, btDevice.getBluetoothAddress());
                    if (name.matches("HC.*")) {
                        hc05device = btDevice;
                        System.out.println("got it!");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void inquiryCompleted(int discType) {
                scanFinished = true;
            }

            @Override
            public void serviceSearchCompleted(int transID, int respCode) {
            }

            @Override
            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
            }
        });
        while (!scanFinished) {
            //this is easier to understand (for me) as the thread stuff examples from bluecove
            Thread.sleep(500);
        }

        //search for services:
        UUID uuid = new UUID(0x1101); //scan for btspp://... services (as HC-05 offers it)
        UUID[] searchUuidSet = new UUID[]{uuid};
        int[] attrIDs = new int[]{
            0x0100 // service name
        };
        scanFinished = false;
        LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet,
                hc05device, new DiscoveryListener() {
                    @Override
                    public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                    }

                    @Override
                    public void inquiryCompleted(int discType) {
                    }

                    @Override
                    public void serviceSearchCompleted(int transID, int respCode) {
                        scanFinished = true;
                    }

                    @Override
                    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
                        for (int i = 0; i < servRecord.length; i++) {
                            hc05Url = servRecord[i].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
                            if (hc05Url != null) {
                                break; //take the first one
                            }
                        }
                    }
                });

        while (!scanFinished) {
            Thread.sleep(500);
        }
*/
        hc05Url = "btspp://98D311FD2017:1;authenticate=false;encrypt=false;master=false";
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
           
       //  System.out.println(is.read()); 
       //  os.write("0".getBytes());
        /* for( int i=0; i<100; i++){
            os.write("1".toString().getBytes()); //just send '1' to the device
            os.write("1".toString().getBytes());
            os.write("1".toString().getBytes());
            System.out.println("sent data: ");
            Thread.sleep(500);
        }*/
        
        //
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


}