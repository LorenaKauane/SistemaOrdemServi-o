/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaOrdemServico.View;

import br.com.SistemaOrdemServico.Controller.cadastroOrdem;
import br.com.SistemaOrdemServico.DAO.OrdemDAO;
import br.com.SistemaOrdemServico.Entidades.OrdemServico;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author IAGO
 */
public class TelaBuscaOrdem extends javax.swing.JDialog {

    cadastroOrdem cadastro = new cadastroOrdem();

    public TelaBuscaOrdem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public void verifica() {
        deletar.setEnabled(true);
    }

    public void mostrarDados() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        OrdemDAO ordemDao = new OrdemDAO();

        List<OrdemServico> lista = ordemDao.listar();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi encontrado, verifique se está cadastrado!");
        } else {
            for (OrdemServico o : ordemDao.listar()) {
                /*Adicionando os dados as linhas da minha JTable*/
                modelo.addRow(new Object[]{
                    o.getIdOrdemServico(),
                    o.getCliente().getNome(),
                    o.getCliente().getCpf(),
                    o.getFuncionario().getNome(),
                    o.getServico().getNome(),
                    o.getSituacao(),
                    o.getOqueFoiRealizado(),
                    o.getObjetoSQL(),
                    o.getValorTotal()

                });
            }
        }

    }

    public void mostrarPesquisa(String campo, String campoPesquisa) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        OrdemDAO ordemDao = new OrdemDAO();

        List<OrdemServico> lista = ordemDao.pesquisa(campo, campoPesquisa);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi encontrado, verifique se está cadastrado!");
        } else {
            for (OrdemServico o : lista) {
                /*Adicionando os dados as linhas da minha JTable*/
                modelo.addRow(new Object[]{
                    o.getIdOrdemServico(),
                    o.getCliente().getNome(),
                    o.getCliente().getCpf(),
                    o.getFuncionario().getNome(),
                    o.getServico().getNome(),
                    o.getSituacao(),
                    o.getOqueFoiRealizado(),
                    o.getObjetoSQL(),
                    o.getValorTotal()

                });
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pesquisar = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        adicionar = new javax.swing.JButton();
        deletar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        comboPesquisa = new javax.swing.JComboBox<>();
        btnPesquisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Busca Ordem");

        adicionar.setText("Adicionar!");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        deletar.setText("Deletar");
        deletar.setEnabled(false);
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        jLabel1.setText("Pesquisar");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdOrdem", "Nome do Cliente", "CPF", "Nome do Funcionario", "Tipo do serviço", "Situação", "Trabalho realizado", "Data do cadastro", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione!", "NOME CLIENTE", "CPF CLIENTE", "NOME FUNCIONARIO", "NUMERO DA ORDEM", "TODOS" }));
        comboPesquisa.setToolTipText("");
        comboPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPesquisaActionPerformed(evt);
            }
        });

        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                    .addComponent(pesquisar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed

        TelaOS tela = new TelaOS(this, true);
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_adicionarActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed

        /*Quando o usuario selecionar um item na JTable capturo apenas o ID*/
        int id = (int) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);

        int i = JOptionPane.showConfirmDialog(this, "Certeza que deseja excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {

            String resultado = cadastro.deletar(id);

            JOptionPane.showMessageDialog(this, resultado);
            /*Atualizando a Jtable*/
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setNumRows(0);
            mostrarDados();
        }

    }//GEN-LAST:event_deletarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        verifica();
    }//GEN-LAST:event_tabelaMouseClicked

    private void comboPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPesquisaActionPerformed
        pesquisar.setFormatterFactory(null); // Limpando o campo formatado
        pesquisar.setText(null);
        if (comboPesquisa.getSelectedIndex() == 2) {
            MaskFormatter cpf;
            try {
                cpf = new MaskFormatter("###.###.###-##");
                pesquisar.setFormatterFactory(new DefaultFormatterFactory(cpf));
                pesquisar.setEnabled(true);
            } catch (ParseException ex) {
                Logger.getLogger(TelaCadastroClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*Else responsavel por inativar o campo formatter*/
        } else if (comboPesquisa.getSelectedIndex() != 5) {
            pesquisar.setEnabled(true);
        } else {
            pesquisar.setEnabled(false);
        }
    }//GEN-LAST:event_comboPesquisaActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        deletar.setEnabled(false);

        /*Toda vez que o usuario clicar em pesquisar vai limpar os campos na JTable*/
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        //Verificacao do combobox
        if (comboPesquisa.getSelectedIndex() == 1) {
            mostrarPesquisa("cli.nome", pesquisar.getText());
        } else if (comboPesquisa.getSelectedIndex() == 2) {
            mostrarPesquisa("cli.cpf_cnpj", pesquisar.getText());
        } else if (comboPesquisa.getSelectedIndex() == 3) {
            mostrarPesquisa("fun.nome", pesquisar.getText());
        } else if (comboPesquisa.getSelectedIndex() == 4) {
            mostrarPesquisa("os.idOrdemServico", pesquisar.getText());
        } else if (comboPesquisa.getSelectedIndex() == 5) {
            mostrarDados();
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaBuscaOrdem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaOrdem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaOrdem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaOrdem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBuscaOrdem dialog = new TelaBuscaOrdem(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JComboBox<String> comboPesquisa;
    private javax.swing.JButton deletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField pesquisar;
    public static javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
