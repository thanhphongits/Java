/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class DSHoaDon_Ban {
    protected HoaDon_Ban[] list = new HoaDon_Ban[0];
    protected boolean isread;
    public void add(HoaDon_Ban a){
        list= Arrays.copyOf(list,list.length+1);
        list[list.length-1]=a;
    }
    public int size(){
        return list.length;
    }
    public HoaDon_Ban get(int index){
        return list[index];
    }
    public void Remove(int index){
        for (int i=index; i<list.length-1; i++){
            list[i] = list[i+1];
        }
        list= Arrays.copyOf(list,list.length-1);
    }
    public void nhap(String S){
        // Ma + NgayLap + NhanVien + KhachHang + MangSanPham
        HoaDon_Ban a = new HoaDon_Ban();
        String[] out = S.split("-");
        a.setMsdh(out[0]);
        a.setNgayLapHD(out[1]);
        a.setNv(out[2]);
        a.setKhachHang(out[3]);
        a.setGiamGia(Integer.parseInt(out[4]));
        a.setTongTien(Integer.parseInt(out[5]));
        a.setSl(Integer.parseInt(out[6]));
        this.add(a);
    }
    public void docdl(){
            File text = new File("./CSDL/Bill_Sell.txt");
		    Scanner scanner = null;
            try {
                scanner = new Scanner(text);
            } catch (FileNotFoundException e) {
                try{
                    text.createNewFile();
                }catch(IOException a){
    
                }
                try {
                    scanner = new Scanner(text);
                } catch (FileNotFoundException x){
                    
                }
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.nhap(line);
                for(int i=0;i<this.get(this.size()-1).getSl();i++){
                    this.get(this.size()-1).getlist().nhap(scanner.nextLine());
                }
            }
            isread=true;
            this.updateMa();
    }
    public void ghidl(){
            if(isread==false) {
                return;
            }
            File f = new File("./CSDL/Bill_Sell.txt");

            try(PrintWriter pw = new PrintWriter(f)){
                for(int i=0;i<this.size();i++){
                    pw.println(this.get(i).toString());
                    for(int j=0;j<this.get(i).getSl();j++){
                        pw.println(this.get(i).listSanPham.get(j).toString());
                    }
                }
            } catch(Exception e){
            };
            isread = false;
    }
    public void nhap(){
        HoaDon_Ban a = new HoaDon_Ban();
        a.nhapBill();
        this.add(a);
    }
    public void xuat(){
        System.out.println("DANH SÁCH HOÁ ĐƠN BÁN");
        System.out.println(String.format("%-10s%-15s%-15s%-15s%-15s%-15s%-15s","Mã","Ngày lập","mã nhân viên","mã khách hàng","Giảm","Tổng Tiền","Số lượng"));
        for(int i=0;i<this.size();i++){
            this.get(i).xuat1();
        }
    }
    public void updateMa(){
        if(this.size()==0) HoaDon_Ban.countma=95000;
        else{
            HoaDon_Ban.countma=Integer.parseInt(this.get(this.size()-1).getMsdh())+1;
        }
    }
    public static void Menu(){
        DSHoaDon_Ban a = new DSHoaDon_Ban();
        a.docdl();
        int option ;
        do{
            System.out.println("QUÁN LÍ HOÁ ĐƠN BÁN ");
            System.out.println("1.Nhập hoá đơn");
            System.out.println("2.Xuất danh sách hoá đơn");
            System.out.println("3.Xuất hoá đơn chi tiết");
            System.out.println("0.Thoát");
            option=CongCu.getOption(CongCu.inp.nextLine());
            switch(option){
                case 1:{
                    a.nhap();
                    break;
                }
                case 2:{
                    a.xuat();
                    break;
                }
                case 3:{
                    a.xuat1();
                    break;
                }
                default:{
                    System.out.println("Nhập lại cú pháp");
                    break;
                }
                case 0:{
                    System.out.println("Thoát");
                    break;
                }
            }
        }while(option!=0);
        a.ghidl();
    }
    public int timkiem(String ma){
        for(int i=0;i<this.size();i++)
            if(this.get(i).getMsdh().equals(ma)){
                return i;
            }
        return -1;
    }
    public void thongKeDoanhThu(){
        DSSanPham sp = new DSSanPham();
        Date a;
        Date b;
        do{
            System.out.println("Nhập ngày bắt đầu");
            a=CongCu.convertDate(CongCu.inp.nextLine());
            System.out.println("Nhập ngày kết thúc");
            b=CongCu.convertDate(CongCu.inp.nextLine());
        }while(a.after(b)||a.equals(b));
        int Tong=0;
        System.out.println("DANH SÁCH HOÁ ĐƠN BÁN");
        System.out.println(String.format("%-10s%-15s%-15s%-15s%-15s%-15s%-15s","Mã","Ngày lập","mã nhân viên","mã khách hàng","Giảm","Tổng Tiền","Số lượng"));
        for(int i=0;i<this.size()&&!this.get(i).getNgayLapHD().after(b);i++){
            if(this.get(i).getNgayLapHD().after(a)&&this.get(i).getNgayLapHD().before(b)||this.get(i).getNgayLapHD().equals(a)||this.get(i).getNgayLapHD().equals(b)){
                this.get(i).xuat1();
                Tong+=(this.get(i).tongTien-this.get(i).giamGia);
                for(int j=0;j<this.get(i).getSl();j++){
                    int index = sp.timKiem(this.get(i).listSanPham.get(j).getLoai());
                    if(index!=-1){
                        sp.updatebuy(index,this.get(i).listSanPham.get(j).getSoluong());
                    }
                    else{
                        sp.add(this.get(i).listSanPham.createSP(j));
                    }
                }
            }
        }
        System.out.println("Tổng doanh thu: "+Tong);
        System.out.println("Sản Phẩm bán được");
        sp.xuat();
    }
    public static void ThongKe(){
        String option;
        DSHoaDon_Ban a =new DSHoaDon_Ban();
        a.docdl();
        do{
            System.out.println("THỐNG KÊ BÁN HÀNG");
            System.out.println("1.Thống kê doanh thu theo khoảng tự chọn");
            System.out.println("2.Thống kê theo tháng");
            option=CongCu.inp.nextLine();
            switch(option){
                case "1":{
                    a.thongKeDoanhThu();
                    break;
                }
                case "2":{
                    break;
                }
               
                default:{
                    break;
                }
            }
        }while(option!="0");
        a.ghidl();
    }
    public void xuat1(){
        System.out.println("Nhập mã hoá đơn: ");
        String ma=CongCu.inp.nextLine();
        int index=this.timkiem(ma);
        if(index==-1){
            System.out.println("Không tồn tại mã hoá đơn");
        }else{
            this.get(index).xuat();
        }
    }
    public static void main(String[] args) {
        DSHoaDon_Ban a = new DSHoaDon_Ban();
        a.docdl();
        a.nhap();
        a.thongKeDoanhThu();
        a.ghidl();
    }
}
