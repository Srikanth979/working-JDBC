package com.exampleJDBC.app.test;

class E1 {
	{
		System.out.println("empty");
	}
	static {
		System.out.println("static loop");
	}
	
	E1(){
		System.out.println("cosntructor");
	}
	public static void m1(String args[]){
		System.out.println("main");		
	}

}

public class Example {
	
	public static void main(String args[]){
		E1 e = new E1();
	}

}