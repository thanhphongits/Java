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
public class Main {
    public static void main(String[] args) {
        Bai1.Hello();
        int tmp;
        do{
            System.out.println("1. Bài 1.\n"
                             + "2. Bài 2.\n"
                             + "3. Bài 3.\n"
                             + "4. Bài 4.\n"
                             + "5. Bài 5.\n" 
                             + "6. Bài 6.\n"
                             + "7. Bài 7.\n"
                             + "8. Bài 8.\n"
                             + "9. Bài 9.\n"
                             + "0. Thoát\n"
                             + "Nhập lựa chọn của bạn: ");
            
            tmp = Tool.CheckInt();
            switch(tmp){
                case 1: Bai1.Menu(); break;
                case 2: Bai2.Menu(); break;
                case 3: Bai3.Menu(); break;
                case 4: Bai456.Menu(); break;
                case 5: Bai456.Menu(); break;
                case 6: Bai456.Menu(); break;
                case 7: Bai7.Menu(); break;
                case 8: Bai8.Menu(); break;
                case 9: Bai9.Menu(); break;
                case 0: break;
                default: break;
            }
        }while(tmp != 0);
    }
}
