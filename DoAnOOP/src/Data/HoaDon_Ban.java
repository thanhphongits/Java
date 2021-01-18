package Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HoaDon_Ban extends HoaDon{
    private String khachHang;
    private static String noiBan  = "Cửa hàng App Store";
    private String nv =DSNhanVien.online;
    protected static int countma;
    protected int giamGia;
    protected int sl;
    public HoaDon_Ban() {
            //super();
            //noiBan = "";
    }
    
    public HoaDon_Ban(String namesp, String mssp, String msdh, String sluong, String nguoiban) {
            super();
            //this.khachHang=khachHang ;

    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }
    
    public String getKhachHang() {
            return khachHang;
    }
    
    public void setKhachHang(String KhachHang) {
            this.khachHang = KhachHang;
    }
    
    public static String getNoiBan() {
            return noiBan;
    }
    
    public static void setNoiBan(String noiBan) {
            HoaDon_Ban.noiBan = noiBan;
    }
        
    public void nhapBill(){
        DSSanPham sp = new DSSanPham();
        DSKhachHang kh = new DSKhachHang();
        kh.docdl();
        sp.docdl();
        String ktra;
        sl=0;
        System.out.println("Nhập số điện thoại");
        ktra=CongCu.inp.nextLine();
        while(!CongCu.checkSDT(ktra)){
              System.out.println("Nhập lại số điện thoại");  
              ktra = CongCu.inp.nextLine();
        }
        
        int k=kh.timkiemSDT(ktra);
        if(k==-1){
            System.out.println("Bạn có muốn đăng ký thành viên ");
            if(CongCu.getYesNo()){
                kh.nhap1();
                khachHang=kh.list.get(kh.list.size()-1).getMaKH();
                k=kh.list.size()-1;
            }else{
                k=-1;
                khachHang="Guest";
            }
        }
        else{
            khachHang=kh.list.get(k).getMaKH();
        }
        
        int option;
        int i=0;
        this.msdh=String.format("%d",countma++);
        do{
            System.out.println("Nhập mã loại sản phẩm (nhập 0 để thoát)");
            String loaiHang=tmp.nextLine();
            if(loaiHang.equals("0")){
                option =0;
            }else{
                int x = sp.timKiem(loaiHang);
                int sl1=0;
                if(x == -1){
                    System.out.println("Không tồn tại mã loại");
                }else{
                    System.out.println("Nhập số lượng");
                    sl1=CongCu.getOption(CongCu.inp.nextLine());
                    while(!sp.isAvailable(x, sl1)){
                        System.out.println("Quá số lượng trong kho");
                        System.out.println("Mời nhập lại số lượng bé hơn");
                        sl1=Integer.parseInt(tmp.nextLine());
                    }
                    sp.updateSell(x, sl1);
                    listSanPham.add(sp.createSP(x, sl1));
                    tongTien+=listSanPham.list[i].getGiaTien()*listSanPham.list[i].soluong;
                    i++;
                }
                option=1;
            }
        }while(option!=0);
        sl=i;
        if(k!=-1){
            if(kh.list.get(k).tichluy>0){
                System.out.println("Bạn có muốn dùng điểm tích luỹ k");
                if(CongCu.getYesNo()){
                    System.out.println("Điểm hiện tại: "+kh.list.get(k).tichluy);
                    System.out.println("Bạn muốn dùng bao nhiêu điêm");
                    int diem=Integer.parseInt(CongCu.inp.nextLine());
                    if(diem<kh.list.get(k).tichluy){
                        System.out.println();
                        giamGia=diem*1000;
                        kh.list.get(k).tichluy-=diem;
                    }else{
                        System.out.println("Thoát");
                    }
                }
            }
            kh.list.get(k).tichluy+=(tongTien-giamGia)*3/100000;
        }
        kh.ghidl();
        ngayLapHD= new Date(); //cái này là lấy ngày hiện tại
        sp.ghidl();
        this.xuat();
    }
    public void xuat(){
        System.out.println(String.format("Mã hoá đơn:%-25s", this.msdh));
        System.out.println("Khách hàng: "+String.format("%-20s",this.khachHang)+"Nhân Viên: "+nv);
        listSanPham.xuatHD();
        System.out.println("Tổng: "+String.format("%40d", tongTien));
        System.out.println("Giảm: "+giamGia);
        int thanhtoan=0;
        if(giamGia>tongTien) thanhtoan=0;
        else{
            thanhtoan=(int)tongTien-giamGia;
        }
        System.out.println("Thanh Toán: "+thanhtoan);
        System.out.println(noiBan);
    }
    
    public void xuat1(){//thong tin cơ bản của hoá đơn
        //Mã hd - ngay lap hoa don - nhan vien  - khach ahngf-Tong Tien - so luong
        System.out.println(String.format("%-10s%-15s%-15s%-15s%-15s%-15s%-15s",this.getMsdh(),this.toStringNgay(),this.getNv(),this.getKhachHang(),this.getGiamGia(),this.getTongTien(),this.getSl()));
    }
    public String toString(){
       // Ma + NgayLap + NhanVien + KhachHang+giamGia +Tong Tien+ MangSanPham
       return msdh + "-" + toStringNgay() + "-" + nv + "-" + khachHang+"-"+giamGia+"-"+tongTien + "-" + listSanPham.size();
    }

    public String getNv() {
        return nv;
    }

    public void setNv(String nv) {
        this.nv = nv;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    public static void main(String[] args) throws ParseException {
        HoaDon_Ban a = new HoaDon_Ban();
        a.nhapBill();
        a.xuat();
    }
}