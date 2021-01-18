/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chap0;

/**
 *
 * @author Thanh Phong
 */
public class Bai3 {
    private int r;

    public Bai3(){
        this.r= 0;
    }
    public Bai3(int r){
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
        r = Tool.CheckInt();
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
        Bai1.Hello();
        Bai3 a = new Bai3();
        a.Nhap();
        int tmp;
        do{
            System.out.println("1. Chu Vi\n"
                             + "2. Diện Tích\n"
                             + "0. Thoát\n"
                             + "Nhập lựa chọn của bạn: ");
            tmp = Tool.CheckInt();
            switch(tmp){
                case 1: a.ChuVi();break;
                case 2: a.DienTich();break;
                case 0: break;
                default: break;
            }
        }while(tmp != 0);
    }
    public static void main(String[] args) {
        Bai3.Menu();
    }
}
