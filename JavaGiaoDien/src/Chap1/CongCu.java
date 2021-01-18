/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chap1;

import java.util.Scanner;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Thanh Phong
 */
public class CongCu {

    static Scanner inp = new Scanner(System.in);

    public static void Hello() {
        System.out.println("Go Go");
    }

    public static int CheckInt() {
        int x;
        try {
            x = Integer.parseInt(CongCu.inp.nextLine());
        } catch (Exception e) {
            System.out.print("Nhập sai.\nNhập lại: ");
            x = CongCu.CheckInt();
        }
        return x;
    }
    public static float CheckFloat(){
        float x;
        try {
            x = Float.parseFloat(CongCu.inp.nextLine());
        } catch (Exception e) {
            System.out.print("Nhập sai.\nNhập lại: ");
            x = CongCu.CheckFloat();
        }
        return x;
    }

    public static boolean CheckChanLe(int x) {
        if (x % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int CheckAmDuong(int x) {
        if (x > 0) {
            return 1;
        } else {
            if (x < 0) {
                return -1;
            }
        }
        return 0;
    }

    public static boolean CheckNgTo(int x) {
        if (x < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
