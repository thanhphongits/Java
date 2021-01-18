/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDB.XuLyDatabase;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.NhaCungCap_DTO;
import DTO.PhieuNhap_DTO;
import DTO.SanPham_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PhieuNhap_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    
    public ArrayList<PhieuNhap_DTO> getAllPhieuNhap(){

        ArrayList<PhieuNhap_DTO> resultArray = new ArrayList<PhieuNhap_DTO>();
        String query = "SELECT * FROM tbl_phieunhap";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                PhieuNhap_DTO PN_DTO = new PhieuNhap_DTO();
                
                PN_DTO.setMaPhieuNhap(resultSet.getInt("maPhieuNhap"));
                PN_DTO.setMaNV(resultSet.getInt("maNV"));
                PN_DTO.setNgayLapPhieu(LocalDate.parse(resultSet.getString("ngayLapPhieu")));
                PN_DTO.setTongSLNhap(resultSet.getInt("tongSLNhap"));
                PN_DTO.setTrangThaiPN(resultSet.getString("trangThaiPN"));
                
                resultArray.add(PN_DTO);
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
    
    public ArrayList<ChiTietPhieuNhap_DTO> getAllChiTietPhieuNhap(){

        ArrayList<ChiTietPhieuNhap_DTO> resultArray = new ArrayList<ChiTietPhieuNhap_DTO>();
        String query = "SELECT * FROM tbl_chitietphieunhap";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                ChiTietPhieuNhap_DTO CTPN_DTO = new ChiTietPhieuNhap_DTO();
                
                CTPN_DTO.setMaCTPN(resultSet.getInt("maCTPN"));
                CTPN_DTO.setMaPhieuNhap(resultSet.getInt("maPhieuNhap"));
                CTPN_DTO.setMaSP(resultSet.getInt("maSP"));
                CTPN_DTO.setSoLuongNhap(resultSet.getInt("soLuongNhap"));
                
                resultArray.add(CTPN_DTO);
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
    
    public int ThemPhieuNhap(PhieuNhap_DTO phieunhapDTO){      
        int result = 0;
 
        String queryPhieuNhap = "INSERT INTO tbl_phieunhap(maPhieuNhap, maNV, ngayLapPhieu, tongSLNhap) "
                + "VALUES(?, ?, ?, ?) ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(queryPhieuNhap);
            
            ps.setInt(1, phieunhapDTO.getMaPhieuNhap());
            ps.setInt(2, phieunhapDTO.getMaNV());
            ps.setString(3, phieunhapDTO.getNgayLapPhieu().toString() );
            ps.setInt(4, phieunhapDTO.getTongSLNhap());

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
    
    public int ThemChiTietPhieuNhap(ChiTietPhieuNhap_DTO chitietpnDTO){
        int resultCTPN = 0;
         
        //Thêm chi tiết hóa đơn start 
        String queryCTPN = "INSERT INTO tbl_chitietphieunhap(maCTPN, maPhieuNhap, maSP, soLuongNhap) VALUES(?, ?, ?, ?) ";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(queryCTPN);
            
            ps.setInt(1, chitietpnDTO.getMaCTPN());
            ps.setInt(2, chitietpnDTO.getMaPhieuNhap());
            ps.setInt(3, chitietpnDTO.getMaSP());
            ps.setInt(4, chitietpnDTO.getSoLuongNhap());
            
            resultCTPN = ps.executeUpdate();

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
   
        return resultCTPN;
     }
    
    public int CapNhatSLSP(SanPham_DTO sanphamDTO){
        int resultSLSP = 0;
        
        //Cập nhật số lượng sản phẩm còn lại vào database
        String querySLSP = "UPDATE tbl_sanpham SET soLuongSP = soLuongSP + ? WHERE maSP = ?";
        try {

            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            ps = connection.prepareStatement(querySLSP);
            
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
    
    public ArrayList<PhieuNhap_DTO> timKiemPN(String sqlTimKiem, String searchValue){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<PhieuNhap_DTO> resultArray = new ArrayList<PhieuNhap_DTO>();
        String query = "SELECT * FROM tbl_phieunhap WHERE "+ sqlTimKiem +" LIKE '%" + searchValue +"%' ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                PhieuNhap_DTO PN_DTO = new PhieuNhap_DTO();
                
                PN_DTO.setMaPhieuNhap(resultSet.getInt("maPhieuNhap"));
                PN_DTO.setMaNV(resultSet.getInt("maNV"));
                PN_DTO.setNgayLapPhieu(LocalDate.parse(resultSet.getString("ngayLapPhieu")));
                PN_DTO.setTongSLNhap(resultSet.getInt("tongSLNhap"));
                PN_DTO.setTrangThaiPN(resultSet.getString("trangThaiPN"));
                
                resultArray.add(PN_DTO);
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
    public ArrayList<PhieuNhap_DTO> locTheoNgayPN(String ma1, String ma2, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<PhieuNhap_DTO> resultArray = new ArrayList<PhieuNhap_DTO>();
        String query = "SELECT * FROM tbl_phieunhap WHERE ngayLapPhieu BETWEEN '" + ma1 + "' AND '"+ ma2 + "'"
                + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM tbl_nhanvien WHERE (maNV BETWEEN '1' AND '200') AND (tenTaiKhoanNV LIKE '%m%')
        
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                PhieuNhap_DTO PN_DTO = new PhieuNhap_DTO();
                
                PN_DTO.setMaPhieuNhap(resultSet.getInt("maPhieuNhap"));
                PN_DTO.setMaNV(resultSet.getInt("maNV"));
                PN_DTO.setNgayLapPhieu(LocalDate.parse(resultSet.getString("ngayLapPhieu")));
                PN_DTO.setTongSLNhap(resultSet.getInt("tongSLNhap"));
                PN_DTO.setTrangThaiPN(resultSet.getString("trangThaiPN"));
                
                resultArray.add(PN_DTO);
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
    
    public ArrayList<PhieuNhap_DTO> locTheoNgayPN(String ma1, String ma2){ 
        ArrayList<PhieuNhap_DTO> resultArray = new ArrayList<PhieuNhap_DTO>();
        String query = "SELECT * FROM tbl_phieunhap WHERE ngayLapPhieu BETWEEN '" + ma1 + "' AND '" + ma2 + "'";
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                PhieuNhap_DTO PN_DTO = new PhieuNhap_DTO();
                
                PN_DTO.setMaPhieuNhap(resultSet.getInt("maPhieuNhap"));
                PN_DTO.setMaNV(resultSet.getInt("maNV"));
                PN_DTO.setNgayLapPhieu(LocalDate.parse(resultSet.getString("ngayLapPhieu")));
                PN_DTO.setTongSLNhap(resultSet.getInt("tongSLNhap"));
                PN_DTO.setTrangThaiPN(resultSet.getString("trangThaiPN"));
                
                resultArray.add(PN_DTO);
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
    
    public ArrayList<PhieuNhap_DTO> locBeHonBang(String ma1, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<PhieuNhap_DTO> resultArray = new ArrayList<PhieuNhap_DTO>();
        String query = "SELECT * FROM tbl_phieunhap WHERE ngayLapPhieu <= '"+ ma1 + "'" + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
        //SELECT * FROM `tbl_nhanvien` WHERE maNV <= '30'
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                PhieuNhap_DTO PN_DTO = new PhieuNhap_DTO();
                
                PN_DTO.setMaPhieuNhap(resultSet.getInt("maPhieuNhap"));
                PN_DTO.setMaNV(resultSet.getInt("maNV"));
                PN_DTO.setNgayLapPhieu(LocalDate.parse(resultSet.getString("ngayLapPhieu")));
                PN_DTO.setTongSLNhap(resultSet.getInt("tongSLNhap"));
                PN_DTO.setTrangThaiPN(resultSet.getString("trangThaiPN"));
                
                resultArray.add(PN_DTO);
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
    
    public ArrayList<PhieuNhap_DTO> locBeHonBang(String ma2){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<PhieuNhap_DTO> resultArray = new ArrayList<PhieuNhap_DTO>();
        String query = "SELECT * FROM tbl_phieunhap WHERE ngayLapPhieu <= '"+ ma2 + "'";
        
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                PhieuNhap_DTO PN_DTO = new PhieuNhap_DTO();
                
                PN_DTO.setMaPhieuNhap(resultSet.getInt("maPhieuNhap"));
                PN_DTO.setMaNV(resultSet.getInt("maNV"));
                PN_DTO.setNgayLapPhieu(LocalDate.parse(resultSet.getString("ngayLapPhieu")));
                PN_DTO.setTongSLNhap(resultSet.getInt("tongSLNhap"));
                PN_DTO.setTrangThaiPN(resultSet.getString("trangThaiPN"));
                
                resultArray.add(PN_DTO);
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
    
    public ArrayList<PhieuNhap_DTO> locLonHonBang(String ma2){ 
        ArrayList<PhieuNhap_DTO> resultArray = new ArrayList<PhieuNhap_DTO>();
        String query = "SELECT * FROM tbl_phieunhap WHERE ngayLapPhieu >= '"+ ma2 + "'";
        
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                PhieuNhap_DTO PN_DTO = new PhieuNhap_DTO();
                
                PN_DTO.setMaPhieuNhap(resultSet.getInt("maPhieuNhap"));
                PN_DTO.setMaNV(resultSet.getInt("maNV"));
                PN_DTO.setNgayLapPhieu(LocalDate.parse(resultSet.getString("ngayLapPhieu")));
                PN_DTO.setTongSLNhap(resultSet.getInt("tongSLNhap"));
                PN_DTO.setTrangThaiPN(resultSet.getString("trangThaiPN"));
                
                resultArray.add(PN_DTO);
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
    
    public ArrayList<PhieuNhap_DTO> locLonHonBang(String ma1, String cbbValue, String valueSearch){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<PhieuNhap_DTO> resultArray = new ArrayList<PhieuNhap_DTO>();
        String query = "SELECT * FROM tbl_phieunhap WHERE ngayLapPhieu >= '"+ ma1 + "'" + " AND " + cbbValue + " LIKE '%" + valueSearch + "%' ";
     
        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                PhieuNhap_DTO PN_DTO = new PhieuNhap_DTO();
                
                PN_DTO.setMaPhieuNhap(resultSet.getInt("maPhieuNhap"));
                PN_DTO.setMaNV(resultSet.getInt("maNV"));
                PN_DTO.setNgayLapPhieu(LocalDate.parse(resultSet.getString("ngayLapPhieu")));
                PN_DTO.setTongSLNhap(resultSet.getInt("tongSLNhap"));
                PN_DTO.setTrangThaiPN(resultSet.getString("trangThaiPN"));
                
                resultArray.add(PN_DTO);
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
    
    public int XoaPN(PhieuNhap_DTO phieunhapDTO){
        int result = 0;
        String queryKhoa = "UPDATE tbl_phieunhap SET trangThaiPN='Khóa' WHERE maPhieuNhap =?";
            
            try{
                xuLyDB = new XuLyDatabase();
                connection = xuLyDB.openConnection();

                ps = connection.prepareStatement(queryKhoa);

                ps.setInt(1, phieunhapDTO.getMaPhieuNhap());

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
