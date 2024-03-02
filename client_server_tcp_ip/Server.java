import java.io.*;
import java.net.*;


/**
 * Server
 */
class Server {
    public static void main(String[] args) {
        ServerSocket ss;
        Socket as;
        DataInputStream sin;
        DataOutputStream sout;
        try{
            ss=new ServerSocket(1234, 0);
            as=ss.accept();
            sin=new DataInputStream(as.getInputStream());
            sout=new DataOutputStream(as.getOutputStream());
            sout.writeUTF("Welcome Clinet");
            String str=sin.readUTF();
            System.out.println("Client says :"+str);
            System.in.read();
         }
         catch (IOException e){System.err.println("IOExcption in server: "+e);}
    }


    
}