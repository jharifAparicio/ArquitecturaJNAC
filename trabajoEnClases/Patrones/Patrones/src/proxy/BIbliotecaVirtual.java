/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxy;

/**
 *
 * @author jharif
 */
public class BIbliotecaVirtual {
    public static void main(String[] args){
        LibroReal libro = new LibroReal("Había una vez un pequeño príncipe...","El Principito", "Antoine de Saint-Exupéry", 1943);
        ProxyLibro proxyLibro = new ProxyLibro(libro);
        proxyLibro.Leer();
        System.out.println("-----------------------------------------------------");
        proxyLibro.setUsuario("jharif");
        proxyLibro.Leer();
    }
}
