
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Thanh Phong
 */
public class JFrameCode {
    public JFrameCode(){
        JLabel lable = new JLabel("Hello World", SwingConstants.CENTER);
        JButton btn = new JButton("Đăng Nhập");
        lable.setForeground(Color.red);
        lable.setFont(new Font(Font.SERIF, Font.BOLD, 40));
//        this.setTitle("Thanh Phong");
//        this.setSize(500, 500);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//        this.add(lable);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Xin chào");
        f.setSize(400, 500);
        
        f.setLayout(null);
        f.setVisible(true);
        Button btn = new Button("OK");
        btn.setSize(50,70);
        
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        btn.setBounds(50, 50, 100, 100);
        f.add(btn);
    }
}
