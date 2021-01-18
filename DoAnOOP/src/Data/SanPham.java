/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class SanPham{
      protected String loai;
      protected String ten;
      protected static String NCC="Apple Store";
      protected int soluong;
      protected int giaTien;
      public static int countMa;
      //loai ten so luong gia tien
      Scanner nhap=new Scanner(System.in);
      public SanPham()
      {
    	  loai=null;
    	  ten=null;
    	  soluong=0;
      }
      public SanPham(String loai,String ten,int soluong)
      { 
    	  this.loai=loai;
    	  this.ten=ten;
    	  this.soluong=soluong;
      }
      public void setGiaTien(int giaTien){
          this.giaTien=giaTien;
      }
      public int getGiaTien(){
          return giaTien;
      }
    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Scanner getNhap() {
        return nhap;
    }

    public void setNhap(Scanner nhap) {
        this.nhap = nhap;
    }
      
      
    public void nhap()
        {
            loai=String.format("%d", countMa++);
            System.out.println("Nhập tên:");
            ten=nhap.nextLine();
            System.out.println("Nhập giá");
            int k=CongCu.getOption(CongCu.inp.nextLine());
            while(k==-1){
                System.out.println("Nhập lại giá tiền");
                k=CongCu.getOption(CongCu.inp.nextLine());

            }
            this.setGiaTien(k);
            soluong=0;
        }
        
    public void xuat(){
        System.out.println(String.format("%-10s%-20s%-5s%-10s%-20s",getLoai(),getTen(),getSoluong(),getGiaTien(),SanPham.NCC));
    }
    public void nhap(String S){
        String[] out = S.split("-");
        this.setLoai(out[0]);
        this.setTen(out[1]);
        this.setSoluong(Integer.parseInt(out[2]));
        this.setGiaTien(Integer.parseInt(out[3]));
    }
    public String toString(){
        return this.getLoai()+"-"+this.getTen()+"-"+this.getSoluong()+"-"+this.getGiaTien()+"-"+NCC;
    }
}
