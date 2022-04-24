package StrategiesClasses;

import java.util.AbstractMap;




import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

/**
 * This class implements the Ordered strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && Adrián O. Cruz Silva
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {
		super("Ordered");
	}

	/**
	 * Method that counts the frequency of a dataSet with a SORTED COPY of dataSet
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
		//Sorts dataSet with java's array list's sort method
		//Null parameter indicates sorting in the element's natural order (ascending)
		dataSet.sort(null);
		
		//Creates resulting array list of map entries
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		//Adds sorted's 1st entry to results, in order to make looping and comparisons possible
		results.add(new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(0), 1));
		
		/*
		 * Loops through all dataSet sorted elements with i and j
		 * While results' last element has same key as iteration (i): j stays the same, entry value++, i++
		 * If key not the same, j equals i (i being the 1st entry w/a different key)
		 * This method will make an O(n) iteration with i and j
		 */
		
		int j = 0;
		for (int i=1; i<dataSet.size(); i++) {
			
			//While the last key in results equals current i in dataSet: results' last value++, i++
			while (i<dataSet.size() && results.get(results.size()-1).getKey().compareTo(dataSet.get(i)) == 0) {
				results.get(results.size()-1).setValue(results.get(results.size()-1).getValue() + 1);
				i++;
			}
			
			/*
			 * If dataSet i key not equal to results' last element:
			 * j will equal that new element's position
			 * add i to results.
			 * 
			 * The next iteration will start with j being one item less than i.
			 * This way, j is optimized to not loop through all values as in a nested loop.
			 */
			
			if (i<dataSet.size()) {
				j=i;
				results.add(new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(j), 1));
			}

		}
	
		return results; 
		
	}
	
}