package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    //identidad, nombre, fechaIngreso, categoria
    private long   Identidad;
    private String Nombre;
    private String FechaIngreso;
    private String Categoria;

    public Cliente(){
    }
    public Cliente(long pIdentidad, String pNombre,
                   String pFechaIngreso, String pCategoria) {
        this.Identidad    = pIdentidad;
        this.Nombre       = pNombre;
        this.FechaIngreso = pFechaIngreso;
        this.Categoria    = pCategoria;
    }

    public long getIdentidad() {
        return Identidad;
    }
    public void setIdentidad(long identidad) {
        Identidad = identidad;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public String getCategoria() {
        return Categoria;
    }
    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    //crear los metodos -agregar, visualizar, buscar, validar-
    public void agregar(ArrayList<Cliente> clientes) {
        try {

            Cliente cliente = new Cliente();
            Scanner teclado = new Scanner(System.in).useDelimiter("\n");
            System.out.print("Ingrese la Identidad: ");
            cliente.setIdentidad(teclado.nextLong());
            System.out.print("Ingrese el Nombre: ");
            cliente.setNombre(teclado.next());
            System.out.print("Ingrese la Fecha de Ingreso: ");
            cliente.setFechaIngreso(teclado.next());
            System.out.print("Ingrese la Categoria: ");
            cliente.setCategoria(teclado.next());
            clientes.add(cliente);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void visualizar(ArrayList<Cliente> clientes) {
        for (Cliente item: clientes) {
            System.out.println("Cliente: " + item.getNombre()
            + " - " + item.getIdentidad()
            + " - " + item.getFechaIngreso()
            + " - " + item.getCategoria());
        }
    }

    public void buscarCliente(ArrayList<Cliente> clientes, Factura factura) {
        try {

            Scanner teclado = new Scanner(System.in).useDelimiter("\n");
            boolean acertado;
            long identidad;
            Cliente cliente = new Cliente();

            //mostrar clientes
            cliente.visualizar(clientes);

            do {
                acertado = false;
                System.out.print("Ingrese la Identidad del Cliente: ");
                identidad = teclado.nextLong();

                for (Cliente item : clientes) {
                    if (identidad == item.getIdentidad()) {
                        factura.setCliente(item);
                        acertado = true;
                        break;
                    } else {
                        System.out.println("No se encuentra un cliente con esa identidad."); //validar
                    }
                }

            } while (acertado == false);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
