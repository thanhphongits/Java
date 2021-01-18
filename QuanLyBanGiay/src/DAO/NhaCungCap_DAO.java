/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import ConnectDB.XuLyDatabase;
import DTO.NhaCungCap_DTO;
import DTO.NhanVien_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class NhaCungCap_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    
    
    public ArrayList<NhaCungCap_DTO> getAllNCC(){
        
        ArrayList<NhaCungCap_DTO> resultArray = new ArrayList<NhaCungCap_DTO>();
        String query = "SELECT * FROM tbl_nhacungcap";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhaCungCap_DTO nhacungcapDTO = new NhaCungCap_DTO();
                
                nhacungcapDTO.setMaNCC(resultSet.getInt("maNCC"));
                nhacungcapDTO.setTenNCC(resultSet.getString("tenNCC"));
                nhacungcapDTO.setDiaChiNCC(resultSet.getString("diaChiNCC"));
                nhacungcapDTO.setSdtNCC(resultSet.getString("sdtNCC"));
                nhacungcapDTO.setSoLuongSPNCC(resultSet.getInt("soLuongSPNCC"));
                nhacungcapDTO.setTrangThaiNCC(resultSet.getString("trangThaiNCC"));
                    resultArray.add(nhacungcapDTO);
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
    
//    public ArrayList<NhaCungCap_DTO> getAllSPNCC(){
//        ArrayList<NhaCungCap_DTO> resultArray = new ArrayList<NhaCungCap_DTO>();
//        String query = "SELECT * FROM tbl_nhacungcap, tbl_sanpham WHERE tbl_nhacungcap.maNCC = tbl_sanpham.maNCC";
//        
//        try{
//            xuLyDB = new XuLyDatabase_BUS();
//            connection = xuLyDB.openConnection();
//            
//            ps = connection.prepareStatement(query);
//            resultSet = ps.executeQuery();
//            
//            while (resultSet.next()){
//                NhaCungCap_DTO nhacungcapDTO = new NhaCungCap_DTO();
//                
//                nhacungcapDTO.set(resultSet.getInt("maNCC"));
//                nhacungcapDTO.setTenNCC(resultSet.getString("tenNCC"));
//                nhacungcapDTO.setDiaChiNCC(resultSet.getString("diaChiNCC"));
//                nhacungcapDTO.setSdtNCC(resultSet.getString("sdtNCC"));
//                 nhacungcapDTO.setTrangThaiNCC(resultSet.getString("trangThaiNCC"));
//                
////                if (resultSet.getString("trangThaiNV").equals("Mở")){
//                    resultArray.add(nhacungcapDTO);
//                //}
//                
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(NhaCungCap_DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        //Dong ket noi
//        finally{
//            try{
//                xuLyDB.closeConnection(connection);
//                ps.close();
//                resultSet.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//        
//        return resultArray;
//    }
    
    public int ThemNCC(NhaCungCap_DTO nhacungcapDTO){     
        int result = 0;
        String query = "INSERT INTO tbl_nhacungcap(maNCC, tenNCC, diaChiNCC, sdtNCC) "
                + "VALUES(?, ?, ?, ?) ";
        
        try{
            xuLyDB = new XuLyDatabase();
            
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            
            ps.setInt(1, nhacungcapDTO.getMaNCC());
            ps.setString(2, nhacungcapDTO.getTenNCC());
            ps.setString(3, nhacungcapDTO.getDiaChiNCC());
            ps.setString(4, nhacungcapDTO.getSdtNCC());
 
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
    
    public int KhoaNCC(NhaCungCap_DTO nhacungcapDTO){
        int result = 0;
        String queryKhoa = "UPDATE tbl_nhacungcap SET trangThaiNCC='Khóa' WHERE maNCC =?";
            
            try{
                xuLyDB = new XuLyDatabase();
                connection = xuLyDB.openConnection();

                ps = connection.prepareStatement(queryKhoa);

                ps.setInt(1, nhacungcapDTO.getMaNCC());

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
    
    public int CapNhatNCC(NhaCungCap_DTO nhacungcapDTO){
        int result = 0;
 
        try{
                    String queryUpdate = "UPDATE tbl_nhacungcap SET tenNCC= ?, diaChiNCC= ?, sdtNCC= ?"
                    + " WHERE maNCC = ?";
                    
                    xuLyDB = new XuLyDatabase();
                    connection = xuLyDB.openConnection();

                    ps = connection.prepareStatement(queryUpdate);

                    ps.setString(1, nhacungcapDTO.getTenNCC());
                    ps.setString(2, nhacungcapDTO.getDiaChiNCC());
                    ps.setString(3, nhacungcapDTO.getSdtNCC());
                    ps.setInt(4, nhacungcapDTO.getMaNCC());

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
 
    public ArrayList<NhaCungCap_DTO> timKiemTheoTenNCC(String searchValue){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhaCungCap_DTO> resultArray = new ArrayList<NhaCungCap_DTO>();
        String query = "SELECT * FROM tbl_nhacungcap WHERE tenNCC LIKE '%" + searchValue +"%' ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhaCungCap_DTO nhacungcapDTO = new NhaCungCap_DTO();
                nhacungcapDTO.setMaNCC(resultSet.getInt("maNCC"));
                nhacungcapDTO.setTenNCC(resultSet.getString("tenNCC"));
                nhacungcapDTO.setDiaChiNCC(resultSet.getString("diaChiNCC"));
                nhacungcapDTO.setSdtNCC(resultSet.getString("sdtNCC"));
                nhacungcapDTO.setTrangThaiNCC(resultSet.getString("trangThaiNCC"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhacungcapDTO);
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
    
    public ArrayList<NhaCungCap_DTO> timKiemTheoMaNCC(String searchValue){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhaCungCap_DTO> resultArray = new ArrayList<NhaCungCap_DTO>();
        String query = "SELECT * FROM tbl_nhacungcap WHERE maNCC LIKE '%" + searchValue +"%' ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhaCungCap_DTO nhacungcapDTO = new NhaCungCap_DTO();
                nhacungcapDTO.setMaNCC(resultSet.getInt("maNCC"));
                nhacungcapDTO.setTenNCC(resultSet.getString("tenNCC"));
                nhacungcapDTO.setDiaChiNCC(resultSet.getString("diaChiNCC"));
                nhacungcapDTO.setSdtNCC(resultSet.getString("sdtNCC"));
                nhacungcapDTO.setTrangThaiNCC(resultSet.getString("trangThaiNCC"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhacungcapDTO);
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
    
    public ArrayList<NhaCungCap_DTO> timKiemTheoDiaChiNCC(String searchValue){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhaCungCap_DTO> resultArray = new ArrayList<NhaCungCap_DTO>();
        String query = "SELECT * FROM tbl_nhacungcap WHERE diaChiNCC LIKE '%" + searchValue +"%' ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhaCungCap_DTO nhacungcapDTO = new NhaCungCap_DTO();
                nhacungcapDTO.setMaNCC(resultSet.getInt("maNCC"));
                nhacungcapDTO.setTenNCC(resultSet.getString("tenNCC"));
                nhacungcapDTO.setDiaChiNCC(resultSet.getString("diaChiNCC"));
                nhacungcapDTO.setSdtNCC(resultSet.getString("sdtNCC"));
                nhacungcapDTO.setTrangThaiNCC(resultSet.getString("trangThaiNCC"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhacungcapDTO);
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
    
    public ArrayList<NhaCungCap_DTO> timKiemTheoSDTNCC(String searchValue){ //Tìm kiếm theo tên tài khoản nhân viên
        ArrayList<NhaCungCap_DTO> resultArray = new ArrayList<NhaCungCap_DTO>();
        String query = "SELECT * FROM tbl_nhacungcap WHERE sdtNCC LIKE '%" + searchValue +"%' ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                NhaCungCap_DTO nhacungcapDTO = new NhaCungCap_DTO();
                nhacungcapDTO.setMaNCC(resultSet.getInt("maNCC"));
                nhacungcapDTO.setTenNCC(resultSet.getString("tenNCC"));
                nhacungcapDTO.setDiaChiNCC(resultSet.getString("diaChiNCC"));
                nhacungcapDTO.setSdtNCC(resultSet.getString("sdtNCC"));
                nhacungcapDTO.setTrangThaiNCC(resultSet.getString("trangThaiNCC"));
                
//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                    resultArray.add(nhacungcapDTO);
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
    
}
    



