/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHang_DAO;
import DTO.KhachHang_DTO;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author h
 */
public class KhachHang_BUS {
    KhachHang_DAO khachhangDAO = new KhachHang_DAO();
    
    public ArrayList<KhachHang_DTO> getAllKhachHang() throws ClassNotFoundException{
        return khachhangDAO.getAllKhachHang();
    }
    public int ThemKhachHang(KhachHang_DTO khachhangDTO){
        int result = khachhangDAO.ThemKhachHang(khachhangDTO);
        return result;
    }
    public int KhoaKH(KhachHang_DTO khachhangDTO){
        int result = khachhangDAO.KhoaKH(khachhangDTO);
        return result;
    }
    
    public int CapNhatKH(KhachHang_DTO khachhangDTO){       
        int result = khachhangDAO.CapNhatKH(khachhangDTO);
        return result;
    }
    
    ///tim kiem///
    public ArrayList<KhachHang_DTO> timKiemKH(String sqlTimKiem, String searchValue){
        return khachhangDAO.timKiemKH(sqlTimKiem, searchValue);
    }
    
    public ArrayList<KhachHang_DTO> timKiemTheoMaVaHoTenKH(String searchValue){
        return khachhangDAO.timKiemTheoMaVaHoTenKH(searchValue);
    }
    
    public void getAllTenKHCBB(JComboBox cbbName){
        khachhangDAO.getAllTenKHCBB(cbbName);
    }
    
    
    
}
