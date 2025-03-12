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
    public class ConexionPsSQL extends DBConnection {

        public ConexionPsSQL(){
            this.URL = "jdbc:postgresql://localhost:5432/db_persona"; // URL de la base de datos
            this.USER = "root"; // Usuario de PostgreSQL
            this.PASSWORD = "123";
        }

        @Override
        public void setConnection() {
            try {
                Class.forName("org.postgresql.Driver");
                this.connection = DriverManager.getConnection(this.URL,this.USER,this.PASSWORD);
                System.out.println("base de datos conectada");
            } catch (ClassNotFoundException e) {
                System.out.println("Error: No se encontró el controlador JDBC de PostgreSQL...");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error al conectar a PostgreSQL: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }
