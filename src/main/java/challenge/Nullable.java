package challenge;

/**
 * This class is inspired in the Scala Optional object. This
 * type of objects help to avoid NPE. You shouldn't be facing
 * null checking statements cause the Nullable object takes care 
 * of it.
 *
 * When returning a Nullable<E> object the only thing you have
 * to do is to ask the object: Do you have a value? or more accurate
 * Are you null? using its isNull() method.
 *
 * @author @marioggar
 *
 **/
class Nullable<E>{

	private E value;

	/**
	 * The inner value is immutable. Once you set the value
	 * there's no setter method to change it.
	 *
	 * @param value The value of the object
	 *
	 **/
	public Nullable(E value){
		this.value = value;
	}

	/**
	 * Returns the real value of the object. Warning! ask first
	 * to isNull() ;)
	 *
	 * @return the value the object is carrying
	 *
	 **/
	public E getValue(){
		return this.value;
	}

	/**
	 * This method tells you if the inner value is null or not
	 *
	 * @return the value the object is carrying (Could be null!!! so ask to isNull())
	 *
	 **/
	public boolean isNull(){
		return this.value == null;
	}

	/**
	 * The toString(), hashCode() and equals() implementations delegate to the
	 * underlying object's methods 
	 *
	 * @return the string representation of the object
	 *
	 **/
	public String toString(){
		return isNull() ? null : getValue().toString();
	}

	/**
	 * The toString(), hashCode() and equals() implementations delegate to the
	 * underlying object's methods 
	 * 
	 * @return true if the object is the same false otherwise
	 *
	 **/
	public boolean equals(Object o){
		if (!Nullable.class.isInstance(o) || isNull()){
			return false;
		}
		Nullable<E> other = (Nullable) o;
		return other.isNull() ? false : getValue().equals(other.getValue());
	}

	/**
	 * The toString(), hashCode() and equals() implementations delegate to the
	 * underlying object's methods 
	 *
	 * @return the hash code
	 **/
	public int hashCode(){
		return isNull() ? 1  : getValue().hashCode();
	}

}
