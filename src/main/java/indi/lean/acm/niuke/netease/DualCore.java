package indi.lean.acm.niuke.netease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DualCore {
	
	public static int computeTime(List<Integer> tasks) {
		int core1TaskLength = 0, core2TaskLength = 0;
		Collections.sort(tasks, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for(Integer task : tasks) {
			if(core1TaskLength > core2TaskLength) {
				core2TaskLength += task;
			} else {
				core1TaskLength += task;
			}
		}
		
		return Math.max(core1TaskLength, core2TaskLength);
	}

	public static void main(String[] args) {
		List<Integer> tasks = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		int times = scanner.nextInt();
		for(int i = 0; i < times; i++) {
			int task = scanner.nextInt();
			tasks.add(task);
		}
		System.out.println(computeTime(tasks));
		scanner.close();
	}

}
