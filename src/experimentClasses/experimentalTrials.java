package experimentClasses;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import aproachClasses.ListCreator;
import aproachClasses.MapFD;
import aproachClasses.OrderedFD;
import aproachClasses.SequentialFD;
import fileClasses.fileCreator;

public class experimentalTrials {

	static float[] sumTime = {0, 0, 0};
	static float averageTime;
	static int initialSize = 50;
	static int increasingSize = 50;
	static int finalSize = 1000;
	static int repetitionSize = 200;
	static fileCreator myFile = new fileCreator();

	static Entry<Integer, Number> entry;
	static ArrayList<Map.Entry<Integer, Number>> squentialResults = new ArrayList<Map.Entry<Integer, Number>>();
	static ArrayList<Map.Entry<Integer, Number>> orderedResults = new ArrayList<Map.Entry<Integer, Number>>();
	static ArrayList<Map.Entry<Integer, Number>> mapResults = new ArrayList<Map.Entry<Integer, Number>>();

	public static <E> void main(String[] args) {
//		SequentialFD sfd = new SequentialFD();
//		OrderedFD ofd = new OrderedFD();
//		MapFD mfd = new MapFD();

		ListCreator list = new ListCreator();
		ArrayList<Integer> dataSet = new ArrayList<Integer>();


		for (int n = initialSize; n <= finalSize; n += increasingSize) {
			for (int i = 0; i < repetitionSize; i++) {
				dataSet = list.createList(n);
				for (int j = 0; j < 3; j++) 
					strategies(j, dataSet); 	
			}			

			averageTime = sumTime[0] / repetitionSize;
			entry = new AbstractMap.SimpleEntry<Integer, Number>(n, averageTime);
			squentialResults.add(entry);

			averageTime = sumTime[1] / repetitionSize;
			entry = new AbstractMap.SimpleEntry<Integer, Number>(n, averageTime);
			orderedResults.add(entry);

			averageTime = sumTime[2] / repetitionSize;
			entry = new AbstractMap.SimpleEntry<Integer, Number>(n, averageTime);
			mapResults.add(entry);


		}
		System.out.println(squentialResults.toString());
		System.out.println(orderedResults.toString());
		System.out.println(mapResults.toString());
		try {
			output();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void strategies(int n, ArrayList<Integer> dataSet) {
		SequentialFD<Integer> sfd = new SequentialFD<>();
		OrderedFD<Integer> ofd = new OrderedFD<>();
		MapFD<Integer> mfd = new MapFD<>();

		long initialTime = 0; 
		long finalTime = 0;

		if (n == 0){
			initialTime = System.nanoTime();
			sfd.computeFDList(dataSet);
			finalTime = System.nanoTime();
			sumTime[n] += (finalTime - initialTime);
		}
		if (n == 1) {
			initialTime = System.nanoTime();
			ofd.computeFDList(dataSet);
			finalTime = System.nanoTime();
			sumTime[n] += (finalTime - initialTime);
		}
		if (n == 2){
			initialTime = System.nanoTime();
			mfd.computeFDList(dataSet);
			finalTime = System.nanoTime();
			sumTime[n] += (finalTime - initialTime);
		}
	}

	public static void output() throws IOException{
		myFile.newFile(squentialResults, "resultsSequential");
		myFile.newFile(orderedResults, "resultsOrdered");
		myFile.newFile(mapResults, "resultsMap");
	}
}

