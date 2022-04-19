package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class corresponds to the Sequential strategy to count frequencies in an
 * array list.
 * @author Fernando J. Bermudez && Adrián O. Cruz Silva
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SequentialFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public SequentialFD() {
		super("Sequential");
	}
	/**
	 * Method that counts the frequency of a dataSet with a regular ArrayList
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * one by one without any sorting or re-arrangement of the elements
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
		//Creates resulting array list of map entries
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		//Adds dataSet's 1st entry to results, in order to make looping and comparisons possible
		results.add(new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(0), 1));
		
		//Loops through all dataSets elements
		for (int i=1; i<dataSet.size(); i++) {
			
			boolean found = false;
			
			//Loops through all "j" elements to compare their keys to the current dataSet element i.
			//If condition met (current dataSet i object is already in results), counter value++ and loop breaks
			for (int j=0; j<results.size(); j++) {
				if (results.get(j).getKey().equals(dataSet.get(i))) {
					results.get(j).setValue(results.get(j).getValue() + 1);
					found = true;
					break;
				}
			}
			
			//If dataSet i not in results, it gets added as key of a new map entry with value 1
			if (!found) {
				results.add(new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(i), 1));
			}
							
		} 

		return results; 
	}

}
