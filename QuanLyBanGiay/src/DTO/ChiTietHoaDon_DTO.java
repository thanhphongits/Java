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
public class ChiTietHoaDon_DTO {
    private int maChiTietHD;
    private int maHD;
    private String tenNV;
    private String tenKH;
    private String diaChiGiaoHang;
    private int sdtGiaoHang;
    private int maSP;
    private String tenSP;
    private int sizeSP;
    private int donGiaSP;
    private int soLuongSP;
    private int thanhTien;
    private String ghiChu;

    public ChiTietHoaDon_DTO(int maChiTietHD, int maHD, String tenNV, String tenKH, String diaChiGiaoHang, int sdtGiaoHang, int maSP, String tenSP, int sizeSP, int donGiaSP, int soLuongSP, int thanhTien, String ghiChu) {
        this.maChiTietHD = maChiTietHD;
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.sdtGiaoHang = sdtGiaoHang;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.sizeSP = sizeSP;
        this.donGiaSP = donGiaSP;
        this.soLuongSP = soLuongSP;
        this.thanhTien = thanhTien;
        this.ghiChu = ghiChu;
    }
    
    public ChiTietHoaDon_DTO(){
        this.maChiTietHD = 0;
        this.maHD = 0;
        this.tenNV = null;
        this.tenKH = null;
        this.diaChiGiaoHang = null;
        this.sdtGiaoHang = 0;
        this.maSP = 0;
        this.tenSP = null;
        this.sizeSP = 0;
        this.donGiaSP = 0;
        this.soLuongSP = 0;
        this.thanhTien = 0;
        this.ghiChu = "";
    }

    public int getMaChiTietHD() {
        return maChiTietHD;
    }

    public void setMaChiTietHD(int maChiTietHD) {
        this.maChiTietHD = maChiTietHD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public int getSdtGiaoHang() {
        return sdtGiaoHang;
    }

    public void setSdtGiaoHang(int sdtGiaoHang) {
        this.sdtGiaoHang = sdtGiaoHang;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSizeSP() {
        return sizeSP;
    }

    public void setSizeSP(int sizeSP) {
        this.sizeSP = sizeSP;
    }

    public int getDonGiaSP() {
        return donGiaSP;
    }

    public void setDonGiaSP(int donGiaSP) {
        this.donGiaSP = donGiaSP;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
