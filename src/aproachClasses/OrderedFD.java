package aproachClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class OrderedFD<E extends Comparable<E>> extends FrequencyCounter<E> {

	public OrderedFD() {
		super("Ordered");
	}

	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		ArrayList<Map.Entry<E, Integer>> results = 
				new ArrayList<Map.Entry<E, Integer>>();
		ArrayList<E> copyList = (ArrayList<E>) dataSet.clone();
		Collections.sort(copyList);
		int frequencyCounter = 1;
		for (int i=0; i<copyList.size()-1; i++) {
			if (copyList.get(i).compareTo(copyList.get(i+1)) == 0) { 
				frequencyCounter++;
			}
			else{
				Map.Entry<E, Integer> entry = 
						new AbstractMap.SimpleEntry<E,Integer>(copyList.get(i), frequencyCounter);
				results.add(entry);
				frequencyCounter = 1;
			}
		}
		Map.Entry<E, Integer> entry = 
		new AbstractMap.SimpleEntry<E,Integer>(copyList.get(copyList.size()-1), frequencyCounter);
		results.add(entry);
		return results;
	} 
}


