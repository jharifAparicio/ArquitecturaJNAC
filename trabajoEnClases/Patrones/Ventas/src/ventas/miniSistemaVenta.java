/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jharif
 */
public class miniSistemaVenta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<IProducto> catalogo = new ArrayList<>();
        catalogo.add(ProductoFabrica.crearProducto("simple", "Pan", 1.5));
        catalogo.add(ProductoFabrica.crearProducto("simple", "Leche", 2.0));

        ProductoCompuesto desayuno = new ProductoCompuesto("Combo Desayuno");
        desayuno.agregarProducto(new ProductoSimple("Pan", 1.5));
        desayuno.agregarProducto(new ProductoSimple("Café", 2.5));
        catalogo.add(desayuno);

        Venta venta = new Venta("Cliente", "02/04/2025", "Factura", "001-123");

        while (true) {
            System.out.println("1. Agregar producto");
            System.out.println("2. Finalizar venta");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 1) {
                System.out.println("Catálogo de productos:");
                for (int i = 0; i < catalogo.size(); i++) {
                    System.out.println((i + 1) + ". " + catalogo.get(i).getDescripcion() + " - $" + catalogo.get(i).getPrecio());
                }
                System.out.print("Seleccione el producto: ");
                int productoIndex = scanner.nextInt() - 1;
                System.out.print("Ingrese la cantidad: ");
                int cantidad = scanner.nextInt();
                venta.agregarDetalle(new DetalleVenta(catalogo.get(productoIndex), cantidad));
            } else if (opcion == 2) {
                venta.mostrarDetalle();
                System.out.println("Seleccione método de pago: 1. Efectivo 2. Tarjeta 3. Transferencia");
                scanner.nextInt();
                System.out.println("Venta finalizada.");
                break;
            } else if (opcion == 3) {
                break;
            }
        }
        scanner.close();
    }
}
