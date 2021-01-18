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
public class Bai456 {
    private int n;
    public Bai456(){
        this.n = 0;
    }
    public Bai456(int n){
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public void Nhap(){
        System.out.print("Nhập số nguyên N: ");
        n = Tool.CheckInt();
    }
    public void Xuat(){
        System.out.println("N :" + n);
    }
    public void ChanLe(){
        if(Tool.CheckChanLe(n)) System.out.println("N là số chẵn .");
        else System.out.println("N là số lẽ .");
    }
    public void AmDuong(){
        if(Tool.CheckAmDuong(n) == 1){
            System.out.println("N là số dương .");
            return;
        }
        else{
            if(Tool.CheckAmDuong(n) == -1){
                System.out.println("N là số âm . ");
                return;
            }
        }
        if(Tool.CheckAmDuong(n) == 0){
            System.out.println("N là số không .");
            return;
        }
    }
    public void NgTo(){
        if(Tool.CheckNgTo(n)) System.out.println("N là số nguyên tố .");
        else System.out.println("N không phải số nguyên tố .");
    }
    public static void Menu() {
        Bai1.Hello();
        Bai456 a = new Bai456();
        a.Nhap();
        int tmp;
        do{
            System.out.println("1. Kiểm Tra Chẳn Lẻ\n"
                             + "2. Kiểm Tra Âm Dương\n"
                             + "3. Kiểm Tra Nguyên Tố\n"
                             + "0. Thoát\n"
                             + "Nhập lựa chọn của bạn: ");
            tmp = Tool.CheckInt();
            switch(tmp){
                case 1: a.ChanLe(); break;
                case 2: a.AmDuong(); break;
                case 3: a.NgTo(); break;
                case 0: break;
                default: break;
            }
        }while(tmp != 0);
        
    }
    public static void main(String[] args) {
        Bai456.Menu();
    }
}
