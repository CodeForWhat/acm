package indi.lean.acm.niuke.netease;

import java.util.Scanner;

public class GoToOffice {
	
	public static int computeLeatestTime(int[] carPosX, int[] carPosY, int officeX, int officeY, int walkTime, int taxiTime) {
		int minTime = (Math.abs(officeX) + Math.abs(officeY)) * walkTime;
		for(int i = 0; i < carPosX.length; i++) {
			int temp = Math.abs(Math.abs(officeX) - Math.abs(carPosX[i])) + Math.abs(Math.abs(officeY) - Math.abs(carPosY[i]));
			
			if((temp = (Math.abs(carPosX[i]) + Math.abs(carPosY[i])) * walkTime + temp * taxiTime) < minTime) {
				minTime = temp;
			}
		}
		return minTime;
	}

	public static void main(String[] args) {
		int[] carPosX, carPosY;
		int officeX, officeY, walkTime, taxiTime;
		
		Scanner scanner = new Scanner(System.in);
		int posCount = scanner.nextInt(); 
		
		carPosX = new int[posCount];
		carPosY = new int[posCount];
		for(int i = 0; i < posCount; i++) {
			carPosX[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < posCount; i++) {
			carPosY[i] = scanner.nextInt();
		}
		
		officeX = scanner.nextInt();
		officeY = scanner.nextInt();
		walkTime = scanner.nextInt();
		taxiTime = scanner.nextInt();
		
		System.out.println(computeLeatestTime(carPosX, carPosY, officeX, officeY, walkTime, taxiTime));
		scanner.close();
	}
}
