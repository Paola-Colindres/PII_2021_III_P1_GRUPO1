package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Factura {
    private long numeroFactura;
    private String fechaIngreso;
    private Cliente Cliente;
    private Empleado Empleado;
    private double subTotal;
    private double totalPagar;
    private double ISV;
    private double Descuento;
    private ArrayList<Detalle> Detalles;


    public Factura(){}
    public Factura(long pNumeroFactura, String pFechaIngreso, Cliente pCliente, Empleado pEmpleado,
                   double pSubTotal, double pTotalPagar, TipoDetalle pTipoDetalle,
                   double pISV, double pDescuento, ArrayList<Detalle> pDetalles) {
        this.numeroFactura = pNumeroFactura;
        this.fechaIngreso = pFechaIngreso;
        this.Cliente = pCliente;
        this.Empleado = pEmpleado;
        this.subTotal = pSubTotal;
        this.totalPagar = pTotalPagar;
        this.ISV = pISV;
        this.Descuento = pDescuento;
        this.Detalles = pDetalles;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }
    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public hn.edu.ujcv.objetos.Cliente getCliente() {
        return Cliente;
    }
    public void setCliente(hn.edu.ujcv.objetos.Cliente cliente) {
        Cliente = cliente;
    }

    public hn.edu.ujcv.objetos.Empleado getEmpleado() {
        return Empleado;
    }
    public void setEmpleado(hn.edu.ujcv.objetos.Empleado empleado) {
        Empleado = empleado;
    }

    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotalPagar() {
        return totalPagar;
    }
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }


    public double getISV() {
        return ISV;
    }
    public void setISV(double ISV) {
        this.ISV = ISV;
    }

    public double getDescuento() {
        return Descuento;
    }
    public void setDescuento(double descuento) {
        Descuento = descuento;
    }

    public ArrayList<Detalle> getDetalles() {
        return Detalles;
    }

    public void setDetalles(ArrayList<Detalle> detalles) {
        Detalles = detalles;
    }

    public void agregarFactura(ArrayList<Factura> facturas, ArrayList<Detalle> detalles,
                               ArrayList<Cliente> clientes, ArrayList<Empleado> empleados,
                               ArrayList<Producto> productos, ArrayList<Servicio> servicios) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Factura factura = new Factura();
        Cliente cliente = new Cliente(); Empleado empleado = new Empleado();
        Detalle detalle = new Detalle();

        System.out.print("Ingrese el numero de factura: ");
        factura.setNumeroFactura(teclado.nextLong());
        System.out.print("Ingrese la Fecha de Ingreso: ");
        factura.setFechaIngreso(teclado.next());

        System.out.print("Ingrese el Impuesto: ");
        factura.setISV(teclado.nextDouble());
        System.out.print("Ingrese el Descuento: ");
        factura.setDescuento(teclado.nextDouble());


        //cliente y empleado
        boolean estaVacio = clientes.isEmpty();
        if (estaVacio == true)
            System.out.println("No hay clientes ingresados.");
        else {

            cliente.buscarCliente(clientes, factura);

            //agregar ArrayList de Detalle
            detalle.agregarDetalle(detalles, productos, servicios, factura, empleados);

            //Subtotal y totalPagar
            double subTotal=0, isv=0, descuento=0;
            for (Detalle item: detalles) {
                subTotal = subTotal + item.getSubtotal();
            }
            factura.setSubTotal(subTotal);
            isv = (factura.getISV()/100) * subTotal;
            descuento = (factura.getDescuento()/100) * subTotal;
            factura.setTotalPagar(subTotal + isv - descuento);

            facturas.add(factura);
            }
    }

    public void validar(ArrayList<Factura> facturas, ArrayList<Detalle> detalles) {
        boolean aceptado;
        long numeroFactura;
        Factura factura = new Factura();
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");

        boolean vacio = facturas.isEmpty();
        if (vacio==true) {
            System.out.println("No hay facturas.");
        } else {

            do {
                aceptado = false;
                System.out.print("Ingrese el N. de Factura: ");
                numeroFactura = teclado.nextLong();

                for (Factura item: facturas) {
                    if (numeroFactura == item.getNumeroFactura()) {
                        factura.visualizar(item, item.getDetalles());
                        aceptado = true;
                    }
                }

            } while(aceptado == false);
        }
    }

    public void visualizar(Factura factura, ArrayList<Detalle> detalles) {
        System.out.println("Fecha de Ingreso: " + factura.getFechaIngreso());
        System.out.println("Cliente: " + factura.getCliente().getNombre());

        System.out.println("\n" + "Lista de Detalles:");
        for (Detalle item : detalles) {
            System.out.println("Tipo de Detalle: " + item.getTipoDetalle());
            switch (item.getTipoDetalle()) {
                case PRODUCTO:
                    System.out.println("Empleado: " + factura.getEmpleado().getNombre());
                    System.out.println("Nombre de producto: " + item.getProducto().getNombre());
                    System.out.println("Precio: " + item.getProducto().getPrecio());
                    System.out.println("Cantidad Llevada: " + item.getCantidadDetalle());
                    break;
                case SERVICIO:
                    System.out.println("Empleado: " + factura.getEmpleado().getNombre());
                    System.out.println("Precio de Servicio: " + item.getServicio().getPrecio());
                    System.out.println("Cantidad: " + item.getCantidadDetalle());
                    break;
            }

        }

        System.out.println();
        System.out.println("SubTotal: " + factura.getSubTotal());
        System.out.println("Y Total a Pagar: " + factura.getTotalPagar());
    }

}
