/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

/**
 *
 * @author jharif
 */
public class ProductoSimple implements IProducto {
    private final String descripcion;
    private final double precio;

    public ProductoSimple(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public double getPrecio() {
        return precio;
    }
}
