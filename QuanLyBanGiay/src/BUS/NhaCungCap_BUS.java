/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import DAO.NhaCungCap_DAO;
import DTO.NhaCungCap_DTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhaCungCap_BUS {
    NhaCungCap_DAO nhacungcapDAO = new NhaCungCap_DAO();
    
    public ArrayList<NhaCungCap_DTO> getAllNCC(){
        return nhacungcapDAO.getAllNCC();
    }
    
    public int ThemNCC(NhaCungCap_DTO nhacungcapDTO){
        int result = nhacungcapDAO.ThemNCC(nhacungcapDTO);
        return result;
    }
    
    public int KhoaNCC(NhaCungCap_DTO nhacungcapDTO){
        int result = nhacungcapDAO.KhoaNCC(nhacungcapDTO);
        return result;
    }
    
    public int CapNhatNCC(NhaCungCap_DTO nhacungcapDTO){
        int result = nhacungcapDAO.CapNhatNCC(nhacungcapDTO);
        return result;
    }
    
    public ArrayList<NhaCungCap_DTO> timKiemTheoTenNCC(String searchValue){
        return nhacungcapDAO.timKiemTheoTenNCC(searchValue);
    }
    
    public ArrayList<NhaCungCap_DTO> timKiemTheoMaNCC(String searchValue){
        return nhacungcapDAO.timKiemTheoMaNCC(searchValue);
    }
    
    public ArrayList<NhaCungCap_DTO> timKiemTheoDiaChiNCC(String searchValue){
        return nhacungcapDAO.timKiemTheoDiaChiNCC(searchValue);
    }
    
    public ArrayList<NhaCungCap_DTO> timKiemTheoSDTNCC(String searchValue){
        return nhacungcapDAO.timKiemTheoSDTNCC(searchValue);
    }
    
}
