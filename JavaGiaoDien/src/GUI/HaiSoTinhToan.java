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
import javafx.beans.binding.Bindings;
import javafx.scene.control.ComboBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Thanh Phong
 */
public class HaiSoTinhToan {

    public static void main(String[] args) {
        JFrame f = Tool.CrJFrame();
        f.setTitle("Hai Số Tính Toán");
        JPanel p = Tool.CrJPanel();

        JLabel lblone = Tool.CrJLabel("Số thứ nhất:", 30, 20, 70, 20);
        p.add(lblone);
        TextField txtone = Tool.CrTextField(150, 20, 150, 20);
        p.add(txtone);

        JLabel lbltwo = Tool.CrJLabel("Số thứ hai:", 30, 70, 70, 20);
        p.add(lbltwo);
        TextField txttwo = Tool.CrTextField(150, 70, 150, 20);
        p.add(txttwo);

        Button btntong = Tool.CrButton("Tổng", 50, 120, 50, 20);
        p.add(btntong);
        Button btnhieu = Tool.CrButton("Hiệu", 120, 120, 50, 20);
        p.add(btnhieu);
        Button btntich = Tool.CrButton("Tích", 190, 120, 50, 20);
        p.add(btntich);
        Button btnthuong = Tool.CrButton("Thương", 260, 120, 50, 20);
        p.add(btnthuong);

        btntong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String one = txtone.getText();
                String two = txttwo.getText();
                if (one.isEmpty() && two.isEmpty()) {
                    {
                        txtone.setText("Vui lòng nhập số");
                        txtone.setForeground(Color.red);
                        txttwo.setText("Vui lòng nhập số");
                        txttwo.setForeground(Color.red);
                        txtone.requestFocus();
                    }
                } else if (one.isEmpty() || two.isEmpty()) {
                    if (one.isEmpty()) {
                        txtone.setText("Vui lòng nhập số");
                        txtone.setForeground(Color.red);
                        txtone.requestFocus();
                    } else {
                        txttwo.setText("Vui lòng nhập số");
                        txttwo.setForeground(Color.red);
                        txttwo.requestFocus();
                    }
                } else {
                    int tmp = Integer.parseInt(one) + Integer.parseInt(two);
                    JOptionPane.showMessageDialog(btntong, "Kết quả là: " + tmp);
                }
                return;
            }
        });
        btnhieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String one = txtone.getText();
                String two = txttwo.getText();
                if (one.isEmpty() && two.isEmpty()) {
                    {
                        txtone.setText("Vui lòng nhập số");
                        txtone.setForeground(Color.red);
                        txttwo.setText("Vui lòng nhập số");
                        txttwo.setForeground(Color.red);
                        txtone.requestFocus();
                    }
                } else if (one.isEmpty() || two.isEmpty()) {
                    if (one.isEmpty()) {
                        txtone.setText("Vui lòng nhập số");
                        txtone.setForeground(Color.red);
                        txtone.requestFocus();
                    } else {
                        txttwo.setText("Vui lòng nhập số");
                        txttwo.setForeground(Color.red);
                        txttwo.requestFocus();
                    }
                } else {
                    int tmp = Integer.parseInt(one) - Integer.parseInt(two);
                    JOptionPane.showMessageDialog(btnhieu, "Kết quả là: " + tmp);
                }
                return;
            }
        });
        btntich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String one = txtone.getText();
                String two = txttwo.getText();
                if (one.isEmpty() && two.isEmpty()) {
                    {
                        txtone.setText("Vui lòng nhập số");
                        txtone.setForeground(Color.red);
                        txttwo.setText("Vui lòng nhập số");
                        txttwo.setForeground(Color.red);
                        txtone.requestFocus();
                    }
                } else if (one.isEmpty() || two.isEmpty()) {
                    if (one.isEmpty()) {
                        txtone.setText("Vui lòng nhập số");
                        txtone.setForeground(Color.red);
                        txtone.requestFocus();
                    } else {
                        txttwo.setText("Vui lòng nhập số");
                        txttwo.setForeground(Color.red);
                        txttwo.requestFocus();
                    }
                } else {
                    int tmp = Integer.parseInt(one) * Integer.parseInt(two);
                    JOptionPane.showMessageDialog(btntich, "Kết quả là: " + tmp);
                }
                return;
            }
        });
        btnthuong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String one = txtone.getText();
                String two = txttwo.getText();
                if (one.isEmpty() && two.isEmpty()) {
                    {
                        txtone.setText("Vui lòng nhập số");
                        txtone.setForeground(Color.red);
                        txttwo.setText("Vui lòng nhập số");
                        txttwo.setForeground(Color.red);
                        txtone.requestFocus();
                    }
                } else if (one.isEmpty() || two.isEmpty()) {
                    if (one.isEmpty()) {
                        txtone.setText("Vui lòng nhập số");
                        txtone.setForeground(Color.red);
                        txtone.requestFocus();
                    } else {
                        txttwo.setText("Vui lòng nhập số");
                        txttwo.setForeground(Color.red);
                        txttwo.requestFocus();
                    }
                } else {
                    if (Integer.parseInt(two) == 0) {
                        JOptionPane.showMessageDialog(btnthuong, "Không chia được!");
                    } else {
                        float tmp = (float)(Integer.parseInt(one) / Integer.parseInt(two));
                        JOptionPane.showMessageDialog(btnthuong, "Kết quả là: " + tmp);
                    }
                }
                return;
            }
        });

        f.add(p);

    }
}
