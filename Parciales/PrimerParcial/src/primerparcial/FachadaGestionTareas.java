/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jharif
 */

public class FachadaGestionTareas {

    private List<ITarea> tareas;

    public FachadaGestionTareas() {
        tareas = new ArrayList<>();
    }

    public void crearTareaSimple(String descripcion) {
        ITarea tarea = FabricaTareas.crearTarea("simple", descripcion);
        if (tarea != null) {
            tareas.add(tarea);
        }
    }

    public void crearTareaCompuesta(String descripcion, List<ITarea> subtareas) {
        ITarea tarea = FabricaTareas.crearTareaCompuesta(descripcion, subtareas);
        if (tarea != null) {
            tareas.add(tarea);
        }
    }
    
    public void agregarTarea(ITarea tarea) {
        if (tarea != null) {
            tareas.add(tarea);
        }
    }

    public void mostrarTareas() {
        for (ITarea tarea : tareas) {
            System.out.println("Tarea: " + tarea.getDescripcion());
        }
    }

    public void ejecutarTareas() {
        for (ITarea tarea : tareas) {
            tarea.ejecutar();
        }
    }
}
