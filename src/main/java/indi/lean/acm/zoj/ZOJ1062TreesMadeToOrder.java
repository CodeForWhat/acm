package indi.lean.acm.zoj;

import java.util.Scanner;

public class ZOJ1062TreesMadeToOrder {
	private static final int INITIAL_SCALE = 20;
	private static int[] catalanNumbers = new int[INITIAL_SCALE + 1];

	public static void main(String[] args) {
		int treeOrder = 0;

		preprocess();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			treeOrder = scanner.nextInt();
			if (treeOrder <= 0) {
				break;
			}

			/** judge how many nodes the specified tree owns */
			int combinations = 0, treeNodes = 0;
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				combinations += catalanNumbers[i];

				if (combinations >= treeOrder) {
					treeNodes = i;
					treeOrder = treeOrder - combinations + catalanNumbers[i];
					break;
				}
			}
			printSpecifiedTree(treeNodes, treeOrder);
			System.out.println();
		}
		scanner.close();
	}

	private static void preprocess() {
		catalanNumbers[0] = catalanNumbers[1] = 1;
		for (int i = 1; i <= INITIAL_SCALE; i++) {
			catalanNumbers[i] = 0;

			for (int j = 0; j < i; j++) {
				catalanNumbers[i] += catalanNumbers[j] * catalanNumbers[i - j - 1];
			}
		}
	}

	private static void printSpecifiedTree(int nodes, int order) {
		if (nodes <= 1) {
			System.out.print("X");
			return;
		}

		// judge the number of nodes in left subtree
		int leftTreeNodeNumber = 0;
		for (int i = 0; i <= nodes - 1 && order > 0; i++) {
			int item = catalanNumbers[i] * catalanNumbers[(int) nodes - i - 1];
			if (order <= item) {
				leftTreeNodeNumber = i;
				break;
			}
			order -= item;
			
		}

		if(leftTreeNodeNumber > 0) {
			System.out.print("(");
			printSpecifiedTree(leftTreeNodeNumber, (order - 1) / catalanNumbers[nodes - leftTreeNodeNumber - 1] + 1);
			System.out.print(")");
		} 
		
		System.out.print("X");
		
		if(nodes - leftTreeNodeNumber - 1 > 0){
			System.out.print("(");
			printSpecifiedTree(nodes - leftTreeNodeNumber - 1, (order - 1) % catalanNumbers[nodes - leftTreeNodeNumber - 1] + 1);
			System.out.print(")");
		}
	}
}
