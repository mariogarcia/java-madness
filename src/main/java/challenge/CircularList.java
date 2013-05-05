package challenge;

/**
 * This interface represents a challenge. For me it was really hard to implement
 * when I face it first time. So I decided to do it no matter what it took.
 *
 * I may have forgotten some of the contracts of this type of list but I think
 * here there are the most important ones.
 *
 * @author @marioggar
 *
 **/
interface CircularList<E>{

	/**
	 * This method returns the next element in the list and moves the header
	 * to that element. So the current element once the method's been called
	 * will be the next element.
	 *
	 * @return the element right after the current element
	 *
	 **/
	public Nullable<E> next();
	/**
	 * This method returns the previous element in the list and moves the header
	 * to that element. So the current element once the method's been called
	 * will be the previous element.
	 *
	 * @return the element right before the current element
	 *
	 **/
	public Nullable<E> previous();
	/**
	 * This method returns the first available element
	 *
	 * @return the first available element
	 **/
	public Nullable<E> current();
	/**
	 * This method adds a new element to the list. The new element becomes the current
	 * element
	 *
	 * @param added The element we want to add
	 * @return a Nullable instance object carrying the inserted element
	 *
	 **/
	public CircularList<E> add(E added);
	/**
	 * This method inserts the second parameter right after where the first parameter is
	 * within the list
	 *
	 * @param pointer The element we use to locate where the added object is going to be
	 * @param added The element we want to add
	 * @return the added element
	 *
	 **/
	public CircularList<E> insertAfter(E pointer,E added);
	/**
	 * This method helps to know whether the list is empty or not
	 *
	 * @return true if the list is empty false otherwise
	 *
	 **/
	public boolean isEmpty();
	/**
	 * This method removes all elements in the list
	 **/
	public void clear();
	/**
	 * This method returns the number of elements this list has
	 **/
	public int size();

}
