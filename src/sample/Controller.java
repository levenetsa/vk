package sample;


import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class Controller {
    static int counter = 1;

    public static void save(String link) throws IOException {
        if (counter>50){URL website = new URL(link);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("information" + counter + ".mp3");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);}
        counter++;
    }
    public static void draw(){
        JFrame frame=new JFrame();
        frame.setSize(600, 400);
        frame.setVisible(true);
        JButton btn = new JButton("Go");
        btn.setSize(80,40);
        btn.setLocation(0, 0);
        btn.setAction(action);
        frame.add(btn);
    }

    public static Action action = new ActionX();

    public static void main(String[] args) throws IOException {
       /* File file = new File("E:/input.txt");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "UTF-8"));


        String c = new String("a");
        while (c != null) {

            if (c.contains("audios/")) {
                save((String) c.subSequence(c.indexOf("http"), c.length() - 5));

            }
            c = br.readLine();
        }*/
        draw();

    }
}