import java.util.Vector;

/**
 * @author Pareja 6 Hugo Elvira 15249 y Edgar Ramírez 15236
 * @version 02/10/2016
 * @Description: Implementacion de VectorHeap con I_PriorityQueue
 */
public class VectorHeap_Implementada<E extends Comparable<E>> implements I_PriorityQueue<E>{

	protected Vector<E> data; // the data, kept in heap order
	
	/**
	 * Constructor
	 */
	public VectorHeap_Implementada(){
		data = new Vector<E>();
	}
	
	/**
	 * @descripcion: Constructor, convierte un vector normal a vectorheap
	 */
	public VectorHeap_Implementada(Vector<E> v){
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
			{ // add elements to heap
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

	/**
	 * @descripcion: mueve un nodo a una posicion deseada
	 */
	protected void percolateUp(int nodo){
		int parent = parent(nodo);
		E value = data.get(nodo);
		while (nodo > 0 && (value.compareTo(data.get(parent)) < 0))
		{
			data.set(nodo,data.get(parent));
			nodo = parent;
			parent = parent(nodo);
		}
		data.set(nodo,value);
	}
	
	/**
	 * @Descripcion: mueve un nodo raiz a alguna posicion
	 */
	protected void pushDownRoot(int root){
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) 
		{
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) && ((data.get(childpos+1)).compareTo (data.get(childpos)) < 0))
				{
					childpos++;
				}
				if ((data.get(childpos)).compareTo (value) < 0)
				{
					data.set(root,data.get(childpos));
					root = childpos; 
			} else { 
				data.set(root,value);
				return;
			}
			} else { 
				data.set(root,value);
				return;
			}
		}
	}

	
	/**
	 * @Descripcion: añade un valor
	 */
	public void add(E value){
		data.add(value);
		percolateUp(data.size()-1);
	}

	/**
	 * @Descripcion: remueve y retorna el valor del primer nodo
	 */
	@Override
	public E remove() {
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if(data.size()>1){pushDownRoot(0);};
		return minVal;
	}

	/**
	 * @Descripcion: indica si esta vacio o no el vectorheap
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @Descripcion: indica el tamaño
	 */
	public int size() {
		return data.size();
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return data.get(0);
	}
}

