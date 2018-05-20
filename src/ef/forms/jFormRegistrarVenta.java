package ef.forms;

import ef.adm.modelo.IMantenimientoAutosVendidosSQLOra;
import ef.adm.modelo.IMantenimientoClientesSQLOra;
import ef.adm.modelo.IMantenimientoRevisionesSQLOra;
import ef.adm.modelo.MantenimientoAutosVendidosAdm;
import ef.adm.modelo.MantenimientoClientesAdm;
import ef.adm.modelo.MantenimientoRevisionesAdm;
import ef.modelo.AutosVendidos;
import ef.modelo.Clientes;
import ef.modelo.Revisiones;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class jFormRegistrarVenta extends javax.swing.JFrame {

    DefaultTableModel modelo2 = new DefaultTableModel(null, new String[]{
        "Placa", "Marca", "Modelo", "Color", "Precio"});

    String codCliente, nomCliente, apellCliente, dniCliente, dirCliente,
            distCliente, telfCliente, nroPlacaAutoVen, marcaAutoVen,
            modeloAutoVen, colorAutoVen, precioAutoVen, aceiteRevision,
            filtroRevision, frenosRevision, otrosRevision, nroRevisionInsert, codigoVentaInsert;

    public jFormRegistrarVenta() {
        initComponents();

        IMantenimientoAutosVendidosSQLOra autoVenAdm = new MantenimientoAutosVendidosAdm();
        ArrayList<AutosVendidos> listaAutosVendidos = autoVenAdm.listarAutosVendidos();

        jTable3.putClientProperty("Terminate edit", Boolean.TRUE);
        for (int i = 0; i < listaAutosVendidos.size(); i++) {
            modelo2.addRow(new Object[]{
                listaAutosVendidos.get(i).getNro_placa(),
                listaAutosVendidos.get(i).getMarca(),
                listaAutosVendidos.get(i).getModelo(),
                listaAutosVendidos.get(i).getColor(),
                listaAutosVendidos.get(i).getPrecio(),
                listaAutosVendidos.get(i).getCod_cliente(),});

        }

        IMantenimientoRevisionesSQLOra revAdm = new MantenimientoRevisionesAdm();
        ArrayList<Revisiones> listaRevisiones = revAdm.listarRevisiones();
        int countNroRevision = listaRevisiones.size();
        int countCodigoVentaAuto = listaAutosVendidos.size();
        
        int codigoVentaAuto = Integer.valueOf(listaAutosVendidos.get(1).getCodigo_venta());
        int countCodigoVentaInsert = codigoVentaAuto + 1;
        codigoVentaInsert = String.valueOf(countCodigoVentaInsert);

        int nroRevision = Integer.valueOf(listaRevisiones.get(countNroRevision - 1).getNro_revision());
        int countNroRevisionInsert = nroRevision + 1;
        nroRevisionInsert = String.valueOf(countNroRevisionInsert);
        System.out.println("Nro de revision: " + countCodigoVentaInsert);

        ListSelectionModel model = jTable3.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {

                if (!model.isSelectionEmpty()) {
                    int selectRow = model.getMinSelectionIndex();
                    //JOptionPane.showMessageDialog(null, "Select Fila: " + selectRow);
                    int selectedRow = jTable3.getSelectedRow();
                    String setToTextField = new String();
                    for (int i = 0; i < jTable3.getColumnCount(); i++) {

                    }

                }

            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jsTClientes1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        }
        ;
        jLabel13 = new javax.swing.JLabel();
        txtAceiteRevision = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFiltroRevision = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtFrenosRevision = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtOtrosRevision = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNomCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtApellCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDirCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDistCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTelCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("MS Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Venta de Autos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(234, 234, 234))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Seleccione el auto a vender:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Datos del Auto");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, -1, -1));

        jsTClientes1.setBackground(new java.awt.Color(51, 51, 51));
        jsTClientes1.setBorder(null);
        jsTClientes1.setForeground(new java.awt.Color(51, 51, 51));

        jTable3.setModel(modelo2);
        jTable3.setBackground(new java.awt.Color(255, 255, 255));
        jTable3.setForeground(new java.awt.Color(51, 51, 51));
        jTable3.setModel(modelo2);
        jTable3.setGridColor(new java.awt.Color(0, 0, 0));
        jTable3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jsTClientes1.setViewportView(jTable3);

        jPanel3.add(jsTClientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 640, 140));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Aceite");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        jPanel3.add(txtAceiteRevision, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 60, 27));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Filtro");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));
        jPanel3.add(txtFiltroRevision, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 60, 27));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Frenos");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));
        jPanel3.add(txtFrenosRevision, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 60, 27));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Otros");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));
        jPanel3.add(txtOtrosRevision, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 200, 27));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 10, 40));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 10, 40));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 10, 40));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 660, 230));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Datos del Cliente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Codigo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, -1));
        jPanel1.add(txtCodCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 120, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel1.add(txtNomCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 120, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Apellidos");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jPanel1.add(txtApellCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 120, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("DNI");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel1.add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 120, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Direccion");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));
        jPanel1.add(txtDirCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 130, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Distrito");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));
        jPanel1.add(txtDistCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 130, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Telefono");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));
        jPanel1.add(txtTelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 130, 30));

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("max 8 carácteres");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, 20));

        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("max 20 carácteres");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, 20));

        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("max 20 carácteres");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, 20));

        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("max 20 carácteres");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, 20));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 20, 180));

        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setText("max 6 carácteres");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 25, -1, 20));

        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("max 30 carácteres");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, 20));

        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("max 20 carácteres");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, -1, 20));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 180));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/add-icon.png"))); // NOI18N
        jButton1.setText("Vender");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 465, 120, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edit_clear1.png"))); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 465, 120, 30));

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Menu Principal");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 102, 204));
        jButton4.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("X");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        txtCodCliente.setText("");
        txtNomCliente.setText("");
        txtApellCliente.setText("");
        txtDniCliente.setText("");
        txtDirCliente.setText("");
        txtDistCliente.setText("");
        txtTelCliente.setText("");
        txtAceiteRevision.setText("");
        txtFiltroRevision.setText("");
        txtFrenosRevision.setText("");
        txtOtrosRevision.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        codCliente = txtCodCliente.getText();
        nomCliente = txtNomCliente.getText();
        apellCliente = txtApellCliente.getText();
        dniCliente = txtDniCliente.getText();
        dirCliente = txtDirCliente.getText();
        distCliente = txtDistCliente.getText();
        telfCliente = txtTelCliente.getText();

        nroPlacaAutoVen = (String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 0))));
        marcaAutoVen = (String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 1))));
        modeloAutoVen = (String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 2))));
        colorAutoVen = (String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 3))));
        precioAutoVen = (String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 4))));

        aceiteRevision = txtAceiteRevision.getText();
        filtroRevision = txtFiltroRevision.getText();
        frenosRevision = txtFrenosRevision.getText();
        otrosRevision = txtOtrosRevision.getText();

        // Insert de Cliente
        Clientes addClientes1 = new Clientes();
        addClientes1.setCod_cliente(codCliente);
        addClientes1.setNombre(nomCliente);
        addClientes1.setApellido(apellCliente);
        addClientes1.setDni(dniCliente);
        addClientes1.setDireccion(dirCliente);
        addClientes1.setDistrito(distCliente);
        addClientes1.setTelefono(telfCliente);

        IMantenimientoClientesSQLOra clienteAdm = new MantenimientoClientesAdm();
        clienteAdm.addClientes(addClientes1);

        // Insert de Auto vendido
        AutosVendidos addAutosVendidos1 = new AutosVendidos();
        addAutosVendidos1.setCodigo_venta(codigoVentaInsert);
        addAutosVendidos1.setNro_placa(nroPlacaAutoVen);
        addAutosVendidos1.setMarca(marcaAutoVen);
        addAutosVendidos1.setModelo(modeloAutoVen);
        addAutosVendidos1.setColor(colorAutoVen);
        addAutosVendidos1.setPrecio(precioAutoVen);
        addAutosVendidos1.setCod_cliente(codCliente);

        IMantenimientoAutosVendidosSQLOra autoVenAdm = new MantenimientoAutosVendidosAdm();

        autoVenAdm.addAutosVendidos(addAutosVendidos1);

        // Insert de revision
        Revisiones addRevisiones1 = new Revisiones();
        addRevisiones1.setNro_revision(nroRevisionInsert);
        addRevisiones1.setCambio_aceite(aceiteRevision);
        addRevisiones1.setCambio_filtro(filtroRevision);
        addRevisiones1.setRevision_frenos(frenosRevision);
        addRevisiones1.setOtros(otrosRevision);
        addRevisiones1.setNro_placa(codigoVentaInsert);

        IMantenimientoRevisionesSQLOra revAdm = new MantenimientoRevisionesAdm();

        revAdm.addRevisiones(addRevisiones1);

        JOptionPane.showMessageDialog(null, "Venta registrado con exito!");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jFormMenuPrincipal menuPrin1 = new jFormMenuPrincipal();
        dispose();
        menuPrin1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "Realmente salir?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.out.println("Regreso");
        } else if (response == JOptionPane.YES_OPTION) {
            System.out.println("Ha salido...");
            System.exit(0);
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.out.println("Ha cerrado boton");
        }
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(jFormRegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFormRegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFormRegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFormRegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFormRegistrarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable3;
    private javax.swing.JScrollPane jsTClientes1;
    private javax.swing.JTextField txtAceiteRevision;
    private javax.swing.JTextField txtApellCliente;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtDirCliente;
    private javax.swing.JTextField txtDistCliente;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtFiltroRevision;
    private javax.swing.JTextField txtFrenosRevision;
    private javax.swing.JTextField txtNomCliente;
    private javax.swing.JTextField txtOtrosRevision;
    private javax.swing.JTextField txtTelCliente;
    // End of variables declaration//GEN-END:variables
}
