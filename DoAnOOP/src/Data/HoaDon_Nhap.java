package Data;
import java.util.Date;
import java.util.Scanner;
public class HoaDon_Nhap extends HoaDon {
    private static String nguoimua = "Cửa hàng Apple";
    private String nvNhapHang =DSNhanVien.online;
    private String nhaCungCap="Apple Inc.";
    protected int sl;
    public static int countma;
    public HoaDon_Nhap() {
            super();
            nhaCungCap = "";
    }
    public HoaDon_Nhap(String namesp, String mssp, String msdh, int sluong, String nhaCungCap) {
            super();
            this.nhaCungCap = nhaCungCap;

    }

    public static String getNguoimua() {
            return nguoimua;
    }
    public static void setNguoimua(String nguoimua) {
            HoaDon_Nhap.nguoimua = nguoimua;
    }

    public String getNguoiban() {
            return nhaCungCap;
    }
    public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
    public void nhapBill(){
        DSSanPham sp = new DSSanPham();
        sp.docdl();
        this.msdh=String.format("%d",countma);
        int option;
        int i=0;
        do{
            System.out.println("Nhập mã loại sản phẩm (nhập 0 để thoát)");
            String loaiHang=tmp.nextLine();
            if(loaiHang.equals("0")){
                option =0;
            }else{
                int x = sp.timKiem(loaiHang);
                if(x == -1){
                    System.out.println("Không tồn tại mã loại");
                    System.out.println("Có muốn nhập loại hàng mới");
                    if(CongCu.getYesNo()){
                        SanPham a= new SanPham();
                        a.nhap();
                        sp.add(a);
                    }
                }else{
                    System.out.println("Nhập số lượng");
                    int sl=Integer.parseInt(tmp.nextLine());
                    while(sl<=0){
                        System.out.println("Mời nhập lại số lượng( lớn hơn 0):");
                        sl=Integer.parseInt(tmp.nextLine());
                    }
                    sp.updatebuy(x, sl);
                    listSanPham.add(sp.createSP(x, sl));
                    tongTien+=listSanPham.list[i].getGiaTien()*listSanPham.list[i].soluong;
                    i++;
                }
                option=1;
            }
        }while(option!=0);
        ngayLapHD= new Date(); 
        sl=i;
        sp.ghidl();
    }

    public String getNvNhapHang() {
        return nvNhapHang;
    }

    public void setNvNhapHang(String nvNhapHang) {
        this.nvNhapHang = nvNhapHang;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    public void xuat(){
        System.out.println("Khách hàng: "+this.nhaCungCap+"Nhân Viên: "+nvNhapHang);
        listSanPham.xuatHD();
        System.out.println("Tổng: "+String.format("%40d", tongTien));
    }
    
    public String toString(){
       // Ma + NgayLap + NhanV + MangSanPham
       return msdh + "-" + toStringNgay() + "-" +tongTien+"-"+ nvNhapHang+"-" + listSanPham.size();
    }
    public void xuat1(){
        System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s",this.getMsdh(),this.toStringNgay(),this.getTongTien(),this.getNvNhapHang(),this.listSanPham.size()));
    }
}
