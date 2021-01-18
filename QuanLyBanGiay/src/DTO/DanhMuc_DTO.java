/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class DanhMuc_DTO {
    private int maDM;
    private String tenDM;
    private int soLuongSPDM;
    private String trangThaiDM;

    public String getTrangThaiDM() {
        return trangThaiDM;
    }

    public void setTrangThaiDM(String trangThaiDM) {
        this.trangThaiDM = trangThaiDM;
    }

    public DanhMuc_DTO(int maDM, String tenDM, int soLuongSPDM, String trangThaiDM) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.soLuongSPDM = soLuongSPDM;
        this.trangThaiDM = trangThaiDM;
    }
    
     public DanhMuc_DTO() {
        this.maDM = 0;
        this.tenDM = null;
        this.soLuongSPDM = 0;
        this.trangThaiDM = null;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public int getSoLuongSPDM() {
        return soLuongSPDM;
    }

    public void setSoLuongSPDM(int soLuongSPDM) {
        this.soLuongSPDM = soLuongSPDM;
    }
    
    
}
