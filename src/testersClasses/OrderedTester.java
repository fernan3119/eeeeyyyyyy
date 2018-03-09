package testersClasses;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import aproachClasses.OrderedFD;
import aproachClasses.SequentialFD;
import fileClasses.fileCreator;

public class OrderedTester {

	public static void main(String[] args) throws FileNotFoundException {
		OrderedFD<Integer> ofdI = new OrderedFD<>();
		OrderedFD<String> ofdS = new OrderedFD<>();

		fileCreator file = new fileCreator();

		ArrayList<Integer> integerList = file.integersReader();
		ArrayList<String> stringList = file.stringsReader();

		System.out.println(ofdI.computeFDList(integerList).toString());
		System.out.println(ofdS.computeFDList(stringList).toString());
	}
}
