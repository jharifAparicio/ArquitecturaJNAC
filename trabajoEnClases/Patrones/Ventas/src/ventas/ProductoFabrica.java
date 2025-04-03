/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

/**
 *
 * @author jharif
 */
public class ProductoFabrica {
    public static IProducto crearProducto(String tipo, String descripcion, double precio){
        if(tipo.equalsIgnoreCase("simple")){
            return new ProductoSimple(descripcion, precio);
        }
        return null;
    }
}
