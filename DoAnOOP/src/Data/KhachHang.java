package Data;
import java.util.Scanner;
public class KhachHang extends Nguoi {
    private String maKH;
    protected static int coutma;
    protected int tichluy;
    public void setCMND(String CMND) {
        DSKhachHang a =new DSKhachHang();
      
        if(CongCu.checkCMND(CMND)&&a.timkiemCMND(CMND)==-1){
            this.CMND=CMND;
        }else{
            if(!CongCu.checkCMND(CMND)){
                System.out.println("Nhập sai định dạng mời nhập lại!");
            }
            else{
                System.out.println("CMND đã tồn tại. Tính ăn cắp danh tính ak");
            }
            this.setCMND(inp.nextLine());
        }
    }
    public void setSDT(String sDT) {
        DSKhachHang a =new DSKhachHang();
        
        if(CongCu.isSDT(sDT)&&a.timkiemSDT(sDT)==-1){
            this.SDT=sDT;
        }else{
            if(!CongCu.isSDT(sDT))
                System.out.println("Nhập sai định dạng. Mời nhập lại");
            else {
                System.out.println("SDT đã tồn tại. Tính ăn cắp danh tính ak");
            }
            this.setSDT(inp.nextLine());
        }
    }
    
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(int coutma2) {
        this.maKH = String.format("%d", coutma2);
    }
    public void setMaKH(String S) {
        this.maKH = S;
    }

    public int getTichluy() {
        return tichluy;
    }
    public void setTichluy(int tichluy) {
        this.tichluy = tichluy;
    }
    public void setTichluy(String a) {
        this.tichluy = Integer.parseInt(a);
    }
    public KhachHang() {            
        super();
        maKH = "";
        tichluy=0;
	}
    public KhachHang(String ten, String GT, String ngaysinh, String diachi, String mail, String SDT, String maKH, int tichluy) {
        super();
	this.maKH = maKH;
        this.tichluy=tichluy;
	}
	
    public String toString(){
        return maKH+"-"+ten+"-"+GT+"-"+this.toBString()+"-"+CMND+"-"+SDT+"-"+email+"-"+diachi+"-"+tichluy;
    }
    public void nhap() {
        System.out.println("Moi nhap:");
        this.setMaKH(KhachHang.coutma++);
        System.out.print("\nTen Khách hàng: ");
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
        CongCu.addkh(this.getCMND(), this.getSDT());
    }
       
    /*public void setSDT(String sDT) {
       if(CongCu.checkSDT(sDT)){
            if(CongCu.timKiemSDTKH(sDT)!=-1){
                System.out.println("SDT đã tồn tại.Mời nhập lại SDT");
                setSDT(inp.nextLine());
            }else
            this.SDT=sDT;
        }else{
            this.setSDT(inp.nextLine());
        }
    }
    public void setCMND(String CMND) {
        if(CongCu.checkCMND(CMND)){
            if(CongCu.timKiemCMNDKH(CMND)!=-1){
                System.out.println("Mời nhập lại CMND");
                setCMND(inp.nextLine());
            }else
            this.CMND=CMND;
        }else{
            this.setCMND(inp.nextLine());
        
        }
    }*/
    public void xuat(){                
        System.out.println(String.format("%-10s%-20s%-10s%-13s%-15s%-25s%-15s%-30s%-20s",this.maKH,this.ten,this.GT,this.toBString(),this.CMND,this.diachi,this.SDT,this.email,this.tichluy));
    }
    public static void main(String[] args) {
        KhachHang a = new KhachHang();
        a.nhap();
    }
}
