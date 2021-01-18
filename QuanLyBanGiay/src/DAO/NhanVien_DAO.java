/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDB.XuLyDatabase;
import DTO.ChucVu_DTO;
import DTO.NhanVien_DTO;
import GUI.QuanLyNhanVien_GUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author mend
 */
public class NhanVien_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    
    //Start Hàm đăng nhập quản trị
    public ResultSet LoginQuanTri(String tenTaiKhoanNV, String matKhauNV){  
            PreparedStatement ps = null;
            ResultSet resultLogin = null;
            Connection connection = null;
            
            try {
                    xuLyDB = new XuLyDatabase();
                    connection = xuLyDB.openConnection();
                    String query = "SELECT * FROM tbl_nhanvien\n" + "WHERE tenTaiKhoanNV = ? AND matKhauNV = ? ";

                    ps = connection.prepareStatement(query);
                    ps.setString(1, tenTaiKhoanNV);
                    ps.setString(2, matKhauNV);

                    resultLogin = ps.executeQuery();
                    
                    return resultLogin;
                    
                }catch(Exception e){
                        System.out.print(e);
                }
 
          return null;
        }
    //End Hàm đăng nhập quản trị
    
    public ArrayList<NhanVien_DTO> getAllNhanVien() throws ClassNotFoundException{
        
        ArrayList<NhanVien_DTO> resultArray = new ArrayList<NhanVien_DTO>();
        String query = "SELECT * FROM tbl_nhanvien";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
                nhanvienDTO.setMaNV(resultSet.getInt("maNV"));
                nhanvienDTO.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvienDTO.setTenTaiKhoanNV(resultSet.getString("tenTaiKhoanNV"));
                nhanvienDTO.setMatKhauNV(resultSet.getString("matKhauNV"));
                nhanvienDTO.setHoTenNV(resultSet.getString("hoTenNV"));
                nhanvienDTO.setDiaChiNV(resultSet.getString("diaChiNV"));
                nhanvienDTO.setSdtNV(resultSet.getString("sdtNV"));
                nhanvienDTO.setCmndNV(resultSet.getString("cmndNV"));
                nhanvienDTO.setGioiTinhNV(resultSet.getString("gioiTinhNV"));
                nhanvienDTO.setTrangThaiNV(resultSet.getString("trangThaiNV"));
                
                nhanvienDTO.setAnhNV(resultSet.getBytes("anhNV"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhanvienDTO);
                //}
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultArray;
    }
    
    public ArrayList<ChucVu_DTO> getAllChucVu(){
        
        ArrayList<ChucVu_DTO> resultArray = new ArrayList<ChucVu_DTO>();
        String query = "SELECT * FROM tbl_chucvu";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                ChucVu_DTO chucvuDTO = new ChucVu_DTO();
                chucvuDTO.setMaChucVu(resultSet.getInt("maChucVu"));
                chucvuDTO.setTenChucVu(resultSet.getString("tenChucVu"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(chucvuDTO);
                //}
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultArray;
    }
    
    //Start tìm kiếm
    public ArrayList<NhanVien_DTO> timKiemNV(String sqlTimKiem, String searchValue){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhanVien_DTO> resultArray = new ArrayList<NhanVien_DTO>();
        String query = "SELECT * FROM tbl_nhanvien WHERE "+ sqlTimKiem +" LIKE '%" + searchValue +"%' ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
                nhanvienDTO.setMaNV(resultSet.getInt("maNV"));
                nhanvienDTO.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvienDTO.setTenTaiKhoanNV(resultSet.getString("tenTaiKhoanNV"));
                nhanvienDTO.setMatKhauNV(resultSet.getString("matKhauNV"));
                nhanvienDTO.setHoTenNV(resultSet.getString("hoTenNV"));
                nhanvienDTO.setDiaChiNV(resultSet.getString("diaChiNV"));
                nhanvienDTO.setSdtNV(resultSet.getString("sdtNV"));
                nhanvienDTO.setCmndNV(resultSet.getString("cmndNV"));
                nhanvienDTO.setGioiTinhNV(resultSet.getString("gioiTinhNV"));
                nhanvienDTO.setTrangThaiNV(resultSet.getString("trangThaiNV"));
                
                nhanvienDTO.setAnhNV(resultSet.getBytes("anhNV"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhanvienDTO);
                //}
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultArray;
    }
    
    
    public ArrayList<NhanVien_DTO> locTheoMaNV(String ma1, String ma2, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhanVien_DTO> resultArray = new ArrayList<NhanVien_DTO>();
        String query = "SELECT * FROM tbl_nhanvien WHERE maNV BETWEEN '" + ma1 + "' AND '"+ ma2 + "'"
                + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM tbl_nhanvien WHERE (maNV BETWEEN '1' AND '200') AND (tenTaiKhoanNV LIKE '%m%')
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
                nhanvienDTO.setMaNV(resultSet.getInt("maNV"));
                nhanvienDTO.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvienDTO.setTenTaiKhoanNV(resultSet.getString("tenTaiKhoanNV"));
                nhanvienDTO.setMatKhauNV(resultSet.getString("matKhauNV"));
                nhanvienDTO.setHoTenNV(resultSet.getString("hoTenNV"));
                nhanvienDTO.setDiaChiNV(resultSet.getString("diaChiNV"));
                nhanvienDTO.setSdtNV(resultSet.getString("sdtNV"));
                nhanvienDTO.setCmndNV(resultSet.getString("cmndNV"));
                nhanvienDTO.setGioiTinhNV(resultSet.getString("gioiTinhNV"));
                nhanvienDTO.setTrangThaiNV(resultSet.getString("trangThaiNV"));
                
                nhanvienDTO.setAnhNV(resultSet.getBytes("anhNV"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhanvienDTO);
                //}
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultArray;
    }
    
    public ArrayList<NhanVien_DTO> locTheoMaNV(String ma1, String ma2){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhanVien_DTO> resultArray = new ArrayList<NhanVien_DTO>();
        String query = "SELECT * FROM tbl_nhanvien WHERE maNV BETWEEN '" + ma1 + "' AND '" + ma2 + "'";
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
                nhanvienDTO.setMaNV(resultSet.getInt("maNV"));
                nhanvienDTO.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvienDTO.setTenTaiKhoanNV(resultSet.getString("tenTaiKhoanNV"));
                nhanvienDTO.setMatKhauNV(resultSet.getString("matKhauNV"));
                nhanvienDTO.setHoTenNV(resultSet.getString("hoTenNV"));
                nhanvienDTO.setDiaChiNV(resultSet.getString("diaChiNV"));
                nhanvienDTO.setSdtNV(resultSet.getString("sdtNV"));
                nhanvienDTO.setCmndNV(resultSet.getString("cmndNV"));
                nhanvienDTO.setGioiTinhNV(resultSet.getString("gioiTinhNV"));
                nhanvienDTO.setTrangThaiNV(resultSet.getString("trangThaiNV"));
                
                nhanvienDTO.setAnhNV(resultSet.getBytes("anhNV"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhanvienDTO);
                //}
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultArray;
    }
    
    public ArrayList<NhanVien_DTO> locLonHonBang(String ma1, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhanVien_DTO> resultArray = new ArrayList<NhanVien_DTO>();
        String query = "SELECT * FROM tbl_nhanvien WHERE maNV >= '"+ ma1 + "'" + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV >= '30'
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
                nhanvienDTO.setMaNV(resultSet.getInt("maNV"));
                nhanvienDTO.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvienDTO.setTenTaiKhoanNV(resultSet.getString("tenTaiKhoanNV"));
                nhanvienDTO.setMatKhauNV(resultSet.getString("matKhauNV"));
                nhanvienDTO.setHoTenNV(resultSet.getString("hoTenNV"));
                nhanvienDTO.setDiaChiNV(resultSet.getString("diaChiNV"));
                nhanvienDTO.setSdtNV(resultSet.getString("sdtNV"));
                nhanvienDTO.setCmndNV(resultSet.getString("cmndNV"));
                nhanvienDTO.setGioiTinhNV(resultSet.getString("gioiTinhNV"));
                nhanvienDTO.setTrangThaiNV(resultSet.getString("trangThaiNV"));
                
                nhanvienDTO.setAnhNV(resultSet.getBytes("anhNV"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhanvienDTO);
                //}
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultArray;
    }
    
    public ArrayList<NhanVien_DTO> locBeHonBang(String ma1, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhanVien_DTO> resultArray = new ArrayList<NhanVien_DTO>();
        String query = "SELECT * FROM tbl_nhanvien WHERE maNV <= '"+ ma1 + "'" + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV <= '30'
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
                nhanvienDTO.setMaNV(resultSet.getInt("maNV"));
                nhanvienDTO.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvienDTO.setTenTaiKhoanNV(resultSet.getString("tenTaiKhoanNV"));
                nhanvienDTO.setMatKhauNV(resultSet.getString("matKhauNV"));
                nhanvienDTO.setHoTenNV(resultSet.getString("hoTenNV"));
                nhanvienDTO.setDiaChiNV(resultSet.getString("diaChiNV"));
                nhanvienDTO.setSdtNV(resultSet.getString("sdtNV"));
                nhanvienDTO.setCmndNV(resultSet.getString("cmndNV"));
                nhanvienDTO.setGioiTinhNV(resultSet.getString("gioiTinhNV"));
                nhanvienDTO.setTrangThaiNV(resultSet.getString("trangThaiNV"));
                
                nhanvienDTO.setAnhNV(resultSet.getBytes("anhNV"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhanvienDTO);
                //}
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultArray;
    }
    
    public ArrayList<NhanVien_DTO> locLonHonBang(String ma2){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhanVien_DTO> resultArray = new ArrayList<NhanVien_DTO>();
        String query = "SELECT * FROM tbl_nhanvien WHERE maNV >= '"+ ma2 + "'";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV >= '30'
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
                nhanvienDTO.setMaNV(resultSet.getInt("maNV"));
                nhanvienDTO.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvienDTO.setTenTaiKhoanNV(resultSet.getString("tenTaiKhoanNV"));
                nhanvienDTO.setMatKhauNV(resultSet.getString("matKhauNV"));
                nhanvienDTO.setHoTenNV(resultSet.getString("hoTenNV"));
                nhanvienDTO.setDiaChiNV(resultSet.getString("diaChiNV"));
                nhanvienDTO.setSdtNV(resultSet.getString("sdtNV"));
                nhanvienDTO.setCmndNV(resultSet.getString("cmndNV"));
                nhanvienDTO.setGioiTinhNV(resultSet.getString("gioiTinhNV"));
                nhanvienDTO.setTrangThaiNV(resultSet.getString("trangThaiNV"));
                
                nhanvienDTO.setAnhNV(resultSet.getBytes("anhNV"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhanvienDTO);
                //}
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultArray;
    }
    
    public ArrayList<NhanVien_DTO> locBeHonBang(String ma2){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhanVien_DTO> resultArray = new ArrayList<NhanVien_DTO>();
        String query = "SELECT * FROM tbl_nhanvien WHERE maNV <= '"+ ma2 + "'";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV <= '30'
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
                nhanvienDTO.setMaNV(resultSet.getInt("maNV"));
                nhanvienDTO.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvienDTO.setTenTaiKhoanNV(resultSet.getString("tenTaiKhoanNV"));
                nhanvienDTO.setMatKhauNV(resultSet.getString("matKhauNV"));
                nhanvienDTO.setHoTenNV(resultSet.getString("hoTenNV"));
                nhanvienDTO.setDiaChiNV(resultSet.getString("diaChiNV"));
                nhanvienDTO.setSdtNV(resultSet.getString("sdtNV"));
                nhanvienDTO.setCmndNV(resultSet.getString("cmndNV"));
                nhanvienDTO.setGioiTinhNV(resultSet.getString("gioiTinhNV"));
                nhanvienDTO.setTrangThaiNV(resultSet.getString("trangThaiNV"));
                
                nhanvienDTO.setAnhNV(resultSet.getBytes("anhNV"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhanvienDTO);
                //}
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return resultArray;
    }
    //End tìm kiếm
    
    public void getAllChucVuCBB(JComboBox cbbName){
        String query = "SELECT * FROM tbl_chucvu";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                cbbName.addItem(resultSet.getString("maChucVu"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void getAllTenNVCBB(JComboBox cbbName){
        String query = "SELECT * FROM tbl_nhanvien";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    cbbName.addItem(resultSet.getInt("maNV") + "-" + resultSet.getString("hoTenNV"));
                }  
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public int ThemNhanVien(NhanVien_DTO nhanvienDTO){ 
        int result = 0;
        String query = "INSERT INTO tbl_nhanvien(maNV, maChucVu, tenTaiKhoanNV, matKhauNV, hoTenNV, diaChiNV, sdtNV, cmndNV, gioiTinhNV, anhNV) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(query);
            
            ps.setInt(1, nhanvienDTO.getMaNV());
            ps.setInt(2, nhanvienDTO.getMaChucVu());
            ps.setString(3, nhanvienDTO.getTenTaiKhoanNV());
            ps.setString(4, nhanvienDTO.getMatKhauNV());
            ps.setString(5, nhanvienDTO.getHoTenNV());
            ps.setString(6, nhanvienDTO.getDiaChiNV());
            ps.setString(7, nhanvienDTO.getSdtNV());
            ps.setString(8, nhanvienDTO.getCmndNV());
            ps.setString(9, nhanvienDTO.getGioiTinhNV());
            
            
            InputStream AnhNV = new FileInputStream(new File(QuanLyNhanVien_GUI.ImgPath));
            ps.setBlob(10, AnhNV);
         
            result = ps.executeUpdate();
   
        }catch (SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Dong ket noi
        finally{
            try{
                xuLyDB.closeConnection(connection);
                ps.close();
//                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    public int KhoaNV(NhanVien_DTO nhanvienDTO){
        int result = 0;
        String queryKhoa = "UPDATE tbl_nhanvien SET trangThaiNV='Khóa' WHERE maNV =?";
            
            try{
                xuLyDB = new XuLyDatabase();
                connection = xuLyDB.openConnection();

                ps = connection.prepareStatement(queryKhoa);

                ps.setInt(1, nhanvienDTO.getMaNV());

                result = ps.executeUpdate(); //executeUpdate trả về số dòng chịu tác động

            }catch (SQLException e){
                e.printStackTrace();
            }

            //Dong ket noi
            finally{
                try{
                    xuLyDB.closeConnection(connection);
                    ps.close();
    //                resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        return result;
        
    }
    
    public int CapNhatNV(NhanVien_DTO nhanvienDTO){
        int result = 0;
        
        if (QuanLyNhanVien_GUI.ImgPath == null){ //Nếu không update ảnh
            try{
                    String queryUpdateNoImage = "UPDATE tbl_nhanvien SET maChucVu= ?, tenTaiKhoanNV= ?, matKhauNV= ?, hoTenNV= ?, diaChiNV= ?,"
                    + " sdtNV= ?, cmndNV= ?, gioiTinhNV= ? WHERE maNV = ?";
                    
                    xuLyDB = new XuLyDatabase();
                    connection = xuLyDB.openConnection();

                    ps = connection.prepareStatement(queryUpdateNoImage);

                    ps.setInt(1, nhanvienDTO.getMaChucVu());
                    ps.setString(2, nhanvienDTO.getTenTaiKhoanNV());
                    ps.setString(3, nhanvienDTO.getMatKhauNV());
                    ps.setString(4, nhanvienDTO.getHoTenNV());
                    ps.setString(5, nhanvienDTO.getDiaChiNV());
                    ps.setString(6, nhanvienDTO.getSdtNV());
                    ps.setString(7, nhanvienDTO.getCmndNV());
                    ps.setString(8, nhanvienDTO.getGioiTinhNV());

                    ps.setInt(9, nhanvienDTO.getMaNV());

                    result = ps.executeUpdate(); //executeUpdate trả về số dòng chịu tác động

                }catch (SQLException e){
                    e.printStackTrace();
                }

                //Dong ket noi
                finally{
                    try{
                        xuLyDB.closeConnection(connection);
                        ps.close();
        //                resultSet.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        }
        else{ //Có update image
            try{
                    String queryUpdateImage = "UPDATE tbl_nhanvien SET maChucVu= ?, tenTaiKhoanNV= ?, matKhauNV= ?, hoTenNV= ?, diaChiNV= ?,"
                    + " sdtNV= ?, cmndNV= ?, gioiTinhNV= ?, anhNV= ? WHERE maNV = ?";
                    
                    xuLyDB = new XuLyDatabase();
                    connection = xuLyDB.openConnection();

                    ps = connection.prepareStatement(queryUpdateImage);

                    ps.setInt(1, nhanvienDTO.getMaChucVu());
                    ps.setString(2, nhanvienDTO.getTenTaiKhoanNV());
                    ps.setString(3, nhanvienDTO.getMatKhauNV());
                    ps.setString(4, nhanvienDTO.getHoTenNV());
                    ps.setString(5, nhanvienDTO.getDiaChiNV());
                    ps.setString(6, nhanvienDTO.getSdtNV());
                    ps.setString(7, nhanvienDTO.getCmndNV());
                    ps.setString(8, nhanvienDTO.getGioiTinhNV());
                    //Update ảnh
                    InputStream AnhNV = new FileInputStream(new File(QuanLyNhanVien_GUI.ImgPath));
                    ps.setBlob(9, AnhNV);
                    
                    ps.setInt(10, nhanvienDTO.getMaNV());

                    result = ps.executeUpdate(); //executeUpdate trả về số dòng chịu tác động

                }catch (SQLException e){
                    e.printStackTrace();
                } catch (FileNotFoundException ex) {
                Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Dong ket noi
                finally{
                    try{
                        xuLyDB.closeConnection(connection);
                        ps.close();
        //                resultSet.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        }

        return result;
        
        
    }
    
}
