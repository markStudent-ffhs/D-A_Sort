package ch.ffhs.dua.sort;

public class HeapSort 
{
	
	private static int LENGTH;
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
		makeHeap(array, start ,end);        
        for (int i = LENGTH; i > 0; i--)
        {
            swap(array,0, i);
            LENGTH = LENGTH - 1;
            sink(array, start, end, 0);
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
	public static void makeHeap1(int[] array, int start, int end)
	{
		System.out.println("length " + array.length);
		//LENGTH = end - start + 1;
        for (int i = array.length/2; i >= 0; i--) {
            sink(array, start, end, i);
        }
        for (int i = 0; i < array.length; i++) {
        	System.out.println(array[i]);
        }
	}
	
	public static void makeHeap(int array[], int start, int end) {
		int n = array.length;
		for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
		
		for (int i = 0; i < array.length; i++) {
        	System.out.println(array[i]);
        }
	}
	
	public static void heapify(int arr[], int n, int i)
    {
        int smallest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;
 
        // If largest is not root
        if (smallest != i)
        {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, smallest);
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
		
		int largest = index;  // Initialize largest as root
        int left = 2 * index + 1;  // left = 2*i + 1
        int right = 2 * index + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (left < end && array[left] > array[largest])
            largest = left;
 
        // If right child is larger than largest so far
        if (right < end && array[right] > array[largest])
            largest = right;
 
        // If largest is not root
        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            sink(array, start, end, largest);
        }
//		System.out.println("Index "+ index);
//		int left = 2 * index ;
//        int right = 2 * index + 1;
//        int max = index;
//        if (start + left <= end && array[start + left] > array[start + index]) {
//            max = left;
//        }
//        if (start + right <= end && array[start + right] > array[start + max]) {        
//            max = right;
//        }
// 
//        if (max != index) {
//        	System.out.println("swap " +index + " " + max);
//            swap(array, start + index, max);
//            sink(array, start, end, max);
//        }		
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
