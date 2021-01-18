/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.time.LocalDate;



/**
 *
 * @author Administrator
 */
public class HoaDon_DTO {
    private int maHD;
    private int maKH;
    private int maNV;
    private LocalDate ngayLapHD;
    private int tongTienHD;
    private String trangThaiHD;

    public String getTrangThaiHD() {
        return trangThaiHD;
    }

    public void setTrangThaiHD(String trangThaiHD) {
        this.trangThaiHD = trangThaiHD;
    }

    public HoaDon_DTO(int maHD, int maKH, int maNV, LocalDate ngayLapHD, int tongTienHD, String trangThaiHD) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayLapHD = ngayLapHD;
        this.tongTienHD = tongTienHD;
        this.trangThaiHD = trangThaiHD;
    }
    
    public HoaDon_DTO() {
        this.maHD = 0;
        this.maKH = 0;
        this.maNV = 0;
        this.ngayLapHD = LocalDate.now();
        this.tongTienHD = 0;
        this.trangThaiHD = null;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public LocalDate getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(LocalDate ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public int getTongTienHD() {
        return tongTienHD;
    }

    public void setTongTienHD(int tongTienHD) {
        this.tongTienHD = tongTienHD;
    }
    
    
}
