/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chap1;

/**
 *
 * @author Thanh Phong
 */
public class HinhChuNhat {
    private int dai, rong;
    public HinhChuNhat(){
        this.dai = 0;
        this.rong = 0;
    }
    public HinhChuNhat(int dai, int rong){
        this.dai = dai;
        this.rong = rong;
    }

    public int getDai() {
        return dai;
    }

    public void setDai(int dai) {
        this.dai = dai;
    }

    public int getRong() {
        return rong;
    }

    public void setRong(int rong) {
        this.rong = rong;
    }
    public void ChuVi(){
        int chuvi = (dai + rong) *2 ;
        System.out.println("Chu Vi: " + chuvi);
    }
    public void DienTich(){
        int dientich = dai * rong;
        System.out.println("Diện tích: " + dientich);
    }
    public void Nhap(){
        System.out.print("Nhập chiều dài: ");
        dai = CongCu.CheckInt();
        System.out.println("Nhập chiều rộng: ");
        rong = CongCu.CheckInt();
    }
    public void Xuat(){
        System.out.println("Chiều dài: " + dai);
        System.out.println("Chiều rộng: " + rong);
    }
    public static void Menu(){
        CongCu.Hello();
        HinhChuNhat a = new HinhChuNhat();
        a.Nhap();
        int tmp;
        do{
            System.out.println("1. Chu Vi\n"
                             + "2. Diện Tích\n"
                             + "0. Thoát\n"
                             + "Nhập lựa chọn của bạn: ");
            tmp = CongCu.CheckInt();
            switch(tmp){
                case 1: a.ChuVi();break;
                case 2: a.DienTich();break;
                case 0: break;
                default: break;
            }
        }while(tmp != 0);
    }
    public static void main(String[] args) {
        HinhChuNhat.Menu();
    }
}
