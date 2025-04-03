/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

/**
 *
 * @author jharif
 */
public class DetalleVenta {
    private IProducto producto;
    private int cantidad;

    public DetalleVenta(IProducto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public double getSubTotal(){
        return cantidad * producto.getPrecio();
    }
    
    @Override
    public String toString(){
        return cantidad + " x" + producto.getDescripcion() + " = " + getSubTotal();
    }
}
