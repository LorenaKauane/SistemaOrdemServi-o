package br.com.SistemaOrdemServico.View;

import br.com.SistemaOrdemServico.Controller.FuncionarioController;
import br.com.SistemaOrdemServico.DAO.FuncionarioDAO;
import br.com.SistemaOrdemServico.Entidades.Funcionario;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/*Classe parecida com a classe TelaBuscarCLiente*/
public class TelaBuscarFuncionario extends javax.swing.JDialog {

    FuncionarioController cadastro = new FuncionarioController();

    public TelaBuscarFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        btnPesquisar.setEnabled(false);
        verifica();
    }

    public void verifica() {
        if (tabela.getSelectedRow() == -1) {
            editar.setEnabled(false);
            deletar.setEnabled(false);
        } else {
            editar.setEnabled(true);
            deletar.setEnabled(true);
        }
    }

    public void mostrarDados() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        List<Funcionario> lista = funcionarioDao.lista();
        if (lista.isEmpty()) {
            mensagem("Nenhum registro encontrado");
        } else {
            for (Funcionario c : lista) {

                modelo.addRow(new Object[]{
                    c.getIdFuncionario(),
                    c.getNome(),
                    c.getCpf(),
                    c.getTelefone(),
                    c.getSenha()

                });

            }
        }

    }

    public void mostrarPesquisa(String campo, String campoPesquisa) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        List<Funcionario> lista = funcionarioDao.pesquisar(campo, campoPesquisa);
        if (lista.isEmpty()) {
            mensagem("Nenhum registro encontrado");
        } else {
            for (Funcionario f : lista) {

                modelo.addRow(new Object[]{
                    f.getIdFuncionario(),
                    f.getNome(),
                    f.getCpf(),
                    f.getTelefone(),
                    f.getSenha()

                });

            }
        }

    }

    public void mensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    public int confirmacaoMensagem(String mensagem, String titulo) {
        int i = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_OPTION);
        return i;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboPesquisa = new javax.swing.JComboBox<>();
        pesquisar = new javax.swing.JFormattedTextField();
        adicionar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        deletar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca Funcionarios");
        setResizable(false);

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione!", "NOME", "CPF", "TODOS" }));
        comboPesquisa.setToolTipText("");
        comboPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPesquisaActionPerformed(evt);
            }
        });

        adicionar.setText("Adicionar!");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.setEnabled(false);
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        deletar.setText("Deletar");
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
                "Id", "Nome", "CPF", "Telefone", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(pesquisar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void comboPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPesquisaActionPerformed
        pesquisar.setFormatterFactory(null); // Limpando o campo formatado
        pesquisar.setText(null);
        if(comboPesquisa.getSelectedIndex() != 0){
            btnPesquisar.setEnabled(true);
        }else{
            btnPesquisar.setEnabled(false);
        }
        
        if (comboPesquisa.getSelectedIndex() == 2) {
            MaskFormatter cpf;
            try {
                cpf = new MaskFormatter("###.###.###-##");
                pesquisar.setFormatterFactory(new DefaultFormatterFactory(cpf));
                pesquisar.setEnabled(true);
            } catch (ParseException ex) {
                Logger.getLogger(TelaCadastroClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (comboPesquisa.getSelectedIndex() != 3) {
            pesquisar.setEnabled(true);
        } else {
            pesquisar.setEnabled(false);
        }
    }//GEN-LAST:event_comboPesquisaActionPerformed

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed

        TelaFuncionario tela = new TelaFuncionario(this, true);
        dispose();
        tela.setVisible(true);
    }//GEN-LAST:event_adicionarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed

        String id = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0));
        String nome = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 1));
        String cpf = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 2));
        String telefone = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 3));
        String senha = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 4));

        dispose();
        TelaFuncionario tela = new TelaFuncionario(this, true, id, nome, cpf, senha, telefone);
        tela.setVisible(true);
    }//GEN-LAST:event_editarActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        int id = (int) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
        if (confirmacaoMensagem("Certeza que deseja excluir", "Atenção") == JOptionPane.YES_OPTION) {
            String resultado = cadastro.deletar(id);
            mensagem(resultado);
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setNumRows(0);
            mostrarDados();
        }

    }//GEN-LAST:event_deletarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        verifica();
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        deletar.setEnabled(false);
        editar.setEnabled(false);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        if (comboPesquisa.getSelectedIndex() == 1) {
            mostrarPesquisa("nome", pesquisar.getText());
        } else if (comboPesquisa.getSelectedIndex() == 2) {
            mostrarPesquisa("cpf", pesquisar.getText());
        } else if (comboPesquisa.getSelectedIndex() == 3) {
            mostrarDados();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaBuscarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBuscarFuncionario dialog = new TelaBuscarFuncionario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> comboPesquisa;
    private javax.swing.JButton deletar;
    private javax.swing.JButton editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField pesquisar;
    public static javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
