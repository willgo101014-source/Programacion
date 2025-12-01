package main;
import productos.*;
public class principal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				double suma = 0;

				double producto = 0;

				Productos prodmax = null;

				Productos[] Inventario = new Productos[3];



				Inventario[0] = new Productos("producto1", 13, 6);



				Inventario[1] = new Productos("producto2", 19, 3);



				Inventario[2] = new Productos("producto3", 9, 3);



				for (int i = 0; i < Inventario.length; i++) {

					Productos totialinv = Inventario[i];



					if (totialinv.getStock() > 5) {

						if (prodmax == null || totialinv.getPrecio() > prodmax.getPrecio()) {

							prodmax = totialinv;



						}



					}

				}

				 if (prodmax != null) {

			            System.out.println("Producto con mayor precio: " + prodmax.getNombre() + ", Precio: " + prodmax.getPrecio());

			        } else {

			            System.out.println("No hay productos con stock mayor a 5.");

			        }

			}

		}


