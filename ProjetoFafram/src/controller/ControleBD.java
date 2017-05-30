
package controle;

import java.sql.*;
import javax.swing.JOptionPane;

public class ControleBD {
    //Metodo responsavel por estabelecer conexão com o banco!
    
    
    public static Connection conector(){
     
    /* Criando uma variavel conexão e atribui a ela como NULO, 
    ainda não possui conexão com o banco */
    java.sql.Connection conexao = null;
    
    // A linha abaixo "chamam" o driver
    String driver = "org.postgresql.Driver";
    // Armazenando informações referente o banco e informando o nome do banco
    String caminho = "jdbc:postgresql://localhost:5432/tela_login";
    // Login do seu postgresql
    String usuario = "postgres";
    // Senha do banco
    String senha = "degauss";
        
    //Estabelecendo a conexão com o banco!
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(caminho, usuario, senha);
            return conexao;
            
    //Caso houver algum error na conexão com o banco, ele informa em uma janela o error     
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }   
    
    
}
}
