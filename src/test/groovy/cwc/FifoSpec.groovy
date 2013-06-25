package cwc

import spock.lang.Specification
import spock.lang.Ignore

class FifoSpec extends Specification {

	def "Testing push"(){
		setup:"Building the fifo instance"
			def fifo = new Fifo<String>("second",new Fifo<String>("first",null))
		when: "Pushing a third one"
			fifo.push("third")
		then: "Getting all values from the last to the first"
			fifo.poll() == "third"
			fifo.poll() == "second"
			fifo.poll() == "first"
	}

	def "Testing peek"(){
		setup:"Building the fifo instance"
			def fifo = new Fifo<String>(
			 /* HEAD */
				"second",
			 /* TAIL */
				new Fifo<String>(
					"first",
					null
				)
			)
		when: "Pushing a third one"
	     /* HEAD */
			fifo.push("third")
		then: "Getting all values from the last to the first"
			fifo.poll() == "third"
			fifo.peek() == "second"
			fifo.poll() == "second"
			fifo.peek() == "first"
			fifo.poll() == "first"
			fifo.poll() == null 
	}


}
