package challenge;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

class CircularListImpl<E> implements CircularList<E>{

	private E current = null;
	private LinkedList<E> list = new LinkedList<E>();
	private ListIterator<E> listIterator = null;

	public E next(){
		if (current == null){
			return null;
		}
		if(current == list.getLast()){
			current = list.getFirst();
			return current;
		}
		return listIterator.next();
	}

	public E previous(){				
		if (current == null){
			return null;
		}
		if (current == list.getFirst()){
			current = list.getLast();
			return current;
		}
		return listIterator.previous();
	}

	public E current(){
		return current;
	}	

	public E add(E added){
		current = added;
		list.add(current);
		listIterator = list.listIterator(list.indexOf(current));
		return current;
	}

	public E insertAfter(E pointer,E added){
		int index = list.indexOf(pointer);
		list.set(index,added);
		listIterator = list.listIterator(index);
		current = added;

		return added;
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}

	public void clear(){
		list.clear();
	}

	public int size(){
		return list.size();
	}

}

