/**
 * 
 */
package indi.lean.acm.zoj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YinKailin
 *
 */
public class ZOJ1088SystemOverload {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		byte[] flag = new byte[151];
		int n = 0;
		while (scanner.hasNextInt()) {
			n = scanner.nextInt();

			if (n == 0) {
				break;
			}

			for (int m = 2; m < Integer.MAX_VALUE; m++) {
				int count = 1, curPos = 1, tempCount = 0;

				// set default value
				Arrays.fill(flag, (byte) 0);
				flag[1] = 1;

				for (; flag[2] != 1;) {
					if (flag[curPos] == 0) {
						if (++tempCount == m) {
							tempCount = 0;
							flag[curPos] = 1;
							count++;
						}
					}

					curPos = (curPos + 1 > n) ? 1 : curPos + 1;
				}

				if (count == n) {
					System.out.printf("%d\n", m);
					break;
				}
			}
		}

		scanner.close();
	}
}
