/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.HoaDon_DAO;
import DTO.ChiTietHoaDon_DTO;
import DTO.HoaDon_DTO;
import DTO.SanPham_DTO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class HoaDon_BUS {
    HoaDon_DAO HD_DAO = new HoaDon_DAO();
    
    public ArrayList<HoaDon_DTO> getAllHoaDon(){
        return HD_DAO.getAllHoaDon();
    }
    
    public ArrayList<ChiTietHoaDon_DTO> getAllChiTietHoaDon(){
        return HD_DAO.getAllChiTietHoaDon();
    }
    
    public int ThemHoaDon(HoaDon_DTO hoadonDTO){
        int result = HD_DAO.ThemHoaDon(hoadonDTO);
        return result;
    }
    
    public int ThemChiTietHoaDon(ChiTietHoaDon_DTO chitiethdDTO){
        int result = HD_DAO.ThemChiTietHoaDon(chitiethdDTO);
        return result;
    }
    
     public int CapNhatSLSP(SanPham_DTO sanphamDTO){
         int result = HD_DAO.CapNhatSLSP(sanphamDTO);
         return result;
     }
     
     //Tim Kiem start
     public ArrayList<HoaDon_DTO> timKiemHD(String sqlTimKiem, String searchValue){
         return HD_DAO.timKiemHD(sqlTimKiem, searchValue);
     }
     
     //Tim kiem ket hop start
     public ArrayList<HoaDon_DTO> locTheoNgayHD(String ma1, String ma2, String cbbValue, String valueSearch){
         return HD_DAO.locTheoNgayHD(ma1, ma2, cbbValue, valueSearch);
     }
     
     public ArrayList<HoaDon_DTO> locTheoNgayHD(String ma1, String ma2){
         return HD_DAO.locTheoNgayHD(ma1, ma2);
     }
     
     public ArrayList<HoaDon_DTO> locBeHonBang(String ma1, String cbbValue, String valueSearch){
         return HD_DAO.locBeHonBang(ma1, cbbValue, valueSearch);
     }
     
     public ArrayList<HoaDon_DTO> locBeHonBang(String ma2){
         return HD_DAO.locBeHonBang(ma2);
     }
     
     public ArrayList<HoaDon_DTO> locLonHonBang(String ma2){
         return HD_DAO.locLonHonBang(ma2);
     }
     
     public ArrayList<HoaDon_DTO> locLonHonBang(String ma1, String cbbValue, String valueSearch){
         return HD_DAO.locLonHonBang(ma1, cbbValue, valueSearch);
     }
     //Tim kiem ket hop end
     //Tim kiem end
    
     public int XoaHD(HoaDon_DTO hoadonDTO){
         int result = HD_DAO.XoaHD(hoadonDTO);
         return result;
     }
     
     
     
}
