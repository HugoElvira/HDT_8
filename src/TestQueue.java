import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.junit.Test;

/**
 * @author Pareja 6 Hugo Elvira 15249 y Edgar Ramírez 15236
 * @version 02/10/2016
 * @Description: Test de la implementacion de VectorHeap 
 */
public class TestQueue {

	@Test
	public void test() throws FileNotFoundException {
		String file = "pacientes.txt";
		String[] separador; 
		BufferedReader br = new BufferedReader(new FileReader(file));
	    String line;
	    
	    Vector<Agenda_Clinica> listado = new Vector<Agenda_Clinica>();
	    
        try {
			while ((line = br.readLine()) != null) {
			    separador=line.split(",");
			    listado.add(new Agenda_Clinica(separador[0], separador[1], separador[2]));
			}
		} catch (IOException e) {
			System.out.println("error");
		}

		//Lista ordenadda usando implementacion de PiorityQueue
		System.out.println("\nOrden por grado de emergencia  (Usando VectorHeap implementado)\n");
		
		String listaOrdenada_Implementada="";
		VectorHeap_Implementada vector_heap_implementada = new VectorHeap_Implementada(listado);
		int size=vector_heap_implementada.size();
		
		for(int i=0; i<size; i++){
			Agenda_Clinica paciente = (Agenda_Clinica)vector_heap_implementada.remove();
			listaOrdenada_Implementada += paciente.toString()+"\n";
		}
		
		System.out.println(listaOrdenada_Implementada);
	}

}
