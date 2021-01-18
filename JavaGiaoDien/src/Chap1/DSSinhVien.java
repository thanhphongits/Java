/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chap1;

import java.util.Arrays;

/**
 *
 * @author Thanh Phong
 */
public class DSSinhVien {

    private SinhVien[] list;

    public DSSinhVien() {
        list = new SinhVien[0];
    }

    public DSSinhVien(SinhVien[] list) {
        this.list = list;
    }

    public void add(SinhVien a) {
        list = Arrays.copyOf(list, list.length + 1);
        list[list.length - 1] = a;
    }

    public int size() {
        return list.length;
    }

    public void Remove(int index) {
        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        list = Arrays.copyOf(list, list.length - 1);
    }

    public SinhVien get(int index) {
        return list[index];
    }

    public void nhap() {
        SinhVien a = new SinhVien();
        a.Nhap();
        this.add(a);
    }

    public void xuat() {
        System.out.println("DANH SÁCH SINH VIÊN");
        System.out.println(String.format("%-10s%-15s%-15s%-15s%-15s%-15s%-15s", "Mã", "Ngày lập", "mã nhân viên", "mã khách hàng", "Giảm", "Tổng Tiền", "Số lượng"));
        for (int i = 0; i < this.size(); i++) {
            this.get(i).Xuat();
        }
    }

    public void xuat(int i) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("%-10s%-20s%-10s%-13s%-15s%-25s%-15s%-30s%-20s", "MSNV", "Họ tên", "Giới tính", "Ngày sinh", "CMND", "Địa chỉ", "Số điện thoại", "email", "Chức vụ"));
        this.get(i).Xuat();
    }

    public int timkiem(int ma) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getMssv() == ma) {
                return i;
            }
        }
        return -1;
    }

    public SinhVien[] getList() {
        return list;
    }

    public void setList(SinhVien[] list) {
        this.list = list;
    }

    public static void Menu() {
        CongCu.Hello();
        DSSinhVien a = new DSSinhVien();
        a.nhap();
        int tmp;
        do {
            System.out.println("1. Xuất\n"
                    + "2. Thêm\n"
                    + "3. Sỉ số\n"
                    + "4. Xóa\n"
                    + "5. Tìm kiếm\n"
                    + "0. Thoát\n"
                    + "Nhập lựa chọn của bạn: ");
            tmp = CongCu.CheckInt();
            switch (tmp) {
                case 1:
                    a.xuat();
                    break;
                case 2: {
                    a.nhap();
                    break;
                }
                case 3: {
                    int x = a.size();
                    System.out.println("Sỉ số của dánh sách sinh viên: " + x);
                    break;
                }
                case 4: {
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    int x = CongCu.CheckInt();
                    a.Remove(x);
                    break;
                }
                case 5: {
                    System.out.println("Nhập mã cần tìm");
                    int ma = CongCu.CheckInt();
                    int index = a.timkiem(ma);
                    if (index != -1) {
                        a.xuat(index);
                    } else {
                        System.out.println("Không tìm thấy mã");
                    }
                    break;
                }
                case 0:
                    break;
                default:
                    break;
            }
        } while (tmp != 0);

    }
}
