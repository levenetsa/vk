package sample;

/**
 * Created by ACER-PC on 10.09.2014.
 */

import java.io.*;
import java.net.*;

public class parser {

    public String getHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static PrintWriter out;
    public static File file;

    public static void main(String args[])throws IOException
    {
        file = new File("get.txt");
        out= new PrintWriter(file);
        parser c = new parser();
        String h=c.getHTML("http://api.vk.com/oauth/authorize?");
        out.print(h);
        out.close();
    }

}