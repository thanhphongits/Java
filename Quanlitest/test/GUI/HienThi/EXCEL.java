/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.HienThi;

import BUS.SanPhamBUS;
import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import GUI.Excel.MyJOptionPane;
import GUI.MyTable;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Vind
 */
public class EXCEL {
    Workbook instance = null;
    public EXCEL(String url) throws FileNotFoundException, IOException {
        //FileInputStream inputStream = new FileInputStream(new File(url));
        instance =  new XSSFWorkbook(url);
    }
    public Cell getCell(int row,int col){
        Sheet sheet= instance.getSheetAt(0);
        return sheet.getRow(row).getCell(col);
    }
    public String getInfo(int row,int col){
        return getCell(row, col).getStringCellValue();
    }
    public static void main(String[] args) {
        try {
            EXCEL a = new EXCEL("./test.xls");
            System.out.println(a.getInfo(2, 1));
        } catch (IOException ex) {
            Logger.getLogger(EXCEL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String docFileExcelSanPham(int rowx, int col) {
        FileInputStream inputStream = null;
        try {
            Sheet sheet = instance.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();
            while (rowIterator.hasNext()) {
                rowx--;
                
                Row row = rowIterator.next();
                if(rowx==0)
                    return row.getCell(col).getStringCellValue();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    int stt = (int) cellIterator.next().getNumericCellValue();
                    String ma = cellIterator.next().getStringCellValue();
                    String ten = cellIterator.next().getStringCellValue();
                    String maLoaiSP = cellIterator.next().getStringCellValue();
                    LocalDate NamSX = LocalDate.parse(cellIterator.next().getStringCellValue());
                    String MaNCC = cellIterator.next().getStringCellValue();
                    String MaTH = cellIterator.next().getStringCellValue();
                    int dongia = (int) cellIterator.next().getNumericCellValue();
                    int soLuong = (int) cellIterator.next().getNumericCellValue();
                    String mota = cellIterator.next().getStringCellValue();
                    String image = cellIterator.next().getStringCellValue();
                }
            }
        }catch(Exception e){
            
        }
        return null;
    }
}   
