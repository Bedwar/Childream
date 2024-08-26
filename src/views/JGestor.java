/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.*;
import CadastroDAL.ModulodeConexao;
import javax.swing.JOptionPane;

/**
 *
 * @author beatr
 */
public class JGestor extends javax.swing.JInternalFrame {

    /**
     * Creates new form JProfessor
     */
    Connection conectar = null;
    PreparedStatement pcc = null;
    ResultSet rs;

    public JGestor() {
        initComponents();
        conectar = ModulodeConexao.conexao();
    }

    private void limparcampo() {
        txtNome.setText(null);
        txtIda.setText(null);
        txtEnd.setText(null);
    }

    private void novo() {
        String sql = "insert into criança(nomecri,idade,ender) values (?,?,?)";

        try {
            // ID AUTOINCREMENT
            pcc = conectar.prepareStatement(sql);
            pcc.setString(1, txtNome.getText());
            pcc.setString(2, txtIda.getText());
            pcc.setString(3, txtEnd.getText());

            if ((txtNome.getText().isEmpty()) || (txtIda.getText().isEmpty()) || (txtEnd.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Insira todos os campos");
            }
            int adc = pcc.executeUpdate();

            if (adc > 0) {
                JOptionPane.showMessageDialog(null, "Adicionado");
                limparcampo();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update criança set nomecri=?,idade=?,ender=? where idcri=?";
        try {
            pcc = conectar.prepareStatement(sql);
            pcc.setString(1, txtNome.getText());
            pcc.setString(2, txtIda.getText());
            pcc.setString(3, txtEnd.getText());
            pcc.setString(4, txtID.getText());
            pcc.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado");
            limparcampo();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void ver() {
        String sql = "select * from criança where idcri=?";
        try {
            pcc = conectar.prepareStatement(sql);
            pcc.setString(1, txtID.getText());
            rs = pcc.executeQuery();

            if (rs.next()) {
                txtNome.setText(rs.getString(4));
                txtIda.setText(rs.getString(2));
                txtEnd.setText(rs.getString(3));

            } else {
                JOptionPane.showMessageDialog(null, "não cadastrado");
                limparcampo();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void delete() {

        int del = JOptionPane.showConfirmDialog(null, "Excluir?");

        if (del == JOptionPane.YES_OPTION) {
            String sql = "delete from criança where idcri=?";

            try {
                pcc = conectar.prepareStatement(sql);
                pcc.setString(1, txtID.getText());
               pcc.executeUpdate();
               if(del>0){
               JOptionPane.showMessageDialog(null, "Removido");
               limparcampo();
               }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btVer = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtIda = new javax.swing.JTextField();
        txtEnd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastrar Criança");
        setPreferredSize(new java.awt.Dimension(570, 473));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Idade");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Endereço");

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        btNovo.setToolTipText("Novo");
        btNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btEditar.setToolTipText("Editar");
        btEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view.png"))); // NOI18N
        btVer.setToolTipText("Ver");
        btVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerActionPerformed(evt);
            }
        });

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btDelete.setToolTipText("Delete");
        btDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("ID");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel8.setText("Deletar");

        jLabel7.setText("Pesquisar");

        jLabel6.setText("Alterar");

        jLabel5.setText("Criar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel1)))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome)
                                    .addComponent(txtIda)
                                    .addComponent(txtEnd)
                                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btVer, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(78, 78, 78)
                .addComponent(jLabel6)
                .addGap(62, 62, 62)
                .addComponent(jLabel7)
                .addGap(59, 59, 59)
                .addComponent(jLabel8)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btVer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        setBounds(0, 0, 570, 473);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerActionPerformed
        // TODO add your handling code here:
        ver();
    }//GEN-LAST:event_btVerActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        novo();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIda;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
