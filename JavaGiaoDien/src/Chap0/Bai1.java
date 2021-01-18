package Chap0;

import java.util.Scanner;

/*
 * @author Thanh Phong
 * OOP
 - Toàn vẹn dữ liệu
 - Đa hình
 - Kế thừa
 - Trừu tượng
 */
public class Bai1 {

    private int x = 0, y = 0;

    public Bai1() {
        this.x = 0;
        this.y = 0;
    }

    public Bai1(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void Tong() {
        int tong = x + y;
        System.out.println("Tổng: " + tong);
    }

    public void Hieu() {
        int hieu = x - y;
        System.out.println("Tổng: " + hieu);
    }

    public void Tich() {
        int tich = x * y;
        System.out.println("Tổng: " + tich);
    }

    public void Thuong() {
        if(y < 0){
            System.out.println("Không thực hiện được phép chia. ");
            return;
        }
        float thuong = x / y;
        System.out.println("Tổng: " + thuong);
    }

    public void Nhap() {
        System.out.print("Nhập x: ");
        x = Tool.CheckInt();
        System.out.print("Nhập y: ");
        y = Tool.CheckInt();
    }

    public void Xuat() {
        System.out.println("X = " + x);
        System.out.println("Y = " + y);
    }

    public static void Hello() {
        System.out.println("Go Go");
    }

    public static void Menu() {
        Bai1.Hello();
        Bai1 a = new Bai1();
        a.Nhap();
        int tmp;
        do {
            System.out.println("1. Tống\n"
                    + "2. Hiệu\n"
                    + "3. Tích\n"
                    + "4. Thương\n"
                    + "0. Thoát\n"
                    + "Nhập sự lựa chọn của bạn: ");
            tmp = Integer.parseInt(Tool.inp.nextLine());
            switch (tmp) {
                case 1:
                    a.Tong();
                    break;
                case 2:
                    a.Hieu();
                    break;
                case 3:
                    a.Tich();
                    break;
                case 4:
                    a.Thuong();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (tmp != 0);
        System.out.println("See you again!");
    }

    public static void main(String[] args) {
        Bai1.Menu();
    }
}


