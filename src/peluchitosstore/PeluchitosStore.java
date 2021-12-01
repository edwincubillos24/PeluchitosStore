/*
 * Crear una aplicación para la tienda Peluchitos.com en el que se pueda hacer un 
CRUD (Create, Read, Update, Delete) y se almacene las propiedades: Nombre, Cantidad,
Precio, Tamaño y Referencia.
Se debe visualizar un menú en el que el usuario digite la opción deseada
1. Agregar
2. Buscar
3. Modificar
4. Borrar
5. Ver Inventario
6. Salir
 */
package peluchitosstore;

import java.util.ArrayList;
import java.util.Scanner;

class Peluchito {

    String nombre, tamano, referencia;
    int cantidad;
    double precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Peluchito() {
    }

    public Peluchito(String nombre, String tamano, String referencia, int cantidad, double precio) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}

public class PeluchitosStore {

    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Peluchito> listaPeluches = new ArrayList<Peluchito>();
        String nombre, tamano, referencia;
        int cantidad, opcion;
        double precio;

        do {
            opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    System.out.println("Digite la referencia del peluche");
                    referencia = lector.next();
                    System.out.println("Digite el nombre del peluche");
                    nombre = lector.next();
                    System.out.println("Digite la cantidad de peluches");
                    cantidad = lector.nextInt();
                    System.out.println("Digite el precio del peluche");
                    precio = lector.nextDouble();
                    System.out.println("Digite el tamaño: Grande, Mediano, Pequeño");
                    tamano = lector.next();
                    Peluchito peluchito = new Peluchito(nombre, tamano, referencia, cantidad, precio);
                    listaPeluches.add(peluchito);
                    break;
                case 2:
                    System.out.println("Digite el nombre del peluche a buscar");
                    nombre = lector.next();
                    boolean existeElPeluche = false;
                    for (int i = 0; i < listaPeluches.size(); i++) {
                        if (nombre.equals(listaPeluches.get(i).getNombre())) {
                            System.out.println("\nPELUCHE ENCONTRADO\nNombre: " + nombre
                                    + "\nReferencia: " + listaPeluches.get(i).getReferencia()
                                    + "\nCantidad: " + listaPeluches.get(i).getCantidad()
                                    + "\nPrecio: " + listaPeluches.get(i).getPrecio()
                                    + "\nTamaño: " + listaPeluches.get(i).getTamano());
                            existeElPeluche = true;
                        }
                    }
                    if (!existeElPeluche) {
                        System.out.println("¡PELUCHE NO EXISTE!");
                    }
                    break;
                case 3:
                    System.out.println("Digite el nombre del peluche a modificar");
                    nombre = lector.next();
                    existeElPeluche = false;
                    for (int i = 0; i < listaPeluches.size(); i++) {
                        if (nombre.equals(listaPeluches.get(i).getNombre())) {
                            System.out.println("Desea modificar la referencia  Digite 1. Si ó 2. No");
                            opcion = lector.nextInt();
                            if (opcion == 1) {
                                System.out.println("Digite la nueva referencia del peluche");
                                listaPeluches.get(i).setReferencia(lector.next());
                            }

                            System.out.println("Desea modificar el nombre Digite 1. Si ó 2. No");
                            opcion = lector.nextInt();
                            if (opcion == 1) {
                                System.out.println("Digite el nuevo nombre del peluche");
                                listaPeluches.get(i).setNombre(lector.next());
                            }
                            System.out.println("Digite la nueva cantidad de peluches");
                            listaPeluches.get(i).setCantidad(lector.nextInt());
                            System.out.println("Digite el nuevo precio del peluche");
                            listaPeluches.get(i).setPrecio(lector.nextDouble());
                            System.out.println("Digite el nuevo tamaño: Grande, Mediano, Pequeño");
                            listaPeluches.get(i).setTamano(lector.next());
                            existeElPeluche = true;
                            System.out.println("El peluche se ha modificado de forma exítosa");
                        }
                    }
                    if (!existeElPeluche) {
                        System.out.println("¡PELUCHE NO EXISTE!");
                    }
                    break;
                case 4:
                    System.out.println("Digite el nombre del peluche a eliminar");
                    nombre = lector.next();
                    existeElPeluche = false;
                    for (int i = 0; i < listaPeluches.size(); i++) {
                        if (nombre.equals(listaPeluches.get(i).getNombre())) {
                            listaPeluches.remove(i);
                            existeElPeluche = true;
                            System.out.println("¡PELUCHE ELIMINADO CON ÉXITO!");
                        }
                    }
                    if (!existeElPeluche) {
                        System.out.println("¡PELUCHE NO EXISTE!");
                    }
                    break;
                case 5:
                    /*    int i=0;    //Con ciclo while
                    while(i<referenciaList.size()){
                        System.out.println("\nReferencia: "+referenciaList.get(i));
                        i++;
                    }*/
                    for (int i = 0; i < listaPeluches.size(); i++) {
                        System.out.println("\nNombre: " + listaPeluches.get(i).getNombre()
                                + "\nReferencia: " + listaPeluches.get(i).getReferencia()
                                + "\nCantidad: " + listaPeluches.get(i).getCantidad()
                                + "\nPrecio: " + listaPeluches.get(i).getPrecio()
                                + "\nTamaño: " + listaPeluches.get(i).getTamano());
                    }
                    break;
                case 6:
                    System.out.println("Gracias totales, chao chao");
                    break;
                default:
                    System.out.println("¡Opción incorrecta!");
                    break;
            }
        } while (opcion != 6);
    }

    private static int mostrarMenu() {
        int opcion;
        System.out.println("\nPeluchitos Store\n1.Agregar\n2.Buscar\n3.Modificar\n4.Borrar"
                + "\n5.Ver Inventario\n6. Salir\nDigite la opción deseada");
        opcion = lector.nextInt();
        return opcion;
    }
}
