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
		
		//Loops through all of sorted's elements
		for (int i=1; i<dataSet.size(); i++) {
			
			boolean found = false;
			
			//Loops through all results elements (at most) to compare their keys to the current sorted element i.
			//If condition met (current sorted i object is already in results), current result's element value++ (counter) and loop breaks
			for (int j=0; j<results.size(); j++) {
				
				
				//Compares current sorted element i to results element j.
				//If result's j is bigger than sorted's i, loop breaks, since there will never be a key equal to i after that.
				if (results.get(j).getKey().compareTo(dataSet.get(i)) > 0) {
					break;
				}
				
				if (results.get(j).getKey().equals(dataSet.get(i))) {
					results.get(j).setValue(results.get(j).getValue() + 1);
					found = true;
					break;
				}
			}
			
			//If sorted i not in results, it gets added as key of a new map entry with value 1
			if (!found) {
				results.add(new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(i), 1));
			}
							
		} 

		return results; 	
		
	}

}
