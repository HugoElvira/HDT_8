import java.util.PriorityQueue;
import java.util.Vector;

/**
 * @author Pareja 6 Hugo Elvira 15249 y Edgar Ramírez 15236
 * @version 02/10/2016
 * @Description: VectorHeap usando java collection 
 */

	public class VectorHeap_JCollection< E extends Comparable<E>> extends PriorityQueue<E>{

		protected Vector<E> data; // the data, kept in heap order
		
		/**
		 * Constructor
		 */
		public VectorHeap_JCollection(){
		data = new Vector<E>();}
		
		/**
		 *@Description: Constructor que recibe un vector como parametro
		 */
		public VectorHeap_JCollection(Vector<E> v){
		int i;
		data = new Vector<E>(v.size()); 
		for (i = 0; i < v.size(); i++){ 
			add(v.get(i));
			}
		
		}
		
		/**
		 * @return el padre del nodo deseado
		 */
		protected static int parent(int i){return (i-1)/2;}
		
		/**
		 * @return la localidad del hijo izquierdo de un nodo 
		 */
		protected static int left(int i){return 2*i+1;}
		
		/**
		 * @return la localidad del hijo derecho de un nodo 
		 */
		protected static int right(int i){return 2*(i+1);}
		
	}


