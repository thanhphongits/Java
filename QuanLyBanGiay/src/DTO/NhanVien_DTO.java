/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.InputStream;

/**
 *
 * @author mend
 */
public class NhanVien_DTO {
    private int maNV;
    private int maChucVu;
    private String tenTaiKhoanNV;
    private String matKhauNV;
    private String hoTenNV;
    private String diaChiNV;
    private String sdtNV;
    private String cmndNV;
    private String gioiTinhNV;
    private String trangThaiNV;
    private byte[] anhNV;
    
    public NhanVien_DTO(int maNV, int maChucVu, String tenTaiKhoanNV, String matKhauNV, String hoTenNV, String diaChiNV, String sdtNV, String cmndNV, String gioiTinhNV, String trangThaiNV, byte[] anhNV) {
        this.maNV = maNV;
        this.maChucVu = maChucVu;
        this.tenTaiKhoanNV= tenTaiKhoanNV;
        this.matKhauNV = matKhauNV;
        this.hoTenNV = hoTenNV;
        this.diaChiNV = diaChiNV;
        this.sdtNV = sdtNV;
        this.cmndNV = cmndNV;
        this.gioiTinhNV = gioiTinhNV;
        this.trangThaiNV = trangThaiNV;
        this.anhNV = anhNV;
    }
    
    public NhanVien_DTO(){
        this.maNV = 0;
        this.maChucVu = 0;
        this.tenTaiKhoanNV= null;
        this.matKhauNV = null;
        this.hoTenNV = null;
        this.diaChiNV = null;
        this.sdtNV = null;
        this.cmndNV = null;
        this.gioiTinhNV = null;
        this.trangThaiNV = null;
        this.anhNV = null;
    }

    public String getTrangThaiNV() {
        return trangThaiNV;
    }

    public void setTrangThaiNV(String trangThaiNV) {
        this.trangThaiNV = trangThaiNV;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenTaiKhoanNV() {
        return tenTaiKhoanNV;
    }

    public void setTenTaiKhoanNV(String tenTaiKhoanNV) {
        this.tenTaiKhoanNV = tenTaiKhoanNV;
    }

    public String getMatKhauNV() {
        return matKhauNV;
    }

    public void setMatKhauNV(String matKhauNV) {
        this.matKhauNV = matKhauNV;
    }

    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public String getCmndNV() {
        return cmndNV;
    }

    public void setCmndNV(String cmndNV) {
        this.cmndNV = cmndNV;
    }

    public String getGioiTinhNV() {
        return gioiTinhNV;
    }

    public void setGioiTinhNV(String gioiTinhNV) {
        this.gioiTinhNV = gioiTinhNV;
    }

    public byte[] getAnhNV() {
        return anhNV;
    }

    public void setAnhNV(byte[] anhNV) {
        this.anhNV = anhNV;
    }
    
  
}
