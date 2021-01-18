/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.util.Scanner;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Thanh Phong
 */
public class Tool {
    static Scanner inp = new Scanner(System.in);

    public static void Hello() {
        System.out.println("Go Go");
    }

    public static int CheckInt() {
        int x;
        try {
            x = Integer.parseInt(Tool.inp.nextLine());
        } catch (Exception e) {
            System.out.print("Nhập sai.\nNhập lại: ");
            x = Tool.CheckInt();
        }
        return x;
    }
    public static boolean isNum(String S){
        for(int i=0;i<S.length();i++){
            if((int)S.charAt(i)<48||(int)S.charAt(i)>57){
                return false;
            }
        }
        return true;
    }
    public static float CheckFloat(){
        float x;
        try {
            x = Float.parseFloat(Tool.inp.nextLine());
        } catch (Exception e) {
            System.out.print("Nhập sai.\nNhập lại: ");
            x = Tool.CheckFloat();
        }
        return x;
    }

    public static boolean CheckChanLe(int x) {
        if (x % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int CheckAmDuong(int x) {
        if (x > 0) {
            return 1;
        } else {
            if (x < 0) {
                return -1;
            }
        }
        return 0;
    }

    public static boolean CheckNgTo(int x) {
        if (x < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static JFrame CrJFrame(){
        JFrame f = new JFrame();
        f.setSize(400, 300);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.GRAY);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        return f;
    }
    public static JPanel CrJPanel(){
        JPanel p = new JPanel();
        p.setBounds(10, 10, 350, 150);
        p.setLayout(null);
        p.setBackground(Color.CYAN);
        p.setOpaque(true);

        return p;
    }
    public static JLabel CrJLabel(String title, int x, int y, int width, int height){
        JLabel label = new JLabel(title);
        label.setBounds(x,y,width,height);
        label.setBackground(Color.PINK);
        label.setOpaque(true);
        return label;
    }
    public static TextField CrTextField(int x, int y, int width, int height){
        TextField txt = new TextField();
        txt.setBounds(x,y,width,height);
        return txt;
    }
    public static Button CrButton(String s, int x, int y, int width, int height){
        Button btn = new Button(s);
        btn.setBounds(x,y,width,height);
        btn.setBackground(Color.green);
        return btn;
    }
    public static JComboBox CrComboBox(String [] s,  int x, int y, int width, int height){
        JComboBox cbx = new JComboBox(s);
        cbx.setBounds(x, y, width, height);
        cbx.addActionListener(cbx);
        return cbx;
    }
    
}
