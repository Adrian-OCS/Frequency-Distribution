package TesterClasses;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import StrategiesClasses.AbstractFDStrategy;


public class GenericFDTester<E extends Comparable<E>> {

	private AbstractFDStrategy<E> strategy; 
	
	public GenericFDTester(AbstractFDStrategy<E> s) {
		strategy = s;  
	}
	
	public void run(DataReader<E> reader) throws FileNotFoundException {
		
		ArrayList<E> data = reader.readDataFromFile();  
		TestingUtils.displayListElements("Original Data", data);

		ArrayList<Map.Entry<E, Integer>> fd = strategy.computeFDList(data); 

		fd.sort(new GenericEntryComparator<E,Integer>());
		
		TestingUtils.displayListElements("Frequency Distribution", fd);

	}


}
