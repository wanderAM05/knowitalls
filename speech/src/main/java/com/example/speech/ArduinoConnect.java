package com.example.speech;


import com.fazecast.jSerialComm.SerialPort;

   
public class ArduinoConnect  {
   
   
   public ArduinoConnect() {
     
   }
   
   public void Send() throws Exception {
      SerialPort sp = SerialPort.getCommPort("COM3"); // device name 
      sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
      sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written
      
      if (sp.openPort()) {
         System.out.println("Port is open :)");
      } else {
         System.out.println("Failed to open port :(");
         return;
      }		
      
      Integer j=1;
      //sp.getOutputStream().write(j.byteValue());
        // sp.getOutputStream().flush();
         //Thread.sleep(10000);
       for (int i=0; i<2; i++){
         sp.getOutputStream().write(j.byteValue());
         sp.getOutputStream().flush();
          Thread.sleep(5000);
      }
      
      if (sp.closePort()) {
         System.out.println("Port is closed :)");
      } else {
         System.out.println("Failed to close port :(");
         return;
      }
    
   }
}