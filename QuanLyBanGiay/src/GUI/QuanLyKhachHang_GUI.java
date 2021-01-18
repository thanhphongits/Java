package GUI;

import BUS.CongCu;
import BUS.KhachHang_BUS;
import DTO.KhachHang_DTO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QuanLyKhachHang_GUI extends javax.swing.JPanel {

   

    KhachHang_BUS khachhangBUS = new KhachHang_BUS();

    public QuanLyKhachHang_GUI() {
        initComponents();
        LoadAllKhachHangToJTable();
        addGioiTinhCBB();
        addTimKiemCBB();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMaKH = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        lbHoTen = new javax.swing.JLabel();
        lbCMND = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        txfMaKH = new javax.swing.JTextField();
        txfHoTen = new javax.swing.JTextField();
        txfDiaChi = new javax.swing.JTextField();
        txfSDT = new javax.swing.JTextField();
        txfCMND = new javax.swing.JTextField();
        lbTimKiem = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txfTimKiem = new javax.swing.JTextField();
        btnXoaInput = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnKhoa = new javax.swing.JButton();
        cbbTimKiem = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        cbbGioiTinh = new javax.swing.JComboBox<>();
        btnExcelExport = new javax.swing.JButton();
        lbQuanLyNhanVien = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(1013, 699));
        setVerifyInputWhenFocusTarget(false);

        lbMaKH.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbMaKH.setText("Mã khách hàng:");

        lbDiaChi.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbDiaChi.setText("Địa chỉ:");

        lbHoTen.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbHoTen.setText("Họ tên:");

        lbCMND.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbCMND.setText("CMND:");

        lbSDT.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbSDT.setText("SĐT:");

        lbGioiTinh.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbGioiTinh.setText("Giới Tính:");

        txfMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfMaKHKeyPressed(evt);
            }
        });

        txfHoTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfHoTenKeyPressed(evt);
            }
        });

        txfDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfDiaChiKeyPressed(evt);
            }
        });

        txfSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfSDTKeyPressed(evt);
            }
        });

        txfCMND.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfCMNDKeyPressed(evt);
            }
        });

        lbTimKiem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTimKiem.setText("Tìm kiếm:");

        txfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTimKiemActionPerformed(evt);
            }
        });
        txfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfTimKiemKeyReleased(evt);
            }
        });

        btnXoaInput.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnXoaInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clean-icon3.png"))); // NOI18N
        btnXoaInput.setPreferredSize(new java.awt.Dimension(104, 27));
        btnXoaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaInputActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-add-27.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(104, 27));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-update-left-rotation-27.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnKhoa.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-delete-27.png"))); // NOI18N
        btnKhoa.setText("Xóa");
        btnKhoa.setPreferredSize(new java.awt.Dimension(104, 27));
        btnKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaActionPerformed(evt);
            }
        });

        cbbTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimKiemActionPerformed(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Họ Tên", "Địa Chỉ", "SĐT", "CMND", "Giới Tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblKhachHangAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseEntered(evt);
            }
        });
        tblKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblKhachHangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKhachHangKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(0).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(1).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(2).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(3).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(4).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(5).setResizable(false);
        }

        cbbGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbGioiTinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbGioiTinhKeyPressed(evt);
            }
        });

        btnExcelExport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExcelExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-export-excel-27.png"))); // NOI18N
        btnExcelExport.setText("Xuất Excel");
        btnExcelExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 160, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txfCMND)
                                            .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(27, 27, 27)
                                            .addComponent(txfSDT))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(lbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(27, 27, 27)
                                                    .addComponent(txfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(258, 258, 258))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbTimKiem)
                                .addGap(29, 29, 29)
                                .addComponent(txfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcelExport)
                                .addGap(83, 83, 83))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCapNhat)
                        .addComponent(btnKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcelExport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        lbQuanLyNhanVien.setBackground(new java.awt.Color(102, 102, 255));
        lbQuanLyNhanVien.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        lbQuanLyNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-user-groups-26.png"))); // NOI18N
        lbQuanLyNhanVien.setText("QUẢN LÝ KHÁCH HÀNG");
        lbQuanLyNhanVien.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(346, 346, 346))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txfMaKHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMaKHKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            focusInput(txfHoTen);
        }
    }//GEN-LAST:event_txfMaKHKeyPressed

    private void txfHoTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfHoTenKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            focusInput(txfDiaChi);
        }
    }//GEN-LAST:event_txfHoTenKeyPressed

    private void txfDiaChiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDiaChiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            focusInput(txfSDT);
        }
    }//GEN-LAST:event_txfDiaChiKeyPressed

    private void txfSDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSDTKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            focusInput(txfCMND);
        }
    }//GEN-LAST:event_txfSDTKeyPressed

    private void txfCMNDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCMNDKeyPressed

    }//GEN-LAST:event_txfCMNDKeyPressed

    private void txfTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTimKiemKeyPressed
        TimKiemKH();
    }//GEN-LAST:event_txfTimKiemKeyPressed

    private void btnXoaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaInputActionPerformed
        XoaInput();
    }//GEN-LAST:event_btnXoaInputActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ThemKH();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        CapNhatKH();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaActionPerformed
        KhoaKH();
    }//GEN-LAST:event_btnKhoaActionPerformed

    private void cbbTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimKiemActionPerformed
        TimKiemKH();
    }//GEN-LAST:event_cbbTimKiemActionPerformed

    private void tblKhachHangAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblKhachHangAncestorAdded
        showRowClicked();
    }//GEN-LAST:event_tblKhachHangAncestorAdded

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        showRowClicked();

    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void tblKhachHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKhachHangKeyPressed
        // TODO add your handling code here:
        //showRowClicked();
    }//GEN-LAST:event_tblKhachHangKeyPressed

    private void cbbGioiTinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbGioiTinhKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn yêu cầu!");
        }
    }//GEN-LAST:event_cbbGioiTinhKeyPressed

    private void btnExcelExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelExportActionPerformed
        ExportExcel();
    }//GEN-LAST:event_btnExcelExportActionPerformed

    private void txfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTimKiemActionPerformed
        // TODO add your handling code here:
        TimKiemKH();
    }//GEN-LAST:event_txfTimKiemActionPerformed

    private void tblKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKhachHangMouseEntered

    private void tblKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKhachHangKeyReleased
        // TODO add your handling code here:
        showRowClicked();
    }//GEN-LAST:event_tblKhachHangKeyReleased

    private void txfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTimKiemKeyReleased
        // TODO add your handling code here:
        TimKiemKH();
    }//GEN-LAST:event_txfTimKiemKeyReleased
    private void showRowClicked() {
        int viTri = tblKhachHang.getSelectedRow();
        System.out.println(viTri);
        if (viTri != -1) {
            txfMaKH.setEnabled(false);
            txfMaKH.setDisabledTextColor(Color.magenta);
            txfMaKH.setText(tblKhachHang.getValueAt(viTri, 0).toString());
            txfHoTen.setText(tblKhachHang.getValueAt(viTri, 1).toString());
            txfDiaChi.setText(tblKhachHang.getValueAt(viTri, 2).toString());
            txfSDT.setText(tblKhachHang.getValueAt(viTri, 3).toString());
            txfCMND.setText(tblKhachHang.getValueAt(viTri, 4).toString());
            cbbGioiTinh.setSelectedItem(tblKhachHang.getValueAt(viTri, 5).toString());
        }
//       }
    } //Show thông tin nhân viên được click lên Input

    private void LoadAllKhachHangToJTable() {
        ArrayList<KhachHang_DTO> khachhangArr = new ArrayList<KhachHang_DTO>();
        DefaultTableModel modelKH = (DefaultTableModel) tblKhachHang.getModel();
        modelKH.setRowCount(0); //Xóa dữ liệu đang có trong jtable

        KhachHang_BUS khachhangBUS = new KhachHang_BUS();

        try {
            khachhangArr = khachhangBUS.getAllKhachHang();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyKhachHang_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        KhachHang_DTO khachhangDTO = new KhachHang_DTO();

        for (int i = 0; i < khachhangArr.size(); i++) {
            khachhangDTO = khachhangArr.get(i);

            int maKH = khachhangDTO.getMaKH();
            String hoTenKH = khachhangDTO.getHoTenKH();
            String diaChiKH = khachhangDTO.getDiaChiKH();
            String sdtKH = khachhangDTO.getSdtKH();
            String cmndKH = khachhangDTO.getCmndKH();
            String gioiTinhKH = khachhangDTO.getGioiTinhKH();

            if (khachhangDTO.getTrangThaiKH().equals("Mở")) {
                Object[] row = {maKH, hoTenKH, diaChiKH, sdtKH, cmndKH, gioiTinhKH};
                modelKH.addRow(row);
            }

        }

    } //Load tất cả nhân viên từ database lên JTable

    private void addGioiTinhCBB() {
        cbbGioiTinh.addItem("Nam");
        cbbGioiTinh.addItem("Nữ");
        cbbGioiTinh.addItem("Khác");
    }

    private void XoaInput() {

        txfMaKH.setEnabled(true);
        txfMaKH.setDisabledTextColor(Color.WHITE);

        if (txfMaKH.getText().isEmpty() == false) {
            txfMaKH.setText("");
        }

        if (txfHoTen.getText().isEmpty() == false) {
            txfHoTen.setText("");
        }
        if (txfDiaChi.getText().isEmpty() == false) {
            txfDiaChi.setText("");
        }
        if (txfSDT.getText().isEmpty() == false) {
            txfSDT.setText("");
        }
        if (txfCMND.getText().isEmpty() == false) {
            txfCMND.setText("");
        }
        cbbGioiTinh.setSelectedItem("Nam");

    } //Dùng cho clean button

    private void ThemKH() {
        ArrayList<KhachHang_DTO> khachhangArr = new ArrayList<KhachHang_DTO>();
        KhachHang_DTO khachhangDTO = new KhachHang_DTO();
        int MaKH, SdtKH, CmndKH;

        if (txfMaKH.getDisabledTextColor() != Color.GRAY) {

            if (txfMaKH.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách hàng!");
                txfMaKH.requestFocus();
            } else if (txfHoTen.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên!");
                txfHoTen.requestFocus();
            } else if (txfDiaChi.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ!");
                txfDiaChi.requestFocus();
            } else if (txfSDT.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập SDT !");
                txfSDT.requestFocus();
            } else if (txfCMND.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập CMND !");
                txfCMND.requestFocus();
            } else {
                if (CongCu.checkCMNDKH(txfCMND.getText())){
                        try {
                        MaKH = Integer.parseInt(txfMaKH.getText());
                    } catch (NumberFormatException e) { //Kiểm tra có phải số nguyên hay không
                        JOptionPane.showMessageDialog(null, "Mã khách hàng phải là số nguyên!");
                        txfMaKH.requestFocus();
                    }
                    MaKH = Integer.parseInt(txfMaKH.getText());
                    khachhangDTO.setMaKH(MaKH);
                    khachhangDTO.setHoTenKH(txfHoTen.getText());
                    khachhangDTO.setDiaChiKH(txfDiaChi.getText());
                    khachhangDTO.setSdtKH(txfSDT.getText());
                    khachhangDTO.setCmndKH(txfCMND.getText());
                    khachhangDTO.setGioiTinhKH((String) cbbGioiTinh.getSelectedItem());

                    KhachHang_BUS khachhangBUS = new KhachHang_BUS();

                    try {
                        int result = khachhangBUS.ThemKhachHang(khachhangDTO);

                        if (result != 0) {
                            JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
                            XoaInput();
                        } else {
                            System.out.println("Thêm khách hàng thất bại!");
                            JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại! \n Mã khách hàng đã tồn tại!"); //Chưa ràng buộc tên tài khoản
                            txfMaKH.requestFocus();
                        }
                        LoadAllKhachHangToJTable();
                    } catch (Exception ex){ 
                        ex.printStackTrace();
                    }
                    
                    
                    
                }
                
               
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhấn Clean trước khi thêm!");
        }

    } //Thêm khách hàng

    private void CapNhatKH()// cập nhật khách hàng
    {
        KhachHang_DTO khachhangDTO = new KhachHang_DTO();
        System.out.println(tblKhachHang.getSelectedRow());//Test

        if (tblKhachHang.getSelectedRow() == -1 || txfMaKH.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn sửa!");
        } else if (txfHoTen.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên!");
            txfHoTen.requestFocus();
        } else if (txfDiaChi.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ!");
            txfDiaChi.requestFocus();
        } else if (txfSDT.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập SDT !");
            txfSDT.requestFocus();
        } else if (txfCMND.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập CMND !");
            txfCMND.requestFocus();
        } else {
            khachhangDTO.setMaKH(Integer.parseInt(txfMaKH.getText()));
            khachhangDTO.setHoTenKH(txfHoTen.getText());
            khachhangDTO.setDiaChiKH(txfDiaChi.getText());
            khachhangDTO.setSdtKH(txfSDT.getText());
            khachhangDTO.setCmndKH(txfCMND.getText());
            khachhangDTO.setGioiTinhKH((String) cbbGioiTinh.getSelectedItem());
            //Set ảnh trong hàm Thêm ở DAO

            KhachHang_BUS khachhangBUS = new KhachHang_BUS();

            try {
                int result = khachhangBUS.CapNhatKH(khachhangDTO);

                if (result != 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thất bại!");
                }

                LoadAllKhachHangToJTable();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    private void KhoaKH()//khóa khách hàng
    {
        KhachHang_DTO khachhangDTO = new KhachHang_DTO();

        if (tblKhachHang.getSelectedRow() != -1 && txfMaKH.getText().isEmpty() == false) {
            khachhangDTO.setMaKH(Integer.parseInt(txfMaKH.getText()));

            KhachHang_BUS khachhangBUS = new KhachHang_BUS();

            int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa khách hàng này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (luaChon == JOptionPane.YES_OPTION) {
                try {
                    int result = khachhangBUS.KhoaKH(khachhangDTO);

                    if (result != 0) {
                        JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công!");
                        XoaInput();
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa khách hàng thất bại!");
                    }

                    LoadAllKhachHangToJTable();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn xóa!");
        }

    }

    private void addTimKiemCBB() {
        cbbTimKiem.addItem("Mã KH");
        cbbTimKiem.addItem("Họ và tên KH");
        cbbTimKiem.addItem("Địa chỉ KH");
        cbbTimKiem.addItem("CMND KH");
        cbbTimKiem.addItem("SDT KH");
        cbbTimKiem.addItem("Giới tính KH");
    }

    private void focusInput(JTextField nameTextField) {
        nameTextField.requestFocus();
    }

    //---------Tìm kiếm -----------//
    private void TimKiemKH() {
        String optionTimKiem = (String) cbbTimKiem.getSelectedItem();
        System.out.println("Đã chọn: " + optionTimKiem);//Test

        switch (optionTimKiem) {
            case "Mã KH": {
                String sqlTimKiem = "maKH";
                TimKiem(sqlTimKiem, txfTimKiem.getText());
                break;
            }

            case "Họ và tên KH": {
                String sqlTimKiem = "hoTenKH";
                TimKiem(sqlTimKiem, txfTimKiem.getText());
                break;
            }
            case "Địa chỉ KH": {
                String sqlTimKiem = "diaChiKH";
                TimKiem(sqlTimKiem, txfTimKiem.getText());
                break;
            }
            case "SDT KH": {
                String sqlTimKiem = "sdtKH";
                TimKiem(sqlTimKiem, txfTimKiem.getText());
                break;
            }
            case "CMND KH": {
                String sqlTimKiem = "cmndKH";
                TimKiem(sqlTimKiem, txfTimKiem.getText());
                break;
            }
            case "Giới tính KH": {
                String sqlTimKiem = "gioiTinhKH";
                TimKiem(sqlTimKiem, txfTimKiem.getText());
                break;
            }
        }
    }

    private void TimKiem(String sqlTimKiem, String valueSearch) {
        {
            KhachHang_BUS khachhangBUS = new KhachHang_BUS();

            ArrayList<KhachHang_DTO> khachhangArr = khachhangBUS.timKiemKH(sqlTimKiem, valueSearch);
            DefaultTableModel modelKH = (DefaultTableModel) tblKhachHang.getModel();
            modelKH.setRowCount(0);

            KhachHang_DTO khachhangDTO = new KhachHang_DTO();

            for (int i = 0; i < khachhangArr.size(); i++) {
                khachhangDTO = khachhangArr.get(i);

                int maKH = khachhangDTO.getMaKH();

                String hoTenKH = khachhangDTO.getHoTenKH();
                String diaChiKH = khachhangDTO.getDiaChiKH();
                String sdtKH = khachhangDTO.getSdtKH();
                String cmndKH = khachhangDTO.getCmndKH();
                String gioiTinhKH = khachhangDTO.getGioiTinhKH();

                if (khachhangDTO.getTrangThaiKH().equals("Mở")) {
                    Object[] row = {maKH, hoTenKH, diaChiKH, sdtKH, cmndKH, gioiTinhKH};
                    modelKH.addRow(row);
                }
            }
        }
    }

    private void ExportExcel() {
        JFileChooser file = new JFileChooser(); //Khởi tạo JFileChooser
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            XSSFWorkbook excelWorkbook = new XSSFWorkbook();
            XSSFSheet excelSheet = excelWorkbook.createSheet("Danh sách khách hàng");

            XSSFRow row = null;
            Cell cell = null;

            row = excelSheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH KHÁCH HÀNG");

            row = excelSheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Mã khách hàng");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Họ tên");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Địa chỉ");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("SDT");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("CMND");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Giới tính");
            for (int i = 0; i < tblKhachHang.getRowCount(); i++) {
                row = excelSheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                for (int j = 0; j < tblKhachHang.getColumnCount(); j++) {
                    row.createCell(j).setCellValue(tblKhachHang.getValueAt(i, j).toString());
                }
            }

            FileOutputStream excelFOS;
            BufferedOutputStream excelBOS;
            try {
                excelFOS = new FileOutputStream(new File(file.getSelectedFile() + ".xls"));
                excelBOS = new BufferedOutputStream(excelFOS);
                excelWorkbook.write(excelBOS);
                JOptionPane.showMessageDialog(null, "Xuất file excel thành công!");
                excelBOS.close();
                excelWorkbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnExcelExport;
    private javax.swing.JButton btnKhoa;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoaInput;
    private javax.swing.JComboBox<String> cbbGioiTinh;
    private javax.swing.JComboBox cbbTimKiem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCMND;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbMaKH;
    private javax.swing.JLabel lbQuanLyNhanVien;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTimKiem;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txfCMND;
    private javax.swing.JTextField txfDiaChi;
    private javax.swing.JTextField txfHoTen;
    private javax.swing.JTextField txfMaKH;
    private javax.swing.JTextField txfSDT;
    private javax.swing.JTextField txfTimKiem;
    // End of variables declaration//GEN-END:variables

}
