package Chap0;

import java.util.Scanner;

public class Bai9 {
    private String chuoi;
    Scanner so=new Scanner(System.in);

    public String getChuoi() {
        return chuoi;
    }

    public void setChuoi(String chuoi) {
        this.chuoi = chuoi;
    }

    public Bai9(String chuoi) {
        this.chuoi = chuoi;
    }
    public Bai9()
    {
    }
    public void NhapChuoi()
    {
        System.out.println("Hãy nhập chuỗi bạn muốn : ");
        chuoi= so.nextLine().trim();
    }
    public int getDoDai()
    {
        return chuoi.length();
    }
    public void XoaKhoangTrang()
    {
        while(chuoi.contains("  "))
        {
             chuoi=chuoi.replaceAll("  "," ");
        }
        System.out.println(chuoi.substring(0));
    }
    public void XuatChuoi() //xin chao
    {
        int i;
        char kyTu;
       for(i = 0 ; i < chuoi.length(); i++)
       {
           kyTu=chuoi.charAt(i);
           if(Character.isSpace(kyTu))
           {
               System.out.println();
           }
           else
           {
               System.out.print(kyTu);
           }
       }
        System.out.println("\n");
    }
    
    public void XuatKyTuTraiPhai()
    {
        int k;
        System.out.println("Mời nhập số : ");
        k=Tool.CheckInt();
        if(k> chuoi.length()/2)
        {
            System.out.println("Những kí tự bên trái của chuỗi là : " + chuoi.substring(0,chuoi.length()/2) );
            System.out.println("Những kí tự bên phải của chuỗi là : " + chuoi.substring(chuoi.length()/2, chuoi.length()) );
        }
        else
        {
            System.out.println("Những kí tự bên trái của chuỗi là : " + chuoi.substring(0,k) );
            System.out.println("Những kí tự bên phải của chuỗi là : " + chuoi.substring(chuoi.length()-k,chuoi.length()) );
        }
    }
    
    public void XuatNKyTu()
    {
        int k;
        int n;
        System.out.println("Mời nhập vị trí : ");
        k=Tool.CheckInt();
        System.out.println("Mời nhập số ký tự muốn xuất : ");
        n=Tool.CheckInt();
        if(n> chuoi.length()-k)
        {
            System.out.println("Những kí tự cần xuất là : " + chuoi.substring(k, chuoi.length()));
        }
        else
        {
            System.out.println("Những kí tự cần xuất là : " + chuoi.substring(k,k+n));
        }
    }
    public static void Menu()
   {
       Bai1.Hello();
       Bai9 a = new Bai9();
       a.NhapChuoi();
       String option;
        do
        {
            Scanner menu=new Scanner(System.in);
            System.out.println("======================================================================================================================================================================================================================================================================================");
            System.out.println("                                                                                    BÀI 9 ");
            System.out.println("======================================================================================================================================================================================================================================================================================");
            System.out.println("1.Xuất Độ dài của mảng ");
            System.out.println("2.Xóa khoảng trắng thừa của chuỗi ");
            System.out.println("3.Đếm số từ của chuỗi và xuất mỗi từ nằm trên 1 dòng ");
            System.out.println("4.Nhập số tự nhiên k, xuất k ký tự bên trái và bên phải của chuỗi ");
            System.out.println("5.Nhập số tự nhiên k,n xuất n ký tự từ vị trí k ");
            System.out.println("0.Thoát");
            System.out.println("Hãy nhập lựa chọn của bạn : ");
            option=menu.nextLine();
            while (!option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5"))
            {
                System.err.println("BẠN ĐÃ NHẬP SAI VUI LÒNG CHỌN TỪ 0 -> 5");
                System.err.printf("MỜI NHẬP LẠI : ");
                option = menu.nextLine().trim();
            }
            switch(option)
            {
                case "1":
                {
                    System.out.println("Độ dài của mảng là : " + a.getDoDai());
                    break;
                }
                case "2":
                {
                    a.XoaKhoangTrang();
                    break;
                }
                case "3":
                {
                    a.XuatChuoi();
                    break;
                }
                case "4":
                {
                    a.XuatKyTuTraiPhai();
                    break;
                }
                case "5":
                {
                    a.XuatNKyTu();
                    break;
                }
                case "0":
                {
                    break;
                }
            }          
        }while(!option.equals("0"));
        System.out.println("Thoát thành công");
    }
    public static void main(String[] args) {
        Bai9.Menu();
    }
}
