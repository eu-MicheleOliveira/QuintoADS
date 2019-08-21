/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alunos
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Class.forName("com.mysql.jdbc.Driver");//carregaodriverdeconexãocomoMySQL
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url="jdbc:mysql://localhost/teste";//URLdobancodedados
//fazaconexãocomobancodedados
Connection con;
        try {
            con = DriverManager.getConnection(url,"root","");
//criaoobjetostatementparaexecutarcomandosSQL
            Statement stmt = con.createStatement();
//criaumatabelanobancodedados
/*
            stmt.execute("CREATE TABLE produto"
                    + "(codigo INT PRIMARY KEY,"
                    + "descricao CHAR(40),"
                    + "preco FLOAT);");
*/

//insereumregistro
            int linhasModificadas = stmt.executeUpdate("INSERT INTO produto "
                    + "(codigo,descricao,preco) VALUES "
                    + "(102,'Pendrive 64GB',40.50)");         
            
            
        ResultSet x=stmt.executeQuery("select * from produto");
        while(x.next())
            System.out.println("Código: "+x.getInt(1)+
                               "\tDescrição: "+x.getString("descricao")+
                               "\tPreço: "+x.getFloat(3));

         con.close();
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
