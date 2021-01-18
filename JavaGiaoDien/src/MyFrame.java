
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Phong
 */
public class MyFrame extends JFrame{
//    - Tạo class my JFrame
//B1: new 1 class mới tên: MyFrame extends JFrame
//B2: tất cả các ctrol Obj nằm trên Frame trở thành thuộc tính của MyFrame
//B3: Xét các giá trị ban đầu cho các  ctron thì viết vào trong class MyFrame - gọi hàm trực tiếp
//	Kể cả hàm event cho btn
    Panel p0 = new Panel();
    Panel p1= new  Panel();
    Panel p2 = new Panel();

    MyFrame() {
        
    };
    
    public static void main(String[] args) {
        MyFrame frame = new  MyFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        String a = (String)JOptionPane.showInputDialog("Nhập số thứ nhấ");
        //Object [] comboliObjects
    }
}
