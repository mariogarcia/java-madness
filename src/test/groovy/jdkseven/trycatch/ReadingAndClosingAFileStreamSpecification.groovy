package jdkseven.trycatch

import spock.lang.Specification

class ReadingAndClosingAFileStreamSpecification extends Specification{

	def "Reading countries from sample file"(){
		setup: "Given a sample file"
			def file = new File(getClass().getResource("/countries_ok.txt").file)
		when: "Reading the file"
			def proc = new ReadingAndClosingAFileStream()
			def list = proc.getCountriesFromFile(file)
		then: "Checking content"
			list.size() == 9
			list.every{it}
	}
}
