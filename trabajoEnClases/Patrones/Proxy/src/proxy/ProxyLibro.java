/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxy;

/**
 *
 * @author jharif
 */
public class ProxyLibro implements ILibro {
    private LibroReal libroReal;
    private String usuario;

    public ProxyLibro(LibroReal libroReal) {
        this.libroReal = libroReal;
        this.usuario = "";
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void Leer() {
        if(usuario.equals("jharif")) {
            System.out.println("usted tiene permisos, puede leer el libro:");
            libroReal.Leer();
        }else{
            System.out.println("error usted no tiene permisos");
        }
    }
}
