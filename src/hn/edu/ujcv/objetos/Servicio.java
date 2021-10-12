package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Servicio {
    private String codigo;
    private String descripcion;
    private double precio;
    private Empleado Empleado;

    public Servicio(){
    }
    public Servicio(String pCodigo, String pDescripcion, double pPrecio, Empleado pEmpleado){
        this.codigo = pCodigo;
        this.descripcion = pDescripcion;
        this.precio = pPrecio;
        this.Empleado = pEmpleado;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public hn.edu.ujcv.objetos.Empleado getEmpleado() {
        return Empleado;
    }
    public void setEmpleado(hn.edu.ujcv.objetos.Empleado empleado) {
        Empleado = empleado;
    }

    public void agregarServicio(ArrayList<Servicio> servicios, ArrayList<Empleado> empleados) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Servicio servicio = new Servicio();
        Empleado empleado = new Empleado();
        String respuesta;
        do {
            System.out.print("Ingrese el Codigo del servicio: ");
            servicio.setCodigo(teclado.next());
            System.out.print("Ingrese descripcion del servicio brindado: ");
            servicio.setDescripcion(teclado.next());
            System.out.print("Ingrese precio del servicio: ");
            servicio.setPrecio(teclado.nextDouble());
            System.out.println("\nDATOS DEL EMPLEADO QUE ATENDIÓ");
            empleado.buscarEmpleado(empleados, servicio);

            servicios.add(servicio);
            System.out.println("Desea agregar otro servicio S/N?");
            respuesta = teclado.next();
        }while(respuesta.equalsIgnoreCase("s"));

    }
    public void visualizarServicio(ArrayList<Servicio> servicios){
        for (Servicio item: servicios) {
            System.out.println("SERVICIO BRINDADO");
            System.out.println("Codigo: "+item.getCodigo()+
                    "\nDescripcion: "+item.getDescripcion()+
                    "\nPrecio: "+item.getPrecio()+
                    "\nAtendido por: "+item.getEmpleado().getNombre());
        }
    }

    public void buscarServicio(ArrayList<Servicio> servicios, Detalle detalle, Factura factura) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Servicio servicio = new Servicio();
        String codigo;
        boolean acertado;

        //mostrar servicios
        servicio.visualizarServicio(servicios);

        boolean vacio = servicios.isEmpty();

        if (vacio == true) {
            System.out.println("No hay servicios ingresados");
        } else {
            do {
                acertado = false;
                System.out.print("Ingrese el Codigo del servicio: ");
                codigo = teclado.next();

                for (Servicio item : servicios) {
                    if (codigo.equalsIgnoreCase(item.getCodigo())) {
                        detalle.setServicio(item);
                        factura.setEmpleado(item.getEmpleado());
                        acertado = true;
                    } else {
                        System.out.println("No se encuentra un Producto con ese codigo."); //validar
                    }
                }
            } while (acertado == false);
        }
    }
}
