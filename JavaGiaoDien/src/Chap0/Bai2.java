package Chap0;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Phong
 */
public class Bai2 {
    private int dai, rong;
    public Bai2(){
        this.dai = 0;
        this.rong = 0;
    }
    public Bai2(int dai, int rong){
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
        dai = Tool.CheckInt();
        System.out.println("Nhập chiều rộng: ");
        rong = Tool.CheckInt();
    }
    public void Xuat(){
        System.out.println("Chiều dài: " + dai);
        System.out.println("Chiều rộng: " + rong);
    }
    public static void Menu(){
        Bai1.Hello();
        Bai2 a = new Bai2();
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
        Bai2.Menu();
    }
}
