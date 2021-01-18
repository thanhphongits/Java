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
public class Bai7 {

    private int n;

    public Bai7() {
        this.n = 0;
    }

    public Bai7(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public void Nhap(){
        System.out.print("Nhập N: ");
        n = Tool.CheckInt();
    }
    public void Xuat(){
        System.out.println("N là : " + n);
    }

    public void NhoHonNAndTong() {
        int tong = 0;
        System.out.print("Các số tự nhiên nhỏ hơn hoặc bằng N :");
        for (int i = 0; i <= n; i++) {
            System.out.print(i + "\t");
            tong = tong + i;
        }
        System.out.println("Tổng các số đó là: " + tong);
    }

    public void ChanLeNhoHonNAndTong(int x) {
        if (x == 2) {
            int tong = 0;
            System.out.print("Các số tự nhiên chẵn nhỏ hơn hoặc bằng N :");
            for (int i = 0; i <= n; i++) {
                if (Tool.CheckChanLe(i)) {
                    System.out.print(i + "\t");
                    tong = tong + i;
                }
            }
            System.out.println("Tổng các số đó là: " + tong);
        } else if (x == 3) {
            int tong = 0;
            System.out.print("Các số tự nhiên lẻ nhỏ hơn hoặc bằng N :");
            for (int i = 0; i <= n; i++) {
                if (!Tool.CheckChanLe(i)) {
                    System.out.print(i + "\t");
                    tong = tong + i;
                }
            }
            System.out.println("Tổng các số đó là: " + tong);
        }
    }

    public void NguyenToNhoHonNAndTong() {
        int tong = 0;
        System.out.print("Các số nguyên tố nhỏ hơn hoặc bằng N :");
        for (int i = 0; i <= n; i++) {
            if (Tool.CheckNgTo(i)) {
                System.out.print(i + "\t");
                tong = tong + i;
            }
        }
        System.out.println("Tổng các số đó là: " + tong);
    }
    public void NNguyenToDauTien(){
        int tmp = 0;
        System.out.print("N số nguyên tố đầu tiên là: ");
        for(int i = 2; i < Integer.MAX_VALUE ; i++){
            if(Tool.CheckNgTo(i))
            {
                tmp ++;
                System.out.println(i + "\t");
            }
            if(tmp == n){
                return;
            }
        }
    }
    public static void Menu(){
        Bai1.Hello();
        Bai7 a = new Bai7();
        a.Nhap();
        int tmp;
        do{
            System.out.println("1. Các số tự nhiên <= N và tổng của chúng .\n"
                             + "2. Các số tự nhiên chẵn <= N và tổng của chúng .\n"
                             + "3. Các số tự nhiên lẻ <= N và tổng của chúng .\n"
                             + "4. Các số tự nhiên là số nguyên tố <= N và tổng của chúng .\n"
                             + "5. N số nguyên tố đầu tiên\n"
                             + "0. Thoát\n"
                             + "Nhập lựa chọn của bạn: ");
            tmp = Tool.CheckInt();
            switch(tmp){
                case 1: a.NhoHonNAndTong(); break;
                case 2: a.ChanLeNhoHonNAndTong(2); break;
                case 3: a.ChanLeNhoHonNAndTong(3); break;
                case 4: a.NguyenToNhoHonNAndTong(); break;
                case 5: a.NNguyenToDauTien(); break;
                case 0: break;
                default: break;
            }
        }while(tmp != 0);
    }
    public static void main(String[] args) {
        Bai7.Menu();
    }
}
