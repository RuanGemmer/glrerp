/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.ClienteDAO;
import entidade.Cliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruang
 */
public class jif_Visualizar_cliente extends javax.swing.JInternalFrame {

    private final ClienteDAO clienteDAO = new ClienteDAO();
    private ArrayList<Cliente> clientes = clienteDAO.consultarTodos("cliente");
    
    private DefaultTableModel tableModel;
    
    /**
     * Creates new form jif_Visualizar_cliente
     */
    public jif_Visualizar_cliente() {
        initComponents();
        this.tableModel = (DefaultTableModel) jTable1.getModel();
        this.getTableItems("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtf_Buscar = new javax.swing.JTextField();
        jbt_fechar = new javax.swing.JButton();
        jbt_visualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(238, 238, 238));
        setBorder(null);
        setTitle("Visualizar - Cliente");
        setPreferredSize(new java.awt.Dimension(960, 500));

        jTable1.setBackground(new java.awt.Color(250, 250, 250));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF/CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Busca:");

        jtf_Buscar.setEditable(false);
        jtf_Buscar.setBackground(new java.awt.Color(250, 250, 250));
        jtf_Buscar.setForeground(new java.awt.Color(0, 0, 0));

        jbt_fechar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_fechar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_fechar.setText("Fechar");
        jbt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_fecharActionPerformed(evt);
            }
        });

        jbt_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jbt_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jbt_visualizar.setText("Visualizar");
        jbt_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_visualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_visualizar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_fechar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_visualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jbt_fechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getTableItems(String termoBusca) {
        // Remove os itens da tabela
        this.tableModel.getDataVector().removeAllElements();
        this.tableModel.fireTableDataChanged();
        
        // filtra os novos itens
        ArrayList<String[]> newData = new ArrayList();
        for(Cliente cliente : clientes) {
            String[] data = {
                Integer.toString(cliente.getId()), 
                cliente.getNome(), 
                cliente.getCpf()
            };
            
            if(termoBusca.equals("")) {
                newData.add(data);
            } else if (data[2].contains(termoBusca)) {
                newData.add(data);
            }
        }
        
        for(String[] data : newData) {
            this.tableModel.addRow(data);
        }
    }
    
    private void jbt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_fecharActionPerformed
        this.dispose();

    }//GEN-LAST:event_jbt_fecharActionPerformed

    private void jbt_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_visualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt_visualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbt_fechar;
    private javax.swing.JButton jbt_visualizar;
    private javax.swing.JTextField jtf_Buscar;
    // End of variables declaration//GEN-END:variables
}
