package indi.lean.acm.zoj;

import java.util.Scanner;

public class ZOJ1070BodePlot {
	public static void main(String[] args) {
		double vs = 0D, r = 0D, c = 0D, w = 0D;
		int number = 0;
		
		Scanner scanner = new Scanner(System.in);
		vs = scanner.nextDouble();
		r = scanner.nextDouble();
		c = scanner.nextDouble();
		number = scanner.nextInt();
		
		for(int i = 0; i < number; i++) {
			w = scanner.nextDouble();
			double value = vs * r * c * w / Math.sqrt(c * Math.pow(w, 2D) + 1);
			System.out.printf("%.3f\n", value);
		}
		
		scanner.close();
	}
}
