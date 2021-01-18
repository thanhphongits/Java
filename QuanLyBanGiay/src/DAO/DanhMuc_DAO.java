/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDB.XuLyDatabase;
import DAO.NhanVien_DAO;
import DTO.DanhMuc_DTO;
import DTO.SanPham_DTO;
import java.io.FileNotFoundException;
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
public class DanhMuc_DAO {
    private XuLyDatabase xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    
    public ArrayList<DanhMuc_DTO> getAllDanhMuc(){
        xuLyDB = new XuLyDatabase();
        ArrayList<DanhMuc_DTO> resultArray = new ArrayList<DanhMuc_DTO>();
        String query = "SELECT * FROM tbl_danhmuc";
        
        try{
            
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                DanhMuc_DTO danhmucDTO = new DanhMuc_DTO();
                danhmucDTO.setMaDM(resultSet.getInt("maDM"));
                danhmucDTO.setTenDM(resultSet.getString("tenDM"));
                danhmucDTO.setSoLuongSPDM(resultSet.getInt("soLuongSPDM"));  
                danhmucDTO.setTrangThaiDM(resultSet.getString("trangThaiDM"));
                
                resultArray.add(danhmucDTO);

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
    
    
    public ArrayList<SanPham_DTO> getAllSPDanhMuc(int danhmuc){
        xuLyDB = new XuLyDatabase();
        ArrayList<SanPham_DTO> resultArray = new ArrayList<SanPham_DTO>();
        String query = "SELECT * FROM tbl_sanpham WHERE maDM='" + danhmuc + "'";
        
        try {
            
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
                SP_DTO.setTrangThaiSP(resultSet.getString("trangThaiSP"));
                SP_DTO.setMieuTaSP(resultSet.getString("mieuTaSP"));
                SP_DTO.setDonGiaSP(resultSet.getInt("donGiaSP"));
                SP_DTO.setAnhSP(resultSet.getBytes("anhSP"));
//                if(SP_DTO.getTrangThaiSP() == "Mở"){
//                
//                }
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
    
    public int ThemDanhMuc(DanhMuc_DTO danhmucDTO){ 
        int result = 0;
        String query = "INSERT INTO tbl_danhmuc(maDM, tenDM) "
                + "VALUES(?, ?) ";
        
        try{
            xuLyDB = new XuLyDatabase();

            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            
            ps.setInt(1, danhmucDTO.getMaDM());
            ps.setString(2, danhmucDTO.getTenDM());
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
    
    public int CapNhatDM(DanhMuc_DTO danhmucDTO){
        int result = 0;
            try{
                    String query = "UPDATE tbl_danhmuc SET tenDM= ? WHERE maDM = ?";
                    
                    xuLyDB = new XuLyDatabase();
                    connection = xuLyDB.openConnection();

                    ps = connection.prepareStatement(query);

                    ps.setString(1, danhmucDTO.getTenDM());
                    ps.setInt(2, danhmucDTO.getMaDM());

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
    
    public int KhoaDM(DanhMuc_DTO danhmucDTO){
        int result = 0;
        String queryKhoa = "UPDATE tbl_danhmuc SET trangThaiDM='Khóa' WHERE maDM =?";
            
            try{
                xuLyDB = new XuLyDatabase();
                connection = xuLyDB.openConnection();

                ps = connection.prepareStatement(queryKhoa);

                ps.setInt(1, danhmucDTO.getMaDM());

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
    
    
    public ArrayList<DanhMuc_DTO> timKiemDM(String sqlTimKiem, String searchValue){ 
        ArrayList<DanhMuc_DTO> resultArray = new ArrayList<DanhMuc_DTO>();
        String query = "SELECT * FROM tbl_danhmuc WHERE "+ sqlTimKiem +" LIKE '%" + searchValue +"%' ";
        
        try{
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()){
                DanhMuc_DTO danhmucDTO = new DanhMuc_DTO();
                danhmucDTO.setMaDM(resultSet.getInt("maDM"));
                danhmucDTO.setTenDM(resultSet.getString("tenDM"));
                danhmucDTO.setSoLuongSPDM(resultSet.getInt("soLuongSPDM"));  
                danhmucDTO.setTrangThaiDM(resultSet.getString("trangThaiDM"));
                
                resultArray.add(danhmucDTO);

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
