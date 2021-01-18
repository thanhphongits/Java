/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.KhachHang_DTO;
import DTO.NhanVien_DTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class CongCu {
    
    public static int FormatTienStringSangInt(String str){
        return Integer.parseInt(str.replaceAll("[^a-zA-Z0-9]", ""));
    }
    public static String FormatTienIntSangString(int valueInt){
        return String.format("%,d", valueInt);
    }
    
    public static boolean checkSDT(String SDT){
        if(SDT.length()!=10){
            JOptionPane.showMessageDialog(null, "SDT cần có 10 chữ số");
            return false;
        }
        for (int i=0;i<SDT.length();i++){
            if((int)SDT.charAt(i)<48||(int)SDT.charAt(i)>57){
                JOptionPane.showMessageDialog(null, "SDT chỉ chứa số");
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkCMND(String CMND){
        if(CMND.length()!=9&&CMND.length()!=12){
            JOptionPane.showMessageDialog(null, "CMND yêu cầu độ dài 9 hoặc 12 mời nhập lại");
            return false;
        }
        for(int i=0;i<CMND.length();i++){
            if((int)CMND.charAt(i)<48||(int)CMND.charAt(i)>57){
                JOptionPane.showMessageDialog(null, "CMND chỉ chứa số");
                return false;
            }
        }
        
        //Kiểm tra trùng 
        ArrayList<NhanVien_DTO> nhanvienArr = new ArrayList<NhanVien_DTO>();  
        NhanVien_BUS nhanvienBUS = new NhanVien_BUS();
      
        try {
            nhanvienArr = nhanvienBUS.getAllNhanVien();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CongCu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
        
        for (int i=0; i < nhanvienArr.size(); i++ ){
                nhanvienDTO = nhanvienArr.get(i);
                
                if (nhanvienDTO.getCmndNV()== CMND){
                    JOptionPane.showMessageDialog(null, "CMND đã tồn tại! Mời nhập CMND khác!");
                    return false;
                }
        
        }
        
        return true;
    }
    
    public static boolean checkCMNDKH(String CMND){
        if(CMND.length()!=9&&CMND.length()!=12){
            JOptionPane.showMessageDialog(null, "CMND yêu cầu độ dài 9 hoặc 12 mời nhập lại");
            return false;
        }
        for(int i=0;i<CMND.length();i++){
            if((int)CMND.charAt(i)<48||(int)CMND.charAt(i)>57){
                JOptionPane.showMessageDialog(null, "CMND chỉ chứa số");
                return false;
            }
        }
        
        //Kiểm tra trùng 
        ArrayList<KhachHang_DTO> khArr = new ArrayList<KhachHang_DTO>();  
        KhachHang_BUS khBUS = new KhachHang_BUS();
      
        try {
            khArr = khBUS.getAllKhachHang();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CongCu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        KhachHang_DTO khDTO = new KhachHang_DTO();
        
        for (int i=0; i < khArr.size(); i++ ){
                khDTO = khArr.get(i);
                
                if (khDTO.getCmndKH() == CMND){
                    JOptionPane.showMessageDialog(null, "CMND đã tồn tại! Mời nhập CMND khác!");
                    return false;
                }
        
        }
        
        return true;
    }
    
    
    public static boolean checkTenTK(String tenTK){
        if(tenTK.length() > 30  ){
            JOptionPane.showMessageDialog(null, "Tên tài khoản chỉ dưới 30 kí tự");
            return false;
        }
        
        //Kiểm tra trùng tên tài khoản
        ArrayList<NhanVien_DTO> nhanvienArr = new ArrayList<NhanVien_DTO>();  
        NhanVien_BUS nhanvienBUS = new NhanVien_BUS();
      
        try {
            nhanvienArr = nhanvienBUS.getAllNhanVien();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CongCu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
        
        for (int i=0; i < nhanvienArr.size(); i++ ){
                nhanvienDTO = nhanvienArr.get(i);
                
                if (nhanvienDTO.getTenTaiKhoanNV().equals(tenTK)){
                    JOptionPane.showMessageDialog(null, "Tên tài khoản đã tồn tại! Mời nhập tên tài khoản khác!");
                    return false;
                }
        
        }
            
        return true;
    }
    
    public static boolean checkMa(String maNV){
        //int maNVInt=0;
        if(maNV.length() > 10  ){
            JOptionPane.showMessageDialog(null, "Mã nhân viên chỉ dưới 10 ");
            return false;
        }
        
       int maNVInt = Integer.parseInt(maNV);
        
        try{
          maNVInt = Integer.parseInt(maNV);
        }catch(NumberFormatException e){ //Kiểm tra có phải số nguyên hay không
            System.out.println("Lỗi");
            JOptionPane.showMessageDialog(null, "Mã nhân viên phải là số nguyên!");
                                            
        }
        
        //Kiểm tra trùng 
        ArrayList<NhanVien_DTO> nhanvienArr = new ArrayList<NhanVien_DTO>();  
        NhanVien_BUS nhanvienBUS = new NhanVien_BUS();
      
        try {
            nhanvienArr = nhanvienBUS.getAllNhanVien();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CongCu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        NhanVien_DTO nhanvienDTO = new NhanVien_DTO();
        
        for (int i=0; i < nhanvienArr.size(); i++ ){
                nhanvienDTO = nhanvienArr.get(i);
                
                if (nhanvienDTO.getMaNV() == maNVInt){
                    JOptionPane.showMessageDialog(null, "Mã NV đã tồn tại! Mời nhập mã nhân viên khác!");
                    return false;
                }
        
        }
            
        return true;
    }

    public static boolean checkTen(String HoTen){
        if(HoTen.length() > 30  ){
            JOptionPane.showMessageDialog(null, "Họ tê chỉ được nhập dưới 30 kí tự");
            return false;
        }
        
        return true;
    }
    
    public static boolean checkTenDangNhap(String tenDN){
        if(tenDN.length() > 30  ){
            JOptionPane.showMessageDialog(null, "Họ tê chỉ được nhập dưới 30 kí tự");
            return false;
        }
        
        return true;
    }
    
    public static boolean checkDiaChi(String DiaChi){
        if(DiaChi.length() > 100  ){
            JOptionPane.showMessageDialog(null, "Địa chỉ chỉ được nhập dưới 100 kí tự");
            return false;
        }
        
        return true;
    }
    
    
    
}
