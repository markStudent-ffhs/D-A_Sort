package ch.ffhs.dua.sort;

public class InsertSort 
{
	/**
	 * Sortiert ein Array durch Einfügen
	 * @param array Das zu sortierende Array.
	 */
	public static void sort(int[] array)
	{
		for (int i = 1; i < array.length; i++)
		{
			int val = array[i];
			int j = 0;
			for ( ; j < i; j++)
			{
				if (array[j] > val) break;
			}
			for (int k = i; k > j; k--)
			{
				array[k] = array[k-1];
			}
			array[j] = val;
		}
	}
	
	/**
	 * Sortiert einen durch zwei Grenzen angebenen Teil eines Arrays durch Einfügen.
	 * Arrayelemente ausserhalb der Grenzen werden nicht verschoben.
	 * @param array 
	 * @param start Index des ersten  Elementes des Teils, das Sortiert werden muss.
	 * @param end   Index des letzten Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{
		for (int i = start + 1; i <= end; i++)
		{
			int val = array[i];
			int j = start;
			for ( ; j < i; j++)
			{
				if (array[j] > val) break;
			}
			for (int k = i; k > j; k--)
			{
				array[k] = array[k-1];
			}
			array[j] = val;
		}
	}

}
