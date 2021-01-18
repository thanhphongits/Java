package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class DSNhanVien implements giaodien{
        protected ArrayList<NhanVien> list = new ArrayList<>(0);
        protected boolean read;
        protected static String online;
        Scanner inp= new Scanner(System.in);
        
        public void nhap(){//Nhập từ bàn phím|thêm
            int n;
            System.out.println("Số Lượng: ");
            n=CongCu.getOption(inp.nextLine());
            for(int i=0;i<n;i++){
                System.out.println("Nhập nhân viên "+(i+1));
                NhanVien a =new NhanVien();
                a.nhap();
                list.add(a);
            }
        }
        public void nhap(String S){ //nhập từ file
            String[] out = S.split("-");
                    NhanVien a= new NhanVien();
                    a.setMaNV(out[0]);
                    a.setTen(out[1]);
                    a.setGT(out[2]);
                    a.setNgaysinh(out[3]);
                    a.setCMND(out[4]);
                    a.setSDT(out[5]);
                    a.setEmail(out[6]);
                    a.setDiachi(out[7]);
                    a.setChucVu(out[8]);
                    a.setMatKhau(out[9]);
                    list.add(a);
                    CongCu.addnv(out[4],out[5]);
        }
        public void nhap1(){ //Nhập ông chủ
            NhanVien a = new NhanVien();
            a.nhap1();
            list.add(a);

        }
        public void xuat(){
            System.out.println("---------------------------------------------------------------DANH SÁCH NHÂN VIÊN--------------------------------------------------------------------------------");
            System.out.println(String.format("%-10s%-20s%-10s%-13s%-15s%-25s%-15s%-30s%-20s","MSNV","Họ tên","Giới tính","Ngày sinh","CMND","Địa chỉ","Số điện thoại","email","Chức vụ"));
            for(int i=0;i<list.size();i++){
                list.get(i).xuat();
            }
        }
        public void xuat(int i){
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("%-10s%-20s%-10s%-13s%-15s%-25s%-15s%-30s%-20s","MSNV","Họ tên","Giới tính","Ngày sinh","CMND","Địa chỉ","Số điện thoại","email","Chức vụ"));
                list.get(i).xuat();
        }
        public void swap(int i,int j){
                    NhanVien a;
                        a=list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, a);
        }
        public void sapxep(){
            for(int i=1;i<list.size()-1;i++){
                for(int j=i+1;j<list.size();j++){
                    if(Integer.parseInt(list.get(i).getMaNV())>Integer.parseInt(list.get(j).getMaNV())){
                        swap(i,j);
                    }
                }
            }
        }
        public int timkiem(String maNV){
            for(int i=0;i<list.size();i++)
            if(list.get(i).getMaNV().equals(maNV)) return i;
            return -1;
        }
        public int timkiemCMND(String CMND){
            for(int i=0;i<list.size();i++)
            if(list.get(i).getCMND().equals(CMND)) return i ;
            return -1;
        }
        public int timkiemSDT(String SDT){
            for(int i=0;i<list.size();i++)
            if(list.get(i).getSDT().equals(SDT)) return i;
            return -1;
        }
        public void timKiemTen(String Ten){
            System.out.println("---------------------------------------------------------------DANH SÁCH NHÂN VIÊN --------------------------------------------------------------------------------");
            System.out.println(String.format("%-10s%-20s%-10s%-13s%-15s%-25s%-15s%-30s%-20s","MSKH","Họ tên","Giới tính","Ngày sinh","CMND","Địa chỉ","Số điện thoại","email","Chức vụ"));
            for(int i=0;i<list.size();i++)
                if(list.get(i).getTen().indexOf(Ten) >= 0){
                    this.list.get(i).xuat();
                }
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
                        ten =CongCu.chuanHoaTen(ten);
                        if(ten.equals("")){
                            System.out.println("Không tìm thấy tên nhân viên\n");
                        }
                        else{
                            
                            this.timKiemTen(ten);
                        }
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
        public void docdl(){
            CongCu.newCSDLNhanVien();
            File text = new File("./CSDL/NhanVien.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(text);
            } catch (FileNotFoundException e) {
                try{
                    text.createNewFile();
                    
                }catch(IOException a){
                            
                }
                try{
                    scanner = new Scanner(text);
                }catch (FileNotFoundException x){
                    
                }
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.nhap(line);
            }
            read=true;
            if(this.getsize()!=0)
            this.updateMa();
        }
        public void ghidl(){
            if(read==false) {
                return;
            }
            File f = new File("./CSDL/NhanVien.txt");

            try(PrintWriter pw = new PrintWriter(f)){
                for(int i=0;i<list.size();i++)
                pw.println(list.get(i).toString());
            } catch(Exception e){
            };
            read = false;
        }
        public void xoa() {
            System.out.println("Nhập mã nhân viên cần xóa");
            String ma=CongCu.inp.nextLine();
            int i=this.timkiem(ma);
            if(i!=-1){
                System.out.println("Bạn tin tương vào sự lựa chọn của bản thân (Yes//No)????");
                if(CongCu.getYesNo()){
                    list.remove(i);
                    System.out.println("Tài khoản đã được xóa");
                }else{
                    System.out.println("Người này đã được ở lại công ty");
                }
            }
            else{
                System.out.println("Thanh niên này không tồn tại");
            }
        }
        public void xoanhanvien(){
            list.clear();
        }
        public void sua(){
            
            System.out.println("Nhập mã nhân viên cần sửa");
            String maNV=inp.nextLine();
            int index=this.timkiem(maNV);
            int option1;
            if(index!=-1)
            do{
                this.xuat(index);
                System.out.println("Chọn thông tin cần cập nhập");
                System.out.println("1.Tên");
                System.out.println("2.Giới tính");
                System.out.println("3.Ngày sinh");
                System.out.println("4.CMND");
                System.out.println("5.Địa chỉ");
                System.out.println("6.Số điện thoại");
                System.out.println("7.Email");
                if(online.equals("boss")){
                    System.out.println("8.Chức vụ");
                    System.out.println("9.Đặt lại mật khẩu");
                }
                System.out.println("0.Thoát");
                option1=Integer.parseInt(inp.nextLine());
                switch(option1){
                    case 0:{
                        break;
                    }
                    case 1:{
                        System.out.println("Nhập tên mới");
                        this.list.get(index).setTen(CongCu.inp.nextLine());
                        break;
                    }
                    case 2:{
                        System.out.println("Nhập giới tính mới");
                        this.list.get(index).setGT(CongCu.inp.nextLine());
                        break;
                    }
                    case 3:{
                        System.out.println("Nhập ngày sinh mới");
                        this.list.get(index).setNgaysinh(CongCu.inp.nextLine());
                        break;
                    }
                    case 4:{
                        System.out.println("Nhập số CMND mới");
                        this.list.get(index).setCMND(CongCu.inp.nextLine());
                        break;
                    }
                    case 5:{
                        System.out.println("Nhập địa chỉ mới");
                        this.list.get(index).setDiachi(CongCu.inp.nextLine());
                        break;
                    }
                    case 6:{
                        System.out.println("Nhập số điện thoại mới ");
                        this.list.get(index).setSDT(CongCu.inp.nextLine());
                        break;
                    }
                    case 7:{
                        System.out.println("Nhập email mới");
                        this.list.get(index).setEmail(CongCu.inp.nextLine());
                        break;
                    }
                    case 8:{
                        if(online.equals("boss")){
                            System.out.println("Nhập chức vụ mới");
                            this.list.get(index).setChucVu(CongCu.inp.nextLine());
                        }
                        else System.out.println("Bạn nhập sai rồi. Nhập lại nào.");
                        break;
                    }
                    case 9:{
                        if(online.equals("boss")){
                            this.list.get(index).setMatKhau("123456");
                            System.out.println("Đã đặt lại thành mặc định:'123456'");
                        }
                        else{
                            System.out.println("Bạn nhập sai rồi. Nhập lại nào.");
                        }
                        break;
                    }
                    default:{
                        System.out.println("Bạn nhập sai rồi. Nhập lại nào.");
                    }
                }
            }while(option1!=0);
            else {
                System.out.println("Không tìm thấy: " + maNV);
            }
        }
        public static  void suaThongTin(){//sửa thanh static
            DSNhanVien a= new DSNhanVien();
            a.docdl();
            int index=a.timkiem(online);
            int option;
            do{
                System.out.println("Sửa thông tin cá nhân");
                System.out.println("1.Email");
                System.out.println("2.Địa chỉ");
                System.out.println("3.Số điện thoại");
                System.out.println("4.Mật khẩu");
                System.out.println("0.Thoat");
                System.out.println("Nhập lựa chọn");
                option= Integer.parseInt(CongCu.inp.nextLine());
                 switch(option){
                    case 0:{
                        break;
                    }
                    case 1:{
                        System.out.println("Nhập email mới");
                        a.list.get(index).setEmail(CongCu.inp.nextLine());
                        break;
                    }
                    case 2:{
                        System.out.println("Nhập địa chỉ mới");
                        a.list.get(index).setDiachi(CongCu.inp.nextLine());
                        break;
                    }
                    case 3:{
                        System.out.println("Nhập số điện thoại mới ");
                        a.list.get(index).setSDT(CongCu.inp.nextLine());
                        break;
                    }
                    
                    case 4:{
                        a.doiPass(index);
                        break;
                    }
                    
                    default:{
                        System.out.println("Nhập sai nhập lại");
                    }
                }
            }while(option!=0);
        }
        
        public static void MenuBoss_Nhanvien() {
            int option;
            DSNhanVien a = new DSNhanVien();
            a.docdl();
            do{
                System.out.println("Quản lí nhân viên");
                System.out.println("1.Xuất danh sách");
                System.out.println("2.Cập nhập thông tin");
                System.out.println("3.Thêm nhân viên mới");
                System.out.println("4.Xóa nhân viên");
                System.out.println("5.Tìm kiếm nhân viên");
                System.out.println("0.Thoát");
                System.out.println("Nhập lựa chọn");
                option=CongCu.getOption(CongCu.inp.nextLine());
                switch(option){
                    case 1:{
                        if(a.list.size()==0){
                            System.out.println("Không có nhân viên");
                        }
                        else
                        a.xuat();
                        break;
                    }
                    case 2:{
                        a.sua();
                        break;
                    }
                    case 3:{
                        a.nhap();
                        a.sapxep();
                        break;
                    }
                    case 4:{
                        a.xoa();
                        break;
                    }
                    case 5:{
                        a.timKiem();
                        break;
                    }
                    case 0:{
                        break;
                    }
                    default:{
                        System.out.println("Nhập sai mời nhập lại");
                        break;
                    }
                }
            }while(option!=0);
            a.ghidl();
        }
        public void updateMa(){
            if(this.list.size()==1) NhanVien.coutma=311001;
            else
            NhanVien.coutma=Integer.parseInt(this.list.get(list.size()-1).getMaNV())+1;
               //list[soLuong-1].getMaNV();
        }
        public int getsize(){
            return list.size();
        }
        public static String getQuyen(int i){
            DSNhanVien a = new DSNhanVien();
            a.docdl();
            return a.list.get(i).getChucVu();
        }
        public static String getQuyen(String ma){
            DSNhanVien a = new DSNhanVien();
            a.docdl();
            int i= a.timkiem(ma);
            return a.list.get(i).getChucVu();
        }
        public void doiPass(int i){
           // DSNhanVien a = new DSNhanVien();
            //a.docdl();   
                System.out.println("Đổi mật khẩu");
                System.out.print("Nhập mật khẩu hiện tại");
                String mkHt=CongCu.inp.nextLine();
                int count=1;
                while(!this.getPassWord(i).equals(mkHt)&&count<5){
                    System.out.println("Sai mật khẩu");
                    mkHt=CongCu.inp.nextLine();
                    count++;
                }
                if(this.getPassWord(i).equals(mkHt)){
                    System.out.print("Nhập mật khẩu mới");
                    String mk1=CongCu.inp.nextLine();
                    System.out.print("Nhập lại mật khẩu mới");
                    String mk2= CongCu.inp.nextLine();
                    count=1;
                    while(!mk1.equals(mk2)&&count<5){
                        System.out.println("Không khớp");
                        System.out.print("Nhập mật khẩu mới");
                        mk1=CongCu.inp.nextLine();
                        System.out.print("Nhập lại mật khẩu mới");
                        mk2= CongCu.inp.nextLine();
                        count++;
                    }
                    if(mk1.equals(mk2)){
                        this.setPassWord(i, mk1);
                        System.out.println("Thành công");
                    }else{
                        System.out.println("Thất bại");
                    }

                }
        }
        
        public void setOnline(String s){
            DSNhanVien.online=s;
        }
        public String getOnline(){
            return online;
        }
        public String getPassWord(int i){
            return list.get(i).getMatKhau();
        }
        public void setPassWord(int i,String matKhau){
            list.get(i).setMatKhau(matKhau);
        }
        public static int Dangnhap() {
            DSNhanVien a = new DSNhanVien();
            a.docdl();
            boolean key;
            if(a.getsize()==0){
                System.out.println("Xin chào");
                System.out.println("Chào mừng bạn đến với chúng tôi");
                System.out.println("Chúng ta bắt đầu công việc nha");
                System.out.println("Mời nhập thông tin");
                a.nhap1();
                a.ghidl();
                System.out.println("Khởi động thành công. Bạn chính là trùm của họ. Tài khoản của bạn là boss");
                System.out.println("Mật khẩu mặc định là 123456");
                a.setOnline("boss");
            }
            do{
                System.out.print("Tài khoản:");
                String taiKhoan=CongCu.inp.nextLine();
                System.out.print("Mật khẩu:");
                String matKhau=CongCu.inp.nextLine();
                int i=a.timkiem(taiKhoan);
                if(i==-1){
                    System.out.println("Tài khoản cũng quên.Anh có tính làm việc nữa không??????(-_-) Đăng nhập lại");
                    key=true;
                }else{
                    String mk=a.list.get(i).getMatKhau();
                    int k=1;
                    while(!(mk.equals(matKhau))&&k<5){
                        System.out.println("Sai mật khẩu ");
                        System.out.print("Nhập lại mật khẩu");
                        matKhau=CongCu.inp.nextLine();
                        k++;
                    }
                    if(k==5&&!mk.equals(matKhau)){
                        System.out.println("Nhập sai quá nhiều");
                        key=true;
                    } //h muốn kết thúc chương trình
                    else{
                        System.out.println("Chào mừng bạn bắt đầu công việc!");
                        a.setOnline(taiKhoan);
                        return i;
                    }
                }

            }while(key);
            return -1;
        }
        public static void menuQuanLi_NhanVien(){
            DSNhanVien a = new DSNhanVien();
            a.docdl();
            int option;
            do{
                System.out.println("QUẢN LÍ NHÂN VIÊN");
                System.out.println("1.Xuất danh sách nhân viên");
                System.out.println("2.Sửa thông tin");
                System.out.println("3.Thêm nhân viên");
                System.out.println("4.Xóa nhân viên");
                System.out.println("5.Tìm kiếm nhân viên");
                System.out.println("0.Thoát");
                option=CongCu.getOption(CongCu.inp.nextLine());
                switch(option){
                    case 1:{
                        if(a.list.size()==0){
                            System.out.println("Không có nhân viên");
                        }
                        else
                        a.xuat();
                        break;
                    }
                    case 2:{
                        a.sua();
                        break;
                    }
                    case 3:{
                        a.nhap();
                        a.sapxep();
                        break;
                    }
                    case 4:{
                        a.xoa();
                        break;
                    }
                    case 5:{
                        a.timKiem();
                        break;
                    }
                    case 0:{
                        break;
                    }
                    default:{
                        System.out.println("Nhập sai mời nhập lại");
                        break;
                    }
                    
                }

            }while(option!=0);
            a.ghidl();
        }
        public void sapxeptheoTen(){
            //DSNhanVien a = this.clone();
        }
}