/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.HienThi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vind
 */
public class test {
    public static void main(String[] args) {
        EXCEL a = null;
        try {
            a = new EXCEL("./test.xls");
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(a.getInfo(2, 1));
    }
}
