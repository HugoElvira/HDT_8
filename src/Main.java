import java.io.FileNotFoundException;

/**
 * @author Pareja 6 Hugo Elvira 15249 y Edgar Ramírez 15236
 * @version 02/10/2016
 * @Description: permite una interfaz entre el usuario y la computadora
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Agenda_Clinica ejecutar=new Agenda_Clinica(null, null, null);
		ejecutar.Mostrar();
	
}
}