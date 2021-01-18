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
public class HinhTron {
    private int r;

    public HinhTron(){
        this.r= 0;
    }
    public HinhTron(int r){
        this.r = r;
    }
    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
    public void  Nhap(){
        System.out.print("Nhập bán kính: ");
        r = CongCu.CheckInt();
    }
    public void Xuat(){
        System.out.println("Bán kính là: " + r);
    }
    public void ChuVi(){
        double chuvi = Math.PI*2*r;
        System.out.println("Chu vi: " + chuvi);
    }
    public void DienTich(){
        double dientich = Math.PI*r*r;
        System.out.println("Diện tích: " + dientich);
    }
    public static void Menu() {
        CongCu.Hello();
        HinhTron a = new HinhTron();
        a.Nhap();
        int tmp;
        do{
            System.out.println("1. Xuất\n"
                             + "2. Chu Vi\n"
                             + "3. Diện Tích\n"
                             + "0. Thoát\n"
                             + "Nhập lựa chọn của bạn: ");
            tmp = CongCu.CheckInt();
            switch(tmp){
                case 1: a.Xuat();break;
                case 2: a.ChuVi();break;
                case 3: a.DienTich();break;
                case 0: break;
                default: break;
            }
        }while(tmp != 0);
    }
}
