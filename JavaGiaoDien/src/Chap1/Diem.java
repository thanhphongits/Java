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
public class Diem {

    private int x, y;

    public Diem() {
        this.x = 0;
        this.y = y;
    }

    public Diem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Diem(Diem a) {
        this.x = a.x;
        this.y = a.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void Nhap() {
        System.out.print("Nhập x: ");
        x = CongCu.CheckInt();
        System.out.print("Nhập y: ");
        y = CongCu.CheckInt();
    }

    public void Xuat() {
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
    }

    public void Move() {
        System.out.println("Nhập tọa độ điểm muốn di chuyển đến!");
        System.out.print("Nhập x: ");
        int x1 = CongCu.CheckInt();
        System.out.print("Nhập y: ");
        int y1 = CongCu.CheckInt();
        this.x = x1;
        this.y = y1;
    }

    public void TinhTien() {
        System.out.println("Nhập khoảng cách muốn di chuyển đến !");
        System.out.print("Nhập dx: ");
        int dx = CongCu.CheckInt();
        System.out.print("Nhập dy: ");
        int dy = CongCu.CheckInt();
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    public static void Menu(){
        CongCu.Hello();
        Diem a = new Diem();
        CongCu.Hello();
        a.Nhap();
        int tmp;
        do{
            System.out.println("1. Xuất\n"
                             + "2. Di Chuyển\n"
                             + "3. Tịnh Tiến\n"
                             + "0. Thoát\n"
                             + "Nhập lựa chọn của bạn: ");
            tmp = CongCu.CheckInt();
            switch(tmp){
                case 1: a.Xuat();break;
                case 2: a.Move();break;
                case 3: a.TinhTien();break;
                case 0: break;
                default: break;
            }
        }while(tmp != 0);
    }

}
