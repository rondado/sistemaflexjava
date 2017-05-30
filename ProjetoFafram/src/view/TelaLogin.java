
package visao;

import controle.ControleBD;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author titata
 */
public class TelaLogin extends javax.swing.JFrame {

    
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
        public void logar(){
            
            /* A linha abaixo vai executa a instrução SQL onde vai pesquisar 
            no banco de dados o usuario e a senha */
            
        String sql = "select * from usuarios where login=? and senha=?";
            try {
                
                /* As linhas abaixo preparam a consulta ao banco de dados
                com os valores digitados nas JTextField. O "?" é substituido
                pelo conteudo das variaveis*/
                
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtnome.getText());
                pst.setString(2, txtsenha.getText());
                
                //A linha abaixo executa a query
                rs = pst.executeQuery();
                
                /* Se existir o usuario e a senha for verdadeiro, abre a proxima
                janela e fecha a janela de login e senha*/
                
                if(rs.next()){
                  TelaPrincipal principal = new TelaPrincipal();
                  principal.setVisible(true);
                  dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalido!");
                }
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
    }
    
    public TelaLogin() {
        initComponents();
        setResizable(false); //Desativando o botão maximizar da janela
        conexao = ControleBD.conector(); //Inicializando o banco
           
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_sair = new javax.swing.JButton();
        btn_acessar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtsenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de login e senha");
        setBackground(java.awt.Color.white);
        getContentPane().setLayout(null);

        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sair);
        btn_sair.setBounds(300, 260, 90, 30);

        btn_acessar.setText("Acessar");
        btn_acessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acessarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_acessar);
        btn_acessar.setBounds(180, 260, 90, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 0, 521, 170);

        jLabelSenha.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(140, 220, 90, 20);

        jLabelUsuario.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabelUsuario.setText("Usuario:");
        getContentPane().add(jLabelUsuario);
        jLabelUsuario.setBounds(130, 180, 90, 20);
        getContentPane().add(txtnome);
        txtnome.setBounds(210, 180, 180, 30);
        getContentPane().add(txtsenha);
        txtsenha.setBounds(210, 220, 180, 28);

        setSize(new java.awt.Dimension(561, 314));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        
        System.exit(0); //Fechar janela
        
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_acessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acessarActionPerformed
        if (txtnome.getText().equals("") || txtsenha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nome ou senha invalido!");
        } else {
            logar();
            
        }
    }//GEN-LAST:event_btn_acessarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_acessar;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField txtnome;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables
}
