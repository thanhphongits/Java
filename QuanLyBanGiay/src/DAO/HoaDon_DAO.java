/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDB.XuLyDatabase;
import DTO.ChiTietHoaDon_DTO;
import DTO.HoaDon_DTO;
import DTO.SanPham_DTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class HoaDon_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    
    public ArrayList<HoaDon_DTO> getAllHoaDon(){

        ArrayList<HoaDon_DTO> resultArray = new ArrayList<HoaDon_DTO>();
        String query = "SELECT * FROM tbl_hoadon";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                HoaDon_DTO HD_DTO = new HoaDon_DTO();
                HD_DTO.setMaHD(resultSet.getInt("maHD"));
                HD_DTO.setMaKH(resultSet.getInt("maKH"));
                HD_DTO.setMaNV(resultSet.getInt("maNV"));
                HD_DTO.setNgayLapHD(LocalDate.parse(resultSet.getString("ngayLapHD")));
                HD_DTO.setTongTienHD(resultSet.getInt("tongTienHD"));
                HD_DTO.setTrangThaiHD(resultSet.getString("trangThaiHD"));
                
                resultArray.add(HD_DTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         //Dong ket noi
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
    
    public ArrayList<ChiTietHoaDon_DTO> getAllChiTietHoaDon(){

        ArrayList<ChiTietHoaDon_DTO> resultArray = new ArrayList<ChiTietHoaDon_DTO>();
        String query = "SELECT * FROM tbl_chitiethd";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                ChiTietHoaDon_DTO chitiethdDTO = new ChiTietHoaDon_DTO();
                
                chitiethdDTO.setMaChiTietHD(resultSet.getInt("maChiTietHD"));
                chitiethdDTO.setMaHD(resultSet.getInt("maHD"));
                chitiethdDTO.setTenNV(resultSet.getString("tenNV"));
                chitiethdDTO.setTenKH(resultSet.getString("tenKH"));
                chitiethdDTO.setDiaChiGiaoHang(resultSet.getString("diaChiGiaoHang"));
                chitiethdDTO.setMaSP(resultSet.getInt("maSP"));
                chitiethdDTO.setTenSP(resultSet.getString("tenSP"));
                chitiethdDTO.setSizeSP(resultSet.getInt("sizeSP"));
                chitiethdDTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                chitiethdDTO.setSoLuongSP(resultSet.getInt("soLuongSP"));
                chitiethdDTO.setThanhTien(resultSet.getInt("thanhTien"));
                chitiethdDTO.setGhiChu(resultSet.getString("ghiChu"));
                
                resultArray.add(chitiethdDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         //Dong ket noi
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
     
    public int ThemHoaDon(HoaDon_DTO hoadonDTO){      
        int result = 0;
 
        String queryHoaDon = "INSERT INTO tbl_hoadon(maHD, maKH, maNV, ngayLapHD, tongTienHD) "
                + "VALUES(?, ?, ?, ?, ?) ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(queryHoaDon);
            
            ps.setInt(1, hoadonDTO.getMaHD());
            ps.setInt(2, hoadonDTO.getMaKH());
            ps.setInt(3, hoadonDTO.getMaNV());
            ps.setString(4, hoadonDTO.getNgayLapHD().toString());
            ps.setInt(5, hoadonDTO.getTongTienHD());

            result = ps.executeUpdate();
   
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
    
    public int ThemChiTietHoaDon(ChiTietHoaDon_DTO chitiethdDTO){
        int resultCTHD = 0;
         
        //Thêm chi tiết hóa đơn start 
        String queryCTHD = "INSERT INTO tbl_chitiethd(maChiTietHD, maHD, tenNV, tenKH, diaChiGiaoHang, sdtGiaoHang, "
                + "maSP, tenSP, sizeSP, donGiaSP, soLuongSP, thanhTien, ghiChu) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(queryCTHD);
            
            ps.setInt(1, chitiethdDTO.getMaChiTietHD());
            ps.setInt(2, chitiethdDTO.getMaHD());
            ps.setString(3, chitiethdDTO.getTenNV());
            ps.setString(4, chitiethdDTO.getTenKH());
            ps.setString(5, chitiethdDTO.getDiaChiGiaoHang());
            ps.setInt(6, chitiethdDTO.getSdtGiaoHang());
            ps.setInt(7, chitiethdDTO.getMaSP());
            ps.setString(8, chitiethdDTO.getTenSP());
            ps.setInt(9, chitiethdDTO.getSizeSP());
            ps.setInt(10, chitiethdDTO.getDonGiaSP());
            ps.setInt(11, chitiethdDTO.getSoLuongSP());
            ps.setInt(12, chitiethdDTO.getThanhTien());
            ps.setString(13, chitiethdDTO.getGhiChu());
            
            resultCTHD = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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
   
        return resultCTHD;
     }
    
    public int CapNhatSLSP(SanPham_DTO sanphamDTO){
        int resultSLSP = 0;
        
        //Cập nhật số lượng sản phẩm còn lại vào database
        String querySLSP = "UPDATE tbl_sanpham SET soLuongSP = ? WHERE maSP = ?";
        try {
            ChiTietHoaDon_DTO chitiethdDTO = new ChiTietHoaDon_DTO();
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(querySLSP);
            
            System.out.println(sanphamDTO.getSoLuongSP()); //test
            ps.setInt(1, sanphamDTO.getSoLuongSP()); 
            ps.setInt(2, sanphamDTO.getMaSP());
            
            resultSLSP = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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
        return resultSLSP;
    }
    
    public ArrayList<HoaDon_DTO> timKiemHD(String sqlTimKiem, String searchValue){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<HoaDon_DTO> resultArray = new ArrayList<HoaDon_DTO>();
        String query = "SELECT * FROM tbl_hoadon WHERE "+ sqlTimKiem +" LIKE '%" + searchValue +"%' ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                HoaDon_DTO HD_DTO = new HoaDon_DTO();
                HD_DTO.setMaHD(resultSet.getInt("maHD"));
                HD_DTO.setMaKH(resultSet.getInt("maKH"));
                HD_DTO.setMaNV(resultSet.getInt("maNV"));
                HD_DTO.setNgayLapHD(LocalDate.parse(resultSet.getString("ngayLapHD")));
                HD_DTO.setTongTienHD(resultSet.getInt("tongTienHD"));
                
                resultArray.add(HD_DTO);
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
    
    //Tim kiem ket hop start
    public ArrayList<HoaDon_DTO> locTheoNgayHD(String ma1, String ma2, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<HoaDon_DTO> resultArray = new ArrayList<HoaDon_DTO>();
        String query = "SELECT * FROM tbl_hoadon WHERE ngayLapHD BETWEEN '" + ma1 + "' AND '"+ ma2 + "'"
                + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM tbl_nhanvien WHERE (maNV BETWEEN '1' AND '200') AND (tenTaiKhoanNV LIKE '%m%')
        
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                HoaDon_DTO HD_DTO = new HoaDon_DTO();
                HD_DTO.setMaHD(resultSet.getInt("maHD"));
                HD_DTO.setMaKH(resultSet.getInt("maKH"));
                HD_DTO.setMaNV(resultSet.getInt("maNV"));
                HD_DTO.setNgayLapHD(LocalDate.parse(resultSet.getString("ngayLapHD")));
                HD_DTO.setTongTienHD(resultSet.getInt("tongTienHD"));
                
                resultArray.add(HD_DTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         //Dong ket noi
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
    
    public ArrayList<HoaDon_DTO> locTheoNgayHD(String ma1, String ma2){ 
        ArrayList<HoaDon_DTO> resultArray = new ArrayList<HoaDon_DTO>();
        String query = "SELECT * FROM tbl_hoadon WHERE ngayLapHD BETWEEN '" + ma1 + "' AND '" + ma2 + "'";
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                HoaDon_DTO HD_DTO = new HoaDon_DTO();
                HD_DTO.setMaHD(resultSet.getInt("maHD"));
                HD_DTO.setMaKH(resultSet.getInt("maKH"));
                HD_DTO.setMaNV(resultSet.getInt("maNV"));
                HD_DTO.setNgayLapHD(LocalDate.parse(resultSet.getString("ngayLapHD")));
                HD_DTO.setTongTienHD(resultSet.getInt("tongTienHD"));
                
                resultArray.add(HD_DTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         //Dong ket noi
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
    
    public ArrayList<HoaDon_DTO> locBeHonBang(String ma1, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<HoaDon_DTO> resultArray = new ArrayList<HoaDon_DTO>();
        String query = "SELECT * FROM tbl_hoadon WHERE ngayLapHD <= '"+ ma1 + "'" + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV <= '30'
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                HoaDon_DTO HD_DTO = new HoaDon_DTO();
                HD_DTO.setMaHD(resultSet.getInt("maHD"));
                HD_DTO.setMaKH(resultSet.getInt("maKH"));
                HD_DTO.setMaNV(resultSet.getInt("maNV"));
                HD_DTO.setNgayLapHD(LocalDate.parse(resultSet.getString("ngayLapHD")));
                HD_DTO.setTongTienHD(resultSet.getInt("tongTienHD"));
                
                resultArray.add(HD_DTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         //Dong ket noi
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
    
    public ArrayList<HoaDon_DTO> locBeHonBang(String ma2){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<HoaDon_DTO> resultArray = new ArrayList<HoaDon_DTO>();
        String query = "SELECT * FROM tbl_hoadon WHERE ngayLapHD <= '"+ ma2 + "'";
        
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                HoaDon_DTO HD_DTO = new HoaDon_DTO();
                HD_DTO.setMaHD(resultSet.getInt("maHD"));
                HD_DTO.setMaKH(resultSet.getInt("maKH"));
                HD_DTO.setMaNV(resultSet.getInt("maNV"));
                HD_DTO.setNgayLapHD(LocalDate.parse(resultSet.getString("ngayLapHD")));
                HD_DTO.setTongTienHD(resultSet.getInt("tongTienHD"));
                
                resultArray.add(HD_DTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         //Dong ket noi
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
    
    public ArrayList<HoaDon_DTO> locLonHonBang(String ma2){ 
        ArrayList<HoaDon_DTO> resultArray = new ArrayList<HoaDon_DTO>();
        String query = "SELECT * FROM tbl_hoadon WHERE ngayLapHD >= '"+ ma2 + "'";
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                HoaDon_DTO HD_DTO = new HoaDon_DTO();
                HD_DTO.setMaHD(resultSet.getInt("maHD"));
                HD_DTO.setMaKH(resultSet.getInt("maKH"));
                HD_DTO.setMaNV(resultSet.getInt("maNV"));
                HD_DTO.setNgayLapHD(LocalDate.parse(resultSet.getString("ngayLapHD")));
                HD_DTO.setTongTienHD(resultSet.getInt("tongTienHD"));
                
                resultArray.add(HD_DTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         //Dong ket noi
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
    
    public ArrayList<HoaDon_DTO> locLonHonBang(String ma1, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<HoaDon_DTO> resultArray = new ArrayList<HoaDon_DTO>();
        String query = "SELECT * FROM tbl_hoadon WHERE ngayLapHD >= '"+ ma1 + "'" + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
     
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                HoaDon_DTO HD_DTO = new HoaDon_DTO();
                HD_DTO.setMaHD(resultSet.getInt("maHD"));
                HD_DTO.setMaKH(resultSet.getInt("maKH"));
                HD_DTO.setMaNV(resultSet.getInt("maNV"));
                HD_DTO.setNgayLapHD(LocalDate.parse(resultSet.getString("ngayLapHD")));
                HD_DTO.setTongTienHD(resultSet.getInt("tongTienHD"));
                
                resultArray.add(HD_DTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         //Dong ket noi
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
    
    
    //Tim kiem ket hop end
    
    public int XoaHD(HoaDon_DTO hoadonDTO){
        int result = 0;
        String queryKhoa = "UPDATE tbl_hoadon SET trangThaiHD='Khóa' WHERE maHD =?";
            
            try{
                xuLyDB = new XuLyDatabase();
                connection = xuLyDB.openConnection();

                ps = connection.prepareStatement(queryKhoa);

                ps.setInt(1, hoadonDTO.getMaHD());

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
    
    
}
