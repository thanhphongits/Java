

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Phong
 */
import java.awt.Color;import java.awt.Container;import java.awt.FlowLayout;
import java.awt.JobAttributes;
import static java.awt.SystemColor.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
public class Flowlayout extends JFrame {
    private static final long serialVersionUID = 1L;

public Flowlayout(String title)

{

setTitle(title);

JPanel pnFlow=new JPanel();

pnFlow.setLayout(new FlowLayout());

pnFlow.setBackground(Color.PINK);

JButton btn1=new JButton("FlowLayout");

JButton btn2=new JButton("Add các control");

JButton btn3=new JButton("Trên 1 dòng");

JButton btn4=new JButton("Hết chỗ chứa");

JButton btn5=new JButton("Thì xuống dòng");

btn5.addActionListener(new ActionListener() {
    @Override
public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub
JOptionPane.showMessageDialog(null, "Button 5 được click!");
}});

pnFlow.add(btn1);

pnFlow.add(btn2);

pnFlow.add(btn3);

pnFlow.add(btn4);

pnFlow.add(btn5);

Container con=getContentPane();

con.add(pnFlow);

}

public static void main(String[] args)

{

Flowlayout myUI=new Flowlayout("Demo FlowLayout");

myUI.setSize(600, 100);

myUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

myUI.setLocationRelativeTo(null);

myUI.setVisible(true);

}

}
