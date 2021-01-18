/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVien_DAO;
import DTO.ChucVu_DTO;
import DTO.NhanVien_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author mend
 */
public class NhanVien_BUS {
    NhanVien_DAO nhanvienDAO = new NhanVien_DAO();
    
    public ResultSet LoginQuanTri(String tenTaiKhoanNV, String matKhauNV){
        ResultSet resultLogin = nhanvienDAO.LoginQuanTri(tenTaiKhoanNV, matKhauNV);
        return resultLogin;
    }
    
    public ArrayList<NhanVien_DTO> getAllNhanVien() throws ClassNotFoundException{
        return nhanvienDAO.getAllNhanVien();
    }
    
    public ArrayList<ChucVu_DTO> getAllChucVu(){
        return nhanvienDAO.getAllChucVu();
    }
    
    public void getAllChucVuCBB(JComboBox cbbName){
        nhanvienDAO.getAllChucVuCBB(cbbName);
    }
    
    public void getAllTenNVCBB(JComboBox cbbName){
        nhanvienDAO.getAllTenNVCBB(cbbName);
    }
    
    public int ThemNhanVien(NhanVien_DTO nhanvienDTO){
        int result = nhanvienDAO.ThemNhanVien(nhanvienDTO);
        return result;
    }
    
    public int KhoaNV(NhanVien_DTO nhanvienDTO){
        int result = nhanvienDAO.KhoaNV(nhanvienDTO);
        return result;
    }
    
    public int CapNhatNV(NhanVien_DTO nhanvienDTO){
        int result = nhanvienDAO.CapNhatNV(nhanvienDTO);
        return result;
    }
    
    //Start tìm kiếm
    public ArrayList<NhanVien_DTO> timKiemNV(String sqlTimKiem, String searchValue){
        return nhanvienDAO.timKiemNV(sqlTimKiem, searchValue);
    }
    
   public ArrayList<NhanVien_DTO> locTheoMaNV(String ma1, String ma2, String cbbValue, String valueSearch){
        return nhanvienDAO.locTheoMaNV(ma1, ma2,cbbValue,valueSearch);
    }
   
   public ArrayList<NhanVien_DTO> locTheoMaNV(String ma1, String ma2){
       return nhanvienDAO.locTheoMaNV(ma1, ma2);
   }
    
   public ArrayList<NhanVien_DTO> locLonHonBang(String ma1, String cbbValue, String valueSearch){
       return nhanvienDAO.locLonHonBang(ma1, cbbValue, valueSearch);
   }
   
   public ArrayList<NhanVien_DTO> locLonHonBang(String ma1){
       return nhanvienDAO.locLonHonBang(ma1);
   }
   
   public ArrayList<NhanVien_DTO> locBeHonBang(String ma1, String cbbValue, String valueSearch){
       return nhanvienDAO.locBeHonBang(ma1, cbbValue, valueSearch);
   }
   
   public ArrayList<NhanVien_DTO> locBeHonBang(String ma2){
      return nhanvienDAO.locBeHonBang(ma2);
   }
   
    //End tìm kiếm
}
