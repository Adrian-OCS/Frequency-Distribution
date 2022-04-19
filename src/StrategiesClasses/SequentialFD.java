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
		/*TODO ADD YOUR CODE HERE*/
		
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		results.add(new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(0), 1));
		
		for (int i=1; i<dataSet.size(); i++) {
			
			boolean found = false;
			
			for (int j=0; j<results.size(); j++) {
				if (results.get(j).getKey().equals(dataSet.get(i))) {
					results.get(j).setValue(results.get(j).getValue() + 1);
					found = true;
					break;
				}
			}
			
			if (!found) {
				results.add(new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(i), 1));
			}
							
		} 

		return results; 
	}

}
