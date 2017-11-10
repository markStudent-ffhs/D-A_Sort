package ch.ffhs.dua.sort;

import java.util.Arrays;

public class HeapSort 
{
	private static boolean DEBUG = true;
	
	/**
	 * Sortiert ein Array mit Heapsort.
	 * @param array
	 */
	public static void sort(int[] array)
	{
		sort(array, 0, array.length - 1);
	}
	
	/**
	 * Sortiert ein Teilstück eines Array s mit Heapsort.
	 * @param array
	 * @param start Index des ersten  Elementes des zu sortierenden Teils.
	 * @param start Index des letzten Elementes des zu sortierenden Teils.
	 */
	public static void sort(int[] array, int start, int end)
	{
		if(null == array || array.length == 0 || array.length == 1)
			return;
		
        if(DEBUG) System.out.println("######## Make Heap:");
		makeHeap(array, start ,end);
		if(DEBUG) System.out.println("######## Heap Done");
		int n = end - start;
		if(DEBUG) System.out.println("######## Start sort:");
        for (int i = n; i >= 0; i--) {
            swap(array, 0, i);
            sink(array, start, i, 0);
        }
        
        if(DEBUG) {
	        System.out.println("Sorted Array:");
			System.out.println(Arrays.toString(array));
			System.out.println("######## Sort done");
			System.out.println("");
			System.out.println("");
        }
	}
	
	/**
	 * Erzeugt aus einem angegebenen Teilstück einen Heap.
	 * @param array
	 * @param start Index des ersten Elementes, aus dem ein Heap erzeugt werden sollte.
	 *              Das ist auch der Index der Wurzel des Heaps; die Kinder der Wurzel
	 *              liegen dann an den Position start+1 und start+2.
	 * @param end   Index des letzten Elementes des Stücks, aus dem ein Heap erzeugt werden sollte.
	 */
	public static void makeHeap(int[] array, int start, int end)
	{
		int n = end - start + 1;
		for (int i = n / 2 - 1; i >= 0; i--) {
            sink(array, start, end + 1, i);
		}
		
		if(DEBUG) {
			System.out.println("Heap is:");
			System.out.println(Arrays.toString(array));
		}
	}

	
	/**
	 * Hilfsmethode für Heapsort:
	 * Aus einem Teilstück eines Arrays mit den Grenzen start und end
	 * sollte ein Heap erzeugt werden. Für Indices grösser als index
	 * sei die Heap-Eigenschaft bereits erfüllt.
	 * Die Methode ordnet das Stück zwischen index und end so um, 
	 * dass die Heapeigenschaft für alle Elemente erfüllt ist.
	 * @param array
	 * @param start
	 * @param end
	 * @param index
	 */
	static void sink(int[] array, int start, int end, int index)
	{
		    int largest = index; 
	        int left = 2 * index + 1;
	        int right = 2 * index + 2;
	 
	        // If left child is larger than root
	        if (start + left < end && array[start + left] > array[start + largest]) {
	        	largest = left;
	        }
	 
	        // If right child is larger than largest so far
	        if (start + right < end && array[start + right] > array[start + largest]) {
	            largest = right;
	        }

	        // If largest is not root
	        if (largest != index && start + largest <= end) {
	            swap(array, start + index, start + largest);
	            sink(array, start, end, largest);
	        }
	    }
	
	/**
	 * Entfernt das Wurzelelement eines Heaps, baut den Heap um,
	 * so dass er nach dem Entfernen wieder ein Heap ist (mit einem Element weniger), 
	 * und setzt das ehemalige Wurzelelement an die vormals letzte Stelle im Heap 
	 * (die nun nicht mehr zum Heap gehört).
	 * @param array Ein Array, das als Teilstück einen heap enthält.
	 * @param start Indes der Wurzel des heaps
	 * @param end   Index des letzten Heap-Elements.
	 */
	public static void removeHeapRoot(int[] array, int start, int end)
	{
		// TODO	(Implementieren Sie diese Methode, wenn Sie sie für die Sort-Methoden brauchen.		
	}
	
	/**
	 * Berechnet den Index des linken Kindelementes in einem Heap.
	 * @param parentIndex
	 * @param offset Offset für Heap-Eigenschaft: entspricht 
	 *         dem Index der Heapwurzel - 1
	 * @return Index des linken Kindes
	 */
	static int leftChild(int parentIndex, int offset)
	{
		return 2 * parentIndex - offset;
	}

	/**
	 * Berechnet den Index des rechten Kindelementes in einem Heap.
	 * @param parentIndex
	 * @param offset Offset für Heap-Eigenschaft: entspricht 
	 *         dem Index der Heapwurzel - 1
	 * @return Index des rechten Kindes
	 */
	static int rightChild(int parentIndex, int offset)
	{
		return leftChild(parentIndex, offset) + 1;
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
	
}
