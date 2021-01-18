/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Phong
 */
import GUI.Tool;
import java.awt.Color;
import javax.swing.*;

public class Test {

    JFrame f;

    Test() {
       f = Tool.CrJFrame();
                JPanel p = new JPanel();
        p.setBounds(10, 10, 350, 450);
        p.setLayout(null);
        p.setBackground(Color.CYAN);
        p.setOpaque(true);
        String country[] = {"India", "Aus", "U.S.A", "England", "Newzealand"};
        JComboBox cb = new JComboBox(country);
        cb.setBounds(50, 50, 90, 20);
        
       

        p.add(cb);
        
        f.add(p);
     
    }

    public static void main(String[] args) {
        new Test();
    }
}
