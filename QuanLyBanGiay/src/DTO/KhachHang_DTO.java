/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author h
 */
public class KhachHang_DTO {

    private int maKH;
    private String hoTenKH;
    private String diaChiKH;
    private String sdtKH;
    private String cmndKH;
    private String gioiTinhKH;
    private String trangThaiKH;

    public void KhachHang_DTO() {
        this.maKH = 0;
        this.hoTenKH = null;
        this.diaChiKH = null;
        this.gioiTinhKH = null;
        this.sdtKH = null;
        this.cmndKH = null;
        this.trangThaiKH = null;
    }

    public void KhachHang_DTO(int maKH, String sdtKH, String cmndKH, String hoTenKH, String diaChiKH, String gioiTinhKH, String trangThaiKH) {
        this.maKH = maKH;
        this.hoTenKH = hoTenKH;
        this.diaChiKH = diaChiKH;
        this.gioiTinhKH = gioiTinhKH;
        this.sdtKH = sdtKH;
        this.cmndKH = cmndKH;
        this.trangThaiKH = trangThaiKH;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getCmndKH() {
        return cmndKH;
    }

    public void setCmndKH(String cmndKH) {
        this.cmndKH = cmndKH;
    }

    public String getGioiTinhKH() {
        return gioiTinhKH;
    }

    public void setGioiTinhKH(String gioiTinhKH) {
        this.gioiTinhKH = gioiTinhKH;
    }

    public String getTrangThaiKH() {
        return trangThaiKH;
    }

    public void setTrangThaiKH(String trangThaiKH) {
        this.trangThaiKH = trangThaiKH;
    }
}
