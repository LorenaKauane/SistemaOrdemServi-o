/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaOrdemServico.View;

import br.com.SistemaOrdemServico.Controller.ClienteController;
import br.com.SistemaOrdemServico.DAO.ClienteDAO;
import br.com.SistemaOrdemServico.Entidades.Cliente;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import static br.com.SistemaOrdemServico.View.TelaCadastroClientes.cpfCliente;

public class TelaBuscarCliente extends javax.swing.JDialog {

    ClienteController cadastro = new ClienteController();
    /*Variavel responsavel pela verificação se está ou não aberta a tela de OS para 
      selecionar o cliente */
    private boolean estadoTelaOS = false;

    public TelaBuscarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        verifica();
        /*Responsavel para o usuario selecionar sempre APENAS 1 linha da minha JTable*/
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        btnPesquisa.setEnabled(false);

    }

    /*Construtor responsavel para eu ter a visualização do cadastro de cliente
      e para o jDialog abrir em '' cima '' de outro para eu poder EDITAR o meu cliente 
      e voltar a abrir a ESTA tela de buscar cliente*/
    public TelaBuscarCliente(TelaCadastroClientes owner, boolean modal) {
        super(owner, modal);
        initComponents();
        btnPesquisa.setEnabled(false);
    }

    /*Construtor responsavel para eu ter a visualização DESTA tela na minha tela de OS 
      para selecionar o cliente*/
    public TelaBuscarCliente(TelaOS owner, boolean modal, boolean estadoTela) {
        super(owner, modal);
        initComponents();
        verifica();
        /*Responsavel para o usuario selecionar sempre APENAS 1 linha da minha JTable*/
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        estadoTelaOS = estadoTela;
        btnPesquisa.setEnabled(false);
    }

    /*metodo responsavel para o controle dos botoes*/
    public void verifica() {
        /*Se a pessoa selecionar a linha -1 (não existe) os botão vai ficar 
          Enabled, caso ela selecione, os botoes ficam clicaveis*/
        if (tabela.getSelectedRow() == -1) {
            editar.setEnabled(false);
            deletar.setEnabled(false);
        } else {
            editar.setEnabled(true);
            deletar.setEnabled(true);

        }
    }

    /*Metodo responsavel por mostrar os dados direto no banco de dados
      E popular a JTable*/
    public void mostrarDados() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        ClienteDAO clienteDao = new ClienteDAO();
        try {

            List<Cliente> lista = clienteDao.lista();
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum registro encontrodo");
            } else {
                for (Cliente c : lista) {
                    /*Adicionando os dados as linhas da minha JTable*/
                    modelo.addRow(new Object[]{
                        c.getIdCliente(),
                        c.getNome(),
                        c.getCpf(),
                        c.getTelefone(),
                        c.getEndereco(),
                        c.getEmail()
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Metodo responsavel por fazer a mesma coisa que o metodo acima, porém para o campo pesquisa,
     Passo por parametro o campo, ex: cpf, nome etc etc... e o que a pessoa pesquisou
     */
    public void mostrarPesquisa(String campo, String campoPesquisa) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        ClienteDAO clienteDao = new ClienteDAO();

        List<Cliente> lista = clienteDao.pesquisar(campo, campoPesquisa);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro encontrodo");
        } else {
            for (Cliente c : lista) {

                modelo.addRow(new Object[]{
                    c.getIdCliente(),
                    c.getNome(),
                    c.getCpf(),
                    c.getTelefone(),
                    c.getEndereco(),
                    c.getEmail()

                });

            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adicionar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        deletar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        comboPesquisa = new javax.swing.JComboBox<>();
        btnPesquisa = new javax.swing.JButton();
        pesquisar = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca de Clientes");
        setResizable(false);

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
                "Id", "Nome", "CPF", "Telefone", "Endereço", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        comboPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione!", "NOME", "CPF", "TODOS" }));
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Busca de Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(pesquisar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed

        TelaCadastroClientes tela = new TelaCadastroClientes(this, true);
        dispose();
        tela.setVisible(true);

    }//GEN-LAST:event_adicionarActionPerformed
    /*Metodo responsavel por pegar os dados de quando o usuario seleciona um dado na JTable */
    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed

        String idCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0));
        String nomeCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 1));
        String cpfCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 2));
        String telefoneCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 3));
        String enderecoCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 4));
        String emailCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 5));

        dispose();

        /*Passo por parametro todos os dados como esta no meu construtor na tela de cadastro de clientes*/
        TelaCadastroClientes tela = new TelaCadastroClientes(this, true, idCliente, nomeCliente, cpfCliente,
                enderecoCliente, telefoneCliente, emailCliente);

        tela.setVisible(true);

    }//GEN-LAST:event_editarActionPerformed
    /*Metodo responsavel poe deletar */
    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed

        /*Quando o usuario selecionar um item na JTable capturo apenas o ID*/
        int id = (int) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);

        //verifica();
        int i = JOptionPane.showConfirmDialog(this, "Certeza que deseja excluir?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            /*Atualizando a Jtable*/
            cadastro.deletar(id);
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setNumRows(0);
            mostrarDados();

        }


    }//GEN-LAST:event_deletarActionPerformed

    private void comboPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPesquisaActionPerformed
        pesquisar.setFormatterFactory(null); // Limpando o campo formatado 
        pesquisar.setText(null);
        //Botao pesquisar
        if(comboPesquisa.getSelectedIndex() != 0){
            btnPesquisa.setEnabled(true);
        }else{
            btnPesquisa.setEnabled(false);
        }
        //Text field
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
        } else if (comboPesquisa.getSelectedIndex() != 3) {
            pesquisar.setEnabled(true);
        } else {
            pesquisar.setEnabled(false);
        }
    }//GEN-LAST:event_comboPesquisaActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        deletar.setEnabled(false);
        editar.setEnabled(false);
        /*Toda vez que o usuario clicar em pesquisar vai limpar os campos na JTable*/
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        /*Verificacao do combobox*/
        switch (comboPesquisa.getSelectedIndex()) {
            case 1:
                mostrarPesquisa("nome", pesquisar.getText());
                break;
            case 2:
            case 3:
                mostrarPesquisa("cpf_cnpj", pesquisar.getText());
                break;
            case 4:
                mostrarDados();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed

    /*Quando o usuario clicar em um dado da JTable*/
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        verifica();
        /*Se for verdadeiro e pq o usuario esta cadastrando uma OS*/
        if (estadoTelaOS == true) {
            String idCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0));
            String nomeCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 1));
            String cpfCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 2));
            String telefoneCliente = String.valueOf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 3));

            adicionar.setEnabled(false);
            deletar.setEnabled(false);
            editar.setEnabled(false);
            /*Se ele der dois cliques e porque selecionou um cliente*/
            if (evt.getClickCount() == 2) {
                System.out.println("Dois Cliques");
                TelaOS tela = new TelaOS(this, true, idCliente, nomeCliente, cpfCliente, telefoneCliente);
                dispose();
                tela.setVisible(true);

            }
        }
    }//GEN-LAST:event_tabelaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBuscarCliente dialog = new TelaBuscarCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField pesquisar;
    public static javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
