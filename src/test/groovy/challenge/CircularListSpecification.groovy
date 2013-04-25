package challenge

import spock.lang.Specification

class CircularListSpecification extends Specification{

	def "Getting current,next and previous"(){
		setup: "Creating an instance of circular list"
			def list = new CircularListImpl<String>()
		when: "Inserting some elements"
			list.add("John")	
			list.add("Peter")	
			list.add("Malloc")	
		and: "Trying to get neMalloMalloccxt, previous and current"
			def current = list.current()
			def next = list.next()
			def previous = list.previous()
		then: "We should get some values" 
			current == "Malloc"
			next == "John"
			previous == "Malloc"
		and: "Size of the list"
			list.size() == 3
	}


}
