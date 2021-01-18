/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DanhMuc_DAO;
import DTO.DanhMuc_DTO;
import DTO.SanPham_DTO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class DanhMuc_BUS {
    DanhMuc_DAO danhmucDAO = new DanhMuc_DAO();
    
    public ArrayList<DanhMuc_DTO> getAllDanhMuc(){
        return danhmucDAO.getAllDanhMuc();
    }
    public ArrayList<SanPham_DTO> getAllSPDanhMuc(int danhmuc){
        return danhmucDAO.getAllSPDanhMuc(danhmuc);
    }
    public int ThemDanhMuc(DanhMuc_DTO danhmucDTO){
        int result = danhmucDAO.ThemDanhMuc(danhmucDTO);
        return result;
    }
    public int CapNhatDanhMuc(DanhMuc_DTO danhmucDTO){
        int result = danhmucDAO.CapNhatDM(danhmucDTO);
        return result;
    }
    public int KhoaDanhMuc(DanhMuc_DTO danhmucDTO){
        int result = danhmucDAO.KhoaDM(danhmucDTO);
        return result;
    }
    
    public ArrayList<DanhMuc_DTO> timKiemDM(String sqlTimKiem, String searchValue){
        return danhmucDAO.timKiemDM(sqlTimKiem, searchValue);
    }
    
}
