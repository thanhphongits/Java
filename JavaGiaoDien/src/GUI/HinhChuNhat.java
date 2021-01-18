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
public class HinhChuNhat {

    public static void main(String[] args) {
        JFrame f = Tool.CrJFrame();
        JPanel p = Tool.CrJPanel();
        f.setTitle("Hình Chữ Nhật");
        JLabel lbldai = Tool.CrJLabel("Chiều dài:", 30, 20, 70, 20);
        p.add(lbldai);
        TextField txtdai = Tool.CrTextField(150, 20, 150, 20);
        p.add(txtdai);
        JLabel lblrong = Tool.CrJLabel("Chiều rộng:", 30, 70, 70, 20);
        p.add(lblrong);
        TextField txtrong = Tool.CrTextField(150, 70, 150, 20);
        p.add(txtrong);
        Button btnchuvi = Tool.CrButton("Chu Vi", 100, 120, 60, 20);
        p.add(btnchuvi);
        Button btndientich = Tool.CrButton("Diện Tích", 200, 120, 60, 20);
        p.add(btndientich);
        
        btnchuvi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dai = txtdai.getText();
                String rong = txtrong.getText();
                if(dai.isEmpty() && rong.isEmpty()){
                    txtdai.setText("Vui lòng nhập số!");
                    txtdai.setForeground(Color.red);
                    txtrong.setText("Vui lòng nhập số!");
                    txtrong.setForeground(Color.red);
                    txtdai.requestFocus();
                }
                else if(dai.isEmpty() || rong.isEmpty()){
                    if (dai.isEmpty()) {
                        txtdai.setText("Vui lòng nhập số");
                        txtdai.setForeground(Color.red);
                        txtdai.requestFocus();
                    } else {
                        txtrong.setText("Vui lòng nhập số");
                        txtrong.setForeground(Color.red);
                        txtrong.requestFocus();
                    }
                }
                else{
                    int tmp = (Integer.parseInt(dai) + Integer.parseInt(rong)) * 2;
                    JOptionPane.showMessageDialog(btnchuvi, "Chu vi là: " + tmp);
                }
                return;
            }
        });
        btndientich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dai = txtdai.getText();
                String rong = txtrong.getText();
                 if(dai.isEmpty() && rong.isEmpty()){
                    txtdai.setText("Vui lòng nhập số!");
                    txtdai.setForeground(Color.red);
                    txtrong.setText("Vui lòng nhập số!");
                    txtrong.setForeground(Color.red);
                    txtdai.requestFocus();
                }
                else if(dai.isEmpty() || rong.isEmpty()){
                    if (dai.isEmpty()) {
                        txtdai.setText("Vui lòng nhập số");
                        txtdai.setForeground(Color.red);
                        txtdai.requestFocus();
                    } else {
                        txtrong.setText("Vui lòng nhập số");
                        txtrong.setForeground(Color.red);
                        txtrong.requestFocus();
                    }
                }
                else{
                    int tmp = Integer.parseInt(dai) * Integer.parseInt(rong);
                    JOptionPane.showMessageDialog(btnchuvi, "Diện tích là: " + tmp);
                }
                 return;
            }
        });
        f.add(p);
    }
}
