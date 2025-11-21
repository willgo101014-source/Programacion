package main;

import productos.*;
public class principal4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 

        int index = 0;

        Productos[] Inventario = new Productos[3];

        Inventario[0] = new Productos("producto1", 13, 6);
        Inventario[1] = new Productos("producto2", 19, 3);
        Inventario[2] = new Productos("producto3", 9, 3);

     

        for (int i = 0; i < Inventario.length; i++) {
            if (Inventario[i] != null) {
                Inventario[index++] = Inventario[i];
            }
        }

        while (index < Inventario.length) {
            Inventario[index++] = null;
        }

       
        System.out.println("Inventario después de compactar:");
        for (Productos p : Inventario) {
            if (p != null)
                System.out.println(p.getNombre() + " - Precio: " + p.getPrecio());
            else
                System.out.println("null");
        }

     
        if (Inventario.length > 0) {

            int indiceMax = 0;
            int indiceMin = 0;

            // Encontrar índices del más caro y más barato
            for (int i = 1; i < Inventario.length; i++) {

                if (Inventario[i] != null) { 

                    if (Inventario[i].getPrecio() > Inventario[indiceMax].getPrecio()) {
                        indiceMax = i;
                    }

                    if (Inventario[i].getPrecio() < Inventario[indiceMin].getPrecio()) {
                        indiceMin = i;
                    }

                }
            }

            // Intercambiar
            Productos temp = Inventario[indiceMax];
            Inventario[indiceMax] = Inventario[indiceMin];
            Inventario[indiceMin] = temp;

            // Mostrar resultado del intercambio
            System.out.println("\nIntercambio realizado:");
            System.out.println("Producto más caro ↔ más barato\n");

            for (Productos p : Inventario) {
                if (p != null)
                    System.out.println(p.getNombre() + " - Precio: " + p.getPrecio());
                else
                    System.out.println("null");
            }
        }
    }
}
