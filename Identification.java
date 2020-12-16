import java.net.*;
import java.util.*;

public class Identification{
   InetAddress localIp; //the local ip in a string
   Enumeration<NetworkInterface> networkInterfaces; //all interfaces' mac adress in A String of
                                                    //ArrayList                  
   //constructor that check all needed data in the begining, for once.
   public Identification() throws Exception{
      localIp = InetAddress.getLocalHost();
      networkInterfaces = NetworkInterface.getNetworkInterfaces();
   }
   
   //returns local ip in a String
   public String getLocalIp() throws Exception{
      return localIp.toString();
   }
   
   //returns all interfaces' MAC address in an ArrayList of String
   public ArrayList<String> getMAC() throws Exception{
      ArrayList<String> out = new ArrayList<>();
      
      while (networkInterfaces.hasMoreElements()) {
         NetworkInterface ni = networkInterfaces.nextElement();
         byte[] hardwareAddress = ni.getHardwareAddress();
         if (hardwareAddress != null) {
            String[] hexadecimalFormat = new String[hardwareAddress.length];
            for (int i = 0; i < hardwareAddress.length; i++) {
               hexadecimalFormat[i] = String.format("%02X", hardwareAddress[i]);
            }
            out.add(String.join("-", hexadecimalFormat));
         }
      }
      return out;
   }
}