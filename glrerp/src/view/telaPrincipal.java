package view;

import dao.ClienteDAO;
import dao.ItemDAO;

/**
 *
 * @author ruang
 */
public class telaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipal
     */
    public telaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jm_cliente = new javax.swing.JMenu();
        jm_cliente_visualizar = new javax.swing.JMenuItem();
        jm_cliente_cadastro = new javax.swing.JMenuItem();
        jm_fornecedor = new javax.swing.JMenu();
        jm_fornecedor_visualizar = new javax.swing.JMenuItem();
        jm_fornecedor_cadastro = new javax.swing.JMenuItem();
        jm_item = new javax.swing.JMenu();
        jm_item_visualizar = new javax.swing.JMenuItem();
        jm_item_cadastro = new javax.swing.JMenuItem();
        jm_producao = new javax.swing.JMenu();
        jm_producao_visualizar = new javax.swing.JMenuItem();
        jm_producao_cadastro = new javax.swing.JMenuItem();
        jm_vendas = new javax.swing.JMenu();
        jm_vendas_visualizar = new javax.swing.JMenuItem();
        jm_vendas_cadastro = new javax.swing.JMenuItem();
        jm_almox = new javax.swing.JMenu();
        jm_almox_visualizar = new javax.swing.JMenuItem();
        jm_almox_cadastro = new javax.swing.JMenuItem();
        jm_user = new javax.swing.JMenu();
        jm_user_visualizar = new javax.swing.JMenuItem();
        jm_user_cadastro = new javax.swing.JMenuItem();
        jm_ajuda = new javax.swing.JMenu();
        jm_ajuda_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(13, 71, 161));

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        jMenuBar2.setBackground(new java.awt.Color(13, 71, 161));
        jMenuBar2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar2.setBorderPainted(false);
        jMenuBar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jMenuBar2.setMinimumSize(new java.awt.Dimension(434, 35));
        jMenuBar2.setPreferredSize(new java.awt.Dimension(434, 35));

        jm_cliente.setBackground(new java.awt.Color(250, 250, 250));
        jm_cliente.setForeground(new java.awt.Color(255, 255, 255));
        jm_cliente.setText("Cliente");

        jm_cliente_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_cliente_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jm_cliente_visualizar.setText("Visualizar");
        jm_cliente_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_cliente_visualizarActionPerformed(evt);
            }
        });
        jm_cliente.add(jm_cliente_visualizar);

        jm_cliente_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_cliente_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        jm_cliente_cadastro.setText("Cadastro");
        jm_cliente_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_cliente_cadastroActionPerformed(evt);
            }
        });
        jm_cliente.add(jm_cliente_cadastro);

        jMenuBar2.add(jm_cliente);

        jm_fornecedor.setForeground(new java.awt.Color(255, 255, 255));
        jm_fornecedor.setText("Fornecedor");

        jm_fornecedor_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_fornecedor_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jm_fornecedor_visualizar.setText("Visualizar");
        jm_fornecedor.add(jm_fornecedor_visualizar);

        jm_fornecedor_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_fornecedor_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        jm_fornecedor_cadastro.setText("Cadastro");
        jm_fornecedor.add(jm_fornecedor_cadastro);

        jMenuBar2.add(jm_fornecedor);

        jm_item.setBackground(new java.awt.Color(13, 71, 161));
        jm_item.setForeground(new java.awt.Color(255, 255, 255));
        jm_item.setText("Item");

        jm_item_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_item_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jm_item_visualizar.setText("Visualizar");
        jm_item_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_item_visualizarActionPerformed(evt);
            }
        });
        jm_item.add(jm_item_visualizar);

        jm_item_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_item_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        jm_item_cadastro.setText("Cadastro");
        jm_item.add(jm_item_cadastro);

        jMenuBar2.add(jm_item);

        jm_producao.setBackground(new java.awt.Color(13, 71, 161));
        jm_producao.setForeground(new java.awt.Color(255, 255, 255));
        jm_producao.setText("Produção");

        jm_producao_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_producao_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jm_producao_visualizar.setText("Visualizar");
        jm_producao.add(jm_producao_visualizar);

        jm_producao_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_producao_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        jm_producao_cadastro.setText("Cadastro");
        jm_producao.add(jm_producao_cadastro);

        jMenuBar2.add(jm_producao);

        jm_vendas.setBackground(new java.awt.Color(13, 71, 161));
        jm_vendas.setForeground(new java.awt.Color(255, 255, 255));
        jm_vendas.setText("Vendas");

        jm_vendas_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_vendas_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jm_vendas_visualizar.setText("Visualizar");
        jm_vendas.add(jm_vendas_visualizar);

        jm_vendas_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_vendas_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        jm_vendas_cadastro.setText("Cadastro");
        jm_vendas.add(jm_vendas_cadastro);

        jMenuBar2.add(jm_vendas);

        jm_almox.setBackground(new java.awt.Color(13, 71, 161));
        jm_almox.setForeground(new java.awt.Color(255, 255, 255));
        jm_almox.setText("Almoxarifado");

        jm_almox_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_almox_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jm_almox_visualizar.setText("Visualizar");
        jm_almox.add(jm_almox_visualizar);

        jm_almox_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_almox_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        jm_almox_cadastro.setText("Cadastro");
        jm_almox.add(jm_almox_cadastro);

        jMenuBar2.add(jm_almox);

        jm_user.setBackground(new java.awt.Color(13, 71, 161));
        jm_user.setForeground(new java.awt.Color(255, 255, 255));
        jm_user.setText("Usuário");

        jm_user_visualizar.setBackground(new java.awt.Color(13, 71, 161));
        jm_user_visualizar.setForeground(new java.awt.Color(255, 255, 255));
        jm_user_visualizar.setText("Visualizar");
        jm_user.add(jm_user_visualizar);

        jm_user_cadastro.setBackground(new java.awt.Color(13, 71, 161));
        jm_user_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        jm_user_cadastro.setText("Cadastro");
        jm_user_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_user_cadastroActionPerformed(evt);
            }
        });
        jm_user.add(jm_user_cadastro);

        jMenuBar2.add(jm_user);

        jm_ajuda.setBackground(new java.awt.Color(13, 71, 161));
        jm_ajuda.setForeground(new java.awt.Color(255, 255, 255));
        jm_ajuda.setText("Ajuda");

        jm_ajuda_sair.setBackground(new java.awt.Color(13, 71, 161));
        jm_ajuda_sair.setForeground(new java.awt.Color(255, 255, 255));
        jm_ajuda_sair.setText("Sair");
        jm_ajuda_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_ajuda_sairActionPerformed(evt);
            }
        });
        jm_ajuda.add(jm_ajuda_sair);

        jMenuBar2.add(jm_ajuda);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jm_cliente_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_cliente_visualizarActionPerformed
        jif_Listagem_DAO jifVis_cliente = new jif_Listagem_DAO(new ClienteDAO(), new jff_Alterar_cliente());
        jDesktopPane1.add(jifVis_cliente);
        jifVis_cliente.setVisible(true);
    }//GEN-LAST:event_jm_cliente_visualizarActionPerformed

    private void jm_ajuda_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_ajuda_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jm_ajuda_sairActionPerformed

    private void jm_cliente_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_cliente_cadastroActionPerformed
        jif_Cadastro_cliente jif_cad_cliente = new jif_Cadastro_cliente();
        jDesktopPane1.add(jif_cad_cliente);
        jif_cad_cliente.setVisible(true);
    }//GEN-LAST:event_jm_cliente_cadastroActionPerformed

    private void jm_item_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_item_visualizarActionPerformed
        jif_Listagem_DAO jifVis_item = new jif_Listagem_DAO(new ItemDAO(), new jff_Alterar_item());
        jDesktopPane1.add(jifVis_item);
        jifVis_item.setVisible(true);
    }//GEN-LAST:event_jm_item_visualizarActionPerformed

    private void jm_user_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_user_cadastroActionPerformed

        jif_Cadastro_user jif_cad_user = new jif_Cadastro_user();
        jDesktopPane1.add(jif_cad_user);
        jif_cad_user.setVisible(true);
          // TODO add your handling code here:
    }//GEN-LAST:event_jm_user_cadastroActionPerformed

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
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jm_ajuda;
    private javax.swing.JMenuItem jm_ajuda_sair;
    private javax.swing.JMenu jm_almox;
    private javax.swing.JMenuItem jm_almox_cadastro;
    private javax.swing.JMenuItem jm_almox_visualizar;
    private javax.swing.JMenu jm_cliente;
    private javax.swing.JMenuItem jm_cliente_cadastro;
    private javax.swing.JMenuItem jm_cliente_visualizar;
    private javax.swing.JMenu jm_fornecedor;
    private javax.swing.JMenuItem jm_fornecedor_cadastro;
    private javax.swing.JMenuItem jm_fornecedor_visualizar;
    private javax.swing.JMenu jm_item;
    private javax.swing.JMenuItem jm_item_cadastro;
    private javax.swing.JMenuItem jm_item_visualizar;
    private javax.swing.JMenu jm_producao;
    private javax.swing.JMenuItem jm_producao_cadastro;
    private javax.swing.JMenuItem jm_producao_visualizar;
    private javax.swing.JMenu jm_user;
    private javax.swing.JMenuItem jm_user_cadastro;
    private javax.swing.JMenuItem jm_user_visualizar;
    private javax.swing.JMenu jm_vendas;
    private javax.swing.JMenuItem jm_vendas_cadastro;
    private javax.swing.JMenuItem jm_vendas_visualizar;
    // End of variables declaration//GEN-END:variables
}
