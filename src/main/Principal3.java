package main;
import productos.*;

public class Principal3 {

    public static void main(String[] args) {

        int index = 0;

        Productos[] Inventario = new Productos[4];

        Inventario[0] = new Productos("producto1", 13, 6);
        Inventario[1] = new Productos("producto2", 19, 3);
        Inventario[2] = null;
        Inventario[3] = new Productos("producto4", 2, 3);


        // 1. Mover elementos NO NULL al inicio del array
        for (int i = 0; i < Inventario.length; i++) {
            if (Inventario[i] != null) {
                Inventario[index++] = Inventario[i];
            }
        }

        // 2. Rellenar lo que queda con NULL
        while (index < Inventario.length) {
            Inventario[index++] = null;
        }

        // Mostrar el inventario resultante
        System.out.println("Inventario después de compactar:");
        for (Productos p : Inventario) {
            if (p != null)
                System.out.println(p.getNombre() + " - Precio " + p.getPrecio());
            else
                System.out.println("null");
        }
    }
}
