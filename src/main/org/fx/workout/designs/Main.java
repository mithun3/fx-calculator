package org.fx.workout.designs;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		ValueFactory f = new ValueFactory();
		
		Value v = f.getValue("DIRECT");
		
		System.out.println(v.value(2d, 2d));
	}

}
