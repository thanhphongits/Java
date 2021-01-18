
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Phong
 */
public class Tuan4 {
    public static void main(String[] args) {
        JFrame f  = new JFrame();
        f.setSize(300, 400);
        f.setTitle("Quản lý sinh viên");
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
         
//        JPanel p = new JPanel();
//        p.setBounds(20, 20, 400, 500);
//        p.setBackground(Color.CYAN);
//        p.setOpaque(true);
//        f.add(p);
        
        JLabel lbHoten = new JLabel("Họ Tên");
        lbHoten.setBounds(30, 30, 40, 25);
        lbHoten.setBackground(Color.green);
        lbHoten.setOpaque(true);
        f.add(lbHoten);
        
        TextField txtHoten = new TextField();
        txtHoten.setBounds(90, 30, 150, 25);
        f.add(txtHoten);
        
        JLabel lbMssv = new JLabel("Mssv");
        lbMssv.setBounds(30, 75, 40, 25);
        lbMssv.setBackground(Color.green);
        lbMssv.setOpaque(true);
        f.add(lbMssv);
        
        TextField txtMssv = new TextField();
        txtMssv.setBounds(90, 75, 150, 25);
        f.add(txtMssv);
        
        JRadioButton btn1RadioButton = new JRadioButton("Học sinh");
        JRadioButton btn2RadioButton = new JRadioButton("Sinh Viên");
        JRadioButton btn3RadioButton = new JRadioButton("Giảng viên");
        f.add(btn1RadioButton);
        f.add(btn2RadioButton);
        f.add(btn3RadioButton);
        btn1RadioButton.setSelected(true);
        
        
        
        
    }
    
}
