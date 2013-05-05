package challenge

import spock.lang.Specification

class CircularListSpecification extends Specification{

	def "Getting current,next and previous"(){
		setup: "Creating an instance of circular list"
			def list = new CircularListImpl<String>()
		when: "Inserting some elements"
			list.
				add("John").
				add("Peter").
				add("Malloc")	
		and: "Trying to get neMalloMalloccxt, previous and current"
			def current = list.current()
			def next = list.next()
			def previous = list.previous()
		and: "Dealing with nulls"
			list.add(null)
		then: "We should get some values" 
			list.current().isNull()
			next.value == "John"
			previous.value == "Malloc"
		and: "Size of the list"
			list.size() == 4
	}

	def "Inserting after a given element"(){
		setup: "Creating a given instance of a circular list"
			def list = new CircularListImpl()
		when: "Adding elements"
			def sameList = 
			  list.
				add("John").
				add("Peter").
				add("Malloc").
				add("Andrew").
				add("Troy")
		and: "How many members so far"
			sameList.size() == 5
		and: "Inserting after a given element"
			list.insertAfter("Malloc","Hugo")
		then: "Malloc should be found applying previous()"	
			list.size() == 6
		and: "The previous value should be"
			list.current().getValue() == "Hugo"
			list.previous().getValue() == "Malloc"
	}

	def "Asking for something doesn't exist"(){
		when: "Creating the list"
			def list = new CircularListImpl<String>()
		then: "Asking for next"
			list.next().isNull()
			list.previous().isNull()
	}
}
