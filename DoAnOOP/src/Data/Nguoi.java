package Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public abstract class Nguoi {
    Scanner inp= new Scanner(System.in);
    protected String ten;
    protected Date ngaysinh;
    protected String SDT;
    protected String CMND;
    protected String email;
    protected String diachi;
    protected String GT;
    
    public Nguoi(String ten, Date ngaysinh, String CMND, String email, String diachi, String GT) {
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.CMND = CMND;
        this.email = email;
        this.diachi = diachi;
        this.GT = GT;
    }
    public Nguoi() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        if(CongCu.checkName(ten)){
            if(ten.length()<5){
                System.out.println("Tên quá ngắn. Mời nhập lại");
                this.setTen(inp.nextLine());
            }else
            this.ten=CongCu.chuanHoaTen(ten);
        }else{
            System.out.println("Có cái tên cũng không nên thân mần ăn được chi. Nhập lại đi chú em");
            this.setTen(inp.nextLine());
        }
    }
    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String S) {
        try {
            this.ngaysinh = new SimpleDateFormat("dd/MM/yyyy").parse(S);
        } catch (ParseException e) {
            System.out.println("Nhập sai kiểu định dạng(dd/MM/yyyy). Mời nhập lại");
            this.setNgaysinh(inp.nextLine());
        }
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        if(CongCu.checkCMND(CMND)){
            this.CMND=CMND;
        }else{
            this.setCMND(inp.nextLine());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        boolean a=false;
        for(int i=1;i<email.length()-3;i++){
            if(email.charAt(i)=='@'){
                a=true;
            }
        }
        if(a==false){
            System.out.println("Email sai.Nhập lại");
            this.setEmail(inp.nextLine());
        }else{
            this.email=email;
        }
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String gT) {
        if(CongCu.isGT(gT)){
            this.GT=gT;
        }else{
            System.out.println("Nhập sai giới tính mời nhập lại (NAM||NU||KHAC)");
            this.setGT(inp.nextLine());
        }
    }
    public String toBString(){  //chuyển ngày sang String
        if (this.ngaysinh == null) {
            return " ";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.ngaysinh);
    }
    public String getSDT() {
        return SDT;
    }
    public int getTuoi(){
        Date a = new Date();
        String hientai= CongCu.toBString(a);
        String[] out1 = hientai.split("/");
        String[] out2 = toBString().split("/");
        int tuoi=Integer.parseInt(out1[2]) - Integer.parseInt(out2[2]);
        if(Integer.parseInt(out1[1]) > Integer.parseInt(out2[1])){
            tuoi--;
        }else{
            if(Integer.parseInt(out1[0]) > Integer.parseInt(out2[0])){
                tuoi--;
            }
        }
        return tuoi;
    }
    public void setSDT(String sDT) {
        if(CongCu.isSDT(sDT)){
            this.SDT=sDT;
        }else{
            this.setSDT(inp.nextLine());
        }
    }
   
}