/**
 * @author Pareja 6 Hugo Elvira 15249 y Edgar Ramírez 15236
 * @version 02/10/2016
 * @Description: Interface priorityQueue
 */
public interface I_PriorityQueue <E extends Comparable<E>>{
	public E getFirst();
	public E remove();
	public void add(E value);
	public boolean isEmpty();
	public int size();
	public void clear();
}
