/* Gestão de Equipamentos */

package VIEWS;

import BEAN.equipamentoBEAN;
import BEAN.estadoBEAN;
import BEAN.historicoBEAN;
import BEAN.userBEAN;
import ConexaoDB.Conexao;
import DAO.equipamentoDAO;
import DAO.estadoDAO;
import DAO.historicoDAO;
import DAO.userDAO;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.JTextField;

public final class home extends javax.swing.JFrame {

    Connection conn = Conexao.getConnection();
    PreparedStatement stm = null;
    ResultSet rs = null;
    userDAO uDAO = new userDAO();
    estadoDAO estdDAO = new estadoDAO();
    equipamentoDAO equipDAO = new equipamentoDAO();
    historicoDAO histDAO = new historicoDAO();

    public home() {
        initComponents();
        init();
        leituraUsers();
        leituraEstados();
        leituraEquipamentos();
        leituraHistorico();
    }

    public void init() {
        userID.setText(String.valueOf(uDAO.getMax()));
        estadoID.setText(String.valueOf(estdDAO.getMax()));
        equipID.setText(String.valueOf(equipDAO.getMax()));
        historicoID.setText(String.valueOf(histDAO.getMax()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        saveButtonUser = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTUsers = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        userSearch = new javax.swing.JTextField();
        PesquisaUSER = new javax.swing.JButton();
        DeleteUSER = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        estadoID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        saveButtonEstado = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTEstado = new javax.swing.JTable();
        DeleteESTADO = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        equipID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEquip = new javax.swing.JTextField();
        SaveEquip = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        anxEQUIP = new javax.swing.JButton();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtNumSerie = new javax.swing.JTextField();
        dataAquis = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        entrada = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTEquip = new javax.swing.JTable();
        PesquisaEQUIP = new javax.swing.JButton();
        DeleteEQUIP = new javax.swing.JButton();
        printEQUIP = new javax.swing.JButton();
        DocEQUIP = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbEQUIP = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbModelo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbMarca = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbNumSerie = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        dataINI = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        dataFIM = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        historicoID = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        saveHIST = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        anxEQUIP1 = new javax.swing.JButton();
        DATA = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        userCB = new javax.swing.JComboBox<>();
        EquipCB = new javax.swing.JComboBox<>();
        estadoCB = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTHist = new javax.swing.JTable();
        pesquisaHIST = new javax.swing.JButton();
        deleteHIST = new javax.swing.JButton();
        printHIST = new javax.swing.JButton();
        docHIST = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        searchUser = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        searchEquip = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        searchMarca = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        searchModelo = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        searchNumSerie = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        searchEstado = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        inicialData = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        fimData = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LREC - GESTÃO DE EQUIPAMENTOS INFORMÁTICOS");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setText("Utilizador ID:");

        userID.setEditable(false);
        userID.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Nome:");

        saveButtonUser.setBackground(new java.awt.Color(204, 204, 204));
        saveButtonUser.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        saveButtonUser.setText("GUARDAR");
        saveButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(saveButtonUser))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButtonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Utilizador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTUsers);
        if (jTUsers.getColumnModel().getColumnCount() > 0) {
            jTUsers.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTUsers.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        jLabel4.setText("Utilizador:");

        PesquisaUSER.setBackground(new java.awt.Color(204, 204, 204));
        PesquisaUSER.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        PesquisaUSER.setText("PESQUISA");
        PesquisaUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisaUSERActionPerformed(evt);
            }
        });

        DeleteUSER.setBackground(new java.awt.Color(204, 204, 204));
        DeleteUSER.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        DeleteUSER.setText("APAGAR");
        DeleteUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteUSERActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(userSearch)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(PesquisaUSER, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(DeleteUSER, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(244, 244, 244))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PesquisaUSER, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteUSER, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(323, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("UTILIZADORES", jPanel3);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel5.setText("Estado ID:");

        estadoID.setEditable(false);
        estadoID.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setText("Estado:");

        saveButtonEstado.setBackground(new java.awt.Color(204, 204, 204));
        saveButtonEstado.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        saveButtonEstado.setText("GUARDAR");
        saveButtonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(estadoID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(saveButtonEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(estadoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(saveButtonEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTEstado);
        if (jTEstado.getColumnModel().getColumnCount() > 0) {
            jTEstado.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTEstado.getColumnModel().getColumn(1).setPreferredWidth(650);
        }

        DeleteESTADO.setBackground(new java.awt.Color(204, 204, 204));
        DeleteESTADO.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        DeleteESTADO.setText("APAGAR");
        DeleteESTADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteESTADOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(DeleteESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 724, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteESTADO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("ESTADO DOS EQUIPAMENTOS", jPanel5);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel7.setText("Equipamento ID:");

        equipID.setEditable(false);
        equipID.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setText("Equipamento:");

        SaveEquip.setBackground(new java.awt.Color(204, 204, 204));
        SaveEquip.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        SaveEquip.setText("GUARDAR");
        SaveEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveEquipActionPerformed(evt);
            }
        });

        jLabel10.setText("Modelo:");

        jLabel11.setText("Marca:");

        jLabel12.setText("Número de Série:");

        jLabel13.setText("Data de Aquisição:");

        anxEQUIP.setBackground(new java.awt.Color(204, 204, 204));
        anxEQUIP.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        anxEQUIP.setText("ANEXAR DOC");
        anxEQUIP.setMaximumSize(new java.awt.Dimension(89, 24));
        anxEQUIP.setMinimumSize(new java.awt.Dimension(89, 24));
        anxEQUIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anxEQUIPActionPerformed(evt);
            }
        });

        dataAquis.setDateFormatString("yyyy-MM-dd");

        jLabel14.setText("Entrada:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(SaveEquip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(anxEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(equipID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataAquis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 91, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(equipID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(dataAquis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anxEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTEquip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Equipamento", "Marca", "Modelo", "Número de Série", "Data de Aquisição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTEquip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(jTEquip);
        if (jTEquip.getColumnModel().getColumnCount() > 0) {
            jTEquip.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTEquip.getColumnModel().getColumn(1).setPreferredWidth(85);
            jTEquip.getColumnModel().getColumn(2).setPreferredWidth(20);
            jTEquip.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTEquip.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        PesquisaEQUIP.setBackground(new java.awt.Color(204, 204, 204));
        PesquisaEQUIP.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        PesquisaEQUIP.setText("PESQUISA");
        PesquisaEQUIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisaEQUIPActionPerformed(evt);
            }
        });

        DeleteEQUIP.setBackground(new java.awt.Color(204, 204, 204));
        DeleteEQUIP.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        DeleteEQUIP.setText("APAGAR");
        DeleteEQUIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEQUIPActionPerformed(evt);
            }
        });

        printEQUIP.setBackground(new java.awt.Color(204, 204, 204));
        printEQUIP.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        printEQUIP.setText("PRINT");
        printEQUIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printEQUIPActionPerformed(evt);
            }
        });

        DocEQUIP.setBackground(new java.awt.Color(204, 204, 204));
        DocEQUIP.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        DocEQUIP.setText("DOCUMENTOS");

        jLabel9.setText("Tipo de Equipamento:");

        cbEQUIP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbEQUIP.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbEQUIPAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel15.setText("Modelo:");

        cbModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbModelo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbModeloAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel16.setText("Marca:");

        cbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbMarca.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbMarcaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel17.setText("NumSerie:");

        cbNumSerie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbNumSerie.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbNumSerieAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel18.setText("Data:");

        jLabel19.setText("-");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(PesquisaEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(234, 234, 234))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(126, 126, 126)
                                        .addComponent(jLabel16))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DeleteEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(108, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dataINI, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dataFIM, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(printEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DocEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(cbNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addComponent(dataINI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dataFIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PesquisaEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DeleteEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(printEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DocEQUIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("EQUIPAMENTOS", jPanel8);

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));

        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel20.setText("Histórico ID:");

        historicoID.setEditable(false);
        historicoID.setBackground(new java.awt.Color(204, 204, 204));

        jLabel21.setText("Equipamento:");

        saveHIST.setBackground(new java.awt.Color(204, 204, 204));
        saveHIST.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        saveHIST.setText("GUARDAR");
        saveHIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveHISTActionPerformed(evt);
            }
        });

        jLabel25.setText("Data:");

        anxEQUIP1.setBackground(new java.awt.Color(204, 204, 204));
        anxEQUIP1.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        anxEQUIP1.setText("ANEXAR");
        anxEQUIP1.setMaximumSize(new java.awt.Dimension(89, 24));
        anxEQUIP1.setMinimumSize(new java.awt.Dimension(89, 24));
        anxEQUIP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anxEQUIP1ActionPerformed(evt);
            }
        });

        DATA.setDateFormatString("yyyy-MM-dd");

        jLabel33.setText("User:");

        jLabel26.setText("Estado:");

        jLabel34.setText("Descrição:");

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane5.setViewportView(desc);

        userCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        userCB.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                userCBAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        EquipCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        EquipCB.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                EquipCBAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        estadoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        estadoCB.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                estadoCBAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(saveHIST)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(anxEQUIP1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel33)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(historicoID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel34)
                            .addComponent(jLabel21)
                            .addComponent(EquipCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DATA, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(historicoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addGap(1, 1, 1)
                .addComponent(userCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EquipCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estadoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anxEQUIP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveHIST, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(DATA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTHist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "User", "Equipamento", "Marca", "Modelo", "NumSerie", "Estado", "Descrição", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTHist.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTHist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTHistMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTHist);
        if (jTHist.getColumnModel().getColumnCount() > 0) {
            jTHist.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTHist.getColumnModel().getColumn(2).setPreferredWidth(85);
            jTHist.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTHist.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTHist.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTHist.getColumnModel().getColumn(8).setPreferredWidth(50);
        }

        pesquisaHIST.setBackground(new java.awt.Color(204, 204, 204));
        pesquisaHIST.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        pesquisaHIST.setText("PESQUISA");
        pesquisaHIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaHISTActionPerformed(evt);
            }
        });

        deleteHIST.setBackground(new java.awt.Color(204, 204, 204));
        deleteHIST.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        deleteHIST.setText("APAGAR");
        deleteHIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteHISTActionPerformed(evt);
            }
        });

        printHIST.setBackground(new java.awt.Color(204, 204, 204));
        printHIST.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        printHIST.setText("PRINT");
        printHIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printHISTActionPerformed(evt);
            }
        });

        docHIST.setBackground(new java.awt.Color(204, 204, 204));
        docHIST.setFont(new java.awt.Font("Verdana Pro Cond Semibold", 1, 14)); // NOI18N
        docHIST.setText("ANEXOS");

        jLabel36.setText("User:");

        searchUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        searchUser.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                searchUserAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel27.setText("Equipamento:");

        searchEquip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        searchEquip.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                searchEquipAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel28.setText("Marca:");

        searchMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        searchMarca.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                searchMarcaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel29.setText("Modelo:");

        searchModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        searchModelo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                searchModeloAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel30.setText("Número de Série:");

        searchNumSerie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        searchNumSerie.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                searchNumSerieAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel31.setText("Estado:");

        searchEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        searchEstado.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                searchEstadoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel32.setText("DATA:");

        jLabel35.setText("-");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(pesquisaHIST, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(195, 195, 195))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125)))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteHIST, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(printHIST, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(docHIST, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inicialData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fimData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(searchEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(searchMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(searchModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(searchNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(searchEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inicialData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fimData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesquisaHIST, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteHIST, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(printHIST, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(docHIST, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("HISTÓRICO", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonUserActionPerformed

        DefaultTableModel tUser = (DefaultTableModel) jTUsers.getModel();

        // Tem como objetivo ler os dados introduzidos pelo utilizador que vai colocá-los numa lista
        Object[] dados = {txtNome.getText()};

        // Guarda os dados na tabela
        tUser.addRow(dados);

        userBEAN uB = new userBEAN();
        userDAO uD = new userDAO();

        if (txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'nome' é de preenchimento obrigatório!", "AVISO!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        uB.setNome(txtNome.getText());
        uD.create(uB);

        //Limpa o campo de Nome
        txtNome.setText("");

        // Chama a função para mostrar os dados na tabela
        leituraUsers();
        // Chama a função para incrementar o valor o ID
        init();
    }//GEN-LAST:event_saveButtonUserActionPerformed

    private void DeleteUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteUSERActionPerformed
        // Esta linha de codigo sera apenas para ver caso nao tenha uma linha 
        // na tabela, fica como linha / id: -1
        // System.out.println("Linha selecionada: " + jTUsers.getSelectedRow());
        // Se por acaso a linha estiver como -1, isto quer dizer que, nao tem
        // nenhuma linha selecionada.
        if (jTUsers.getSelectedRow() != -1) {

            userBEAN u = new userBEAN();
            userDAO uDAO = new userDAO();

            // O produto selecionado será eliminado
            u.setIDusers((int) jTUsers.getValueAt(jTUsers.getSelectedRow(), 0));
            uDAO.delete(u);

            JOptionPane.showMessageDialog(null, "User apagado com sucesso!");

            leituraUsers();
        } else {
            // Caso nao selecione nenhum user para apagar, aparece esta mensagem
            // de erro
            JOptionPane.showMessageDialog(null, "Selecione um user para o eliminar!");
        }

    }//GEN-LAST:event_DeleteUSERActionPerformed

    private void PesquisaUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisaUSERActionPerformed
        pesquisaUsers(userSearch.getText());
    }//GEN-LAST:event_PesquisaUSERActionPerformed

    private void saveButtonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonEstadoActionPerformed

        DefaultTableModel tEstado = (DefaultTableModel) jTEstado.getModel();
        Object[] dados = {txtEstado.getText()};
        tEstado.addRow(dados);

        estadoBEAN estd = new estadoBEAN();
        estadoDAO eDAO = new estadoDAO();

        if (txtEstado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'estado' é de preenchimento obrigatório!", "AVISO!", JOptionPane.WARNING_MESSAGE);
        }

        estd.setEstado(txtEstado.getText());
        eDAO.create(estd);

        txtEstado.setText("");

        leituraEstados();
        init();
    }//GEN-LAST:event_saveButtonEstadoActionPerformed

    private void DeleteESTADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteESTADOActionPerformed

        if (jTEstado.getSelectedRow() != -1) {

            estadoBEAN estd = new estadoBEAN();
            estadoDAO eDAO = new estadoDAO();

            // Quando tiver uma linha selecionada, será apagada
            estd.setIDestado((int) jTEstado.getValueAt(jTEstado.getSelectedRow(), 0));
            eDAO.delete(estd);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um estado para o apagar!");
        }

        leituraEstados();
    }//GEN-LAST:event_DeleteESTADOActionPerformed

    private void SaveEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveEquipActionPerformed

        DefaultTableModel TableEquip = (DefaultTableModel) jTEquip.getModel();
        Object[] dados = {txtEquip.getText(), txtMarca.getText(), txtModelo.getText(), txtNumSerie.getText(), dataAquis.getDate()};

        TableEquip.addRow(dados);

        if (txtEquip.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'equipamento' é de preenchimento obrigatório!");
        }
        if (txtMarca.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'marca' é de preenchimento obrigatório!");
        }
        if (txtModelo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'modelo' é de preenchimento obrigatório!");
        }
        if (txtNumSerie.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'Número Série' é de preenchimento obrigatório!");
        }

        equipamentoBEAN equip = new equipamentoBEAN();
        equipamentoDAO eDAO = new equipamentoDAO();

        equip.setEntrada(Integer.parseInt(entrada.getText()));
        equip.setEquipamento(txtEquip.getText());
        equip.setMarca(txtMarca.getText());
        equip.setModelo(txtModelo.getText());
        equip.setNumSerie(txtNumSerie.getText());
        equip.setDatAquisi(((JTextField) dataAquis.getDateEditor().getUiComponent()).getText());

        eDAO.create(equip);

        entrada.setText("");
        txtEquip.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtNumSerie.setText("");
        dataAquis.setDate(null);

        leituraEquipamentos();
        init();
    }//GEN-LAST:event_SaveEquipActionPerformed

    private void PesquisaEQUIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisaEQUIPActionPerformed
        if (cbEQUIP.getSelectedItem() == "Selecione" && cbMarca.getSelectedItem() == "Selecione" && cbModelo.getSelectedItem() == "Selecione"
                && cbNumSerie.getSelectedItem() == "Selecione" && dataINI.getDate() == null && dataFIM.getDate() == null) {
            leituraEquipamentos();
        }

        //PESQUISAS SIMPLES
        if (cbEQUIP.getSelectedItem() != "Selecione") {
            pesquisaEquipamento(cbEQUIP.getSelectedItem());
        }
        if (cbMarca.getSelectedItem() != "Selecione") {
            pesquisaMarca(cbMarca.getSelectedItem());
        }
        if (cbModelo.getSelectedItem() != "Selecione") {
            pesquisaModelo(cbModelo.getSelectedItem());
        }
        if (cbNumSerie.getSelectedItem() != "Selecione") {
            pesquisaNumSerie(cbNumSerie.getSelectedItem());
        }

        //PESQUISA ENTRE DATAS
        if (dataINI.getDate() != null && dataFIM.getDate() != null) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dataInicial = df.format(dataINI.getDate());
                String dataFim = df.format(dataFIM.getDate());

                pesquisaData(dataInicial, dataFim);
            } catch (Exception e) {
                System.out.println("Erro na data: " + e);
            }
        }

        // PESQUISAS COMPLEMENTARES
        if (cbEQUIP.getSelectedItem() != "Selecione" && cbMarca.getSelectedItem() != "Selecione" && cbModelo.getSelectedItem() != "Selecione") {
            pesquisaComplementar3(cbEQUIP.getSelectedItem(), cbMarca.getSelectedItem(), cbModelo.getSelectedItem());
        }

        if (cbEQUIP.getSelectedItem() != "Selecione" && cbMarca.getSelectedItem() != "Selecione") {
            pesquisaComplementar2(cbEQUIP.getSelectedItem(), cbMarca.getSelectedItem());
        }

        if (cbEQUIP.getSelectedItem() != "Selecione" && cbNumSerie.getSelectedItem() != "Selecione") {
            pesquisaComplementar1(cbEQUIP.getSelectedItem(), cbNumSerie.getSelectedItem());
        }

        if (cbEQUIP.getSelectedItem() != "Selecione" && cbModelo.getSelectedItem() != "Selecione") {
            pesquisaComplementar6(cbEQUIP.getSelectedItem(), cbModelo.getSelectedItem());
        }

        if (cbEQUIP.getSelectedItem() != "Selecione" && dataINI.getDate() != null && dataFIM.getDate() != null) {

            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dataInicial = df.format(dataINI.getDate());
                String dataFim = df.format(dataFIM.getDate());

                pesquisaDataEquipamento(cbEQUIP.getSelectedItem(), dataInicial, dataFim);
            } catch (Exception erro) {
                System.out.println("Erro pesquisaDataEquipamento: " + erro);
            }
        }
        if (cbEQUIP.getSelectedItem() != "Selecione" && cbMarca.getSelectedItem() != "Selecione" && dataINI.getDate() != null && dataFIM.getDate() != null) {

            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dataInicial = df.format(dataINI.getDate());
                String dataFim = df.format(dataFIM.getDate());

                pesquisaComplementar4(cbEQUIP.getSelectedItem(), cbMarca.getSelectedItem(), dataInicial, dataFim);
            } catch (Exception erro) {
                System.out.println("Erro pesquisaComplementar4: " + erro);
            }
        }

        if (cbEQUIP.getSelectedItem() != "Selecione" && cbMarca.getSelectedItem() != "Selecione" && cbModelo.getSelectedItem() != "Selecione"
                && dataINI.getDate() != null && dataFIM.getDate() != null) {

            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dataInicial = df.format(dataINI.getDate());
                String dataFim = df.format(dataFIM.getDate());

                pesquisaComplementar5(cbEQUIP.getSelectedItem(), cbMarca.getSelectedItem(), cbModelo.getSelectedItem(), dataInicial, dataFim);
            } catch (Exception erro) {
                System.out.println("Erro pesquisaComplementar5: " + erro);
            }
        }

    }//GEN-LAST:event_PesquisaEQUIPActionPerformed

    private void DeleteEQUIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEQUIPActionPerformed

        if (jTEquip.getSelectedRow() != -1) {

            equipamentoBEAN equip = new equipamentoBEAN();
            equipamentoDAO equipDAO = new equipamentoDAO();

            equip.setIDequipamento((int) jTEquip.getValueAt(jTEquip.getSelectedRow(), 0));
            equipDAO.delete(equip);

            entrada.setText("");
            txtEquip.setText("");
            txtMarca.setText("");
            txtModelo.setText("");
            txtNumSerie.setText("");
            dataAquis.setDate(null);

            leituraEquipamentos();
            JOptionPane.showMessageDialog(null, "Equipamento eliminado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Seleciona um produto para o eliminar!");
        }

    }//GEN-LAST:event_DeleteEQUIPActionPerformed

    private void anxEQUIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anxEQUIPActionPerformed

        docView doc = new docView();
        doc.setVisible(true);
        setVisible(true);

    }//GEN-LAST:event_anxEQUIPActionPerformed

    private void cbEQUIPAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbEQUIPAncestorAdded

        String sql = "SELECT DISTINCT equipamento FROM equipamento ORDER BY idequipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                cbEQUIP.removeItem(rs.getString("equipamento"));
                cbEQUIP.addItem(rs.getString("equipamento"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro listar equipamento: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_cbEQUIPAncestorAdded

    private void cbMarcaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbMarcaAncestorAdded

        String sql = "SELECT DISTINCT marca FROM equipamento ORDER BY idequipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                cbMarca.removeItem(rs.getString("marca"));
                cbMarca.addItem(rs.getString("marca"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro listar marca: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_cbMarcaAncestorAdded

    private void cbModeloAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbModeloAncestorAdded

        String sql = "select distinct modelo from equipamento ORDER BY idequipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                cbModelo.removeItem(rs.getString("modelo"));
                cbModelo.addItem(rs.getString("modelo"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro listar modelo: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_cbModeloAncestorAdded

    private void cbNumSerieAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbNumSerieAncestorAdded
        String sql = "SELECT numSerie FROM equipamento ORDER BY idequipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                cbNumSerie.removeItem(rs.getString("numSerie"));
                cbNumSerie.addItem(rs.getString("numSerie"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro listar numSerie: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cbNumSerieAncestorAdded

    private void printEQUIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printEQUIPActionPerformed

        try {
            MessageFormat header = new MessageFormat("Informação de Equipamentos");
            MessageFormat footer = new MessageFormat("Página{0, number, integer}");
            jTEquip.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao printar: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_printEQUIPActionPerformed

    private void saveHISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveHISTActionPerformed

        DefaultTableModel tHist = (DefaultTableModel) jTHist.getModel();

        Object[] dados = {userCB.getSelectedItem(), EquipCB.getSelectedItem(), estadoCB.getSelectedItem(), desc.getText(), DATA.getDate()};

        tHist.addRow(dados);

        userBEAN u = new userBEAN();
        equipamentoBEAN equip = new equipamentoBEAN();
        estadoBEAN estd = new estadoBEAN();
        historicoBEAN hist = new historicoBEAN();
        historicoDAO hDAO = new historicoDAO();

        u.setIDusers(userCB.getSelectedIndex());
        hist.setUser(u);

        equip.setIDequipamento(EquipCB.getSelectedIndex());
        hist.setEquipamento(equip);

        estd.setIDestado(estadoCB.getSelectedIndex());
        hist.setEstado(estd);

        hist.setAvaria(desc.getText());
        hist.setData(((JTextField) DATA.getDateEditor().getUiComponent()).getText());

        hDAO.create(hist);

        leituraHistorico();
        init();
    }//GEN-LAST:event_saveHISTActionPerformed

    private void anxEQUIP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anxEQUIP1ActionPerformed

        anxView anx = new anxView();
        anx.setVisible(true);
        setVisible(true);

    }//GEN-LAST:event_anxEQUIP1ActionPerformed

    private void pesquisaHISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaHISTActionPerformed
        if (searchUser.getSelectedItem() == "Selecione" && searchEquip.getSelectedItem() == "Selecione" && searchMarca.getSelectedItem() == "Selecione"
                && searchModelo.getSelectedItem() == "Selecione" && searchNumSerie.getSelectedItem() == "Selecione" && searchEstado.getSelectedItem() == "Selecione" && inicialData.getDate() == null && fimData.getDate() == null) {
            leituraHistorico();
        }

        // PESQUISA SIMPLES
        if (searchUser.getSelectedItem() != "Selecione") {
            pesquisaHistUser(searchUser.getSelectedItem());
        }
        if (searchEquip.getSelectedItem() != "Selecione") {
            pesquisaHistEquip(searchEquip.getSelectedItem());
        }
        if (searchMarca.getSelectedItem() != "Selecione") {
            pesquisaHistMarca(searchMarca.getSelectedItem());
        }
        if (searchModelo.getSelectedItem() != "Selecione") {
            PesquisaHistModelo(searchModelo.getSelectedItem());
        }
        if (searchNumSerie.getSelectedItem() != "Selecione") {
            PesquisaHistNumSerie(searchNumSerie.getSelectedItem());
        }
        if (searchEstado.getSelectedItem() != "Selecione") {
            pesquisaHistEstado(searchEstado.getSelectedItem());
        }

        // PESQUISA ENTRE DATAS
        if (inicialData.getDate() != null && fimData.getDate() != null) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dataInicial = df.format(inicialData.getDate());
                String dataFim = df.format(fimData.getDate());

                pesquisaDataHist(dataInicial, dataFim);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na Pesquisa entre datas: " + e);
            }
        }

        // PESQUISA COMPLEMENTAR: user && estado
        if (searchUser.getSelectedItem() != "Selecione" && searchEstado.getSelectedItem() != "Selecione") {
            pesquisaComplementarHist1(searchUser.getSelectedItem(), searchEstado.getSelectedItem());
        }

        // PESQUISA COMPLEMENTAR: user && data
        if (searchUser.getSelectedItem() != "Selecione" && inicialData.getDate() != null && fimData.getDate() != null) {

            try {
                String dataInicial = inicialData.getDate().toString();
                String dataFim = fimData.getDate().toString();

                pesquisaComplementarHist2(searchUser.getSelectedItem(), dataInicial, dataFim);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ErroPesquisaComplementar2: " + e);
            }
        }

        // PESQUISA COMPLEMENTAR: estado && data
        if (searchEstado.getSelectedItem() != "Selecione" && inicialData.getDate() != null && fimData.getDate() != null) {

            try {
                String dataInicial = inicialData.getDate().toString();
                String dataFim = fimData.getDate().toString();

                pesquisaComplementarHist3(searchEstado.getSelectedItem(), dataInicial, dataFim);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ErroPesquesiaComplementar3: " + e);
            }
        }

        // PESQUISA COMPLEMENTAR: equipamento && marca
        if (searchEquip.getSelectedItem() != "Selecione" && searchMarca.getSelectedItem() != "Selecione") {
            pesquisaComplementarHist4(searchEquip.getSelectedItem(), searchMarca.getSelectedItem());
        }

        // PESQUISA COMPLEMENTAR: equipamento && modelo
        if (searchEquip.getSelectedItem() != "Selecione" && searchModelo.getSelectedItem() != "Selecione") {
            pesquisaComplementarHist6(searchEquip.getSelectedItem(), searchModelo.getSelectedItem());
        }

        // PESQUISA COMPLEMENTAR: equipamento && marca && modelo
        if (searchEquip.getSelectedItem() != "Selecione" && searchMarca.getSelectedItem() != "Selecione" && searchModelo.getSelectedItem() != "Selecione") {
            pesquisaComplementarHist5(searchEquip.getSelectedItem(), searchMarca.getSelectedItem(), searchModelo.getSelectedItem());
        }

        // PESQUISA COMPLEMENTAR: user && estado && data
        if (searchEquip.getSelectedItem() != "Selecione" && searchEstado.getSelectedItem() != "Selecione" && inicialData.getDate() != null && fimData.getDate() != null) {

            try {
                String dataInicial = inicialData.getDate().toString();
                String dataFim = fimData.getDate().toString();
                
                pesquisaComplementarHist7(searchEquip.getSelectedItem(), searchEstado.getSelectedItem(), dataInicial, dataFim);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "ErroPesquesiaComplementar7: " + erro);
            }
        }

    }//GEN-LAST:event_pesquisaHISTActionPerformed

    private void deleteHISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteHISTActionPerformed

        if (jTHist.getSelectedRow() != -1) {
            historicoBEAN hist = new historicoBEAN();
            historicoDAO histDAO = new historicoDAO();

            hist.setIdhistorico((int) jTHist.getValueAt(jTHist.getSelectedRow(), 0));
            histDAO.delete(hist);

            JOptionPane.showMessageDialog(null, "Registo eliminado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para o eliminar");
        }

        leituraHistorico();
    }//GEN-LAST:event_deleteHISTActionPerformed

    private void printHISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printHISTActionPerformed

        try {
            MessageFormat header = new MessageFormat("Histórico");
            MessageFormat footer = new MessageFormat("Página {0, number, integer}");
            jTHist.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao printar: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_printHISTActionPerformed

    private void userCBAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_userCBAncestorAdded
        String sql = "SELECT * from users ORDER BY id";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                userCB.removeItem(rs.getInt("id") + " | " + rs.getString("nome"));
                userCB.addItem(rs.getInt("id") + " | " + rs.getString("nome"));
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ComboBox user: " + erro);
        }

    }//GEN-LAST:event_userCBAncestorAdded

    private void searchUserAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_searchUserAncestorAdded
        String sql = "SELECT nome FROM users ORDER BY id";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                searchUser.removeItem(rs.getString("nome"));
                searchUser.addItem(rs.getString("nome"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "SearchUser: " + erro);
        }
    }//GEN-LAST:event_searchUserAncestorAdded

    private void searchEquipAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_searchEquipAncestorAdded
        String sql = "SELECT equipamento FROM equipamento ORDER BY idequipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                searchEquip.removeItem(rs.getString("equipamento"));
                searchEquip.addItem(rs.getString("equipamento"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "SearchEquipamento: " + erro);
        }
    }//GEN-LAST:event_searchEquipAncestorAdded

    private void searchMarcaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_searchMarcaAncestorAdded
        String sql = "SELECT marca FROM equipamento ORDER BY idequipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                searchMarca.removeItem(rs.getString("marca"));
                searchMarca.addItem(rs.getString("marca"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "searchMarca: " + erro);
        }
    }//GEN-LAST:event_searchMarcaAncestorAdded

    private void searchModeloAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_searchModeloAncestorAdded
        String sql = "SELECT modelo FROM equipamento ORDER BY idequipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                searchModelo.removeItem(rs.getString("modelo"));
                searchModelo.addItem(rs.getString("modelo"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "searchModelo: " + erro);
        }
    }//GEN-LAST:event_searchModeloAncestorAdded

    private void searchNumSerieAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_searchNumSerieAncestorAdded
        String sql = "SELECT numSerie FROM equipamento ORDER BY idequipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                searchNumSerie.removeItem(rs.getString("numSerie"));
                searchNumSerie.addItem(rs.getString("numSerie"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "searchNumSerie: " + erro);
        }
    }//GEN-LAST:event_searchNumSerieAncestorAdded

    private void searchEstadoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_searchEstadoAncestorAdded
        String sql = "SELECT estado FROM estado ORDER BY idestado";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                searchEstado.removeItem(rs.getString("estado"));
                searchEstado.addItem(rs.getString("estado"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "searchEstado: " + erro);
        }
    }//GEN-LAST:event_searchEstadoAncestorAdded

    private void jTHistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTHistMouseClicked
        int row = jTHist.getSelectedRow();
        if (row == -1) {
            return;
        }

        String user = (String) jTHist.getValueAt(row, 1);
        userCB.setSelectedItem(user);

        String equip = (String) jTHist.getValueAt(row, 2);
        String marca = (String) jTHist.getValueAt(row, 3);
        String modelo = (String) jTHist.getValueAt(row, 4);
        String numSerie = (String) jTHist.getValueAt(row, 5);
        EquipCB.setSelectedItem(equip + " | " + marca + " | " + modelo + " | " + numSerie);

        String estado = (String) jTHist.getValueAt(row, 6);
        estadoCB.setSelectedItem(estado);

        desc.setText("");
        DATA.setDate(null);
    }//GEN-LAST:event_jTHistMouseClicked

    private void estadoCBAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_estadoCBAncestorAdded
        String sql = "select * from estado ORDER BY idestado";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                estadoCB.removeItem(rs.getInt("idestado") + " | " + rs.getString("estado"));
                estadoCB.addItem(rs.getInt("idestado") + " | " + rs.getString("estado"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro listar estado: " + erro, "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_estadoCBAncestorAdded

    private void EquipCBAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_EquipCBAncestorAdded
        String sql = "Select * from equipamento ORDER BY idequipamento";

        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                EquipCB.removeItem(rs.getInt("idequipamento") + "|" + rs.getString("equipamento") + " | " + rs.getString("marca") + " | " + rs.getString("modelo") + " | " + rs.getString("numSerie"));
                EquipCB.addItem(rs.getInt("idequipamento") + " | " + rs.getString("equipamento") + " | " + rs.getString("marca") + " | " + rs.getString("modelo") + " | " + rs.getString("numSerie"));
            }

        } catch (SQLException erro) {
            System.out.println("Erro guarda1: " + erro);
        }
    }//GEN-LAST:event_EquipCBAncestorAdded

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DATA;
    private javax.swing.JButton DeleteEQUIP;
    private javax.swing.JButton DeleteESTADO;
    private javax.swing.JButton DeleteUSER;
    private javax.swing.JButton DocEQUIP;
    private javax.swing.JComboBox<Object> EquipCB;
    private javax.swing.JButton PesquisaEQUIP;
    private javax.swing.JButton PesquisaUSER;
    private javax.swing.JButton SaveEquip;
    private javax.swing.JButton anxEQUIP;
    private javax.swing.JButton anxEQUIP1;
    private javax.swing.JComboBox<Object> cbEQUIP;
    private javax.swing.JComboBox<Object> cbMarca;
    private javax.swing.JComboBox<Object> cbModelo;
    private javax.swing.JComboBox<Object> cbNumSerie;
    private com.toedter.calendar.JDateChooser dataAquis;
    private com.toedter.calendar.JDateChooser dataFIM;
    private com.toedter.calendar.JDateChooser dataINI;
    private javax.swing.JButton deleteHIST;
    private javax.swing.JTextArea desc;
    private javax.swing.JButton docHIST;
    private javax.swing.JTextField entrada;
    private javax.swing.JTextField equipID;
    private javax.swing.JComboBox<Object> estadoCB;
    private javax.swing.JTextField estadoID;
    private com.toedter.calendar.JDateChooser fimData;
    private javax.swing.JTextField historicoID;
    private com.toedter.calendar.JDateChooser inicialData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTEquip;
    private javax.swing.JTable jTEstado;
    private javax.swing.JTable jTHist;
    private javax.swing.JTable jTUsers;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton pesquisaHIST;
    private javax.swing.JButton printEQUIP;
    private javax.swing.JButton printHIST;
    private javax.swing.JButton saveButtonEstado;
    private javax.swing.JButton saveButtonUser;
    private javax.swing.JButton saveHIST;
    private javax.swing.JComboBox<String> searchEquip;
    private javax.swing.JComboBox<String> searchEstado;
    private javax.swing.JComboBox<String> searchMarca;
    private javax.swing.JComboBox<String> searchModelo;
    private javax.swing.JComboBox<String> searchNumSerie;
    private javax.swing.JComboBox<String> searchUser;
    private javax.swing.JTextField txtEquip;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumSerie;
    private javax.swing.JComboBox<Object> userCB;
    private javax.swing.JTextField userID;
    private javax.swing.JTextField userSearch;
    // End of variables declaration//GEN-END:variables

    // Função que mostra os users na tabela que estao na DB e os que sao agora adicionados
    public void leituraUsers() {

        DefaultTableModel modelo = (DefaultTableModel) jTUsers.getModel();
        modelo.setNumRows(0);
        userDAO uD = new userDAO();

        for (userBEAN ub : uD.leitura()) {

            modelo.addRow(new Object[]{
                ub.getIDusers(),
                ub.getNome()
            });
        }
    }

    // Função que mostra os estados na tabela
    public void leituraEstados() {
        DefaultTableModel modelo = (DefaultTableModel) jTEstado.getModel();
        modelo.setNumRows(0);

        estadoDAO estdDAO = new estadoDAO();

        for (estadoBEAN estd : estdDAO.leitura()) {
            modelo.addRow(new Object[]{
                estd.getIDestado(),
                estd.getEstado()
            });
        }
    }

    public void leituraEquipamentos() {
        DefaultTableModel modelo = (DefaultTableModel) jTEquip.getModel();
        modelo.setNumRows(0);

        equipamentoDAO eDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : eDAO.leitura()) {
            modelo.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void leituraHistorico() {
        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN hist : hDAO.leitura()) {
            modelo.addRow(new Object[]{
                hist.getIdhistorico(),
                hist.getUser().getNome(),
                hist.getEquipamento().getEquipamento(),
                hist.getEquipamento().getMarca(),
                hist.getEquipamento().getModelo(),
                hist.getEquipamento().getNumSerie(),
                hist.getEstado().getEstado(),
                hist.getAvaria(),
                hist.getData()
            });
        }
    }

    public void pesquisaData(Object d1, Object d2) {

        DefaultTableModel modelo = (DefaultTableModel) jTEquip.getModel();
        modelo.setNumRows(0);
        equipamentoDAO eDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : eDAO.pesquisaData(d1, d2)) {
            modelo.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaDataHist(Object d1, Object d2) {

        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);
        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaData(d1, d2)) {
            modelo.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    public void pesquisaDataEquipamento(Object equipamento, Object d1, Object d2) {

        DefaultTableModel modelo = (DefaultTableModel) jTEquip.getModel();
        modelo.setNumRows(0);
        equipamentoDAO eDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : eDAO.pesquisaDataEquipamento(equipamento, d1, d2)) {
            modelo.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaUsers(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTUsers.getModel();
        modelo.setNumRows(0);
        userDAO uDAO = new userDAO();

        for (userBEAN u : uDAO.pesquisa(nome)) {

            modelo.addRow(new Object[]{
                u.getIDusers(),
                u.getNome()
            });
        }
    }

    public void pesquisaEquipamento(Object equipamento) {
        DefaultTableModel modeloEquip = (DefaultTableModel) jTEquip.getModel();
        modeloEquip.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisaSimplesEquipamento(equipamento)) {
            modeloEquip.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaMarca(Object marca) {
        DefaultTableModel modeloEquip = (DefaultTableModel) jTEquip.getModel();
        modeloEquip.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisaSimplesMarca(marca)) {
            modeloEquip.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaModelo(Object modelo) {
        DefaultTableModel model = (DefaultTableModel) jTEquip.getModel();
        model.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisaSimplesModelo(modelo)) {
            model.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaNumSerie(Object numSerie) {
        DefaultTableModel modeloEquip = (DefaultTableModel) jTEquip.getModel();
        modeloEquip.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisaSimplesNumSerie(numSerie)) {
            modeloEquip.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaComplementar6(Object equipamento, Object modelo) {
        DefaultTableModel model = (DefaultTableModel) jTEquip.getModel();
        model.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisa6(equipamento, modelo)) {
            model.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaComplementar5(Object equipamento, Object marca, Object modelo, Object d1, Object d2) {

        DefaultTableModel model = (DefaultTableModel) jTEquip.getModel();
        model.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisa5(equipamento, marca, modelo, d1, d2)) {
            model.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaComplementar4(Object equipamento, Object marca, Object d1, Object d2) {

        DefaultTableModel modelo = (DefaultTableModel) jTEquip.getModel();
        modelo.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisa4(equipamento, marca, d1, d2)) {
            modelo.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaComplementar3(Object equipamento, Object marca, Object modelo) {
        DefaultTableModel modeloEquip = (DefaultTableModel) jTEquip.getModel();
        modeloEquip.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisa1(equipamento, marca, modelo)) {
            modeloEquip.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaComplementar2(Object equipamento, Object marca) {
        DefaultTableModel modeloEquip = (DefaultTableModel) jTEquip.getModel();
        modeloEquip.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisa2(equipamento, marca)) {
            modeloEquip.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaComplementar1(Object equipamento, Object numSerie) {
        DefaultTableModel modeloEquip = (DefaultTableModel) jTEquip.getModel();
        modeloEquip.setNumRows(0);
        equipamentoDAO equipDAO = new equipamentoDAO();

        for (equipamentoBEAN equip : equipDAO.pesquisa3(equipamento, numSerie)) {
            modeloEquip.addRow(new Object[]{
                equip.getIDequipamento(),
                equip.getEquipamento(),
                equip.getMarca(),
                equip.getModelo(),
                equip.getNumSerie(),
                equip.getDatAquisi()
            });
        }
    }

    public void pesquisaHistUser(Object user) {
        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);
        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaSimplesUser(user)) {
            modelo.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    public void pesquisaHistEquip(Object equipamento) {
        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);
        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaSimplesEquip(equipamento)) {
            modelo.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    public void pesquisaHistMarca(Object marca) {
        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaSimplesMarca(marca)) {
            modelo.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }

    }

    private void PesquisaHistModelo(Object modelo) {
        DefaultTableModel model = (DefaultTableModel) jTHist.getModel();
        model.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaSimplesModelo(modelo)) {
            model.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    private void PesquisaHistNumSerie(Object numSerie) {
        DefaultTableModel model = (DefaultTableModel) jTHist.getModel();
        model.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaSimplesNumSerie(numSerie)) {
            model.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    private void pesquisaHistEstado(Object estado) {
        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaSimplesEstado(estado)) {
            modelo.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    private void pesquisaComplementarHist1(Object user, Object estado) {
        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaComplementar1(user, estado)) {
            modelo.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    private void pesquisaComplementarHist2(Object user, Object data1, Object data2) {
        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaComplementar2(user, data1, data2)) {
            modelo.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    private void pesquisaComplementarHist3(Object estado, Object data1, Object data2) {
        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaComplementar3(estado, data1, data2)) {
            modelo.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    private void pesquisaComplementarHist4(Object equipamento, Object marca) {
        DefaultTableModel modelo = (DefaultTableModel) jTHist.getModel();
        modelo.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaComplementar4(equipamento, marca)) {
            modelo.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    private void pesquisaComplementarHist5(Object equipamento, Object marca, Object modelo) {
        DefaultTableModel model = (DefaultTableModel) jTHist.getModel();
        model.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaComplementar5(equipamento, marca, modelo)) {
            model.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    private void pesquisaComplementarHist6(Object equipamento, Object modelo) {
        DefaultTableModel model = (DefaultTableModel) jTHist.getModel();
        model.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaComplementar6(equipamento, modelo)) {
            model.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }

    private void pesquisaComplementarHist7(Object user, Object estado, Object data1, Object data2) {
        DefaultTableModel model = (DefaultTableModel) jTHist.getModel();
        model.setNumRows(0);

        historicoDAO hDAO = new historicoDAO();

        for (historicoBEAN h : hDAO.pesquisaComplementar7(user, estado, data1, data2)) {
            model.addRow(new Object[]{
                h.getIdhistorico(),
                h.getUser().getNome(),
                h.getEquipamento().getEquipamento(),
                h.getEquipamento().getMarca(),
                h.getEquipamento().getModelo(),
                h.getEquipamento().getNumSerie(),
                h.getEstado().getEstado(),
                h.getAvaria(),
                h.getData()
            });
        }
    }
}
