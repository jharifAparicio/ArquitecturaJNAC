/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxy;

/**
 *
 * @author jharif
 */
public class LibroReal implements ILibro {
    private String texto;
    private String titulo;
    private String autor;
    private int anio;

    public LibroReal(String texto, String titulo, String autor, int anio) {
        this.texto = texto;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }
    
    @Override
    public void Leer() {
        System.out.println("Leyendo el libro: " + titulo);
        System.out.println("Autor: " + autor + " (" + anio + ")");
        System.out.println("Contenido: " + texto);
    }
    
}
