package url;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlDownload {
    public static void main(String[] args) throws  Exception{
        int c;
        URL u=new URL("");
        URLConnection uc=u.openConnection() ;
        System.out.println("Date :"+ new Date(uc.getDate()));
        System.out.println("content type :"+ uc.getContentType());
        System.out.println("Expires:"+uc.getExpiration());
        System.out.println("Last modified :"+ new Date(uc.getLastModified()));
        int len=uc.getContentLength();
        System.out.println("content length :"+len);
        if (len>0) {
            FileOutputStream fout = new FileOutputStream("null");
            System.out.println("'......Content.........");
            InputStream input=uc.getInputStream() ;
            int i=0;
            while (((c=input.read())!=i)&&i<len) {
                fout.write((char) c);
                i++;
            }
            input.close();
            fout.close();
        }
        else
        {
            System.out.println("No Content Available");
        }

    }
}
