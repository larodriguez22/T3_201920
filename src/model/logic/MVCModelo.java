package model.logic;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import com.opencsv.CSVReader;

import model.data_structures.DoubleLinkedList;
import model.sort.Shell;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private DoubleLinkedList<UBERTrip> datos;

	private int tamano;
	private UBERTrip viaje;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new DoubleLinkedList<UBERTrip>();
	}
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.size();
	}

	public void crearLista() throws Exception
	{
		CSVReader reader=null;

		reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-HourlyAggregate.csv"));
		String [] nextLine=reader.readNext();
		while (nextLine != null) {
			// nextLine[] is an array of values from the line
			datos.agregar(new UBERTrip(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
			nextLine = reader.readNext();
		}
		reader.close();
	}

	
	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(UBERTrip v, int lista)
	{	
		datos.agregar(v);
	}

	/**
	 * Requerimiento buscar dato
	 * @param <T>
	 * @param dato Dato a buscar
	 * @return 
	 * @return dato encontrado
	 */
	public UBERTrip buscar(int pos)
	{
		return datos.get(pos);
	}
	
	public double ordenarPorShell(UBERTrip v)
	{
		Shell ordenar= new Shell();
		//ordenar.sort(datos);
		
		return 0;
	}
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public void eliminar(int pos, int lista)
	{
		datos.remove(pos);
	}

	public DoubleLinkedList<UBERTrip> ViajesHoraDada(int hora) 
	{
		DoubleLinkedList<UBERTrip> lista= new DoubleLinkedList<UBERTrip>();
		Iterator ite=datos.iterator();
		while(ite.hasNext())
		{
			UBERTrip viaje=(UBERTrip) ite.next();
			if(viaje.getHod()==hora)
			{
				lista.agregar(viaje);
			}
		}
		return lista;
	}
	
}
