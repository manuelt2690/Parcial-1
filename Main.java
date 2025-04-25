mport java.util.Scanner;

public class InventarioZapatosSimple {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nombre = "";
        int cantidad = 0;
        int vendidos = 0;

        System.out.println("TIENDA DE ZAPATOS - INVENTARIO SIMPLE");

        System.out.print("\nNombre del zapato: ");
        nombre = input.nextLine();

        System.out.print("Cantidad en stock: ");
        cantidad = input.nextInt();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOPCIONES:");
            System.out.println("1. Vender zapatos");
            System.out.println("2. Ver inventario");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");

            int opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    // Vender
                    System.out.print("Cuantos pares quiere vender? ");
                    int venta = input.nextInt();

                    if (venta <= (cantidad - vendidos)) {
                        vendidos += venta;
                        System.out.println("Venta realizada!");

                        // Duplicar si se agotó
                        if ((cantidad - vendidos) == 0) {
                            cantidad *= 2;
                            System.out.println("Se duplicó el inventario!");
                        }
                    } else {
                        System.out.println("No hay suficiente stock!");
                    }
                    break;

                case 2:
                    // Ver inventario
                    System.out.println("\nINVENTARIO ACTUAL");
                    System.out.println("Producto: " + nombre);
                    System.out.println("Stock inicial: " + cantidad);
                    System.out.println("Vendidos: " + vendidos);
                    System.out.println("Disponibles: " + (cantidad - vendidos));
                    break;

                case 3:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }

        input.close();
    }
}
