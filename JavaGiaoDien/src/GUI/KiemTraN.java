/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Button;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Thanh Phong
 */
public class KiemTraN {

    public static void main(String[] args) {
        JFrame f = Tool.CrJFrame();
        JPanel p = Tool.CrJPanel();
        f.setTitle("Nhập N Và Kiểm Tra");
        JLabel lbln = Tool.CrJLabel("Nhập N:", 30, 20, 70, 20);
        p.add(lbln);
        TextField txtn = Tool.CrTextField(150, 20, 150, 20);
        p.add(txtn);

        JRadioButton rdcl = new JRadioButton("Chẳn lẻ");
        rdcl.setBounds(30, 70, 75, 20);
        p.add(rdcl);
        JRadioButton rdss = new JRadioButton("So Sánh");
        rdss.setBounds(130, 70, 75, 20);
        p.add(rdss);
        JRadioButton rdnt = new JRadioButton("Nguyên Tố");
        rdnt.setBounds(240, 70, 85, 20);
        p.add(rdnt);

        ButtonGroup k = new ButtonGroup();
        k.add(rdcl);
        k.add(rdnt);
        k.add(rdss);

        rdcl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = txtn.getText();
                if (txt.isEmpty()) {
                    txtn.setText("Vui lòng nhập số!");
                    txtn.setForeground(Color.red);
                    txtn.requestFocus();
                } else {
                    if(Integer.parseInt(txt) % 2 == 0) JOptionPane.showMessageDialog(rdcl, "N là số chẵn !");
                    else JOptionPane.showMessageDialog(rdcl, "N là số lẽ !");
                }
                return;
            }
        });
        rdnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = txtn.getText();
                if (txt.isEmpty()) {
                    txtn.setText("Vui lòng nhập số!");
                    txtn.setForeground(Color.red);
                    txtn.requestFocus();
                } else {
                    if(Tool.CheckNgTo(Integer.parseInt(txt))) JOptionPane.showMessageDialog(rdcl, "N là số nguyên tố !");
                    else JOptionPane.showMessageDialog(rdcl, "N không là số nguyên tố !");
                }
                return;
            }
        });
        rdss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = txtn.getText();
                if (txt.isEmpty()) {
                    txtn.setText("Vui lòng nhập số!");
                    txtn.setForeground(Color.red);
                    txtn.requestFocus();
                } else {
                    if(Integer.parseInt(txt) >  0) JOptionPane.showMessageDialog(rdcl, "N là số dương !");
                    else if(Integer.parseInt(txt) <  0) JOptionPane.showMessageDialog(rdcl, "N là âm !");
                    else JOptionPane.showMessageDialog(rdcl, "N là không !");
                }
                return;
            }
        });

        f.add(p);
    }
}
