package Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public abstract class HoaDon {
    protected String msdh;
    public DSSanPham listSanPham= new DSSanPham();
    protected int soLoaiSanPham;
    protected Date ngayLapHD;
    protected long tongTien;
    Scanner tmp = new Scanner(System.in);

    public HoaDon() {
        tongTien=0;
    }
    public String getMsdh() {
        return msdh;
    }

    public void setMsdh(String msdh) {
        this.msdh = msdh;
    }

    public int getSoLoaiSanPham() {
        return soLoaiSanPham;
    }

    public void setSoLoaiSanPham(int soLoaiSanPham) {
        this.soLoaiSanPham = soLoaiSanPham;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(String ngayLapHD) {
        try {
            this.ngayLapHD = new SimpleDateFormat("dd/MM/yyyy").parse(ngayLapHD);
        } catch (ParseException e) {
            System.out.println("---------------");
            this.setNgayLapHD(tmp.nextLine());
        }
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }
    
    public String toStringNgay(){
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormat = formatter.format(ngayLapHD);
        return dateFormat;
    }
    public DSSanPham getlist(){
        return this.listSanPham;
    }
}