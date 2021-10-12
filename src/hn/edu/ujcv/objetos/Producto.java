package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    //codigo, nombre, precio, stock
    private String Codigo;
    private String Nombre;
    private double Precio;
    private String Stock;

    public Producto(){
    }
    public Producto(String pCodigo, String pNombre,
                    double pPrecio, String pStock) {
        this.Codigo = pCodigo;
        this.Nombre = pNombre;
        this.Precio = pPrecio;
        this.Stock  = pStock;
    }

    public String getCodigo() {
        return Codigo;
    }
    public void setCodigo(String codigo) {
        Codigo = codigo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double precio) {
        Precio = precio;
    }
    public String getStock() {
        return Stock;
    }
    public void setStock(String stock) {
        Stock = stock;
    }
    //crear los metodos -agregar, visualizar, buscar, validar-
    public void agregar(ArrayList<Producto> productos) {
        Producto producto = new Producto();
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Ingrese el Codigo del Producto: ");
        producto.setCodigo(teclado.next());
        System.out.print("Ingrese el Nombre del Producto: ");
        producto.setNombre(teclado.next());
        System.out.print("Ingrese el Precio del Producto: ");
        producto.setPrecio(teclado.nextDouble());
        System.out.print("Ingrese el Stock del Producto: ");
        producto.setStock(teclado.next());
        productos.add(producto);
    }

    public void visualizar(ArrayList<Producto> productos) {
        for (Producto item: productos) {
            System.out.println("Producto: " + item.getNombre()
                    + " - " + item.getCodigo() + " - "
                    + item.getStock() + " - L." + item.getPrecio());
        }
    }

    public void buscarProducto(ArrayList<Producto> productos, Detalle detalle) {

        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Producto producto = new Producto();
        String codigo;
        boolean acertado;

        //mostrar productos
        producto.visualizar(productos);

        do {
            acertado = false;
            System.out.print("Ingrese el Codigo del Producto: ");
            codigo = teclado.next();

            for (Producto item: productos) {
                if (codigo.equalsIgnoreCase(item.getCodigo())) {
                    detalle.setProducto(item);
                    acertado = true;
                } else {
                    System.out.println("No se encuentra un Producto con ese codigo."); //validar
                }
            }
        } while(acertado==false);
    }
}
