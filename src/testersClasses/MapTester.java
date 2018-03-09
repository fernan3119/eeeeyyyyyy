package testersClasses;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import aproachClasses.ListCreator;
import aproachClasses.MapFD;
import aproachClasses.OrderedFD;
import fileClasses.fileCreator;

public class MapTester {

	public static void main(String[] args) throws FileNotFoundException {
		MapFD<Integer> mfdI = new MapFD<>();
		MapFD<String> mfdS = new MapFD<>();

		fileCreator file = new fileCreator();

		ArrayList<Integer> integerList = file.integersReader();
		ArrayList<String> stringList = file.stringsReader();

		System.out.println(mfdI.computeFDList(integerList).toString());
		System.out.println(mfdS.computeFDList(stringList).toString());

	}		

}
