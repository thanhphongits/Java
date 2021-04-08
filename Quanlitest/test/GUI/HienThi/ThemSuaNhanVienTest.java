/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.HienThi;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import DTO.QuyenDTO;
import com.github.lgooddatepicker.components.DatePicker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vind
 */
public class ThemSuaNhanVienTest {
    ThemSuaNhanVien instance = new ThemSuaNhanVien("Thêm","");
    EXCEL ex;
    public ThemSuaNhanVienTest() {
//        try {
//            this.ex = new EXCEL("./test.xls");
//        } catch (IOException ex) {
//            Logger.getLogger(ThemSuaNhanVienTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDocument method, of class ThemSuaNhanVien.
     */
//    @Test
//    public void testAddDocument() {
//        System.out.println("addDocument");
//        JTextField tx = null;
//        ThemSuaNhanVien instance = null;
//        instance.addDocument(tx);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of check method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testCheck() {
//        System.out.println("check");
//        JTextField tx = null;
//        ThemSuaNhanVien instance = null;
//        instance.check(tx);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListQ method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetListQ() {
//        System.out.println("getListQ");
//        ThemSuaNhanVien instance = null;
//        ArrayList<QuyenDTO> expResult = null;
//        ArrayList<QuyenDTO> result = instance.getListQ();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setListQ method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetListQ() {
//        System.out.println("setListQ");
//        ArrayList<QuyenDTO> listQ = null;
//        ThemSuaNhanVien instance = null;
//        instance.setListQ(listQ);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setType method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetType() {
//        System.out.println("setType");
//        String type = "";
//        ThemSuaNhanVien instance = null;
//        instance.setType(type);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getQlNhanVien method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetQlNhanVien() {
//        System.out.println("getQlNhanVien");
//        ThemSuaNhanVien instance = null;
//        NhanVienBUS expResult = null;
//        NhanVienBUS result = instance.getQlNhanVien();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setQlNhanVien method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetQlNhanVien() {
//        System.out.println("setQlNhanVien");
//        NhanVienBUS qlNhanVien = null;
//        ThemSuaNhanVien instance = null;
//        instance.setQlNhanVien(qlNhanVien);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNvsua method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetNvsua() {
//        System.out.println("getNvsua");
//        ThemSuaNhanVien instance = null;
//        NhanVienDTO expResult = null;
//        NhanVienDTO result = instance.getNvsua();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNvsua method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetNvsua() {
//        System.out.println("setNvsua");
//        NhanVienDTO nvsua = null;
//        ThemSuaNhanVien instance = null;
//        instance.setNvsua(nvsua);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTxManv method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetTxManv() {
//        System.out.println("getTxManv");
//        ThemSuaNhanVien instance = null;
//        JTextField expResult = null;
//        JTextField result = instance.getTxManv();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTxManv method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetTxManv() {
//        System.out.println("setTxManv");
//        JTextField txManv = null;
//        ThemSuaNhanVien instance = null;
//        instance.setTxManv(txManv);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTxHonv method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetTxHonv() {
//        System.out.println("getTxHonv");
//        ThemSuaNhanVien instance = null;
//        JTextField expResult = null;
//        JTextField result = instance.getTxHonv();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTxHonv method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetTxHonv() {
//        System.out.println("setTxHonv");
//        JTextField txHonv = null;
//        ThemSuaNhanVien instance = null;
//        instance.setTxHonv(txHonv);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTxTennv method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetTxTennv() {
//        System.out.println("getTxTennv");
//        ThemSuaNhanVien instance = null;
//        JTextField expResult = null;
//        JTextField result = instance.getTxTennv();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTxTennv method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetTxTennv() {
//        System.out.println("setTxTennv");
//        JTextField txTennv = null;
//        ThemSuaNhanVien instance = null;
//        instance.setTxTennv(txTennv);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTxNgaysinh method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetTxNgaysinh() {
//        System.out.println("getTxNgaysinh");
//        ThemSuaNhanVien instance = null;
//        JTextField expResult = null;
//        JTextField result = instance.getTxNgaysinh();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTxNgaysinh method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetTxNgaysinh() {
//        System.out.println("setTxNgaysinh");
//        JTextField txNgaysinh = null;
//        ThemSuaNhanVien instance = null;
//        instance.setTxNgaysinh(txNgaysinh);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTxSDT method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetTxSDT() {
//        System.out.println("getTxSDT");
//        ThemSuaNhanVien instance = null;
//        JTextField expResult = null;
//        JTextField result = instance.getTxSDT();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTxSDT method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetTxSDT() {
//        System.out.println("setTxSDT");
//        JTextField txSDT = null;
//        ThemSuaNhanVien instance = null;
//        instance.setTxSDT(txSDT);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCbChonTrangThai method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetCbChonTrangThai() {
//        System.out.println("getCbChonTrangThai");
//        ThemSuaNhanVien instance = null;
//        JComboBox<String> expResult = null;
//        JComboBox<String> result = instance.getCbChonTrangThai();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCbChonTrangThai method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetCbChonTrangThai() {
//        System.out.println("setCbChonTrangThai");
//        JComboBox<String> cbChonTrangThai = null;
//        ThemSuaNhanVien instance = null;
//        instance.setCbChonTrangThai(cbChonTrangThai);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCbChonGT method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetCbChonGT() {
//        System.out.println("getCbChonGT");
//        ThemSuaNhanVien instance = null;
//        JComboBox<String> expResult = null;
//        JComboBox<String> result = instance.getCbChonGT();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCbChonGT method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetCbChonGT() {
//        System.out.println("setCbChonGT");
//        JComboBox<String> cbChonGT = null;
//        ThemSuaNhanVien instance = null;
//        instance.setCbChonGT(cbChonGT);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCbChonQuyen method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetCbChonQuyen() {
//        System.out.println("getCbChonQuyen");
//        ThemSuaNhanVien instance = null;
//        JComboBox<String> expResult = null;
//        JComboBox<String> result = instance.getCbChonQuyen();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCbChonQuyen method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetCbChonQuyen() {
//        System.out.println("setCbChonQuyen");
//        JComboBox<String> cbChonQuyen = null;
//        ThemSuaNhanVien instance = null;
//        instance.setCbChonQuyen(cbChonQuyen);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBtnThem method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetBtnThem() {
//        System.out.println("getBtnThem");
//        ThemSuaNhanVien instance = null;
//        JButton expResult = null;
//        JButton result = instance.getBtnThem();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setBtnThem method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetBtnThem() {
//        System.out.println("setBtnThem");
//        JButton btnThem = null;
//        ThemSuaNhanVien instance = null;
//        instance.setBtnThem(btnThem);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBtnSua method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetBtnSua() {
//        System.out.println("getBtnSua");
//        ThemSuaNhanVien instance = null;
//        JButton expResult = null;
//        JButton result = instance.getBtnSua();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setBtnSua method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetBtnSua() {
//        System.out.println("setBtnSua");
//        JButton btnSua = null;
//        ThemSuaNhanVien instance = null;
//        instance.setBtnSua(btnSua);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBtnHuy method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetBtnHuy() {
//        System.out.println("getBtnHuy");
//        ThemSuaNhanVien instance = null;
//        JButton expResult = null;
//        JButton result = instance.getBtnHuy();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setBtnHuy method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetBtnHuy() {
//        System.out.println("setBtnHuy");
//        JButton btnHuy = null;
//        ThemSuaNhanVien instance = null;
//        instance.setBtnHuy(btnHuy);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getdPickerNgaySinh method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testGetdPickerNgaySinh() {
//        System.out.println("getdPickerNgaySinh");
//        ThemSuaNhanVien instance = null;
//        DatePicker expResult = null;
//        DatePicker result = instance.getdPickerNgaySinh();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setdPickerNgaySinh method, of class ThemSuaNhanVien.
//     */
//    @Test
//    public void testSetdPickerNgaySinh() {
//        System.out.println("setdPickerNgaySinh");
//        DatePicker dPickerNgaySinh = null;
//        ThemSuaNhanVien instance = null;
//        instance.setdPickerNgaySinh(dPickerNgaySinh);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class ThemSuaNhanVien.
//     */
    @Test
    public void testMain() {
        System.out.println("main");
        instance = new ThemSuaNhanVien("Thêm", "");
        instance.setVisible(true);
        instance.getTxHonv().setText("Lê Phương");
        instance.getTxTennv().setText("Tây");
        instance.getTxSDT().setText("0393203261");
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getBtnThem().isEnabled(), true);
    }
    @Test
    public void check(){
        assertEquals(1, 1);
    }
}
