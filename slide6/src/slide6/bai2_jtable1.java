/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 98tae
 */
public class bai2_jtable1 extends javax.swing.JFrame {
              Connection con ;
             DefaultComboBoxModel<HocSinh> modelcb = new DefaultComboBoxModel<>();
    /**
     * Creates new form bai1_jtable
     */
    public bai2_jtable1() {
        initComponents();
        setLocationRelativeTo(null);
        con = LHelper.ketNoi("Lab5_SOF203");
        cbba.setModel((ComboBoxModel)modelcb);
        if (con != null) {
//            loadataToTable();
                LoadDataToComBoBox();
        }else{
        return;
        }
        
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbba = new javax.swing.JComboBox<>();
        lbten = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbba.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbaItemStateChanged(evt);
            }
        });

        lbten.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(cbba, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(lbten)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbten))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbaItemStateChanged
        HocSinh hs = (HocSinh) cbba.getSelectedItem();
        lbten.setText(hs.getTenSV());
    }//GEN-LAST:event_cbbaItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bai2_jtable1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bai2_jtable1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bai2_jtable1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bai2_jtable1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bai2_jtable1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbba;
    private javax.swing.JLabel lbten;
    // End of variables declaration//GEN-END:variables

    private void LoadDataToComBoBox() {
        try {
            String sql = "Select * from HOCSINH";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {   
               modelcb.addElement(new HocSinh(rs.getString(1)));
               
            }
            pstm.close();
        } catch (Exception e) {
        e.printStackTrace();
        }
        
    }

//    private void loadataToTable() {
//        try {
//            String sql = "Select * from HOCSINH";
//            PreparedStatement pstm = con.prepareStatement(sql);
//            ResultSet rs = pstm.executeQuery();
//            dtm.setRowCount(0);
//            while (rs.next()) {   
////                Object[] RowData = new Object[]{
////                rs.getString(1),
////                rs.getString(2),
////                rs.getString(3),
////                rs.getDouble(4),
////                };
////                dtm.addRow(RowData);
//                Vector v = new Vector();
//                v.add(rs.getString(1));
//                v.add(rs.getString(2));
//                v.add(rs.getString(3));
//                v.add(rs.getDouble(4));
//                dtm.addRow(v);
//        
//            }
//            pstm.close();
//        } catch (Exception e) {
//        e.printStackTrace();
//        }
//    }
}
