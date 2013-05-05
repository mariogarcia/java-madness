package challenge;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Quick implementation of a CircularList<E> interface. 
 *
 * One feature of this implementation is the use of Nullable<E> objects. 
 * This idea's been taken from the Optional object in Scala. These type of objects help to avoid NPE
 * because the method always return an object. That object can carry a value
 * or not, but anyway you can always ask the object if it has a value or not.
 *
 * @author @marioggar
 *
 **/
class CircularListImpl<E> implements CircularList<E>{

	private Nullable<E> current = new Nullable<E>(null);
	private LinkedList<Nullable<E>> list = new LinkedList<Nullable<E>>();
	private ListIterator<Nullable<E>> listIterator;

	public CircularListImpl(){
		listIterator = list.listIterator();
	}

	/**
	 * This method returns the next element in the list and moves the header
	 * to that element. So the current element once the method's been called
	 * will be the next element.
	 *
	 * @return the element right after the current element
	 *
	 **/
	public Nullable<E> next(){
		if (current.isNull()){
			return current;
		}
		if(list.getLast().equals(current)){
			current = list.getFirst();
			return current;
		}
		return listIterator.next();
	}

	/**
	 * This method returns the previous element in the list and moves the header
	 * to that element. So the current element once the method's been called
	 * will be the previous element.
	 *
	 * @return the element right before the current element
	 *
	 **/
	public Nullable<E> previous(){				
		if (current.isNull()){
			return current;
		}
		if (list.getFirst().equals(current)){
			current = list.getLast();
			return current;
		}
		return listIterator.previous();
	}

	/**
	 * This method returns the first available element
	 *
	 * @return the first available element
	 **/
	public Nullable<E> current(){
		return current;
	}	

	/**
	 * This method adds a new element to the list. The new element becomes the current
	 * element
	 *
	 * @param added The element we want to add
	 * @return a Nullable instance object carrying the inserted element
	 *
	 **/
	public CircularList<E> add(E added){
		current = new Nullable<E>(added);
		list.add(current);
		int index = list.indexOf(current);
		listIterator = index <= 1 ? list.listIterator() : list.listIterator(index - 1);
		return this;
	}

	/**
	 * This method inserts the second parameter right after where the first parameter is
	 * within the list
	 *
	 * @param pointer The element we use to locate where the added object is going to be
	 * @param added The element we want to add
	 * @return the added element
	 *
	 **/
	public CircularList<E> insertAfter(E pointer,E added){
	 /* Wrapping current with Nullable */
		current = new Nullable<E>(added);
	 /* Building the pointer */
		Nullable<E> pointerElement = new Nullable<E>(pointer);
	 /* If we're at the end the it's a matter to add the new element to the list */
		if (list.isEmpty() || list.getLast().equals(pointerElement)){
			return add(added);
		}
	 /* Otherwise we have to get the next element after the pointer and shift the 
	  * rest of elements to the right */
		int index = list.indexOf(pointerElement) + 1; 
		list.add(index,current);
	 /* Setting the iterator */
		listIterator = list.listIterator(list.indexOf(current));
	 /* Returning current */
		return this;
	}

	/**
	 * This method helps to know whether the list is empty or not
	 *
	 * @return true if the list is empty false otherwise
	 *
	 **/
	public boolean isEmpty(){
		return list.isEmpty();
	}

	/**
	 * This method removes all elements in the list
	 **/
	public void clear(){
		list.clear();
	}

	/**
	 * This method returns the number of elements this list has
	 **/
	public int size(){
		return list.size();
	}

}

