package ef.forms;

import ef.adm.modelo.IMantenimientoAutosVendidosSQLOra;
import ef.adm.modelo.MantenimientoAutosVendidosAdm;
import ef.modelo.AutosVendidos;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class jFormAdmAutoVendido extends javax.swing.JFrame {

    DefaultTableModel modelo2 = new DefaultTableModel(null, new String[]{
        "Placa", "Marca", "Modelo", "Color", "Precio", "Cliente"});
    boolean estado_txtFields = true;

    boolean funcEstado_txts(boolean estadoTxts) {
        boolean estado_txts = estadoTxts;
        if (estado_txts == true) {
            txtNroPlaca.setEnabled(true);
            txtMarcaAutoVen.setEnabled(true);
            txtModeloAutoVen.setEnabled(true);
            txtColorAutoVen.setEnabled(true);
            txtPrecioAutoVen.setEnabled(true);
            txtClienteAutoVen.setEnabled(true);

            txtNroPlaca.setText("");
            txtMarcaAutoVen.setText("");
            txtModeloAutoVen.setText("");
            txtColorAutoVen.setText("");
            txtPrecioAutoVen.setText("");
            txtClienteAutoVen.setText("");

            estado_txtFields = true;
        } else {
            txtNroPlaca.setEnabled(false);
            txtMarcaAutoVen.setEnabled(false);
            txtModeloAutoVen.setEnabled(false);
            txtColorAutoVen.setEnabled(false);
            txtPrecioAutoVen.setEnabled(false);
            txtClienteAutoVen.setEnabled(false);

            estado_txtFields = false;

        }

        return estado_txts;
    }

    public jFormAdmAutoVendido() {
        initComponents();

        IMantenimientoAutosVendidosSQLOra autoVenAdm = new MantenimientoAutosVendidosAdm();
        ArrayList<AutosVendidos> listaAutosVendidos = autoVenAdm.listarAutosVendidos();

        jTable3.putClientProperty("Terminate edit", Boolean.TRUE);
        for (int i = 0; i < listaAutosVendidos.size(); i++) {
            modelo2.addRow(new Object[]{
                listaAutosVendidos.get(i).getNro_placa(),
                listaAutosVendidos.get(i).getModelo(),
                listaAutosVendidos.get(i).getMarca(),
                listaAutosVendidos.get(i).getColor(),
                listaAutosVendidos.get(i).getPrecio(),
                listaAutosVendidos.get(i).getCod_cliente(),});

        }

        btnEditar.setEnabled(false);
        txtAreaLogs.setText("Bienvenido: \nAgregue nuevas Autos Vendidos o seleccione uno de la tabla...\n"
                + "En el campo cliente agregar el codigo que corresponde (Ej: C1001)");
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
                    // Finally set this to your JTextField.
                    txtNroPlaca.setText(String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 0))));
                    txtMarcaAutoVen.setText(String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 1))));
                    txtModeloAutoVen.setText(String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 2))));
                    txtColorAutoVen.setText(String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 3))));
                    txtPrecioAutoVen.setText(String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 4))));
                    txtClienteAutoVen.setText(String.valueOf((jTable3.getValueAt(jTable3.getSelectedRow(), 5))));

                    funcEstado_txts(false);
                    System.out.println(" " + txtNroPlaca.getText());
                    System.out.println("" + txtMarcaAutoVen.getText());
                    System.out.println("" + txtModeloAutoVen.getText());
                    System.out.println("" + txtColorAutoVen.getText());
                    System.out.println("" + txtPrecioAutoVen.getText());
                    System.out.println("" + txtClienteAutoVen.getText());
                    btnEditar.setEnabled(true);
                    btnRegistrar.setEnabled(false);
                    txtAreaLogs.setText("Bienvenido: \nEditar o eliminar el registro seleccionado...");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaLogs = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNroPlaca = new javax.swing.JTextField();
        txtClienteAutoVen = new javax.swing.JTextField();
        txtMarcaAutoVen = new javax.swing.JTextField();
        txtModeloAutoVen = new javax.swing.JTextField();
        txtColorAutoVen = new javax.swing.JTextField();
        txtPrecioAutoVen = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jsTClientes1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        }
        ;
        jButton2 = new javax.swing.JButton();
        jsTProducto = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        }
        ;
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("MS Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Mantenimiento Tabla Autos Vendidos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Placa");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 70, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Marca");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Modelo");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Color");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/add-icon.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnRegistrar.setFocusable(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 367, 109, -1));

        btnEditar.setBackground(new java.awt.Color(102, 102, 102));
        btnEditar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edituser1.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnEditar.setFocusable(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 367, 109, -1));

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/deleteuser1.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 367, 109, -1));

        btnLimpiar.setBackground(new java.awt.Color(102, 102, 102));
        btnLimpiar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edit_clear1.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel5.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 367, 105, -1));

        txtAreaLogs.setEditable(false);
        txtAreaLogs.setColumns(20);
        txtAreaLogs.setRows(5);
        txtAreaLogs.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaLogs);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 405, 492, 100));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Precio");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Cliente");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
        jPanel5.add(txtNroPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 220, 27));
        jPanel5.add(txtClienteAutoVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 220, 27));
        jPanel5.add(txtMarcaAutoVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 220, 27));
        jPanel5.add(txtModeloAutoVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 220, 27));
        jPanel5.add(txtColorAutoVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 220, 27));
        jPanel5.add(txtPrecioAutoVen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 220, 27));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
        );

        jPanel3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 52, 42));
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 26, -1, 212));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setForeground(new java.awt.Color(51, 51, 51));

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsTClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jsTClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 580, -1));

        jButton2.setBackground(new java.awt.Color(0, 102, 255));
        jButton2.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Menu Principal");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 134, 46));

        jsTProducto.setBackground(new java.awt.Color(51, 51, 51));
        jsTProducto.setBorder(null);
        jsTProducto.setForeground(new java.awt.Color(51, 51, 51));

        jTable2.setModel(modelo2);
        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(modelo2);
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jsTProducto.setViewportView(jTable2);

        jPanel3.add(jsTProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 244, 2, 280));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/ProductosAdd.png"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (estado_txtFields == true) {

            String nroPlacaAutoVen = txtNroPlaca.getText();
            String marcaAutoVen = txtMarcaAutoVen.getText();
            String modeloAutoVen = txtModeloAutoVen.getText();
            String colorAutoVen = txtColorAutoVen.getText();
            String precioAutoVen = txtPrecioAutoVen.getText();
            String clienteAutoVen = txtClienteAutoVen.getText();

            AutosVendidos addAutosVendidos1 = new AutosVendidos();
            addAutosVendidos1.setNro_placa(nroPlacaAutoVen);
            addAutosVendidos1.setMarca(marcaAutoVen);
            addAutosVendidos1.setModelo(modeloAutoVen);
            addAutosVendidos1.setColor(colorAutoVen);
            addAutosVendidos1.setPrecio(precioAutoVen);
            addAutosVendidos1.setCod_cliente(clienteAutoVen);

            IMantenimientoAutosVendidosSQLOra autoVenAdm = new MantenimientoAutosVendidosAdm();

            autoVenAdm.addAutosVendidos(addAutosVendidos1);
            System.out.println(" " + nroPlacaAutoVen);
            System.out.println("" + marcaAutoVen);
            System.out.println("" + modeloAutoVen);
            System.out.println("" + colorAutoVen);
            System.out.println("" + precioAutoVen);
            System.out.println("" + clienteAutoVen);

            System.out.println("Se agrega nuevo registro");
            ArrayList<AutosVendidos> listaAutosVendidos = autoVenAdm.listarAutosVendidos();
            modelo2.setRowCount(0);

            for (int i = 0; i < listaAutosVendidos.size(); i++) {
                modelo2.addRow(new Object[]{
                    listaAutosVendidos.get(i).getNro_placa(),
                    listaAutosVendidos.get(i).getModelo(),
                    listaAutosVendidos.get(i).getMarca(),
                    listaAutosVendidos.get(i).getColor(),
                    listaAutosVendidos.get(i).getPrecio(),
                    listaAutosVendidos.get(i).getCod_cliente(),});

            }

            ListSelectionModel model = jTable3.getSelectionModel();
            funcEstado_txts(true);
            txtAreaLogs.setText("Bienvenido: \nAgregue nuevas Autos Vendidos o seleccione uno de la tabla...\n"
                    + "En el campo cliente agregar el codigo que corresponde (Ej: C1001)");
            JOptionPane.showMessageDialog(null, "Clientes registrado con exito!");

        } else {
            System.out.println("Cambiando Modo");
            JOptionPane.showMessageDialog(null, "Agregue nuevos registros");
            funcEstado_txts(true);

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (estado_txtFields == false) {
            JOptionPane.showMessageDialog(null, "Actualice los campos y luego click en Editar");
            txtNroPlaca.setEnabled(false);
            txtMarcaAutoVen.setEnabled(true);
            txtModeloAutoVen.setEnabled(true);
            txtColorAutoVen.setEnabled(true);
            txtPrecioAutoVen.setEnabled(true);
            txtClienteAutoVen.setEnabled(true);

            estado_txtFields = true;
            btnRegistrar.setEnabled(false);

            txtAreaLogs.setText("Bienvenido: \nModicar registro, actualice campos y luego click en Editar...");
        } else {
            String nroPlacaAutoVen = txtNroPlaca.getText();
            String marcaAutoVen = txtMarcaAutoVen.getText();
            String modeloAutoVen = txtModeloAutoVen.getText();
            String colorAutoVen = txtColorAutoVen.getText();
            String precioAutoVen = txtPrecioAutoVen.getText();
            String clienteAutoVen = txtClienteAutoVen.getText();

            AutosVendidos addAutosVendidos1 = new AutosVendidos();
            addAutosVendidos1.setNro_placa(nroPlacaAutoVen);
            addAutosVendidos1.setMarca(marcaAutoVen);
            addAutosVendidos1.setModelo(modeloAutoVen);
            addAutosVendidos1.setColor(colorAutoVen);
            addAutosVendidos1.setPrecio(precioAutoVen);
            addAutosVendidos1.setCod_cliente(clienteAutoVen);

            IMantenimientoAutosVendidosSQLOra autoVenAdm = new MantenimientoAutosVendidosAdm();

            autoVenAdm.updateAutosVendidos(addAutosVendidos1);

            ArrayList<AutosVendidos> listaAutosVendidos = autoVenAdm.listarAutosVendidos();

            modelo2.setRowCount(0);

            for (int i = 0; i < listaAutosVendidos.size(); i++) {
                modelo2.addRow(new Object[]{
                    listaAutosVendidos.get(i).getNro_placa(),
                    listaAutosVendidos.get(i).getModelo(),
                    listaAutosVendidos.get(i).getMarca(),
                    listaAutosVendidos.get(i).getColor(),
                    listaAutosVendidos.get(i).getPrecio(),
                    listaAutosVendidos.get(i).getCod_cliente(),});

            }

            ListSelectionModel model = jTable3.getSelectionModel();
            System.out.println(" " + nroPlacaAutoVen);
            System.out.println("" + marcaAutoVen);
            System.out.println("" + modeloAutoVen);
            System.out.println("" + colorAutoVen);
            System.out.println("" + precioAutoVen);
            System.out.println("" + clienteAutoVen);

            JOptionPane.showMessageDialog(null, "El registro se ha actualizado con exito");
            btnRegistrar.setEnabled(true);
            funcEstado_txts(true);
            txtAreaLogs.setText("Bienvenido: \nAgregue nuevas Autos Vendidos o seleccione uno de la tabla...\n"
                    + "En el campo cliente agregar el codigo que corresponde (Ej: C1001)");

        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        if (estado_txtFields == false) {

            int response = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar el registro: " + txtNroPlaca.getText(), "Eliminar Registro",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                System.out.println("Regreso");
                txtAreaLogs.setText("Bienvenido: \nSe va a eliminar el registro...");
            } else if (response == JOptionPane.YES_OPTION) {
                System.out.println("Registro eliminado...");
                String nroPlacaAutoVen = txtNroPlaca.getText();
                AutosVendidos addAutosVendidos1 = new AutosVendidos();
                addAutosVendidos1.setNro_placa(nroPlacaAutoVen);

                IMantenimientoAutosVendidosSQLOra autoVenAdm = new MantenimientoAutosVendidosAdm();
                autoVenAdm.deleteAutosVendidos(addAutosVendidos1);

                ArrayList<AutosVendidos> listaAutosVendidos = autoVenAdm.listarAutosVendidos();

                modelo2.setRowCount(0);

                for (int i = 0; i < listaAutosVendidos.size(); i++) {
                    modelo2.addRow(new Object[]{
                        listaAutosVendidos.get(i).getNro_placa(),
                        listaAutosVendidos.get(i).getModelo(),
                        listaAutosVendidos.get(i).getMarca(),
                        listaAutosVendidos.get(i).getColor(),
                        listaAutosVendidos.get(i).getPrecio(),
                        listaAutosVendidos.get(i).getCod_cliente(),});

                }

                ListSelectionModel model = jTable3.getSelectionModel();
                JOptionPane.showMessageDialog(null, "El registro se ha eliminado con exito");
                funcEstado_txts(true);
                btnRegistrar.setEnabled(true);
                txtAreaLogs.setText("Bienvenido: \nAgregue nuevas Autos Vendidos o seleccione uno de la tabla...\n"
                        + "En el campo cliente agregar el codigo que corresponde (Ej: C1001)");

            } else if (response == JOptionPane.CLOSED_OPTION) {
                System.out.println("Ha cerrado boton");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Seleccion un registro ha eliminar");

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        funcEstado_txts(true);
        btnEditar.setEnabled(false);
        btnRegistrar.setEnabled(true);
        txtAreaLogs.setText("Bienvenido: \nAgregue nuevas Autos Vendidos o seleccione uno de la tabla...\n"
                + "En el campo cliente agregar el codigo que corresponde (Ej: C1001)");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jFormMenuPrincipal menuPrin1 = new jFormMenuPrincipal();
        dispose();
        menuPrin1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(jFormAdmAutoVendido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFormAdmAutoVendido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFormAdmAutoVendido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFormAdmAutoVendido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFormAdmAutoVendido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JScrollPane jsTClientes1;
    private javax.swing.JScrollPane jsTProducto;
    private javax.swing.JTextArea txtAreaLogs;
    private javax.swing.JTextField txtClienteAutoVen;
    private javax.swing.JTextField txtColorAutoVen;
    private javax.swing.JTextField txtMarcaAutoVen;
    private javax.swing.JTextField txtModeloAutoVen;
    private javax.swing.JTextField txtNroPlaca;
    private javax.swing.JTextField txtPrecioAutoVen;
    // End of variables declaration//GEN-END:variables
}
