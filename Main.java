/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Random;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Integer[] randomArr = generateRandomNumbers(1000, 1000, 5000);

		// TODO: This is the usage of your implementation for hashing
		MyHashtable myHashtable = new MyHashtable(11);

		long startTime1 = System.nanoTime();
		for (int i : randomArr) {
			myHashtable.insert(i);
		}
		long endTime1 = System.nanoTime();
                long elapsedTime1 = endTime1 - startTime1;
                System.out.println("Elapsed time is : "+ elapsedTime1);
		myHashtable.printTable();

		///////////////////////// SECOND PART ///////////////////////////

		/* TODO: MyInteger class uses hashing implementation of Java
			it is used for hashing algorithm on Hashtable class of Java
		 */
		// Created 1000 random MyInteger class type integers for your usage in Java Hashtable implementation
		MyInteger[] randomArrJava = generateRandomMyNumbers(1000, 5000, 9000);

		Hashtable<Integer, Integer> javaHashtable = new Hashtable<>(11);

		long startTime = System.nanoTime();
		for (MyInteger i : randomArrJava) {
			javaHashtable.put(i.hashCode(), i.get());
		}
		
// The operation
long endTime = System.nanoTime();
long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time 2 is : "+ elapsedTime);
                
                
                
	}

	// Returns the current capacity of the hash table
	private static int hashTableCapacity(Hashtable<Integer, Integer> table) {
									//throws NoSuchFieldException, IllegalAccessException {

		Field tableField = null;

		try {
			tableField = Hashtable.class.getDeclaredField("table");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		tableField.setAccessible(true);

		Object[] tempTable = new Object[0];

		try {
			tempTable = (Object[]) tableField.get(table);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return (tempTable == null ? 0 : tempTable.length);
	}

	// Generate random numbers between low and high
	private static Integer[] generateRandomNumbers(int size, int lowBound, int highBound)
	{
		Random rd = new Random();
		Integer[] tempRandom = new Integer[size];

		for (int i = 0; i < tempRandom.length; i++)
		{
			tempRandom[i] = rd.nextInt(highBound - lowBound) + lowBound;
		}

		return tempRandom;
	}

	// Generate random numbers from MyInteger class between low and high
	private static MyInteger[] generateRandomMyNumbers(int size, int lowBound, int highBound)
	{
		Random rd = new Random();
		MyInteger[] tempRandom = new MyInteger[size];

		for (int i = 0; i < tempRandom.length; i++)
		{
			int randomInt = rd.nextInt(highBound - lowBound) + lowBound;
			tempRandom[i] = new MyInteger(randomInt);
		}

		return tempRandom;
	}

	

/*
        
       array which we make has ellapsed time= 1867600 java's hash table's ellapsed time is 2214100 
        because implementing hasCode () method so that
        least number of hash collision occurs and entries are evenly distributed across all the buckets.
        that's why our ımplementation is faster than java's implementation. Also, hashtable has constant time complexity thats why we can add 1000 value or 10 value 
        it will never change and will be same.
        
        */

 

    
    
}
