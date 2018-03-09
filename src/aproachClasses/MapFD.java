package aproachClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class MapFD<E extends Comparable<E>> extends FrequencyCounter<E> {
	
	public MapFD() {
		super("Map");
	}
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		ArrayList<Map.Entry<E, Integer>> results = 
				new ArrayList<Map.Entry<E, Integer>>();
		Hashtable<E,Integer> list = new Hashtable<E,Integer>();
		for (int i = 0; i < dataSet.size(); i++) {
			E e = dataSet.get(i);
			if(list.containsKey(e))
				list.put(e,list.get(e)+1);
			else
				list.put(e,1);
		}
		for (Entry<E, Integer> entry : list.entrySet()) 
			results.add(entry);
		return results;
	} 
}
