/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico1;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jharif
 */
public class CRUDPersona {

    DBConnection conexion;

    public CRUDPersona(DBConnection conexion) {
        this.conexion = conexion;
    }

    public boolean CreatePerson(Person person) {

        String query = "INSERT INTO persona (nombre,edad, correo) VALUES (?,?,?)";

        try (PreparedStatement stmt = conexion.getConnection().prepareStatement(query)) {
            stmt.setString(1, person.getName());
            stmt.setInt(2, person.getAge());
            stmt.setString(3, person.getEmail());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Person> ReadPersons() {
        String query = "SELECT * FROM persona";
        ArrayList<Person> personas = new ArrayList();

        try (Statement stmt = conexion.getConnection().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = Integer.parseInt(rs.getString("edad"));
                String correo = rs.getString("correo");
                personas.add(new Person(nombre, edad, correo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }
}
