/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primerparcial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jharif
 */
public class PrimerParcial {
    public static void main(String[] args) {
        int opcion;
        FachadaGestionTareas fachada = new FachadaGestionTareas();
        Scanner sc = new Scanner(System.in);
        do{
            // mostramos el menu
            System.out.println("\n=== MENÚ DE GESTIÓN DE TAREAS ===");
            System.out.println("1. Crear Tarea Simple");
            System.out.println("2. Crear Tarea Compuesta");
            System.out.println("3. Mostrar Tareas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch(opcion){
                case 1:
                    System.out.print("ingrese la descripcion de la tarea simple:");
                    String descripcionSimple = sc.nextLine();
                    fachada.crearTareaSimple(descripcionSimple);
                break;
                
                case 2:
                    System.out.print("Ingrese la descripción de la tarea compuesta: ");
                    String descripcionCompuesta = sc.nextLine();
                    List<ITarea> subtareas = new ArrayList<>();

                    while (true) {
                        System.out.print("Ingrese descripción de una subtarea (o 'fin' para terminar): ");
                        String subTareaDescripcion = sc.nextLine();
                        if (subTareaDescripcion.equalsIgnoreCase("fin")) {
                            break;
                        }
                        ITarea subtarea = FabricaTareas.crearTarea("simple", subTareaDescripcion);
                        subtareas.add(subtarea);
                    }

                    fachada.crearTareaCompuesta(descripcionCompuesta, subtareas);
                break;
                case 3:
                    fachada.mostrarTareas();
                break;
                
                case 4:
                    fachada.ejecutarTareas();
                break;
                
                case 0:
                    System.out.println("¡Hasta luego!");
                return;
                
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }while(opcion != 0);
    }
    
}
