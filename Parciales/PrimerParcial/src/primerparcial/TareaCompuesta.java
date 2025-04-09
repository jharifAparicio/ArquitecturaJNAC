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
public class TareaCompuesta implements ITarea {
    private String descripcion;
    private List<ITarea> subtareas;

    public TareaCompuesta(String descripcion) {
        this.descripcion = descripcion;
        this.subtareas = new ArrayList<>();
    }

    public void agregarSubtarea(ITarea tarea) {
        subtareas.add(tarea);
    }
    
    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void ejecutar() {
        System.err.println("Ejecutando tarea compuesta: " + descripcion);
        for(ITarea tarea:subtareas){
            tarea.ejecutar();
        }
    }
}
