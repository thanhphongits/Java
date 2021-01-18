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
public class NhaCungCap_DTO {
    private int maNCC;
    private String tenNCC;
    private String diaChiNCC;
    private String sdtNCC;
    private int soLuongSPNCC;
    private String trangThaiNCC;
    
    public int getSoLuongSPNCC() {
        return soLuongSPNCC;
    }

    public void setSoLuongSPNCC(int soLuongSPNCC) {
        this.soLuongSPNCC = soLuongSPNCC;
    }

    public String getTrangThaiNCC() {
        return trangThaiNCC;
    }

    public void setTrangThaiNCC(String trangThaiNCC) {
        this.trangThaiNCC = trangThaiNCC;
    }
    

    public NhaCungCap_DTO(int maNCC, String tenNCC, String diaChiNCC, String sdtNCC, String trangThaiNCC, int soLuongSPNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChiNCC = diaChiNCC;
        this.sdtNCC = sdtNCC;
        this.trangThaiNCC = trangThaiNCC;
        this.soLuongSPNCC = soLuongSPNCC;
    }

    public NhaCungCap_DTO() {
        this.maNCC = 0;
        this.tenNCC = null;
        this.diaChiNCC = null;
        this.sdtNCC = null;
        this.trangThaiNCC = null;
        this.soLuongSPNCC = 0;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChiNCC() {
        return diaChiNCC;
    }

    public void setDiaChiNCC(String diaChiNCC) {
        this.diaChiNCC = diaChiNCC;
    }

    public String getSdtNCC() {
        return sdtNCC;
    }

    public void setSdtNCC(String sdtNCC) {
        this.sdtNCC = sdtNCC;
    }
    
    
    
    
    
}
