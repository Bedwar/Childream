/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CadastroDAL;
// data acess leayer
import java.sql.*;
/**
 *
 * @author beatr
 */
public class ModulodeConexao {
  
    
    //ESTABELECER CONEXÃO -> Connection return
    
    public static Connection conexao(){
       Connection conectar = null; // variavel q recebe a string para acesso
        
        //DRIVER (NA BIBLIOTECA)JDBC JAVA DATABASE DRIVER ARQ IMPORTADO  
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/progdesktop";
        String user = "root";
        String password = "root";
        
        // CTRL SPACE
        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(url, user, password);
            return conectar;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
}
