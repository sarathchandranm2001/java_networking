import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) {
        Socket cs = null;
        DataOutputStream sout = null;
        DataInputStream sin = null;
        
        try {
            cs = new Socket("localhost", 1234);
            sin = new DataInputStream(cs.getInputStream());
            sout = new DataOutputStream(cs.getOutputStream());
            
            String str = sin.readUTF();
            System.out.println("Server Says: " + str);
            
            sout.writeUTF("Bye");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sout != null) sout.close();
                if (sin != null) sin.close();
                if (cs != null) cs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
