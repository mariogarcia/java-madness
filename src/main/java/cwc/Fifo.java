package cwc;

public class Fifo<A>{

	A head;
	Fifo<A> tail;

	public Fifo(A head,Fifo<A> tail){
		this.head = head;
		this.tail = tail;
	}

	public void push(A a){
		tail = new Fifo<A>(head,
			new Fifo<A>(
				tail.head,
				tail.tail
			)
		);
	 /* Once we have move the previous values 
	  * now we set head to the new value */
		head = a;
	}

	public A poll(){
		A result = this.head;
		if (this.tail != null){
			this.head = tail.head;
			this.tail = tail.tail;
		} else {
			this.head = null;
		}
		return result;
	}

	public A peek(){
		return this.head;
	}
}
