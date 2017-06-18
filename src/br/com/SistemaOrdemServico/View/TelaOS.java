package br.com.SistemaOrdemServico.View;

import br.com.SistemaOrdemServico.Controller.cadastroOrdem;
import br.com.SistemaOrdemServico.DAO.FuncionarioDAO;
import br.com.SistemaOrdemServico.DAO.ServicoDAO;
import br.com.SistemaOrdemServico.Entidades.Funcionario;
import br.com.SistemaOrdemServico.Entidades.Servico;
import static br.com.SistemaOrdemServico.View.LoginTela.cpf;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaOS extends javax.swing.JDialog {

    private int idCliente = 0;
    private int idFuncionario = 0;
    private int idServico = 0;

    public TelaOS(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llimparCampos.setEnabled(false);
        //Parte de setar o funcionario
        //populaComboServico();
        /*String cpfFuncionario = TelaPrincipal.logado.getText();
        System.out.println(cpfFuncionario);
        nomeFuncionario.setText(pesquisaFuncionario(cpfFuncionario));*/

    }

    public TelaOS(TelaBuscarCliente owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    public TelaOS(TelaBuscaOrdem owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    public TelaOS(TelaBuscarCliente owner, boolean modal, String idCliente, String nome,
            String cpf, String telefone) {
        super(owner, modal);
        initComponents();

        this.idCliente = Integer.parseInt(idCliente);
        nomeCliente.setText(nome);
        cpfCliente.setText(cpf);
        telefoneCliente.setText(telefone);

        //Parte de setar o funcionario
        String cpfFuncionario = TelaPrincipal.logado.getText();
        System.out.println(cpfFuncionario);
        nomeFuncionario.setText(pesquisaFuncionario(cpfFuncionario));
        populaComboServico();
    }

    public String pesquisaFuncionario(String cpf) {

        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        Funcionario f = new Funcionario();
        f = funcionarioDao.pesquisarCpf("cpf", cpf);
        this.idFuncionario = f.getIdFuncionario();
        String nome = f.getNome();
        return nome;

    }

    //http://devbrasil.net/group/cdesenvolvendores/forum/topics/obtendo-dado-do?commentId=2307362%3AComment%3A77149&groupId=2307362%3AGroup%3A4247
    public void populaComboServico() {
        ServicoDAO servicoDao = new ServicoDAO();
        List<Servico> lista = servicoDao.lista();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Está vazio...");
        } else {
            for (Servico s : lista) {
                comboBoxServicos.addItem(s.getNome());
            }
        }

    }

    public void limpar() {
        nomeCliente.setText("");
        cpfCliente.setText("");
        telefoneCliente.setText("");

        oqueFoiRealizado.setText("");
        total.setText("");
        comboBoxServicos.setSelectedIndex(0);
        comboBoxSituacao.setSelectedIndex(0);
        valorTotal.setText("");
    }

    public boolean verificaCampos(String teste) {
        if (nomeCliente.getText() != null && nomeFuncionario.getText() != null) {
            if (comboBoxServicos.getSelectedIndex() != 0
                    && comboBoxSituacao.getSelectedIndex() != 0) {
                if (teste != null && teste.length() > 5) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(this, "Digite o que foi realizado");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Verifique o campo Serviços e Situação");
                return false;
            }
        }

        return false;
    }

    public void salvarOS() {
        cadastroOrdem cadastroOrdem = new cadastroOrdem();
        String situacao = comboBoxSituacao.getSelectedItem().toString();
        double totalValor = Double.parseDouble(valorTotal.getText());
        String resultado = cadastroOrdem.salvar(oqueFoiRealizado.getText(),
                totalValor, idFuncionario, idCliente, idServico, situacao);

        JOptionPane.showMessageDialog(this, resultado);
        limpar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numeroOS = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pesquisarCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        cpfCliente = new javax.swing.JFormattedTextField();
        telefoneCliente = new javax.swing.JFormattedTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomeFuncionario = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboBoxServicos = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        comboBoxSituacao = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        valorTotal = new javax.swing.JTextField();
        llimparCampos = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        oqueFoiRealizado = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        cancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cadastro de OS!");

        jLabel2.setText("Nº da OS");

        numeroOS.setText(".");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Dados do cliente");

        pesquisarCliente.setText("Pesquisar Cliente");
        pesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome: ");

        jLabel5.setText("CPF/CNPJ:");

        jLabel6.setText("Telefone:");

        nomeCliente.setEnabled(false);

        cpfCliente.setEnabled(false);
        cpfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfClienteActionPerformed(evt);
            }
        });

        telefoneCliente.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Dado do funcionario");

        jLabel8.setText("Nome: ");

        nomeFuncionario.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Dados da Ordem de Serviço");

        jLabel10.setText("Tipo de serviço:");

        comboBoxServicos.setMaximumRowCount(5);
        comboBoxServicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione!" }));
        comboBoxServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxServicosActionPerformed(evt);
            }
        });

        jLabel11.setText("Situação:");

        comboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione!", "Resolvido", "Não resolvido" }));
        comboBoxSituacao.setEnabled(false);
        comboBoxSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSituacaoActionPerformed(evt);
            }
        });

        jLabel12.setText("Detalhes do serviço realizado");

        jLabel13.setText("Valor total:");

        valorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorTotalKeyReleased(evt);
            }
        });

        llimparCampos.setText("Limpar");
        llimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llimparCamposActionPerformed(evt);
            }
        });

        finalizar.setText("Finalizar");
        finalizar.setEnabled(false);
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        oqueFoiRealizado.setColumns(20);
        oqueFoiRealizado.setRows(5);
        jScrollPane1.setViewportView(oqueFoiRealizado);

        jLabel15.setText("Total: ");

        total.setText("Total");

        cancelar1.setText("Cancelar");
        cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeCliente)
                    .addComponent(cpfCliente)
                    .addComponent(telefoneCliente))
                .addGap(40, 40, 40)
                .addComponent(pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(nomeFuncionario)))
                .addGap(267, 267, 267))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(5, 5, 5)
                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(llimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 16, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(numeroOS))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(telefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(comboBoxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(total))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(comboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel12))
                    .addComponent(finalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(llimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cpfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfClienteActionPerformed

    private void pesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarClienteActionPerformed

        TelaBuscarCliente tela = new TelaBuscarCliente(this, true, true);
        dispose();
        tela.setVisible(true);


    }//GEN-LAST:event_pesquisarClienteActionPerformed

    private void valorTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorTotalKeyReleased
        //Aceita só numeross!!
        valorTotal.setText(valorTotal.getText().replaceAll("[^0-9 | ^.]", ""));
        total.setText(valorTotal.getText());
        String teste = oqueFoiRealizado.getText();
        if (verificaCampos(teste)) {
            finalizar.setEnabled(true);
        }


    }//GEN-LAST:event_valorTotalKeyReleased

    private void llimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llimparCamposActionPerformed

        if (comboBoxServicos.getSelectedIndex() != 0 && comboBoxSituacao.getSelectedIndex() != 0) {
            String campo = oqueFoiRealizado.getText();
            System.out.println(campo.length());
        }


    }//GEN-LAST:event_llimparCamposActionPerformed

    private void comboBoxServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxServicosActionPerformed
        //0 e a opção selecione
        if (comboBoxServicos.getSelectedIndex() == 0) {
            comboBoxSituacao.setEnabled(false);
            llimparCampos.setEnabled(false);

        } else {
            comboBoxSituacao.setEnabled(true);

        }
    }//GEN-LAST:event_comboBoxServicosActionPerformed

    private void comboBoxSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSituacaoActionPerformed
        if (comboBoxSituacao.getSelectedIndex() == 0 && comboBoxServicos.getSelectedIndex() != 0) {
            comboBoxServicos.setSelectedIndex(0);
        } else {
            llimparCampos.setEnabled(true);
        }
    }//GEN-LAST:event_comboBoxSituacaoActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        // TODO add your handling code here:
        ServicoDAO servicoDao = new ServicoDAO();

        String campoServicos = comboBoxServicos.getSelectedItem().toString();
        List<Servico> lista = servicoDao.pesquisa(campoServicos);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi encontrado");
        } else {
            for (Servico s : lista) {
                this.idServico = s.getIdServico();
            }

            int i = JOptionPane.showConfirmDialog(this, "Certeza que deseja salvar?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                salvarOS();
            }
        }


    }//GEN-LAST:event_finalizarActionPerformed

    private void cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelar1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaOS dialog = new TelaOS(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton cancelar1;
    private javax.swing.JComboBox<String> comboBoxServicos;
    private javax.swing.JComboBox<String> comboBoxSituacao;
    private javax.swing.JFormattedTextField cpfCliente;
    private javax.swing.JButton finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JButton llimparCampos;
    public static javax.swing.JTextField nomeCliente;
    private javax.swing.JTextField nomeFuncionario;
    private javax.swing.JLabel numeroOS;
    private javax.swing.JTextArea oqueFoiRealizado;
    private javax.swing.JButton pesquisarCliente;
    private javax.swing.JFormattedTextField telefoneCliente;
    private javax.swing.JLabel total;
    private javax.swing.JTextField valorTotal;
    // End of variables declaration//GEN-END:variables
}
