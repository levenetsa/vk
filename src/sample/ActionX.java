package sample;

import com.sun.xml.internal.ws.api.client.SelectOptimalEncodingFeature;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;

/**
 * Created by ACER-PC on 17.09.2014.
 */
public class ActionX extends AbstractAction {
    String text1;
    String text2;
    public  ActionX(String s,String s1) {
        text1=s;
        text2=s1;
    }

    public void actionPerformed(ActionEvent e) {

        System.out.println();
    }
}
