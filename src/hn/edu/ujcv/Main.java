package hn.edu.ujcv;

import hn.edu.ujcv.objetos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //en el main deben estar los objetos y la estructura del programa,
        //las unicas validaciones es que ingrese a los menus correctos.
        //Las demas validaciones deben estar en las clases, para ello:
        //crear los metodos -agregar, visualizar, buscar, validar-

        //se sube a github individualmente

        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        int opcion; String respuesta;

        //Objetos:
        ArrayList<Producto> productos = new ArrayList<>(); Producto producto = new Producto();
        ArrayList<Cliente>   clientes = new ArrayList<>(); Cliente cliente = new Cliente();
        ArrayList<Empleado> empleados = new ArrayList<>(); Empleado empleado = new Empleado();
        ArrayList<Factura>   facturas = new ArrayList<>(); Factura factura = new Factura();
        ArrayList<Detalle>   detalles = new ArrayList<>(); //Detalle detalle = new Detalle();
        ArrayList<Servicio> servicios = new ArrayList<>(); Servicio servicio = new Servicio();

        try {
            do {
                System.out.println("Elija una opcion");
                System.out.println("1 - Agregar Productos" + "\n"
                        + "2 - Agregar Clientes" + "\n"
                        + "3 - Agregar Empleados" + "\n"
                        + "4 - Agregar Servicios" + "\n"
                        + "5 - Agregar Facturas" + "\n"
                        + "6 - Visualizar Factura");
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        producto.agregar(productos);
                        break;
                    case 2:
                        cliente.agregar(clientes);
                        break;
                    case 3:
                        empleado.agregar(empleados);
                        break;
                    case 4:
                        servicio.agregarServicio(servicios, empleados);
                        break;
                    case 5:
                        factura.agregarFactura(facturas, detalles, clientes, empleados, productos, servicios);
                        break;
                    case 6:
                        factura.validar(facturas, detalles);
                        break;
                    default:
                        System.out.println("Opcion invalida.");
                        break;
                }


                System.out.println("Desea seguir? S/N");
                respuesta = teclado.next();

            } while (respuesta.equalsIgnoreCase("s"));

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());
        }

    }
}
