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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class DSKhachHang implements giaodien {
    protected ArrayList<KhachHang> list = new ArrayList<>();
    protected boolean isread;
    public int getSize(){
        return list.size();
    }
     public int timkiem(String maKH){
        for(int i=0;i<list.size();i++)
        if(list.get(i).getMaKH().equals(maKH)) return i;
        return -1;
    }
    public int timkiemCMND(String CMND){
        for(int i=0;i<list.size();i++)
        if(list.get(i).getCMND().equals(CMND)) return i;
        return -1;
    }
    public int timkiemSDT(String SDT){
        for(int i=0;i<list.size();i++)
        if(list.get(i).getSDT().equals(SDT)) return i;
        return -1;
    }
    public void timKiemTen(String Ten){
        System.out.println("---------------------------------------------------------------DANH SÁCH KHÁCH HÀNG--------------------------------------------------------------------------------");
        System.out.println(String.format("%-10s%-20s%-10s%-13s%-15s%-25s%-15s%-30s%-20s","MSKH","Họ tên","Giới tính","Ngày sinh","CMND","Địa chỉ","Số điện thoại","email","Tích lũy"));
        for(int i=0;i<list.size();i++)
            if(list.get(i).getTen().indexOf(Ten) > 0){
                this.list.get(i).xuat();
            }
    }
    public int updateTL1(int tichLuy, int x){
        return (tichLuy-x);
    }
    public int updateTL2(int tichLuy, int x){
        return (tichLuy+x);
    }
    public void nhap(){
            int n;
            System.out.println("Số Lượng: ");
            n=CongCu.getOption(CongCu.inp.nextLine());
            for(int i=0;i<n;i++){
                System.out.println("Nhập khách hàng "+(i+1));
                KhachHang a =new KhachHang();
                a.nhap();
                list.add(a);
            }
        }
    public void docdl(){
            CongCu.newCSDLKhangHang();
            File text = new File("./CSDL/KhachHang.txt");
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
            this.updateMa();
            isread=true;        
    }
    public void suaThongTin(){            
            System.out.println("Nhập mã khách hàng cần sửa");
            String maKh=CongCu.inp.nextLine();
            int index=this.timkiem(maKh);
            String option1;
            if(index!=-1)
            do{
                this.xuat(index);
                System.out.println("Chọn thông tin cần sửa");
                System.out.println("1.Địa chỉ");
                System.out.println("2.Số điện thoại");
                System.out.println("3.Email");
                System.out.println("0.Thoát");
                option1=CongCu.inp.nextLine();
                switch(option1){
                    case "1":{
                        this.xuat(index);
                        break;
                    }
                    case "2":{
                        System.out.println("Nhập địa chỉ mới");
                        this.list.get(index).setDiachi(CongCu.inp.nextLine());
                        break;
                    }
                    case "3":{
                        System.out.println("Nhập số điện thoại mới ");
                        this.list.get(index).setSDT(CongCu.inp.nextLine());
                        break;
                    }
                    case "4":{
                        System.out.println("Nhập email mới");
                        this.list.get(index).setEmail(CongCu.inp.nextLine());
                        break;
                    }
                    case "0":{
                        break;
                    }
                    default:{
                        System.out.println("Nhập sai nhập lại");
                    }
                }
            }while(option1!="0");
            else {
                System.out.println("Không tìm thấy: " + maKh);
            }
    }
    public static void MenuKhachHang(){
        DSKhachHang a = new DSKhachHang();
        a.docdl();
        int option;
        do{
            System.out.println("QUẢN LÍ KHÁCH HÀNG");
            System.out.println("1.Xuất danh sách khách hàng");
            System.out.println("2.Thêm khách hàng mới");
            System.out.println("3.Chỉnh sửa thông tin khách hàng");
            System.out.println("4.Tìm kiếm ");
            System.out.println("0.Thoát");
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
                    a.suaThongTin();
                    break;
                }
                case 4:{
                    a.timKiem();
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    
                    break;
                }
            }
        }while(option!=0);
        a.ghidl();
 
    }
    public void nhap(String S){
        //return maKH+"-"+ten+"-"+GT+"-"+this.toBString()+"-"+CMND+"-"+SDT+"-"+email+"-"+diachi+"-"+tichluy;
        String[] out = S.split("-");
        KhachHang a = new KhachHang();
        a.setMaKH(out[0]);
        a.setTen(out[1]);
        a.setGT(out[2]);
        a.setNgaysinh(out[3]);
        a.setCMND(out[4]);
        a.setSDT(out[5]);
        a.setEmail(out[6]);
        a.setDiachi(out[7]);
        a.setTichluy(out[8]);
        list.add(a);
        CongCu.addkh(out[4], out[5]);
    }
    public void ghidl(){
        if(isread==false) {
                return;
        }
        File f = new File("./CSDL/KhachHang.txt");

        try(PrintWriter pw = new PrintWriter(f)){
                for(int i=0;i<list.size();i++)
                pw.println(list.get(i).toString());
        } catch(Exception e){
        }
            isread = false;
    }
    public void nhap1(){
            KhachHang a = new KhachHang();
            a.nhap();
            list.add(a);

        }
    public void xuat(){
            System.out.println("---------------------------------------------------------------DANH SÁCH KHÁCH HÀNG--------------------------------------------------------------------------------");
            System.out.println(String.format("%-10s%-20s%-10s%-13s%-15s%-25s%-15s%-30s%-20s","MSKH","Họ tên","Giới tính","Ngày sinh","CMND","Địa chỉ","Số điện thoại","email","Tích lũy"));
            for(int i=0;i<list.size();i++){
                list.get(i).xuat();
            }
        }
    public void xuat(int i){
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("%-10s%-20s%-10s%-13s%-15s%-25s%-15s%-30s%-20s","MSNV","Họ tên","Giới tính","Ngày sinh","CMND","Địa chỉ","Số điện thoại","email","Tích lũy"));
                list.get(i).xuat();
    }
    public void updateMa(){
        if(this.list.size()==0) KhachHang.coutma=311001;
        else
        KhachHang.coutma=Integer.parseInt(this.list.get(list.size()-1).getMaKH())+1;
        //list[soLuong-1].getMaNV();
    }
    public void timKiem(){
        int option;
        do{
            System.out.println("Lựa chọn kiểu tìm kiếm");
            System.out.println("1. Theo mã");
            System.out.println("2. Theo CMND");
            System.out.println("3. Theo SĐT");
            System.out.println("4. Theo tên");
            System.out.println("0. Thoát");
            option = CongCu.getOption(CongCu.inp.nextLine());
            switch(option){
                    case 1:{
                        System.out.println("Nhập mã cần tìm");
                        String ma = CongCu.inp.nextLine();
                        int index = this.timkiem(ma);
                        if(index!=-1){
                            this.xuat(index);
                        }else{
                            System.out.println("Không tìm thấy mã");
                        }
                        break;
                    }
                    case 2:{
                        System.out.println("Nhập CMND cần tìm");
                        String cmnd = CongCu.inp.nextLine();
                        int index = this.timkiemCMND(cmnd);
                        if(index!=-1){
                            this.xuat(index);
                        }else{
                            System.out.println("Không tìm thấy nhân viên");
                        }
                        break;
                    }
                    case 3:{
                        System.out.println("Nhập SDT cần tìm");
                        String sdt = CongCu.inp.nextLine();
                        int index = this.timkiemSDT(sdt);
                        if(index!=-1){
                            this.xuat(index);
                        }else{
                            System.out.println("Không tìm thấy nhân viên");
                        }
                        break;
                    }
                    case 4:{
                        System.out.println("Nhập tên cần tìm");
                        String ten = CongCu.inp.nextLine();
                        ten = CongCu.chuanHoaTen(ten);
                        this.timKiemTen(ten);
                        break;
                    }
                    case 0:{
                        break;
                    }
                    
                    default:{
                        System.out.println("Nhập lại lựa chọn");
                        break;
                    }
                
            }
        }while(option != 0);
        
    }
    public static void Menu(){
        
    }
    public static void main(String[] args) {
        DSKhachHang a = new DSKhachHang();
        a.docdl();
        a.nhap();
        a.ghidl();
    }
}
