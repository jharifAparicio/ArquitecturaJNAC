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
public class Venta {

    private String nombre;
    private String fecha;
    private String tipDocumento;
    private String numeroDocumento;
    private List<DetalleVenta> detalles = new ArrayList<>();

    public Venta(String nombre, String fecha, String tipDocumento, String numeroDocumento) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.tipDocumento = tipDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
    }

    public double getTotal() {
        return detalles.stream().mapToDouble(DetalleVenta::getSubTotal).sum();
    }

    public void mostrarDetalle() {
        System.out.println("Venta realizada por: " + nombre);
        System.out.println("Fecha: " + fecha);
        System.out.println("Documento: " + tipDocumento + " - " + numeroDocumento);
        System.out.println("Detalles de venta:");
        detalles.forEach(System.out::println);
        System.out.println("Total a pagar: " + getTotal());
    }
}
