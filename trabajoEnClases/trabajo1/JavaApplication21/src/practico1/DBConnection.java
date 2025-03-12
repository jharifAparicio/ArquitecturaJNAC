/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico1;

import java.sql.Connection;

import java.sql.SQLException;

/**
 *
 * @author jharif
 */
public abstract class DBConnection {
    protected String URL = ""; //jdbc:mysql://localhost:3307/db_persona?useSSL=false&serverTimezone=UTC
    protected String USER  = ""; // root
    protected String PASSWORD = "";
    protected Connection connection;
    
    public abstract void setConnection();
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void CerrarConexion(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
