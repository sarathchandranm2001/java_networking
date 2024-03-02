import java.io.*;
import java.net.*;

public class ServerUdp {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        DatagramPacket reply = null;

        try {
            ds = new DatagramSocket(1234);
            byte[] buffer = new byte[1000];
            dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);
            System.out.println("From Client: " + (new String(dp.getData()).trim()));
            System.out.println("Client Port: " + dp.getPort());

            reply = new DatagramPacket("from server ok".getBytes(), "from server ok".length(), dp.getAddress(), dp.getPort());
            ds.send(reply);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } finally {
            if (ds != null) ds.close();
        }
    }
}
