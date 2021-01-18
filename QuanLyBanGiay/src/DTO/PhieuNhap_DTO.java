/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author Administrator
 */
public class PhieuNhap_DTO {
    private int maPhieuNhap;
    private int maNV;
    private LocalDate ngayLapPhieu;
    private int tongSLNhap;
    private String trangThaiPN;

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public LocalDate getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(LocalDate ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public int getTongSLNhap() {
        return tongSLNhap;
    }

    public void setTongSLNhap(int tongSLNhap) {
        this.tongSLNhap = tongSLNhap;
    }

    public String getTrangThaiPN() {
        return trangThaiPN;
    }

    public void setTrangThaiPN(String trangThaiPN) {
        this.trangThaiPN = trangThaiPN;
    }

    public PhieuNhap_DTO(int maPhieuNhap, int maNV, LocalDate ngayLapPhieu, int tongSLNhap, String trangThaiPN) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNV = maNV;
        this.ngayLapPhieu = ngayLapPhieu;
        this.tongSLNhap = tongSLNhap;
        this.trangThaiPN = trangThaiPN;
    }
    
    public PhieuNhap_DTO() {
        this.maPhieuNhap = 0;
        this.maNV = 0;
        this.ngayLapPhieu = LocalDate.now();
        this.tongSLNhap = 0;
        this.trangThaiPN = null;
    }
    
    
}
