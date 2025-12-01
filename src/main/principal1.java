package main;
import productos.*;
public class principal1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

double suma= 0;



		

		Productos[] Inventario= new Productos[3];

		

		Inventario[0]= new Productos("producto1", 13, 3);

		

	    Inventario[1]= new Productos("producto2", 10, 3);

	   

	    Inventario[2]= new Productos("producto3", 9, 3) ;

	    

	    for (int i = 0; i < Inventario.length; i++) {

	    

	    	if (Inventario[i] != null && Inventario[i].getStock() % 2 != 0) {

	    		suma = suma + Inventario[i].getPrecio();


	        

	    }

	    System.out.println(suma);

	}

	    	

	    

}

}

