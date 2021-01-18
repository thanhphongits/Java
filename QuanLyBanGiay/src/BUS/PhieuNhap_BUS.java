/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhieuNhap_DAO;
import DTO.ChiTietPhieuNhap_DTO;
import DTO.PhieuNhap_DTO;
import DTO.SanPham_DTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PhieuNhap_BUS {
    PhieuNhap_DAO phieunhapDAO = new PhieuNhap_DAO();
    
    public ArrayList<PhieuNhap_DTO> getAllPhieuNhap(){
        return phieunhapDAO.getAllPhieuNhap();
    }
    
    public ArrayList<ChiTietPhieuNhap_DTO> getAllChiTietPhieuNhap(){
         return phieunhapDAO.getAllChiTietPhieuNhap();
    }
    
    public int ThemPhieuNhap(PhieuNhap_DTO phieunhapDTO){ 
        int result = phieunhapDAO.ThemPhieuNhap(phieunhapDTO);
        return result;
    }
    
    public int ThemChiTietPhieuNhap(ChiTietPhieuNhap_DTO chitietpnDTO){
        int result = phieunhapDAO.ThemChiTietPhieuNhap(chitietpnDTO);
        return result;
    }
    
    public int CapNhatSLSP(SanPham_DTO sanphamDTO){
        int result = phieunhapDAO.CapNhatSLSP(sanphamDTO);
        return result;
    }
    
    
    public ArrayList<PhieuNhap_DTO> timKiemPN(String sqlTimKiem, String searchValue){
        return phieunhapDAO.timKiemPN(sqlTimKiem, searchValue);
    }
    
    public ArrayList<PhieuNhap_DTO> locTheoNgayPN(String ma1, String ma2, String cbbValue, String valueSearch){
        return phieunhapDAO.locTheoNgayPN(ma1, ma2, cbbValue, valueSearch);
    }
    
    public ArrayList<PhieuNhap_DTO> locTheoNgayPN(String ma1, String ma2){
        return phieunhapDAO.locTheoNgayPN(ma1, ma2);
    }
    
    public ArrayList<PhieuNhap_DTO> locBeHonBang(String ma1, String cbbValue, String valueSearch){
        return phieunhapDAO.locBeHonBang(ma1, cbbValue, valueSearch);
    }
    
    public ArrayList<PhieuNhap_DTO> locBeHonBang(String ma2){
        return phieunhapDAO.locBeHonBang(ma2);
    }
    
    public ArrayList<PhieuNhap_DTO> locLonHonBang(String ma2){ 
        return phieunhapDAO.locLonHonBang(ma2);
    }
    
    public ArrayList<PhieuNhap_DTO> locLonHonBang(String ma1, String cbbValue, String valueSearch){
        return phieunhapDAO.locLonHonBang(ma1, cbbValue, valueSearch);
    }
    
    public int XoaPN(PhieuNhap_DTO phieunhapDTO){
        int result = phieunhapDAO.XoaPN(phieunhapDTO);
        return result;
    }
    
    
}
