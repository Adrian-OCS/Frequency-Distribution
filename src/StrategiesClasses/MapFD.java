package StrategiesClasses;

import java.util.ArrayList;

import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class implements the Map/Hash table strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && Adrián O. Cruz Silva
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class MapFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public MapFD() {
		super("Map");
	}
	
	/**
	 * Method that counts the frequency of a dataSet with a Hash table
	 * It uses a Hash table to count the frequency of each elements inside dataSet instead of Map.Entry
	 * like the previous strategies in this experiment
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
		//Creates a hashtable from which entries will be copied to a final results array list
		Hashtable<E, Integer> table = new Hashtable<E, Integer>();
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		//Loops through dataSet elements. 
		//If iteration key not in the hashtable, adds it with value 1
		//Else, increase the found key's value by 1 
		for (int i=0; i<dataSet.size(); i++) {
			if (table.containsKey(dataSet.get(i))) {
				table.put(dataSet.get(i), table.get(dataSet.get(i))+1);
			}
			else {
				table.put(dataSet.get(i), 1);
			}
		}
		
		//Set will copy hashtable elements to be able to loop through them and add them to results
		Set<Map.Entry<E, Integer>> tableKeys = table.entrySet(); 
		
		for (Entry<E, Integer> i: tableKeys) {
			results.add((Entry<E, Integer>) i);
		}
		
		return results; 
	}

}
