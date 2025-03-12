/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practico1;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author jharif
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //DBConnection DBconection = new ConexionMySql();
        ConexionPsSQL DBconexion = new ConexionPsSQL();
        
        // establecer la conexion
        DBconexion.setConnection();
        
        Connection conexion = DBconexion.getConnection();

        CRUDPersona crudpersona = new CRUDPersona(DBconexion);

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            String mensaje;

            // Menú interactivo
            do {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Añadir persona");
                System.out.println("2. Leer personas");
                //System.out.println("3. Editar persona");
                //System.out.println("4. Eliminar persona");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        // Añadir persona
                        System.out.print("Introduce el nombre de la persona: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Introduce la edad de la persona: ");
                        int edad = Integer.parseInt(scanner.nextLine());
                        System.out.print("Introduce el correo de la persona: ");
                        String correo = scanner.nextLine();
                        Person nuevaPersona = new Person(0, nombre, edad, correo);
                        mensaje =crudpersona.CreatePerson(nuevaPersona) ? "se creo usuario" : "no se creo usuario";
                        System.out.println(mensaje);
                        break;

                    case 2:
                        // Leer personas
                        System.out.println("Personas en la base de datos:");
                        System.out.println(crudpersona.ReadPersons());
                        break;
                    case 3:
                        // Salir
                        System.out.println("Saliendo...");
                        try {
                            // Hacer una pausa de 2 segundos
                            Thread.sleep(2000); // 2000 milisegundos = 2 segundos
                        } catch (InterruptedException e) {
                            System.err.println("El hilo fue interrumpido.");
                        }
                        break;
                                

                    default:
                        System.out.println("Opción no válida. Por favor, elige una opción correcta.");
                        break;
                }
            } while (opcion != 5);  // El bucle se repetirá hasta que el usuario elija salir (opción 5)

            // Cerrar la conexión
            DBconexion.CerrarConexion();
            scanner.close();
        }
    }

}
