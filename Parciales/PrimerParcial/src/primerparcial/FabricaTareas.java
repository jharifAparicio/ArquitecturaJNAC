/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.util.List;

/**
 *
 * @author jharif
 */
public class FabricaTareas {
    public static ITarea crearTarea(String tipo, String descripcion){
        if (tipo.equalsIgnoreCase("simple")) {
            return new TareaSimple(descripcion);
        } else if (tipo.equalsIgnoreCase("compuesta")) {
            return new TareaCompuesta(descripcion);
        } else {
            System.out.println("Tipo de tarea no válido. Retornando null.");
            return null;
        }
    }
    
    public static ITarea crearTareaCompuesta(String descripcion, List<ITarea> subtareas) {
        TareaCompuesta compuesta = new TareaCompuesta(descripcion);
        for (ITarea subtarea : subtareas) {
            compuesta.agregarSubtarea(subtarea);
        }
        return compuesta;
    }
}
