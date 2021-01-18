/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Thanh Phong
 */
public class _752020JTable {
    private JFrame f;
    JTextField[] txt;
    JLabel lb1;
    JButton[] btn;
    JPanel top,middle,bot;
    public void NewClass()
    {
        init();
    }
    public void init(){
        
        JFrame f = new JFrame("Chương trình quản lý sinh viên");
        f.setSize(800, 600);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        
        p.setBounds(0, 0, 800, 200);
        p.setLayout(new GridLayout(1,4));
        
        p1.setBounds(0, 0, 200, 200);
        p1.setBackground(Color.CYAN);
        p1.setOpaque(true);
        
        p2.setBounds(200, 0, 200, 200);
        p2.setLayout(new GridLayout(5,1));
        p2.setBackground(Color.GREEN);
        p2.setOpaque(true);
       
        
        JLabel lbl1 = new JLabel("Mã sinh viên", SwingConstants.CENTER);

        
        JLabel lbl2 = new JLabel("Họ tên", SwingConstants.CENTER);
       
        
        JLabel lbl3 = new JLabel("Năm sinh", SwingConstants.CENTER);
        
        JLabel lbl4 = new JLabel("Địa chỉ",SwingConstants.CENTER);
        
        
        JLabel lbl5 = new JLabel("Điện thoại", SwingConstants.CENTER);
       
        
        p2.add(lbl1);
        p2.add(lbl2);
        p2.add(lbl3);
        p2.add(lbl4);
        p2.add(lbl5);
        
        
        
        p3.setBounds(400, 0, 200, 200);
        p3.setBackground(Color.GRAY);
        p3.setLayout(new GridLayout(5, 1));
        p3.setOpaque(true);
        JTextField txt1 = new JTextField();
        JTextField txt2 = new JTextField();
        JTextField txt3 = new JTextField();
        JTextField txt4 = new JTextField();
        JTextField txt5 = new JTextField();
        
        p3.add(txt1);
        p3.add(txt2);
        p3.add(txt3);
        p3.add(txt4);
        p3.add(txt5);
        
        p4.setBounds(600, 0, 200, 200);
        p4.setBackground(Color.ORANGE);
        p4.setOpaque(true);
        p4.setLayout(null);
        
        JButton btn1 = new JButton("Thêm");
        btn1.setSize(20, 50);
        btn1.setBounds(50, 20, 100, 30);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btn1, "Thêm");
                return;
            }
        });
        
        JButton btn2 = new JButton("Sửa");
        btn2.setSize(20, 50);
        btn2.setBounds(50, 70, 100, 30);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btn2, "Sửa");
                return;
            }
        });
        
        JButton btn3 = new JButton("Xóa");
        btn3.setSize(20, 50);
        btn3.setBounds(50, 120, 100, 30);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btn3, "Xóa");
                return;
            }
        });
        
        p4.add(btn1);
        p4.add(btn2);
        p4.add(btn3);
        
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        
        
        f.add(p);
        f.setLayout(null);
        f.setVisible(true);
        top = new JPanel();
        top.setBounds(0, 0, 550, 30);
        top.setBackground(Color.red);

        
        
        middle=CreatePanel_SinhVien();
        middle.setBounds(0, 0, 850, 850);
        middle.setBackground(Color.GRAY);
        
         JTable tb1 ;
         String[][] data= {
            {"1","Nguyễn Văn Tèo","1999","Bến Tre","1234", "abc"},
            {"2","Trần Văn Bưỡi","1998","Long An","1234", "abc"},
           
        };
        String[] columnNames = {"MSSV", "Họ Tên", "Năm Sinh","Địa Chỉ", "Điện Thoại", "Hình"}; 
        tb1 = new JTable(data,columnNames);
      
        
        JScrollPane sp = new JScrollPane(tb1);
        sp.setBounds(0,200,790,200);
        tb1.getTableHeader().setForeground(Color.WHITE);
        tb1.getTableHeader().setBackground(Color.yellow);
        tb1.setSelectionBackground(new Color(52,100,219));   
        tb1.getTableHeader().setOpaque(true);
        tb1.setPreferredSize(new Dimension(300,300));
        
        middle.add(sp);
        f.add(top);
        f.add(middle);
        f.setVisible(true);
    }
   
    private JPanel CreatePanel_SinhVien() {
        JPanel pSinhVien = new JPanel();
        btn= new JButton[10];
        txt=new JTextField[10];
        String[] mangSV = {"MSSV", "Họ Tên", "Năm Sinh","Địa Chỉ", "Điện Thoại", "Hình"} ;       
        pSinhVien.setLayout(null);
        
       
        return pSinhVien; 
    }
    private void tblDSSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSVMouseClicked
          // Chưa viết đc hàm này

    }//GEN-LAST:event_tblDSSVMouseClicked

    

    public static void main(String[] args) {

        _752020JTable a = new _752020JTable();
        a.NewClass();
    }
}
