import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * @author Pareja 6 Hugo Elvira 15249 y Edgar Ramírez 15236
 * @version 02/10/2016
 * @Description: Ordena la agenda de la clinica en general, por nivel de emergencia
 */
public class Agenda_Clinica<E> implements Comparable<E> {
	
	private String nombre;	//Nombre de paciente 
	private String sintoma;	//Sintoma de paciente 
	private String emergencia;	//Codigo de Emergencia de Paciente 
	
	/**
	 * @Descripcion: muestra la lista original y ordenada por emegencia usando las dos formas(implementada y java Collection)
	 */
	
	public void Mostrar() throws FileNotFoundException{

			//Lector de archivo
		    //usando mismo codio de hoja 4, donde se necesito para calculadora postfix
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
		        
		        //Imprime la lista de pacientes directamente del archivo(sin ordenar)
		        System.out.println("Agenda Original\n");
		        for(int i=0; i<listado.size(); i++){
		            System.out.println(listado.get(i));
				}

		        //Lista ordenadda usando  PiorityQueue de JavaCollection
		        System.out.println("\nOrden por grado de emergencia  (Usando VectorHeap con Java Collection)\n");
		        
		        VectorHeap_JCollection vectorHeap = new VectorHeap_JCollection(listado);
				String listaOrdenada_JC="";
		        while(vectorHeap.iterator().hasNext()){
		        	Agenda_Clinica paciente = (Agenda_Clinica) vectorHeap.poll();
		        	listaOrdenada_JC += paciente.toString()+"\n";
				}
				
				
				System.out.println(listaOrdenada_JC);
				
				
				
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
		
	
	
	
	
	public Agenda_Clinica (String Nombre, String Sintoma, String nivelE) {
		nombre=Nombre;
		sintoma=Sintoma;
		emergencia=nivelE;
	}
	
	/**
	 * @Descripcion:devuelve el nivel  de emergencia del paciente(letra indicadora)
	 */
	public String getCode(){
		return emergencia;
	}
	
	/**
	 * @Descripcion:realiza la comparacion entre pacientes
	 */
	@Override
	public int compareTo(E paciente) {
		String nivel=((Agenda_Clinica)paciente).getCode();
		return emergencia.compareTo(nivel);
	}

	/**
	 * @Descripcion:concatena nuevamente los nombres, enfermedad y nivel de emergencia del paciente
	 */
	public String toString(){
		return nombre+", "+sintoma+", "+emergencia;
	}

}


