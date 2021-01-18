package Data;
import java.util.Date;

public class NhanVien extends Nguoi{
    protected String maNV;
    protected String chucVu;
    protected String matKhau;
    protected static int coutma;
    public String toString(){
        return maNV+"-"+ten+"-"+GT+"-"+this.toBString()+"-"+CMND+"-"+SDT+"-"+email+"-"+diachi+"-"+chucVu+"-"+matKhau;
    }

    public NhanVien(String name, Date birthday, String sDT, String iD, String email, String address, String gT,
        String maNV, float luong, String chucVu) {
        
        //super(name, birthday, sDT, iD, email, address, gT);
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.matKhau="123456";
    }

    public NhanVien(String maNV, float luong, String chucVu) {
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.matKhau="123456";
    }
    
    public NhanVien() {
        this.matKhau="123456";
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(int coutma2) {
        this.maNV = String.format("%d", coutma2);
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        if(chucVu.equals("admin")||chucVu.equals("nhanvien")||chucVu.equals("boss"))
            this.chucVu = chucVu;
        else{
            System.out.println("Nhập lại đi em");
            setChucVu(CongCu.inp.nextLine());
        }
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String toStringChucVu(){
        if(this.chucVu.equals("admin")) return "Quản lí";
        if(this.chucVu.equals("nhanvien")) return "Nhân viên";
        if(this.chucVu.equals("boss")) return "Sếp";
        return "";
    }
    public void setMaNV(String string) {
    this.maNV=string;
	}
    //@Override
    public void setCMND(String CMND) {
        if(CongCu.checkCMND(CMND)){
            if(CongCu.timKiemCMNDNV(CMND)!=-1){
                System.out.println("Mời nhập lại CMND");
                setCMND(inp.nextLine());
            }else
            this.CMND=CMND;
        }else{
            this.setCMND(inp.nextLine());
        }
    }
    public void setSDT(String sDT) {
        if(CongCu.checkSDT(sDT)){
            if(CongCu.timKiemSDTNV(sDT)!=-1){
                System.out.println("Mời nhập lại SDT");
                setSDT(inp.nextLine());
            }else
            this.SDT=sDT;
        }else{
            this.setSDT(inp.nextLine());
        }
        
    }
    
    public void xuat(){                 
         System.out.println(String.format("%-10s%-20s%-10s%-13s%-15s%-25s%-15s%-30s%-20s",this.maNV,this.ten,this.GT,this.toBString(),this.CMND,this.diachi,this.SDT,this.email,this.toStringChucVu()));
    }
    public void nhap1(){
        System.out.println("Xin mời nhập");
        this.setMaNV("boss");
        System.out.print("\nTên là: "); this.setTen(CongCu.inp.nextLine());
        System.out.print("\n Giới tính: ");this.setGT(CongCu.inp.nextLine());
        System.out.print("\n Ngày sinh (dd/mm/yyyy): ");
        this.setNgaysinh(CongCu.inp.nextLine());
        System.out.print("\n Số điện thoại: ");  this.setSDT(CongCu.inp.nextLine());
        System.out.print("\nCMND: "); this.setCMND(CongCu.inp.nextLine());
        System.out.print("\nEmail: ");this.setEmail(CongCu.inp.nextLine());
        System.out.print("\n Địa chỉ: ");this.setDiachi(CongCu.inp.nextLine());
        this.setChucVu("boss");

    }
    public void nhap(){
        this.setMaNV(NhanVien.coutma++);
        System.out.print("\nTen NV: ");
        this.setTen(CongCu.inp.nextLine());
        System.out.print("\nGioi tinh: ");
        this.setGT(CongCu.inp.nextLine());;
        System.out.print("\nNgay Sinh (dd/mm/yyyy): ");
        this.setNgaysinh(CongCu.inp.nextLine());
        System.out.print("\nSo dien thoai: "); 
        this.setSDT(CongCu.inp.nextLine());
        System.out.print("\nCMND: "); 
        this.setCMND(CongCu.inp.nextLine());
        System.out.print("\nEmail: ");
        this.setEmail(CongCu.inp.nextLine());
        System.out.print("\nDia chi: ");
        this.setDiachi(CongCu.inp.nextLine());
        this.setChucVu("nhanvien");
        CongCu.addnv(CMND, SDT);
    }
    public NhanVien clone(){
        NhanVien a = new NhanVien();
        a.setMaNV(this.getMaNV());
        a.setTen(this.getTen());
        a.setGT(this.getGT());
        a.setNgaysinh(this.toBString());
        a.setSDT(this.getSDT());
        a.setCMND(this.getCMND());
        a.setEmail(this.getEmail());
        a.setDiachi(this.getDiachi());
        a.setChucVu(this.chucVu);
        return a;
    }
}
    