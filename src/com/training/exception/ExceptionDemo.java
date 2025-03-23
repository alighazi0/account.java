package com.training.exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i =5;
		int j =0;
		try {
		int result = i/j;
		}
		catch(Exception e) {
			System.out.println("An Arithmetic excption occurred !!");
		}
		System.out.println("Execution resumes::");

	}

}
