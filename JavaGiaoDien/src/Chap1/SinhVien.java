/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chap1;

import Chap0.Tool;

/**
 *
 * @author Thanh Phong
 */
public class SinhVien {

    private String hoten, lop;
    private float d1, d2, d3;
    public static int mssv;

    public SinhVien() {
        this.mssv = 311000;;
        this.hoten = "";
        this.lop = "";
        this.d1 = 0;
        this.d2 = 0;
        this.d3 = 0;
    }

    public SinhVien(int mssv, String hoten, String lop, float d1, float d2, float d3) {
        this.mssv = mssv;;
        this.hoten = hoten;
        this.lop = lop;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public SinhVien(SinhVien a) {
        this.mssv = a.mssv;
        this.hoten = a.hoten;
        this.lop = a.lop;
        this.d1 = a.d1;
        this.d2 = a.d2;
        this.d3 = a.d3;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public float getD1() {
        return d1;
    }

    public void setD1(float d1) {
        this.d1 = d1;
    }

    public float getD2() {
        return d2;
    }

    public void setD2(float d2) {
        this.d2 = d2;
    }

    public float getD3() {
        return d3;
    }

    public void setD3(float d3) {
        this.d3 = d3;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public void Nhap() {
        System.out.print("Nhập MSSV: ");
        mssv = SinhVien.mssv++;
        System.out.print("Nhập Họ Tên: ");
        hoten = CongCu.inp.nextLine();
        System.out.print("Nhập Lớp: ");
        lop = CongCu.inp.nextLine();
        System.out.print("Nhập điểm thứ 1: ");
        d1 = CongCu.CheckFloat();
        System.out.print("Nhập điểm thứ 2: ");
        d2 = CongCu.CheckFloat();
        System.out.print("Nhập điểm thứ 3: ");
        d3 = CongCu.CheckFloat();
    }
    
    public void Xuat() {
        System.out.println("MSSV: " + mssv);
        System.out.println("Họ Tên: " + hoten);
        System.out.println("Lớp: " + lop);
        System.out.println("Điểm 1: " + d1);
        System.out.println("Điểm 2: " + d2);
        System.out.println("Điểm 3: " + d3);
    }

    public float DTB() {
        float dtb = (d1 + d2 + d3) / 3;
        return dtb;
    }

    public String XepLoai(float dtb) {
        String xeploai = "";
        if (dtb > 4.0 && dtb < 4.9) {
            return "Yếu";
        } else if (dtb > 5.0 && dtb < 5.4) {
            return "Trung Bình Yếu";
        } else if (dtb > 5.5 && dtb < 6.4) {
            return "Trung Bình";
        }
        else if(dtb > 6.5 && dtb < 6.9){
            return "Trung Bình Khá";
        }
        else if(dtb > 7.0 && dtb < 7.9){
            return "Khá";
        }
        else if(dtb > 8.0 && dtb < 8.4){
            return "Khá Giỏi";
        }
        else return "Giỏi";
    }
     public static void Menu(){
        CongCu.Hello();
        SinhVien a = new SinhVien();
        a.Nhap();
        int tmp;
        do{
            System.out.println("1. Xuất\n"
                             + "2. Tính Điểm Trung Bình\n"
                             + "3. Xếp Loại\n"
                             + "0. Thoát\n"
                             + "Nhập lựa chọn của bạn: ");
            tmp = CongCu.CheckInt();
            switch(tmp){
                case 1: a.Xuat();break;
                case 2: {
                    float f = a.DTB();
                    System.out.println("Điểm Trung Bình: " + f);
                    break;
                }
                case 3:{
                    String s = a.XepLoai(a.DTB());
                    System.out.println("Xếp Loại: " + s);
                    break;  
                }
                case 0: break;
                default: break;
            }
        }while(tmp != 0);
    }
}
