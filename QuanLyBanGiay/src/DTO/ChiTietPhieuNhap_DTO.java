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
public class ChiTietPhieuNhap_DTO {
    private int maCTPN;
    private int maPhieuNhap;
    private int maSP;
    private int soLuongNhap;

    public ChiTietPhieuNhap_DTO(int maCTPN, int maPhieuNhap, int maSP, int soLuongNhap) {
        this.maCTPN = maCTPN;
        this.maPhieuNhap = maPhieuNhap;
        this.maSP = maSP;
        this.soLuongNhap = soLuongNhap;
    }
    
    public ChiTietPhieuNhap_DTO() {
        this.maCTPN = 0;
        this.maPhieuNhap = 0;
        this.maSP = 0;
        this.soLuongNhap = 0;
    }

    public int getMaCTPN() {
        return maCTPN;
    }

    public void setMaCTPN(int maCTPN) {
        this.maCTPN = maCTPN;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }
    
    
    
}
