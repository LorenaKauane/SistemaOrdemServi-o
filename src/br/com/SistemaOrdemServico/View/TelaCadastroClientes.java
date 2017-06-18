package br.com.SistemaOrdemServico.View;

import br.com.SistemaOrdemServico.Controller.ClienteController;
import br.com.SistemaOrdemServico.Entidades.Cliente;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class TelaCadastroClientes extends javax.swing.JDialog {

    ClienteController cadastroCliente = new ClienteController();
    /*Variavel responsavel por armazenar o ID do usuario que vai ser repassado 
      atraves de um construtor ou metodo*/
    private int id = 0;

    public TelaCadastroClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
    }

    /* Para editar*/
    public TelaCadastroClientes(TelaBuscarCliente owner, boolean modal, String id, String nome, String cpf,
            String endereco, String telefone, String email) {
        super(owner, modal);

        initComponents();
        /*Para editar passamos o ID*/
        this.id = Integer.parseInt(id);
        nomeCliente.setText(nome);
        cpfCliente.setText(cpf);
        enderecoCliente.setText(endereco);
        telefoneCliente.setText(telefone);
        emailCliente.setText(email);
    }
    
        /*Seta no campo txt o formatter JRadion*/
    public void selecionadoCPF() {
        MaskFormatter cpf;
        try {
            cpf = new MaskFormatter("###.###.###-##");
            cpfCliente.setFormatterFactory(null);
            cpfCliente.setFormatterFactory(new DefaultFormatterFactory(cpf));
            System.out.println("OPCAO CPF");
        } catch (ParseException ex) {
            Logger.getLogger(TelaCadastroClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*Construtor para adicionar na tela Buscar Cliente*/
    public TelaCadastroClientes(TelaBuscarCliente owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    public void mensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    public int confirmacaoMensagem(String mensagem, String titulo) {
        int i = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_OPTION);
        return i;
    }
    
    public void limparCampos(){
        nomeCliente.setText("");
        enderecoCliente.setText("");
        cpfCliente.setText("");
        emailCliente.setText("");
        telefoneCliente.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotao = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        emailCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_Limpar = new javax.swing.JButton();
        btn_Salvar = new javax.swing.JButton();
        enderecoCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        cpfCliente = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        telefoneCliente = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setText("*Telefone:");

        jLabel7.setText("E-mail:");

        btn_Limpar.setText("Limpar");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        btn_Salvar.setText("Salvar");
        btn_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalvarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cadastro de Clientes! ");

        jLabel4.setText("*Nome:");

        try {
            cpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("*Endereço:");

        try {
            telefoneCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btn_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(enderecoCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefoneCliente)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(telefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalvarActionPerformed
        

        String resultado = cadastroCliente.verificacao(cpfCliente.getText(),nomeCliente.getText(),
                enderecoCliente.getText(),emailCliente.getText(),
                telefoneCliente.getText());
        /*Se  o ID for 0 e porque e um cliente novo!*/
        if (id == 0) {
            /*Passa pela minha verificação que esta na classe cadastroCliente */
            if (resultado == "Salvo!") {
                if (confirmacaoMensagem("Certeza que deseja salvar?", "Atenção") == JOptionPane.YES_OPTION) {
                    cadastroCliente.salvar(id);
                    limparCampos();
                    JOptionPane.showMessageDialog(this, resultado);
                }
            } else {
                JOptionPane.showMessageDialog(this, resultado);
            }
            /*Se a variavel ID for diferente de 0 e porque tem que ser editado!*/
        } else {
            /*Passo pela validação na classe cadastroCliente*/
            if (resultado == "Salvo!") {
                if (confirmacaoMensagem("Certeza que deseja EDITAR?", "Atenção") == JOptionPane.YES_OPTION) {
                    cadastroCliente.salvar(id);
                    limparCampos();
                    JOptionPane.showMessageDialog(this, resultado);
                    /*Zero a variavel ID*/
                    id = 0;
                    TelaBuscarCliente tela = new TelaBuscarCliente(this, true);
                    dispose();
                    tela.setVisible(true);
                }
            } else {
                mensagem(resultado);
            }
        }
    }//GEN-LAST:event_btn_SalvarActionPerformed

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed

        if (confirmacaoMensagem("Certeza que deseja limpar?", "Atenção") == JOptionPane.YES_OPTION) {
            limparCampos();
        }
    }//GEN-LAST:event_btn_LimparActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroClientes dialog = new TelaCadastroClientes(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton btn_Limpar;
    public static javax.swing.JButton btn_Salvar;
    public static javax.swing.JFormattedTextField cpfCliente;
    public static javax.swing.JTextField emailCliente;
    public static javax.swing.JTextField enderecoCliente;
    private javax.swing.ButtonGroup grupoBotao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JTextField nomeCliente;
    public static javax.swing.JFormattedTextField telefoneCliente;
    // End of variables declaration//GEN-END:variables
}
