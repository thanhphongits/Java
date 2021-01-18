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
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class DSSanPham {
    protected SanPham[] list = new SanPham[0];
    protected boolean isread;
    protected Scanner nhap = new Scanner(System.in);
    public void updateSell(int i,int sl){ //giảm số lượng sản phẩm nè
           list[i].setSoluong(list[i].getSoluong()-sl);
    }
    public void updatebuy(int i,int sl){ //tăng số lượng sản phẩm lên
           list[i].setSoluong(list[i].getSoluong()+sl);
    }
    public boolean isAvailable(int i,int sl){
        if(list[i].getSoluong()>=sl) return true;
        else return false;
    }
    public int size(){
        return list.length;
    }
    public void add(SanPham a){
        list=Arrays.copyOf(list,list.length+1);
        list[list.length-1]=a;//list.length=0
    }
    public SanPham get(int index){
        return list[index];
    }
    public void nhap(String S){
        SanPham a= new SanPham();
        a.nhap(S);
        this.add(a);
    }
    public void nhap(){
        System.out.println("Nhập số lượng: ");
        int n=CongCu.getOption(CongCu.inp.nextLine());
        for(int i=0;i<n;i++){
            SanPham a = new SanPham();
            a.nhap();
            this.add(a);
        }
    }
    public void docdl(){
        File text = new File("./CSDL/SanPham.txt");
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
        }
        isread=true;
    }
   public void ghidl(){
            if(isread==false) {
                return;
            }
            File f = new File("./CSDL/SanPham.txt");

            try(PrintWriter pw = new PrintWriter(f)){
                for(int i=0;i<this.size();i++)
                pw.println(this.get(i).toString());
            } catch(Exception e){
            };
            isread = false;
    }
    public int timKiem(String loai){
        for(int i=0;i<this.size();i++){
            if(list[i].getLoai().equals(loai)){
                return i;
            }
        }
       return -1;
    }
       public void xuatHD(){
        System.out.println(String.format("%-20s%-5s%26s","Tên","Số lượng","Thành tiền"));
        for(int i=0;i<this.size();i++){
            System.out.println(String.format("%-20s%-5s%26d", this.get(i).getTen(),this.get(i).getSoluong(),this.get(i).getGiaTien()*this.get(i).getSoluong()));
        }
    }
    public SanPham createSP(int index, int sl){ // tạo clone (bản sao có cùng thông tin nhưng khác số lượng)
        //loai ten so luong gia tien
        SanPham a = new SanPham();
        a.setLoai(this.get(index).getLoai());
        a.setTen(this.get(index).getTen());
        a.setSoluong(sl);
        a.setGiaTien(this.get(index).getGiaTien());
        return a;
    }
    public SanPham createSP(int index){ // tạo clone (bản sao có cùng thông tin cùng sl khác số lượng)
        //loai ten so luong gia tien
        SanPham a = new SanPham();
        a.setLoai(this.get(index).getLoai());
        a.setTen(this.get(index).getTen());
        a.setSoluong(this.get(index).getSoluong());
        a.setGiaTien(this.get(index).getGiaTien());
        return a;
    }
    public void updateMa(){
        if(this.size()==0) SanPham.countMa=7680000;
        else{
            SanPham.countMa=Integer.parseInt(this.get(this.size()-1).getLoai())+1;
        }
    }
    public static void Menu_SanPham(){
        DSSanPham a = new DSSanPham();
        a.docdl();
        int option=0;
        do{
            System.out.println("QUẢN LÍ SẢN PHẨM");
            System.out.println("1.Xuất dánh sách sản phẩm");
            System.out.println("2.Thêm sản phẩm mới");
            String check =DSNhanVien.getQuyen(DSNhanVien.online);
            if(check.equals("boss")||check.equals("admin")){
                System.out.println("3.Xoá sản phẩm");
                System.out.println("4.Sửa giá");
                System.out.println("0.Thoát");
            }
            option=CongCu.getOption(CongCu.inp.nextLine());
            switch(option){
                case 1:{
                    a.xuat();
                    break;
                }
                case 2:{
                    a.nhap();
                    break;
                }
                case 3:{
                    if(check.equals("boss")||check.equals("admin")){
                        a.xoa();
                    }else{
                        System.out.println("Mời nhập lại cú pháp");
                    }
                    break;
                }
                case 4:{
                    if(check.equals("boss")||check.equals("admin")){
                        a.suaGia();
                    }else{
                        System.out.println("Mời nhập lại cú pháp");
                    }
                    break;
                }
                case 0:{
                    System.out.println("Thoát");
                    break;
                }
                default:{
                    System.out.println("Mời nhập lại cú pháp");
                    break;
                }
            }
        }while(option!=0);
        a.ghidl();
    }
    public void xuat(){
        System.out.println(String.format("%-10s%-20s%-5s%-10s%-20s","Loại","Tên SP","Số Lượng","Giá","Nhà Cung Cấp"));
        for(int i=0;i<this.size();i++){
            this.get(i).xuat();
        }
    }
    public void suaGia(){
        System.out.println("Nhập mã số sản phẩm cần sửa giá");
        String ma=CongCu.inp.nextLine();
        int index=this.timKiem(ma);
        if(index==-1){
            System.out.println("Không tìm thấy mã sản phẩm");
        }else{
            System.out.println("Nhập giá mới");
            int k=CongCu.getOption(CongCu.inp.nextLine());
            while(k==-1){
                System.out.println("Nhập lại giá tiền");
                k=CongCu.getOption(CongCu.inp.nextLine());

            }
            list[index].setGiaTien(k);
        }
        
    }
    public void xoa(){
        System.out.println("Nhập mã số sản phẩm cần xoá");
        String ma=CongCu.inp.nextLine();
        int index=this.timKiem(ma);
        if(index==-1){
            System.out.println("Không tìm thấy mã sp");
        }else{
            this.Remove(index);
            System.out.println("Sản phẩm đã được xoá");
        }
    }
    public void Remove(int index){
        for(int i=index;i<this.size()-1;i++){
            this.list[i]=this.list[i+1];
        }
        this.list=Arrays.copyOf(list,list.length-1);
    }
    public static void main(String[] args) {
        DSSanPham a = new DSSanPham();
        a.docdl();
        a.nhap();
        a.ghidl();
    }
    
}
