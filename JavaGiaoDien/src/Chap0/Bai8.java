/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chap0;

import java.util.Arrays;

/**
 *
 * @author Thanh Phong
 */
public class Bai8 {

    private int[] a;

    public Bai8() {
        a = new int[0];
    }

    public Bai8(int length) {
        a = new int[length];
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int getLength() {
        return (a.length);
    }

    public void Nhap() {
        System.out.println("Nhập số phần tử của mảng!");
        int length = Tool.CheckInt();
        a = new int[length];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Nhập phần tử " + (i) + " : ");
            a[i] = Tool.CheckInt();
        }
    }

    public void Xuat() {
        System.out.println("Xuất mảng!");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    public Bai8(int[] a) {
        this.a = a;
    }

    public void CacPhanTuAndTong() {
        int tong = 0;
        for (int i = 0; i < a.length; i++) {
            tong = tong + a[i];
            System.out.print(i + "\t");
        }
        System.out.println("Tổng các phân tử của mảng: " + tong);
    }

    public void ChanLeNgToAndTong(int tmp) {
        switch (tmp) {
            case 2: {
                int tong = 0;
                for (int i = 0; i < a.length; i++) {
                    if (Tool.CheckChanLe(a[i])) {
                        tong = tong + a[i];
                        System.out.print(i + "\t");
                    }
                }
                System.out.println("Tổng các phân tử chẵn của mảng: " + tong);
                break;
            }
            case 3: {
                int tong = 0;
                for (int i = 0; i < a.length; i++) {
                    if (!Tool.CheckChanLe(a[i])) {
                        tong = tong + a[i];
                        System.out.print(i + "\t");
                    }
                }
                System.out.println("Tổng các phân tử lẻ của mảng: " + tong);
                break;
            }
            case 4: {
                int tong = 0;
                for (int i = 0; i < a.length; i++) {
                    if (Tool.CheckNgTo(a[i])) {
                        tong = tong + a[i];
                        System.out.print(i + "\t");
                    }
                }
                System.out.println("Tổng các phân tử là nguyên tố của mảng: " + tong);
                break;
            }
            default:
                break;
        }
    }

    public void Chen() {
        int x, k;
        System.out.print("Nhập giá trị chèn: ");
        x = Tool.CheckInt();
        System.out.print("Nhập vị trí chèn: ");
        k = Tool.CheckInt();
        while (k > a.length | k < 0) {
            System.out.println("Bạn nhập sai vị trí.");
            System.out.print("Hãy nhập lại: ");
            k = Tool.CheckInt();
        }
        int[] b = new int[a.length + 1];
        for (int i = a.length; i > k; i--) {
            b[i] = a[i - 1];
        }
        b[k] = x;
        if (k > 0) {
            for (int i = k - 1; i >= 0; i--) {
                b[i] = a[i];
            }
        }
        a = Arrays.copyOf(b, b.length);

    }

    public void Xoa() {
        System.out.print("Nhập vị trí xóa: ");
        int k = Tool.CheckInt();
        while (k > a.length - 1 | k < 0) {
            System.out.println("Bạn nhập sai vị trí.");
            System.out.print("Hãy nhập lại: ");
            k = Tool.CheckInt();
        }
        int[] b = new int[a.length - 1];
        if (k == a.length - 1) {
            b = Arrays.copyOf(a, a.length - 1);
        } else if (k != a.length - 1) {
            System.arraycopy(a, 0, b, 0, k);
            //System.arraycopy(từ mảng, k, đến mảng, k, độ dài);
            b[k] = a[k + 1];
            if (k <= a.length - 1) {
                for (int i = k + 1; i < a.length - 1; i++) {
                    b[i] = a[i + 1];
                }
            }
        }
        a = Arrays.copyOf(b, b.length);
    }

    public void TimVTX() {
        System.out.print("Nhập số muốn kiểm tra: ");
        int tmp = 0, k = Tool.CheckInt();
        System.out.print("Vị trí của " + k + " trong mảng: ");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                System.out.print(i + "\t");
            }
        }
        if (tmp == 0) {
            System.out.println("Không có " + k + " trong mảng.");
        }
    }

    public static void Menu() {
        Bai1.Hello();
        Bai8 a = new Bai8();
        a.Nhap();
        int tmp;
        do {
            System.out.println("1. Các phần tử của mảng a và tổng của chúng .\n"
                    + "2. Các phần tử chẵn của mảng a và tổng của chúng .\n"
                    + "3. Các phần tử lẻ của mảng a và tổng của chúng .\n"
                    + "4. Các phần tử là số nguyên tố của mảng a và tổng của chúng .\n"
                    + "5. Thêm 1 phần tử mới vào mảng .\n"
                    + "6. Xoá phần tử thứ k của mảng . \n"
                    + "7. Nhập 1 số x, kiểm tra x có trong mảng a không, nếu có thì trả về vị trí của x trong mảng .\n"
                    + "0. Thoát\n"
                    + "Nhập lựa chọn của bạn: ");
            tmp = Tool.CheckInt();
            switch (tmp) {
                case 1:
                    a.CacPhanTuAndTong();
                    break;
                case 2:
                    a.ChanLeNgToAndTong(2);
                    break;
                case 3:
                    a.ChanLeNgToAndTong(3);
                    break;
                case 4: a.ChanLeNgToAndTong(4);break;
                case 5: 
                    a.Chen();
                    break;
                case 6:
                    a.Xoa();
                    break;
                case 7:
                    a.TimVTX();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (tmp != 0);
    }

    public static void main(String[] args) {
        Bai8.Menu();
    }
}
