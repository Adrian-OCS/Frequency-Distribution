package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import DataStructures.SortedList.*;

/**
 * This class implements the SortedList strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && Adrián O. Cruz Silva
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SortedListFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	/**
	 * Our SortedList classes require the data type to be Comparable.
	 * However, Map.Entry and AbstractMap.SimpleEntry are not Comparable,
	 * so we extend AbstractMap.SimpleEntry and create a Comparable
	 * version that we can use with our SortedList.
	 * Note: The K (key) of this class will be the E of SortedListFD,
	 *       so it will be Comparable.
	 * @author Fernando J. Bermudez
	 *
	 * @param <K>  The type of the key of each entry
	 * @param <V>  The type of the value of each entry
	 */
	@SuppressWarnings("serial")
	private static class ComparableEntry<K extends Comparable<K>, V> extends AbstractMap.SimpleEntry<K, V>
																	 implements Comparable<Map.Entry<K, V>> {

		public ComparableEntry(K key, V value) {
			super(key, value);
		}

		@Override
		public int compareTo(Map.Entry<K, V> entry) {
			/* Entries will be compared based on their keys, which are Comparable */
			return getKey().compareTo(entry.getKey());
		}

	} // End of ComparableEntry class

	/* Constructor */
	public SortedListFD() {
		super("SortedList");
	}
	
	/**
	 * Method that counts the frequency of a dataSet with a SortedList
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * 
	 * @author Adrián O. Cruz Silva
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
		//Creates sorted array list data structure that copies all dataSet elements through a loop.
		//Through a binary search, the sorted array list automatically finds the insertion position that maintains itself sorted in O(logn)
		SortedArrayList<E> sorted = new SortedArrayList<E>(1);
		
		for (int i=0; i<dataSet.size(); i++) {
			sorted.add(dataSet.get(i));
		}
		
		//Creates resulting array list of map entries
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		//Adds sorted's 1st entry to results, in order to make looping and comparisons possible
		results.add(new AbstractMap.SimpleEntry<E, Integer>(sorted.get(0), 1));
		
		//Loops through all of sorted's elements
		for (int i=1; i<sorted.size(); i++) {
			
			boolean found = false;
			
			//Loops through all results elements (at most) to compare their keys to the current sorted element i.
			//If condition met (current sorted i object is already in results), current result's element value++ (counter) and loop breaks
			for (int j=0; j<results.size(); j++) {
				
				
				//Compares current sorted element i to results element j.
				//If result's j is bigger than sorted's i, loop breaks, since there will never be a key equal to i after that.
				if (results.get(j).getKey().compareTo(sorted.get(i)) > 0) {
					break;
				}
				
				if (results.get(j).getKey().equals(sorted.get(i))) {
					results.get(j).setValue(results.get(j).getValue() + 1);
					found = true;
					break;
				}
			}
			
			//If sorted i not in results, it gets added as key of a new map entry with value 1
			if (!found) {
				results.add(new AbstractMap.SimpleEntry<E, Integer>(sorted.get(i), 1));
			}
							
		} 

		return results; 
	}

}