/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO; // Còn thiếu ảnh ???

import ConnectDB.XuLyDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.SanPham_DTO;
import DTO.DanhMuc_DTO;
import DTO.NhaCungCap_DTO;
import DTO.NhanVien_DTO;
import GUI.QuanLyNhanVien_GUI;
import GUI.QuanLySanPham_GUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author mend
 */
public class SanPham_DAO {

    private XuLyDatabase xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;

    public ArrayList<SanPham_DTO> getAllSanPham(){

        ArrayList<SanPham_DTO> resultArray = new ArrayList<SanPham_DTO>();
        String query = "SELECT * FROM tbl_sanpham";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                SanPham_DTO SP_DTO = new SanPham_DTO();
                SP_DTO.setMaSP(resultSet.getInt("maSP"));
                SP_DTO.setMaNCC(resultSet.getInt("maNCC"));
                SP_DTO.setMaDM(resultSet.getInt("maDM"));
                SP_DTO.setTenSP(resultSet.getString("tenSP"));
                SP_DTO.setSizeSP(resultSet.getInt("sizeSP"));
                SP_DTO.setSoLuongSP(resultSet.getInt("soLuongSP"));
                
                SP_DTO.setMieuTaSP(resultSet.getString("mieuTaSP"));
                SP_DTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                SP_DTO.setAnhSP(resultSet.getBytes("anhSP"));
                SP_DTO.setTrangThaiSP(resultSet.getString("trangThaiSP"));

                resultArray.add(SP_DTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultArray;
    }

    
    
    public int ThemSP_DAO(SanPham_DTO SP_DTO) throws ClassNotFoundException {
        int result = 0;
        
        int resultDM = 0;
                
        String sql = "INSERT INTO tbl_sanpham(maSP, maNCC, maDM, tenSP, sizeSP,  mieuTaSP, donGiaSP, anhSP) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        
        //Thêm sản phẩm Start
        
        try {
            xuLyDB = new XuLyDatabase();
            
                connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(sql);
            ps.setInt(1, SP_DTO.getMaSP());
            ps.setInt(2, SP_DTO.getMaNCC());
            ps.setInt(3, SP_DTO.getMaDM());
            ps.setString(4, SP_DTO.getTenSP());
            ps.setInt(5, SP_DTO.getSizeSP());
            ps.setString(6, SP_DTO.getMieuTaSP());
            ps.setInt(7, SP_DTO.getDonGiaSP());

            InputStream anhSP = new FileInputStream(new File(QuanLySanPham_GUI.ImgPath));
            ps.setBlob(8, anhSP);
            
            result = ps.executeUpdate();
           

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                //resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //Thêm sản phẩm End
        
        
        return result;
    }
    

    public int CapNhatSP_DAO(SanPham_DTO SP_DTO) {
        int result = 0;
        int resultNCC = 0;
        int resultDM = 0;
        
        if (QuanLySanPham_GUI.ImgPath == null) { //Nếu không update ảnh
            
                String sql = "UPDATE tbl_sanpham SET maNCC = ?, maDM = ?, tenSP = ?, sizeSP = ?, mieuTaSP = ?, donGiaSP = ? WHERE maSP = ?";
                try {
                    xuLyDB = new XuLyDatabase();
                    connection = xuLyDB.openConnection();
                    ps = connection.prepareStatement(sql);
                    ps.setInt(1, SP_DTO.getMaNCC());
                    ps.setInt(2, SP_DTO.getMaDM());
                    ps.setString(3, SP_DTO.getTenSP());
                    ps.setInt(4, SP_DTO.getSizeSP());
                    ps.setString(5, SP_DTO.getMieuTaSP());
                    ps.setInt(6, SP_DTO.getDonGiaSP());
                    ps.setInt(7, SP_DTO.getMaSP());

                    result = ps.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                finally {
                    try {
                        xuLyDB.closeConnection(connection);
                        ps.close();
//                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else{ //Có update image
            try{
                    String sql = "UPDATE tbl_sanpham SET maNCC = ?, maDM = ?, tenSP = ?, sizeSP = ?, mieuTaSP = ?, donGiaSP = ?, anhSP = ? WHERE maSP = ?";
                    
                    xuLyDB = new XuLyDatabase();
                    connection = xuLyDB.openConnection();
                    ps = connection.prepareStatement(sql);
                    ps.setInt(1, SP_DTO.getMaNCC());
                    ps.setInt(2, SP_DTO.getMaDM());
                    ps.setString(3, SP_DTO.getTenSP());
                    ps.setInt(4, SP_DTO.getSizeSP());
                    ps.setString(5, SP_DTO.getMieuTaSP());
                    ps.setInt(6, SP_DTO.getDonGiaSP());
                    //Update ảnh
                    InputStream anhSP = new FileInputStream(new File(QuanLySanPham_GUI.ImgPath));
                    ps.setBlob(7, anhSP);
                    
                    ps.setInt(8, SP_DTO.getMaSP());

                    result = ps.executeUpdate(); //executeUpdate trả về số dòng chịu tác động

                }catch (SQLException e){
                    e.printStackTrace();
                } catch (FileNotFoundException ex) {
                Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public int khoaSP_DAO(SanPham_DTO SP_DTO) throws ClassNotFoundException {
        int result = 0;
        String sql = "UPDATE tbl_sanpham SET trangThaiSP='Khóa' WHERE maSP =?";
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, SP_DTO.getMaSP());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
//                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            }catch (ClassNotFoundException ex) {
//                Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        return result;
    }

    public void getAllDM(JComboBox cbbName) {
        String query = "SELECT * FROM tbl_danhmuc";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                cbbName.addItem(resultSet.getString("maDM"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public void getAllNCC(JComboBox cbbName) {
        String query = "SELECT * FROM tbl_nhacungcap";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                cbbName.addItem(resultSet.getString("maNCC"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    
   public ArrayList<SanPham_DTO> timKiemSP(String nameTimKiem, String searchValue){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<SanPham_DTO> resultArray = new ArrayList<SanPham_DTO>();
        String query = "SELECT * FROM tbl_sanpham WHERE "+ nameTimKiem +" LIKE '%" + searchValue +"%' ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                SanPham_DTO SP_DTO = new SanPham_DTO();
                
                SP_DTO.setMaSP(resultSet.getInt("maSP"));
                SP_DTO.setMaNCC(resultSet.getInt("maNCC"));
                SP_DTO.setMaDM(resultSet.getInt("maDM"));
                SP_DTO.setTenSP(resultSet.getString("tenSP"));
                SP_DTO.setSizeSP(resultSet.getInt("sizeSP"));
                SP_DTO.setSoLuongSP(resultSet.getInt("soLuongSP"));
                SP_DTO.setTrangThaiSP(resultSet.getString("trangThaiSP"));
                SP_DTO.setMieuTaSP(resultSet.getString("mieuTaSP"));
                SP_DTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                SP_DTO.setAnhSP(resultSet.getBytes("anhSP"));
                resultArray.add(SP_DTO);
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
   public ArrayList<SanPham_DTO> locTheoMaSP(String ma1, String ma2, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<SanPham_DTO> resultArray = new ArrayList<SanPham_DTO>();
        String query = "SELECT * FROM tbl_sanpham WHERE maSP BETWEEN '" + ma1 + "' AND '"+ ma2 + "'"
                + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM tbl_nhanvien WHERE (maNV BETWEEN '1' AND '200') AND (tenTaiKhoanNV LIKE '%m%')
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                SanPham_DTO SP_DTO = new SanPham_DTO();
                
                SP_DTO.setMaSP(resultSet.getInt("maSP"));
                SP_DTO.setMaNCC(resultSet.getInt("maNCC"));
                SP_DTO.setMaDM(resultSet.getInt("maDM"));
                SP_DTO.setTenSP(resultSet.getString("tenSP"));
                SP_DTO.setSizeSP(resultSet.getInt("sizeSP"));
                SP_DTO.setSoLuongSP(resultSet.getInt("soLuongSP"));
                SP_DTO.setTrangThaiSP(resultSet.getString("trangThaiSP"));
                SP_DTO.setMieuTaSP(resultSet.getString("mieuTaSP"));
                SP_DTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                SP_DTO.setAnhSP(resultSet.getBytes("anhSP"));
                resultArray.add(SP_DTO);
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
    public ArrayList<SanPham_DTO> locTheoMaSP(String ma1, String ma2){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<SanPham_DTO> resultArray = new ArrayList<SanPham_DTO>();
        String query = "SELECT * FROM tbl_sanpham WHERE maSP BETWEEN '" + ma1 + "' AND '" + ma2 + "'";
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                SanPham_DTO SP_DTO = new SanPham_DTO();
                
                SP_DTO.setMaSP(resultSet.getInt("maSP"));
                SP_DTO.setMaNCC(resultSet.getInt("maNCC"));
                SP_DTO.setMaDM(resultSet.getInt("maDM"));
                SP_DTO.setTenSP(resultSet.getString("tenSP"));
                SP_DTO.setSizeSP(resultSet.getInt("sizeSP"));
                SP_DTO.setSoLuongSP(resultSet.getInt("soLuongSP"));
                SP_DTO.setTrangThaiSP(resultSet.getString("trangThaiSP"));
                SP_DTO.setMieuTaSP(resultSet.getString("mieuTaSP"));
                SP_DTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                SP_DTO.setAnhSP(resultSet.getBytes("anhSP"));
                resultArray.add(SP_DTO);
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
    public ArrayList<SanPham_DTO> locLonHonBang(String ma1, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<SanPham_DTO> resultArray = new ArrayList<SanPham_DTO>();
        String query = "SELECT * FROM tbl_sanpham WHERE maSP >= '"+ ma1 + "'" + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV >= '30'
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                SanPham_DTO SP_DTO = new SanPham_DTO();
                
                SP_DTO.setMaSP(resultSet.getInt("maSP"));
                SP_DTO.setMaNCC(resultSet.getInt("maNCC"));
                SP_DTO.setMaDM(resultSet.getInt("maDM"));
                SP_DTO.setTenSP(resultSet.getString("tenSP"));
                SP_DTO.setSizeSP(resultSet.getInt("sizeSP"));
                SP_DTO.setSoLuongSP(resultSet.getInt("soLuongSP"));
                SP_DTO.setTrangThaiSP(resultSet.getString("trangThaiSP"));
                SP_DTO.setMieuTaSP(resultSet.getString("mieuTaSP"));
                SP_DTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                SP_DTO.setAnhSP(resultSet.getBytes("anhSP"));
                resultArray.add(SP_DTO);
                
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
    public ArrayList<SanPham_DTO> locBeHonBang(String ma1, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<SanPham_DTO> resultArray = new ArrayList<SanPham_DTO>();
        String query = "SELECT * FROM tbl_sanpham WHERE maSP <= '"+ ma1 + "'" + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV <= '30'
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                SanPham_DTO SP_DTO = new SanPham_DTO();
                
                SP_DTO.setMaSP(resultSet.getInt("maSP"));
                SP_DTO.setMaNCC(resultSet.getInt("maNCC"));
                SP_DTO.setMaDM(resultSet.getInt("maDM"));
                SP_DTO.setTenSP(resultSet.getString("tenSP"));
                SP_DTO.setSizeSP(resultSet.getInt("sizeSP"));
                SP_DTO.setSoLuongSP(resultSet.getInt("soLuongSP"));
                SP_DTO.setTrangThaiSP(resultSet.getString("trangThaiSP"));
                SP_DTO.setMieuTaSP(resultSet.getString("mieuTaSP"));
                SP_DTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                SP_DTO.setAnhSP(resultSet.getBytes("anhSP"));
                resultArray.add(SP_DTO);
                
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
    public ArrayList<SanPham_DTO> locLonHonBang(String ma2){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<SanPham_DTO> resultArray = new ArrayList<SanPham_DTO>();
        String query = "SELECT * FROM tbl_sanpham WHERE maSP >= '"+ ma2 + "'";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV >= '30'
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
               SanPham_DTO SP_DTO = new SanPham_DTO();
                
                SP_DTO.setMaSP(resultSet.getInt("maSP"));
                SP_DTO.setMaNCC(resultSet.getInt("maNCC"));
                SP_DTO.setMaDM(resultSet.getInt("maDM"));
                SP_DTO.setTenSP(resultSet.getString("tenSP"));
                SP_DTO.setSizeSP(resultSet.getInt("sizeSP"));
                SP_DTO.setSoLuongSP(resultSet.getInt("soLuongSP"));
                SP_DTO.setTrangThaiSP(resultSet.getString("trangThaiSP"));
                SP_DTO.setMieuTaSP(resultSet.getString("mieuTaSP"));
                SP_DTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                SP_DTO.setAnhSP(resultSet.getBytes("anhSP"));
                resultArray.add(SP_DTO);
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
    
    public ArrayList<SanPham_DTO> locBeHonBang(String ma2){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<SanPham_DTO> resultArray = new ArrayList<SanPham_DTO>();
        String query = "SELECT * FROM tbl_sanpham WHERE maSP <= '"+ ma2 + "'";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV <= '30'
        
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                SanPham_DTO SP_DTO = new SanPham_DTO();
                
                SP_DTO.setMaSP(resultSet.getInt("maSP"));
                SP_DTO.setMaNCC(resultSet.getInt("maNCC"));
                SP_DTO.setMaDM(resultSet.getInt("maDM"));
                SP_DTO.setTenSP(resultSet.getString("tenSP"));
                SP_DTO.setSizeSP(resultSet.getInt("sizeSP"));
                SP_DTO.setSoLuongSP(resultSet.getInt("soLuongSP"));
                SP_DTO.setTrangThaiSP(resultSet.getString("trangThaiSP"));
                SP_DTO.setMieuTaSP(resultSet.getString("mieuTaSP"));
                SP_DTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                SP_DTO.setAnhSP(resultSet.getBytes("anhSP"));
                resultArray.add(SP_DTO);
                
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
}

