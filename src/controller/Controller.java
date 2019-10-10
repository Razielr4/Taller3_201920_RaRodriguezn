package controller;

import java.util.Scanner;

import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					double datos[][] = modelo.carga();
					for(int i=0;i<datos.length;i++){
						System.out.println("-Para el trimestre"+(i+1)+":");
						System.out.println("	-El numero de datos leidos es:"+datos[i][0]);
						System.out.println("	-Para el primer viaje: "+datos[i][1]+" | "+datos[i][2]+" | "+datos[i][3]+" | "+datos[i][4]);
						System.out.println("	-Para el ultimo viaje: "+datos[i][5]+" | "+datos[i][6]+" | "+datos[i][7]+" | "+datos[i][8]);
						System.out.println();
					}
					System.out.println("Linear Probing | Separate Chaining");
					System.out.println("Número de duplas:"+modelo.getL().getN()+"|"+modelo.getS().getN());
					System.out.println("Tamaño final del arreglo:"+modelo.getL().getM()+"|"+modelo.getS().getM());
					System.out.println("Factor de carga final: "+modelo.getL().factor()+"|"+modelo.getS().factor());
					System.out.println("Número de rehashes: "+modelo.getL().numeroRe()+"|"+ modelo.getS().numeroRe());
										
					break;
	
					
				case 6: 
					System.out.println("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					System.out.println("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
