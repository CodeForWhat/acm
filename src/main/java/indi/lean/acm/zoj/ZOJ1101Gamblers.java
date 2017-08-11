package indi.lean.acm.zoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ZOJ1101Gamblers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<Integer> waggers = new ArrayList<Integer>(); 
		while(scanner.hasNextInt()) {
			int gamblerNumber = scanner.nextInt();
			
			int wagger = 0;
			waggers.clear();
			for(int i = 0; i < gamblerNumber; i++) {
				wagger = scanner.nextInt();
				waggers.add(wagger);
			}
			System.out.println(findWinner(waggers));
		}
		scanner.close();
	}
	
	private static String findWinner(List<Integer> waggers) {
		
		// sort waggers in ascending
		Collections.sort(waggers, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		Iterator<Integer> it = waggers.iterator();
		while(it.hasNext()) {
//			it.
		}
		return "";
	}

}
