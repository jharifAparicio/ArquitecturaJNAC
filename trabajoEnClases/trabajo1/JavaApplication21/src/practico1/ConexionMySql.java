/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico1;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jharif
 */
public class ConexionMySql extends DBConnection {
    
    public ConexionMySql(){
        this.URL = "jdbc:mysql://localhost:3307/db_persona?useSSL=false&serverTimezone=UTC";
        this.USER = "root";
        this.PASSWORD = "";
    }

    @Override
    public void setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.URL,this.USER,this.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
}
