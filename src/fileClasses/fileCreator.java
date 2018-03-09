package fileClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;

public class fileCreator {



	public void newFile(ArrayList<Entry<Integer, Number>> results, String name) throws IOException{
		File file = new File("ExperimentalResults/" + name + ".txt");

		FileWriter writer = new FileWriter(file);
		BufferedWriter output = new BufferedWriter(writer);

		for (Entry<Integer, Number> e : results) {
			output.write(e.getKey() + "\t" + e.getValue());
			output.newLine();
		}
		output.close();
	}

	public ArrayList<Integer> integersReader() throws FileNotFoundException {
		File theFile = new File("inputData/integerData.txt");
		Scanner in = new Scanner(theFile);
		ArrayList<Integer> theList = new ArrayList<Integer>();

		while (in.hasNext())
			theList.add(in.nextInt());
		return theList;
	}

	public ArrayList<String> stringsReader() throws FileNotFoundException {
		File theFile = new File("inputData/stringData.txt");
		Scanner in = new Scanner(theFile);
		ArrayList<String> theList = new ArrayList<String>();

		while (in.hasNext())
			theList.add(in.next());

		return theList;
	}



}
