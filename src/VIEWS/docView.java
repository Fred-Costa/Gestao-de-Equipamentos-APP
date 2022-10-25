package VIEWS;

import BEAN.documento;
import BEAN.equipamentoBEAN;
import DAO.documentoDAO;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class docView extends javax.swing.JFrame {

    public docView() {
        initComponents();
        leituraDocumentos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnSEARCH = new javax.swing.JButton();
        btnDELETE = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTDoc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        equipID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFileName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        uploadBTN = new javax.swing.JButton();
        saveBTN = new javax.swing.JButton();
        dataDoc = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(143, 143, 143));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LREC - GESTÃO DE EQUIPAMENTOS INFORMÁTICOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(241, 241, 241))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel3.setFont(new java.awt.Font("Sitka Heading", 0, 16)); // NOI18N
        jLabel3.setText("DOCUMENTOS:");

        btnSEARCH.setBackground(new java.awt.Color(204, 204, 204));
        btnSEARCH.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 0, 12)); // NOI18N
        btnSEARCH.setText("PESQUISA");
        btnSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSEARCHActionPerformed(evt);
            }
        });

        btnDELETE.setBackground(new java.awt.Color(204, 204, 204));
        btnDELETE.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 0, 12)); // NOI18N
        btnDELETE.setText("APAGAR");
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });

        jTDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTDoc);
        if (jTDoc.getColumnModel().getColumnCount() > 0) {
            jTDoc.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Equipamento ID:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nome do Ficheiro:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Data:");

        uploadBTN.setBackground(new java.awt.Color(204, 204, 204));
        uploadBTN.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 0, 12)); // NOI18N
        uploadBTN.setText("UPLOAD");
        uploadBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBTNActionPerformed(evt);
            }
        });

        saveBTN.setBackground(new java.awt.Color(204, 204, 204));
        saveBTN.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 0, 12)); // NOI18N
        saveBTN.setText("GUARDAR");
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        dataDoc.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPath)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(uploadBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dataDoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(equipID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFileName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(equipID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uploadBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 0, 12)); // NOI18N
        jButton1.setText("VER ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDELETE, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(btnSEARCH, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(189, 189, 189))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnDELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBTNActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("C:\\Users\\Frederico\\Desktop"));
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        txtPath.setText(filename);

    }//GEN-LAST:event_uploadBTNActionPerformed

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed

        try {
            DefaultTableModel tDoc = (DefaultTableModel) jTDoc.getModel();
            Object[] dados = {equipID.getText(), txtFileName.getText(), dataDoc.getDate()};
            tDoc.addRow(dados);
            
            equipamentoBEAN equip = new equipamentoBEAN();
            equip.setIDequipamento(Integer.parseInt(equipID.getText()));
            
            documento doc = new documento();
            documentoDAO docDAO = new documentoDAO();
            
            String newPath = "C:\\Users\\Frederico\\Documents\\NetBeansProjects\\GestaoEquip\\uploads\\Documentos\\";
            File directory = new File(newPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            File source = null;
            File destination = null;
            String extension = filename.substring(filename.lastIndexOf('.') + 1);
            source = new File(txtPath.getText());
            destination = new File(newPath + txtFileName.getText() + "." + extension);
            
            Path finalPath = Files.copy(source.toPath(), destination.toPath());
            
            doc.setEquipamento(equip);
            doc.setNomeDoc(txtFileName.getText());
            doc.setDoc(finalPath.toString());
            doc.setData(((JTextField) dataDoc.getDateEditor().getUiComponent()).getText());
            
            docDAO.create(doc);
            leituraDocumentos();
            
            equipID.setText("");
            txtFileName.setText("");
            dataDoc.setDate(null);
            txtPath.setText("");
            
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao guardar documento: " + erro);
        }
    }//GEN-LAST:event_saveBTNActionPerformed

    private void btnSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSEARCHActionPerformed
        
        if (equipID.getText() == "") {
            leituraDocumentos();
        } else {
            pesquisaDocs(Integer.valueOf(equipID.getText()));
        }
        
    }//GEN-LAST:event_btnSEARCHActionPerformed

    private void jTDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDocMouseClicked
        int row = jTDoc.getSelectedRow();
        
        if (row == -1) {
            return;
        }
        
        try {
            MessageFormat footer = new MessageFormat("Página {0, number, integer}");
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTDocMouseClicked

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        // row = linha selecionada da tabela
        int row = jTDoc.getSelectedRow();
        
        // Se a linha da tabela for diff -1, ou seja, existe uma linha que está selecionada
        // esta será eliminada
        if (row != -1) {
            documento doc = new documento();
            documentoDAO docDAO = new documentoDAO();
            
            doc.setIdDoc((int) jTDoc.getValueAt(row, 0));
            docDAO.delete(doc);
            
            equipID.setText("");
            txtFileName.setText("");
            dataDoc.setDate(null);
            txtPath.setText("");
            
            leituraDocumentos();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um documento...");
        }
        
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            
            String path = "C:\\Users\\Frederico\\Documents\\NetBeansProjects\\GestaoEquip\\uploads\\Documentos\\";
            
            File file = new File(path);
            
            if (file.exists()) {
                
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                } else {
                    JOptionPane.showMessageDialog(this, "Não suportado");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ficheiro não existe!");
            }
        } catch (HeadlessException | IOException e) {
            System.out.println("Algo de errado: " + e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(docView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(docView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(docView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(docView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new docView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnSEARCH;
    private com.toedter.calendar.JDateChooser dataDoc;
    private javax.swing.JTextField equipID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTDoc;
    private javax.swing.JButton saveBTN;
    private javax.swing.JTextField txtFileName;
    private javax.swing.JTextField txtPath;
    private javax.swing.JButton uploadBTN;
    // End of variables declaration//GEN-END:variables
String filename = null;

    private void leituraDocumentos() {

        DefaultTableModel modelo = (DefaultTableModel) jTDoc.getModel();
        modelo.setNumRows(0);

        documentoDAO docD = new documentoDAO();

        for (documento doc : docD.leitura()) {
            modelo.addRow(new Object[]{
                doc.getIdDoc(),
                doc.getNomeDoc(),
                doc.getData()
            });
        }
    }
    
    public void pesquisaDocs(Object equipamentoID) {
        
        DefaultTableModel modelo = (DefaultTableModel) jTDoc.getModel();
        modelo.setNumRows(0);

        documentoDAO docDAO = new documentoDAO();
        
        for (documento doc: docDAO.pesquisa(equipamentoID)) {
            modelo.addRow(new Object[] {
                doc.getIdDoc(),
                doc.getNomeDoc(),
                doc.getData()
        });
        }
    }
}
