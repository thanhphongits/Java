
package ConnectDB;

import GUI.Admin_GUI;
import GUI.DangNhap_GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class XuLyDatabase {
    private static String dbURL = "jdbc:mysql://localhost:3306/doanjava?useUnicode=yes&characterEncoding=UTF-8";
    private static String userName = "root";
    private static String password = "";
    
//    public static int checkTrangThaiLogin = 0;
//    public static Connection conn = null;
        
        //Start Hàm kết nối cơ sở dữ liệu
        public Connection openConnection(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, userName, password);
                if(conn != null){
                    System.out.println("Kết nối DB thành công!");
                    return conn;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Kết nối DB thất bại!");
                System.out.println("Kết nối DB thất bại!");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {      
            Logger.getLogger(XuLyDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }
        //End Hàm kết nối cơ sở dữ liệu
        
        //Start Hàm ĐÓNG kết nối cơ sở dữ liệu
        public void closeConnection(Connection conn){
            try {
                if(conn!=null)
                    conn.close();
                    System.out.println("Đóng kết nối DB thành công!");
            } catch (SQLException ex) {
                System.out.println("Đóng kết nối DB thất bại!");
                ex.printStackTrace();
            }
        }
        //End Hàm ĐÓNG kết nối cơ sở dữ liệu
   
        
    }

