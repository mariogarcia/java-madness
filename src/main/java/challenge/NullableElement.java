package challenge;

class NullableElement<E>{

	private E value;

	public NullableElement(E value){
		this.value = value;
	}

	public E getValue(){
		return this.value;
	}

	public boolean isNull(){
		return this.value == null;
	}

}
