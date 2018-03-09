package aproachClasses;

import java.awt.RadialGradientPaint;
import java.util.ArrayList;
import java.util.Random;

public class ListCreator {

	public ArrayList<Integer> createList(int n){
		ArrayList<Integer> list = new ArrayList<>();
		Random generator = new Random();

		for(int i = 0;i<n;++i){
			list.add(generator.nextInt((n/2)+1));
		}
		return list;

	}
}
