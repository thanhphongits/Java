/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mend
 */
public class SanPham_DTO {
    private int maSP,maNCC,soLuongSP,maDM,donGiaSP,sizeSP;
    private String tenSP,mieuTaSP,trangThaiSP;
    private byte [] anhSP;
    public SanPham_DTO(){
        this.maSP = 0;
        this.maNCC = 0;
        this.soLuongSP = 0;
        this.tenSP =null;
        this.sizeSP = 0;
        this.mieuTaSP = null;
        this.donGiaSP = 0;
        this.trangThaiSP = "Mở";
        this.maDM = 0;
        this.anhSP = null;
    }
    public SanPham_DTO(SanPham_DTO SP_DTO){
        this.maSP = SP_DTO.maSP;
        this.maNCC = SP_DTO.maNCC;
        this.mieuTaSP = SP_DTO.mieuTaSP;
        this.sizeSP = SP_DTO.sizeSP;
        this.tenSP = SP_DTO.tenSP;
        this.soLuongSP = SP_DTO.soLuongSP;
        this.donGiaSP = SP_DTO.donGiaSP;
        this.trangThaiSP = SP_DTO.trangThaiSP;
        this.maDM = SP_DTO.maDM;
        this.anhSP = SP_DTO.anhSP;
    }
    public SanPham_DTO(int maSP, int maNCC, String tenSP, int sizeSP, int soLuongSP, String mieuTaSP, int donGiaSP, String trangThaiSP, int maDM, byte [] anhSP){
        this.maSP = maSP;
        this.maNCC = maNCC;
        this.mieuTaSP = mieuTaSP;
        this.sizeSP = sizeSP;
        this.tenSP = tenSP;
        this.soLuongSP = soLuongSP;
        this.donGiaSP = donGiaSP;
        this.trangThaiSP = trangThaiSP;
        this.maDM = maDM;
        this.anhSP = anhSP;
    }

    public byte[] getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(byte[] anhSP) {
        this.anhSP = anhSP;
    }

    public int getMaDM() {
        return maDM;
    }

    public void setMaDM(int maDM) {
        this.maDM = maDM;
    }


    public String getTrangThaiSP() {
        return trangThaiSP;
    }

    public void setTrangThaiSP(String trangThaiSP) {
        this.trangThaiSP = trangThaiSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
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

    public String getMieuTaSP() {
        return mieuTaSP;
    }

    public void setMieuTaSP(String mieuTaSP) {
        this.mieuTaSP = mieuTaSP;
    }

    public int getDonGiaSP() {
        return donGiaSP;
    }

    public void setDonGiaSP(int donGiaSP) {
        this.donGiaSP = donGiaSP;
    }

    public void getMaSP(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
