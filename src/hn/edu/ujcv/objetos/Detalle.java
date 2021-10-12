package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Detalle {
    private long numeroDetalle;
    private TipoDetalle tipoDetalle;
    private double cantidadDetalle;
    private double subtotal;
    private Producto producto;
    private Servicio servicio;


    public Detalle(){}

    public Detalle(long pNumeroDetalle, TipoDetalle pTipoDetalle, double pCantidadDetalle,
                   double pPrecioDetalle, double pSubTotal, Producto pProducto, Servicio pServicio){
        this.numeroDetalle   = pNumeroDetalle;
        this.tipoDetalle     = pTipoDetalle;
        this.cantidadDetalle = pCantidadDetalle;
        this.subtotal        = pSubTotal;
        this.producto = pProducto;
        this.servicio = pServicio;
    }

    public void setNumeroDetalle(long numeroDetalle) {
        this.numeroDetalle = numeroDetalle;
    }
    public long getNumeroDetalle() {
        return numeroDetalle;
    }
    public void setTipoDetalle(TipoDetalle tipoDetalle) {
        this.tipoDetalle = tipoDetalle;
    }
    public TipoDetalle getTipoDetalle() {
        return tipoDetalle;
    }
    public void setCantidadDetalle(double cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }
    public double getCantidadDetalle() {
        return cantidadDetalle;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Servicio getServicio() {
        return servicio;
    }

    public void agregarDetalle(ArrayList<Detalle> detalles, ArrayList<Producto> productos,
                               ArrayList<Servicio> servicios, Factura factura, ArrayList<Empleado> empleados){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Detalle detalle = new Detalle();
        Servicio servicio = new Servicio();
        Producto producto = new Producto();
        Empleado empleado = new Empleado();
        boolean aceptado;

        System.out.print("Ingrese el Numero de Detalle: ");
        detalle.setNumeroDetalle(teclado.nextLong());

        boolean vacio=false;
        do {
            aceptado = false;
            System.out.print("Ingrese el tipo de detalle (producto/servicio): ");

            switch (teclado.next().toLowerCase().trim()) {
                case "producto":
                    detalle.setTipoDetalle(TipoDetalle.PRODUCTO);
                    vacio = productos.isEmpty();
                    aceptado = true;
                    break;
                case "servicio":
                    detalle.setTipoDetalle(TipoDetalle.SERVICIO);
                    vacio = servicios.isEmpty();
                    aceptado = true;
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (aceptado == false);

        if (vacio == true && detalle.getTipoDetalle().equals(TipoDetalle.PRODUCTO)) {
            System.out.println("No hay productos ingresados.");
        } else if (vacio == true && detalle.getTipoDetalle().equals(TipoDetalle.SERVICIO)) {
            System.out.println("No hay servicios ingresados.");
        } else
        {
            switch (detalle.getTipoDetalle()) {
                case PRODUCTO:
                    //visualizar empleados
                    empleado.visualizar(empleados);

                    System.out.println("Ingrese el empleado: ");
                    boolean estaVacio = empleados.isEmpty();

                    if (estaVacio == true) {
                        System.out.println("No hay empleados registrados.");
                    }
                    else {
                    empleado.buscarEmpleado_Factura(empleados, factura);
                    producto.buscarProducto(productos, detalle);
                    System.out.print("Ingrese la Cantidad LLevada: ");
                    detalle.setCantidadDetalle(teclado.nextDouble());
                    detalle.setSubtotal(detalle.getCantidadDetalle() * detalle.getProducto().getPrecio());
                    }
                    break;

                case SERVICIO:

                    servicio.buscarServicio(servicios, detalle, factura);
                    //factura.setEmpleado(servicio.getEmpleado());
                    System.out.print("Ingrese la Cantidad de veces que recibio el Servicio: ");
                    detalle.setCantidadDetalle(teclado.nextDouble());
                    detalle.setSubtotal(detalle.getCantidadDetalle() * detalle.getServicio().getPrecio());
                    break;
                default:
                    System.out.println();
                    break;
            }

            //se agrega objeto detalle en su arraylist de detalles
            detalles.add(detalle);

            //se agrega arraylist detalle en clase factura
            factura.setDetalles(detalles);
        }


    }
}
