/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDB.XuLyDatabase;
import DTO.KhachHang_DTO;
import GUI.QuanLyKhachHang_GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author h
 */
public class KhachHang_DAO {

    private XuLyDatabase xuLyDB = null;
    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;

    public ArrayList<KhachHang_DTO> getAllKhachHang() throws ClassNotFoundException {

        ArrayList<KhachHang_DTO> resultArray = new ArrayList<KhachHang_DTO>();
        String query = "SELECT * FROM tbl_khachhang";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                KhachHang_DTO khachhangDTO = new KhachHang_DTO();
                khachhangDTO.setMaKH(resultSet.getInt("maKH"));
                khachhangDTO.setHoTenKH(resultSet.getString("hoTenKH"));
                khachhangDTO.setDiaChiKH(resultSet.getString("diaChiKH"));
                khachhangDTO.setSdtKH(resultSet.getString("sdtKH"));
                khachhangDTO.setCmndKH(resultSet.getString("cmndKH"));
                khachhangDTO.setGioiTinhKH(resultSet.getString("gioiTinhKH"));
                khachhangDTO.setTrangThaiKH(resultSet.getString("trangThaiKH"));

//                if (resultSet.getString("trangThaiNV").equals("Mở")){
                resultArray.add(khachhangDTO);
                //}

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultArray;
    }

    public ArrayList<KhachHang_DTO> timKiemKH(String sqlTimKiem, String searchValue) { //Tìm kiếm theo cmnd khách hàng
        ArrayList<KhachHang_DTO> resultArray = new ArrayList<KhachHang_DTO>();
        String query = "SELECT * FROM tbl_khachhang WHERE " + sqlTimKiem + " LIKE '%" + searchValue + "%' ";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                KhachHang_DTO khachhangDTO = new KhachHang_DTO();

                khachhangDTO.setMaKH(resultSet.getInt("maKH"));
                khachhangDTO.setHoTenKH(resultSet.getString("hoTenKH"));
                khachhangDTO.setDiaChiKH(resultSet.getString("diaChiKH"));
                khachhangDTO.setSdtKH(resultSet.getString("sdtKH"));
                khachhangDTO.setCmndKH(resultSet.getString("cmndKH"));
                khachhangDTO.setGioiTinhKH(resultSet.getString("gioiTinhKH"));
                khachhangDTO.setTrangThaiKH(resultSet.getString("trangThaiKH"));

                resultArray.add(khachhangDTO);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultArray;
    }

    public ArrayList<KhachHang_DTO> timKiemTheoMaVaHoTenKH(String searchValue) { //Tìm kiếm theo cmnd khách hàng
        ArrayList<KhachHang_DTO> resultArray = new ArrayList<KhachHang_DTO>();
        String query = "SELECT * FROM tbl_khachhang WHERE maKH LIKE '%" + searchValue + "%' OR hoTenKH LIKE '%" + searchValue + "%' ";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                KhachHang_DTO khachhangDTO = new KhachHang_DTO();

                khachhangDTO.setMaKH(resultSet.getInt("maKH"));
                khachhangDTO.setHoTenKH(resultSet.getString("hoTenKH"));
                khachhangDTO.setDiaChiKH(resultSet.getString("diaChiKH"));
                khachhangDTO.setSdtKH(resultSet.getString("sdtKH"));
                khachhangDTO.setCmndKH(resultSet.getString("cmndKH"));
                khachhangDTO.setGioiTinhKH(resultSet.getString("gioiTinhKH"));
                khachhangDTO.setTrangThaiKH(resultSet.getString("trangThaiKH"));

                resultArray.add(khachhangDTO);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultArray;
    }

    public int ThemKhachHang(KhachHang_DTO khachhangDTO) {
        int result = 0;
        String query = "INSERT INTO tbl_khachhang(maKH, hoTenKH, diaChiKh, sdtKH, cmndKH, gioiTinhKH) "
                + "VALUES(?, ?, ?, ?, ?, ?) ";

        try {
            xuLyDB = new XuLyDatabase();
          
                connection = xuLyDB.openConnection();
            
            ps = connection.prepareStatement(query);

            ps.setInt(1, khachhangDTO.getMaKH());

            ps.setString(2, khachhangDTO.getHoTenKH());
            ps.setString(3, khachhangDTO.getDiaChiKH());
            ps.setString(4, khachhangDTO.getSdtKH());
            ps.setString(5, khachhangDTO.getCmndKH());
            ps.setString(6, khachhangDTO.getGioiTinhKH());
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
//                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public int KhoaKH(KhachHang_DTO khachhangDTO) {
        int result = 0;
        String queryKhoa = "UPDATE tbl_khachhang SET trangThaiKH='Khóa' WHERE maKH =?";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(queryKhoa);
            ps.setInt(1, khachhangDTO.getMaKH());

            result = ps.executeUpdate(); //executeUpdate trả về số dòng chịu tác động

        } catch (SQLException e) {
            e.printStackTrace();
        }  //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                //                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;

    }

    public int CapNhatKH(KhachHang_DTO khachhangDTO) {
        int result = 0;

        
            try {
                String queryUpdateNoImage = "UPDATE tbl_khachhang SET hoTenKH= ?, diaChiKH= ?,"
                        + " sdtKH= ?, cmndKH= ?, gioiTinhKH= ? WHERE maKH = ?";

                xuLyDB = new XuLyDatabase();
                connection = xuLyDB.openConnection();

                ps = connection.prepareStatement(queryUpdateNoImage);

                ps.setString(1, khachhangDTO.getHoTenKH());
                ps.setString(2, khachhangDTO.getDiaChiKH());
                ps.setString(3, khachhangDTO.getSdtKH());
                ps.setString(4, khachhangDTO.getCmndKH());
                ps.setString(5, khachhangDTO.getGioiTinhKH());
                ps.setInt(6, khachhangDTO.getMaKH());

                result = ps.executeUpdate(); //executeUpdate trả về số dòng chịu tác động

            } catch (SQLException e) {
                e.printStackTrace();
            }  //Dong ket noi
            finally {
                try {
                    xuLyDB.closeConnection(connection);
                    ps.close();
                    //                resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        

        return result;

    }

    public void getAllTenKHCBB(JComboBox cbbName) {
        String query = "SELECT * FROM tbl_khachhang";

        try {
            xuLyDB = new XuLyDatabase();
            connection = xuLyDB.openConnection();

            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("trangThaiKH").equals("Mở")) {
                    cbbName.addItem(resultSet.getInt("maKH") + "-" + resultSet.getString("hoTenKH"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } //Dong ket noi
        finally {
            try {
                xuLyDB.closeConnection(connection);
                ps.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
