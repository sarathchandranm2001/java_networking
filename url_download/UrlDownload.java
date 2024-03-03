package url;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date; // Import Date class

public class UrlDownload {
    public static void main(String[] args) throws Exception {
        int c;
        URL u = new URL("https://example.com"); // Replace with your URL
        URLConnection uc = u.openConnection();
        System.out.println("Date: " + new Date(uc.getDate()));
        System.out.println("Content type: " + uc.getContentType());
        System.out.println("Expires: " + uc.getExpiration());
        System.out.println("Last modified: " + new Date(uc.getLastModified()));
        int len = uc.getContentLength();
        System.out.println("Content length: " + len);
        if (len > 0) {
            FileOutputStream fout = new FileOutputStream("downloaded_content.txt"); // Provide a valid file path
            System.out.println("......Content.........");
            InputStream input = uc.getInputStream();
            int i = 0;
            while (((c = input.read()) != -1) && i < len) { // Corrected condition
                fout.write((char) c);
                i++;
            }
            input.close();
            fout.close();
        } else {
            System.out.println("No Content Available");
        }
    }
}
