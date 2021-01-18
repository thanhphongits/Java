/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Thanh Phong
 */
public class HinhTron {

    public static void main(String[] args) {
        JFrame f = Tool.CrJFrame();
        JPanel p = Tool.CrJPanel();
         f.setTitle("Hình Tròn");
        JLabel lblbk = Tool.CrJLabel("Bán kính:", 30, 20, 70, 20);
        p.add(lblbk);
        TextField txtbk = Tool.CrTextField(150, 20, 150, 20);
        p.add(txtbk);
        Button btnchuvi = Tool.CrButton("Chu Vi", 100, 70, 60, 20);
        p.add(btnchuvi);
        Button btndientich = Tool.CrButton("Diện Tích", 200, 70, 60, 20);
        p.add(btndientich);

        btnchuvi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bk = txtbk.getText();
                if (bk.isEmpty()) {
                    {
                        txtbk.setText("Vui lòng nhập số");
                        txtbk.setForeground(Color.red);

                        txtbk.requestFocus();
                    }
                } else {
                    double tmp = Integer.parseInt(bk) * 2 * Math.PI;
                    JOptionPane.showMessageDialog(btnchuvi, "Chu vi là: " + tmp);
                }
                return;
            }
        });
        btndientich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bk = txtbk.getText();
                if (bk.isEmpty()) {
                    {
                        txtbk.setText("Vui lòng nhập số");
                        txtbk.setForeground(Color.red);

                        txtbk.requestFocus();
                    }
                } else {
                    double tmp = Integer.parseInt(bk) * Integer.parseInt(bk) * Math.PI;
                    JOptionPane.showMessageDialog(btnchuvi, "Diện tích là: " + tmp);
                }
                return;
            }
        });
        f.add(p);
    }
}
