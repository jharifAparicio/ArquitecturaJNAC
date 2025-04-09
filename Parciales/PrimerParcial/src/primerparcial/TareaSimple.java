/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

/**
 *
 * @author jharif
 */
public class TareaSimple implements ITarea {
    private String descripcion;

    public TareaSimple(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void ejecutar() {
        System.out.println("se ejecuto tarea: " + descripcion);
    }
}
