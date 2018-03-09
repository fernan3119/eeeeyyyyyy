package testersClasses;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;


import aproachClasses.SequentialFD;
import fileClasses.fileCreator;

public class SequentialTester {

	public static void main(String[] args) throws FileNotFoundException{
		SequentialFD<Integer> sfdI = new SequentialFD<>();
		SequentialFD<String> sfdS = new SequentialFD<>();

		fileCreator file = new fileCreator();

		ArrayList<Integer> integerList = file.integersReader();
		ArrayList<String> stringList = file.stringsReader();

		System.out.println(sfdI.computeFDList(integerList).toString());
		System.out.println(sfdS.computeFDList(stringList).toString());
	}
}
