/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
public class ThongKe {
    public static void Menu(){
        int opiton;
        do{
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                      MENU THỐNG KÊ");
            System.out.println("1.Thống kê nhập hàng");
            System.out.println("2.Thống kê bán hàng");
            System.out.println("3.Thống kê nhân viên");
            System.out.println("4.Thống kê khách hàng");
            System.out.println("5.Thống kê sản phẩm");
            System.out.println("0.Thoát");
            opiton=CongCu.getOption(CongCu.inp.nextLine());
            switch(opiton){
                case 1:{
                   DSHoaDon_Nhap.ThongKe();
                   break;
                }
                case 2:{
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    break;
                }
                case 5:{
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    break;
                }
            }
        }while(opiton!=0);
    }
}
