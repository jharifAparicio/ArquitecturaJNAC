/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jharif
 */
public class ProductoCompuesto implements IProducto{
    private final String descripcion;
    private final List<IProducto> productos = new ArrayList<>();

    public ProductoCompuesto(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void agregarProducto(IProducto producto){
        productos.add(producto);
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getPrecio() {
        return productos.stream().mapToDouble(IProducto::getPrecio).sum();
    }
    
}
