//udp server
import java.io.*;
import java.net.*;
public class ServerUdp {
    public static void main(String[] args) {
        DatagramSocket ds=null;
        DatagramPacket dp=null;
        try{
            ds=new DatagramSocket(1234);
            byte[] buffer=new byte[1000];
            dp= new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);
            System.out.println("From Client :"+(new String(dp.getData()).trim()));
            System.out.println("CLinet Port :"+dp.getPort());
            rely=new DatagramSocket()
        }
    }

    
}