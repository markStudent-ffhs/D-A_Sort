package ch.ffhs.dua.sort;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort 
{
	
	/**
	 * Sortiert ein Array durch Quicksort.
	 * @param array Zu sortierendes Array.
	 */
	public static void sort(int[] array)
	{
		sort(array, 0, array.length -1);
	}
	
	/**
	 * Sortiert ein Teilstück eines Arrays durch Quicksort.
	 * @param array ZU sortierenden Array
	 * @param start Index des ersten Elementes des Teils, das sortiert werden muss.
	 * @param end   Index des letzen Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{
//		if(start < end) {
//			
//			sort(array, start, t -1);
//			sort(array, t + 1, end);
//		}
		
		int i = partition(array, start, end, findPivot(array, start, end));
		if(start < i - 1) {
			sort(array, start, i -1);
		}
		if(i < end) {
			sort(array, i, end);
		}
		
	}
	
	/** 
	 * Schwellwert, bei welcher Arraygrösse in der Rekursion InsertSort 
	 * statt Quicksort aufgerufen werden sollte. 
	 */
	static int THRESHOLD = 4; // TODO finden Sie einen sinnvollen Wert
	
	/**
	 * Modifiziertes Quicksorts.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 */
	public static void sortPlus(int[] array)
	{
		// TODO
	}

	/**
	 * Modifiziertes Quicksorts zum SOrtieren eines Teilstücks eines Arrays.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 * @param start Index des ersten  Elementes des zu sortierenden teilstücks.
	 * @param end   Index des letzten Elementes des zu sortierenden teilstücks.
	 */
	public static void sortPlus(int[] array, int start, int end)
	{
		// TODO
	}

	/**
	 * Hilfsmethode für Quicksort. 
	 * Ein Teilstück eines Arrays wird geteilt, so dass alle Elemente,
	 * die kleiner als ein gewisses Pivot-Elements sind, links stehen
	 * und alle Elemente, die grösser als das Pivot-Element rechts stehen.
	 * @param array Array zum Umordnen.
	 * @param start Indes des ersten  Elements des Teilstücks, das geteilt werden muss.
	 * @param end   Index des letztes Elements des Teilstücks, das geteilt werden muss.
	 * @param piv   Index des PiotElements
	 * @return Index des Piot-Element nach der Partitionierung.
	 */
	static int partition(int[] array, int start, int end, int piv)
	{
		// TODO Verwenden Sie diese Mehode für Quicksort
		int i = start;
		int j = end;
		
		while (i <= j) {
            while (array[i] < array[piv])
                  i++;
            while (array[j] > array[piv])
                  j--;
            if (i <= j) {
                  swap(array, i, j);
                  i++;
                  j--;
            }
           
		}
		
		return i;
//		int i = start - 1;
//		for(int j = start; j <= end - 1; j++) {
//			if(array[j] <= array[piv]) {
//				i++;
//				swap(array, i, j);
//			}
//		}
//		
//		swap(array, i + 1, end);
//		return i + 1;
	
	}
	
	/**
	 * Hilfsmethode zum Vertauschen zweier Array-Elemente
	 * @param array
	 * @param a
	 * @param b
	 */
	static void swap(int[] array, int a, int b)
	{
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	/**
	 * Hilfsmethode zum Finden eines Pivot-Elementes für Quicksort.
	 * Zu einem Array und den zwei Indices start und end wird 
	 * der Index eines möglichen Pivot-Elementes angegeben 
	 * @param array
	 * @param start
	 * @param end
	 * @return Index eines Pivot-Elementes
	 */
	static int findPivot(int[] array, int start, int end)
	{
		// TODO
		return ThreadLocalRandom.current().nextInt(start, end + 1);
	}
}
