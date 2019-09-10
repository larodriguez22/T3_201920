package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Crear Lista encadenada de UBERTrips");
			System.out.println("2. Consultar  los viajes de una hora dada");
			System.out.println("3. Ordenar ascendentemente los viajes resultantes de la consulta anterior por ShellSort");
			System.out.println("4. Ordenar ascendentemente los viajes resultantes de la consulta por MergeSort");
			System.out.println("5. Ordenar ascendentemente los viajes resultantes de la consulta por QuickSort");
			System.out.println("6. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(MVCModelo modelo)
		{
			// TODO implementar
		}
}
