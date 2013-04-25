package challenge;

interface CircularList<E> {

	public E next();
	public E previous();
	public E current();
	public E add(E added);
	public E insertAfter(E pointer,E added);
	public boolean isEmpty();
	public void clear();
	public int size();

}
