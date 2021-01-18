package Data;

public class Main {
	public static void main(String[] args) {
            int k=DSNhanVien.Dangnhap();
            String quyen =DSNhanVien.getQuyen(k);
            if(quyen.equals("boss")){
                int option;
                do{
                    System.out.println("Menu Tổng quát");
                    System.out.println("1.Quản lí nhân viên");
                    System.out.println("2.Quản lí khách hàng");
                    System.out.println("3.Quản lí sản phẩm");
                    System.out.println("4.Quản lí hoá đơn bán");
                    System.out.println("5.Quản lí hoá đơn nhập");
                    System.out.println("9.Sửa thông tin");
                    System.out.println("0.Thoát");
                    option=CongCu.getOption(CongCu.inp.nextLine());
                    switch(option){
                        case 1:{
                            DSNhanVien.MenuBoss_Nhanvien();
                            break;
                        }
                        case 2:{
                            DSKhachHang.MenuKhachHang();
                            break;
                        }
                        case 3:{
                            DSSanPham.Menu_SanPham();
                            break;
                        }
                        case 4:{
                            DSHoaDon_Ban.Menu();
                            break;
                        }
                        case 5:{
                            DSHoaDon_Nhap.Menu();
                            break;
                        }
                        case 9:{
                            DSNhanVien.suaThongTin(); // Đổi mật khẩu Boss cơ mà
                            break;
                        }
                        case 0:{
                            System.out.println("Thoát");
                            break;
                        }
                        default:{
                            System.out.println("Nhập sai rồi");
                            System.out.println("có quy định rồi k theo tính biểu tình à");
                            //option=CongCu.getOption(CongCu.inp.nextLine());
                            break;
                        }
                    }
                }while(option!=0);
            }
            else{
                if(quyen.equals("admin")){
                    int option;
                    do{
                        System.out.println("Menu Tổng quát");
                        System.out.println("1.Quản lí nhân viên");
                        System.out.println("2.Quản lí khách hàng");
                        System.out.println("3.Quản lí sản phẩm");
                        System.out.println("4.Quản lí hoá đơn bán");
                        System.out.println("5.Quản lí hóa đơn nhập");
                        System.out.println("9.Sửa đổi thông tin cá nhân");
                        System.out.println("0.Thoát");
                        option=CongCu.getOption(CongCu.inp.nextLine());
                        switch(option){
                            case 1:{
                                DSNhanVien.menuQuanLi_NhanVien();
                                break;
                            }
                            case 2:{
                                DSKhachHang.MenuKhachHang();
                                break;
                            }
                            case 3:{
                                DSSanPham.Menu_SanPham();
                                break;
                            }
                            case 4:{
                                DSHoaDon_Ban.Menu();
                                break;
                            }
                            case 5:{
                                DSHoaDon_Nhap.Menu();
                            }
                            case 9:{
                                DSNhanVien.suaThongTin();
                                break;
                            }
                            case 0:{
                                System.out.println("Thoát");
                                break;
                            }
                            default:{
                                System.out.println("Nhập sai rồi. Tính lươn lẹo à");
                                System.out.println("có quy định rồi không theo tính biểu tình à");
                                //option=CongCu.getOption(CongCu.inp.nextLine());
                                break;
                            }
                        }
                    }while(option!=0);
                }
                else{
                    if(quyen.equals("nhanvien")){
                    int option;
                    do{
                        System.out.println("Menu Tổng quát");
                        System.out.println("1.Quản lí khách hàng");
                        System.out.println("2.Quản lí sản phẩm");
                        System.out.println("3.Quản lí hoá đơn bán");
                        System.out.println("9.Sửa đổi thông tin cá nhân");
                        System.out.println("0.Thoát");
                        option=CongCu.getOption(CongCu.inp.nextLine());
                        switch(option){
                           
                            case 1:{
                                DSKhachHang.MenuKhachHang();
                                break;
                            }
                            case 2:{
                                DSSanPham.Menu_SanPham();
                                break;
                            }
                            case 3:{
                                DSHoaDon_Ban.Menu();
                                break;
                            }
                            case 9:{
                                DSNhanVien.suaThongTin();
                                break;
                            }
                            case 0:{
                                System.out.println("Thoát");
                                break;
                            }
                            default:{
                                System.out.println("Nhập sai rồi.");
                                
                                break;
                            }
                        }
                    }while(option!=0);
                    }
                }
               
            }
        }

}
