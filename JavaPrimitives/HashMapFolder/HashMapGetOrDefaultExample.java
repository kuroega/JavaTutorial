package com.javatutorialhq.java.examples;

import java.util.HashMap;

/*
 * This example source code demonstrate the use of
 * getOrDefault() method of HashMap class
 */

public class HashMapGetOrDefaultExample {

	public static void main(String[] args) throws InterruptedException {
		
		int idNum = 9756;
		HashMap<Integer, String> map = init();
		System.out.println("Student with id number " + idNum + " is "
			+ map.getOrDefault(idNum, "John Doe"));

	}

	private static HashMap<Integer, String> init() {
		// declare the hashmap
		HashMap<Integer, String> mapStudent = new HashMap<>();
		// put contents to our HashMap
		mapStudent.put(73654, "Shyra Travis");
		mapStudent.put(98712, "Sharon Wallace");
		return mapStudent;
	}
}

/* 
 * This example is a lot simpler than it looks. First we have a method 
 * init() which generally populates a HashMap object and returned. 
 * This method has been called by the main method and used the 
 * getOrDefault to display the student name based on the student 
 * id input argument.The default student name is John Doe which will 
 * always be displayed whenever the student id was not found on the 
 * student database.
 */