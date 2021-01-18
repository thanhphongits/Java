/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SanPham_DAO;
import DTO.NhanVien_DTO;
import DTO.SanPham_DTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JComboBox;
  
/**
 *
 * @author Thanh Phong
 */
public class SanPham_BUS {
    SanPham_DAO SP_DAO = new SanPham_DAO();
    
    public ArrayList<SanPham_DTO> getAllSanPham(){
        return SP_DAO.getAllSanPham();   
    }
    
    public void getAllDanhMucSP(JComboBox cbbName){
        SP_DAO.getAllDM(cbbName);
    }
   
    public void getAllNCC(JComboBox cbbName){
        SP_DAO.getAllNCC(cbbName);
    }
   
    public int ThemSanPham(SanPham_DTO SP_DTO) throws ClassNotFoundException{
        int result = SP_DAO.ThemSP_DAO(SP_DTO);
        return result;
    }
    
    public int KhoaSP(SanPham_DTO SP_DTO) throws ClassNotFoundException{
        int result = SP_DAO.khoaSP_DAO(SP_DTO);
        return result;
    }
    
    public int CapNhatSP(SanPham_DTO SP_DTO){
        int result = SP_DAO.CapNhatSP_DAO(SP_DTO);
        return result;
    }
    
    public ArrayList<SanPham_DTO>timKiemSP(String sqlTimKiem, String searchValue){
        return SP_DAO.timKiemSP(sqlTimKiem, searchValue);
    }
    
   public ArrayList<SanPham_DTO> locTheoMaSP(String ma1, String ma2, String cbbValue, String valueSearch){
        return SP_DAO.locTheoMaSP(ma1, ma2,cbbValue,valueSearch);
    }
   
   public ArrayList<SanPham_DTO> locTheoMaSP(String ma1, String ma2){
       return SP_DAO.locTheoMaSP(ma1, ma2);
   }
    
  public ArrayList<SanPham_DTO> locLonHonBang(String ma1, String cbbValue, String valueSearch){
       return SP_DAO.locLonHonBang(ma1, cbbValue, valueSearch);
   }
   
   public ArrayList<SanPham_DTO> locLonHonBang(String ma1){
       return SP_DAO.locLonHonBang(ma1);
   }
   
   public ArrayList<SanPham_DTO> locBeHonBang(String ma1, String cbbValue, String valueSearch){
       return SP_DAO.locBeHonBang(ma1, cbbValue, valueSearch);
   }
   
   public ArrayList<SanPham_DTO> locBeHonBang(String ma2){
      return SP_DAO.locBeHonBang(ma2);
   }
    
}
