package sample;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Controller {
    static int counter = 1;

    public static void save(String link,String s) throws IOException {

            URL website = new URL(link);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(s+"information" + counter + ".mp3");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        counter++;
    }

    public static String s1 = "1", s2 = "2";

    public static void draw() {
        final JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(550, 400);
        frame.setVisible(true);
        final JButton button = new JButton();
        button.setText("go");
        button.setLocation(new Point(80, 40));
        button.setPreferredSize(new Dimension(80, 40));
        final JTextField field1 = new JTextField();
        field1.setPreferredSize(new Dimension(500, 20));
        final JTextField field2 = new JTextField();
        final JLabel label3=new JLabel("enter folders");
        ActionListener actL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    s1 = field1.getText();
                    s2 = field2.getText();
                   // System.out.println(s1 + " " + s2);
                    try {
                        File file = new File(s1);
                        BufferedReader br = null;

                        br = new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(file), "UTF-8"));


                        String c = new String("a");
                       int counter1=0;

                        label3.setText("wait");
                        while (c != null) {

                            if (c.contains("audios/")) {
                                save((String) c.subSequence(c.indexOf("http"), c.length() - 5),s2);

                                counter1++;

                            }
                            c = br.readLine();
                        }
                        label3.setText("done");
                    } catch (Exception e1) {

                    }
                }


            }
        };
        button.addActionListener(actL);
        field2.setPreferredSize(new Dimension(500, 20));
        JLabel label1 = new JLabel("Input  ");
        JLabel label2 = new JLabel("  Layout");
        panel.setVisible(true);
        panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);
        panel.add(button);
        panel.add(label3);
        frame.getContentPane().add(panel);


    }


    public static void main(String[] args) throws IOException {

        draw();

    }
}