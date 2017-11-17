package ch.ffhs.dua.sort;

import ch.ffhs.dua.sort.*;

public class TestSomeSort {

	public static void main(String[] args) {
		test();
	}

	public static void testSort(int[] array) {
		long startTime = System.currentTimeMillis();
		QuickSort.sort(array);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("QuickSort - Array Size: " + array.length + " time: " +elapsedTime);
		
		long startTime1 = System.currentTimeMillis();
		InsertSort.sort(array);
		long stopTime1 = System.currentTimeMillis();
		long elapsedTime1 = stopTime1 - startTime1;
		System.out.println("InsertSort - Array Size: " + array.length + " time: " +elapsedTime1);
		System.out.println("");
	}

	public static int[] createRandomArray(int size) {

		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}

		return array;
	}
	
	public static void test() {
		for (int i = 1; i < 100000; i += 100) {
			int[] testArray = createRandomArray(i);
			testSort(testArray);
			if(i > 10000 && i < 13000) {
				i += 900;
			}
			
			if(i > 13000) {
				i += 10000;
			}
		}
	}

}
