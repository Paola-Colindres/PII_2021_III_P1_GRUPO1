package hn.edu.ujcv.objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {
    //codigo, nombre, fechaIngreso, puesto
    private String Codigo;
    private String Nombre;
    private String FechaIngreso;
    private String Puesto;

    public Empleado(){
    }
    public Empleado(String pCodigo, String pNombre,
                    String pFechaIngreso, String pPuesto) {
        this.Codigo       = pCodigo;
        this.Nombre       = pNombre;
        this.FechaIngreso = pFechaIngreso;
        this.Puesto       = pPuesto;
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

    public String getFechaIngreso() {
        return FechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public String getPuesto() {
        return Puesto;
    }
    public void setPuesto(String puesto) {
        Puesto = puesto;
    }

    //crear los metodos -agregar, visualizar, buscar, validar-
    public void agregar(ArrayList<Empleado> empleados) {
        try {

            Scanner teclado = new Scanner(System.in).useDelimiter("\n");
            Empleado empleado = new Empleado();
            System.out.print("Ingrese el Codigo: ");
            empleado.setCodigo(teclado.next());
            System.out.print("Ingrese el Nombre: ");
            empleado.setNombre(teclado.next());
            System.out.print("Ingrese la Fecha de Ingreso: ");
            empleado.setFechaIngreso(teclado.next());
            System.out.print("Ingrese el Puesto: ");
            empleado.setPuesto(teclado.next());
            empleados.add(empleado);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void visualizar(ArrayList<Empleado> empleados) {
        for (Empleado item: empleados) {
            System.out.println("Empleado: " + item.getNombre()
            + " - " + item.getCodigo() + " - "
            + item.getFechaIngreso() + " - " + item.getPuesto());
        }
    }

    public void buscarEmpleado(ArrayList<Empleado> empleados, Servicio servicio) {
        try {

            Scanner teclado = new Scanner(System.in).useDelimiter("\n");
            boolean acertado;
            String codigo;
            Empleado empleado = new Empleado();

            //mostrar empleados
            empleado.visualizar(empleados);

            do {
                acertado = false;
                System.out.print("Ingrese el Codigo del Empleado: ");
                codigo = teclado.next();

                for (Empleado item: empleados) {
                    if (codigo.equalsIgnoreCase(item.getCodigo())) {
                        servicio.setEmpleado(item);
                        acertado = true;
                        break;
                    } else {
                        System.out.println("No se encuentra un empleado con ese codigo."); //validar
                    }
                }

            } while (acertado == false);
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void buscarEmpleado_Factura(ArrayList<Empleado> empleados, Factura factura) {
        try {

            Scanner teclado = new Scanner(System.in).useDelimiter("\n");
            boolean acertado;
            String codigo;
            Empleado empleado = new Empleado();

            //mostrar empleados
            empleado.visualizar(empleados);

            do {
                acertado = false;
                System.out.print("Ingrese el Codigo del Empleado: ");
                codigo = teclado.next();

                for (Empleado item : empleados) {
                    if (codigo.equalsIgnoreCase(item.getCodigo())) {
                        factura.setEmpleado(item);
                        acertado = true;
                        break;
                    } else {
                        System.out.println("No se encuentra un empleado con ese codigo."); //validar
                    }
                }

            } while (acertado == false);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
