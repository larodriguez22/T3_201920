package controller;

import java.util.Scanner;

import model.data_structures.DoubleLinkedList;
import model.logic.MVCModelo;
import model.logic.UBERTrip;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private static MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	private int hora;

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
				view.printMessage("--------- \n Cargando Viajes ");
				modelo = new MVCModelo();
				try {
					modelo.crearLista();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				view.printMessage("Lista creada");
				view.printMessage("El total de viajes (líneas) leídos para el primer trimestre del año es "+modelo.darTamano());
				view.printMessage("Informacion primer viaje: "+ modelo.buscar(0).getSourceid()+", "+modelo.buscar(0).getDstid()+", "+modelo.buscar(0).getHod()+", "+modelo.buscar(0).getMean_travel_time());
				view.printMessage("Informacion ultimoViaje viaje: "+ modelo.buscar(modelo.darTamano()).getSourceid()+", "+modelo.buscar(modelo.darTamano()).getDstid()+", "+modelo.buscar(modelo.darTamano()).getHod()+", "+modelo.buscar(modelo.darTamano()).getMean_travel_time());
				break;

			case 2:
				view.printMessage("--------- \n Seleccione la hora: ");
				hora = lector.nextInt();
				UBERTrip[] viajes = (UBERTrip[]) modelo.ViajesHoraDada(hora);

				view.printMessage("El número de viajes resultantes de la consulta es: "+viajes.length);

				break;


			case 3:
				view.printMessage("--------- \\n Ordenar por MergeSort:");
				double tiempoMilisegundos = modelo.ordenarPorMerge(hora);
				view.printMessage("El numero total de viajes es:" + tiempoMilisegundos);
				view.printMessage("--------- \\n Ordenar por ShellSort:");

				for(int i=0; i<10;i++)
				{
					view.printMessage("Informacion viaje1: "+ modelo.buscar(i).getSourceid()+", "+modelo.buscar(i).getDstid()+", "+modelo.buscar(i).getHod()+", "+modelo.buscar(i).getMean_travel_time());
				}

				for(int i=modelo.darTamano(); i>modelo.darTamano()-10;i--)
				{
					view.printMessage("Informacion viaje1: "+ modelo.buscar(i).getSourceid()+", "+modelo.buscar(i).getDstid()+", "+modelo.buscar(i).getHod()+", "+modelo.buscar(i).getMean_travel_time());
				}
				break;
				
			case 4:
				view.printMessage("--------- \\n Ordenar por ShellSort:");
				double tiempoMilisegundos2 = modelo.ordenarPorShell(hora);
				view.printMessage("El numero total de viajes es:" + tiempoMilisegundos2);

				for(int i=0; i<10;i++)
				{
					view.printMessage("Informacion viaje1: "+ modelo.buscar(i).getSourceid()+", "+modelo.buscar(i).getDstid()+", "+modelo.buscar(i).getHod()+", "+modelo.buscar(i).getMean_travel_time());
				}

				for(int i=modelo.darTamano(); i>modelo.darTamano()-10;i--)
				{
					view.printMessage("Informacion viaje1: "+ modelo.buscar(i).getSourceid()+", "+modelo.buscar(i).getDstid()+", "+modelo.buscar(i).getHod()+", "+modelo.buscar(i).getMean_travel_time());
				}
				break;
				
			case 5:
				view.printMessage("--------- \\n Ordenar por QuickSort:");
				double tiempoMilisegundos3 = modelo.ordenarPorQuick(hora);
				view.printMessage("El numero total de viajes es:" + tiempoMilisegundos3);

				for(int i=0; i<10;i++)
				{
					view.printMessage("Informacion viaje1: "+ modelo.buscar(i).getSourceid()+", "+modelo.buscar(i).getDstid()+", "+modelo.buscar(i).getHod()+", "+modelo.buscar(i).getMean_travel_time());
				}


				for(int i=modelo.darTamano(); i>modelo.darTamano()-10;i--)
				{
					view.printMessage("Informacion viaje1: "+ modelo.buscar(i).getSourceid()+", "+modelo.buscar(i).getDstid()+", "+modelo.buscar(i).getHod()+", "+modelo.buscar(i).getMean_travel_time());
				}
				break;

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}

		}	

	}
}
