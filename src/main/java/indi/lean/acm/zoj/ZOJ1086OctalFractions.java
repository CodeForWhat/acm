package indi.lean.acm.zoj;

import java.math.BigDecimal;
import java.util.Scanner;

public class ZOJ1086OctalFractions {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigDecimal decimalValue = null;
		while(scanner.hasNextLine()) {
			String octalNumber = scanner.nextLine();
			decimalValue = new BigDecimal(0);
			String validOctalNumber = octalNumber.substring(octalNumber.indexOf(".") + 1, octalNumber.length());
			for(int index = 0; index < validOctalNumber.length(); index++) {
				int digit = 0;
				if((digit = validOctalNumber.charAt(index) - '0') == 0) {
					continue;
				}
				
				decimalValue = decimalValue.add(compute(digit, index + 1));
			}
			System.out.printf("%s[8] = %s[10]\n", octalNumber, decimalValue.toPlainString());
		}
		
		scanner.close();
	}
	
	private static BigDecimal compute(int digit, int pow) {
		BigDecimal value = new BigDecimal(1);
		
		while(pow-- > 0) {
			value = value.multiply(new BigDecimal(1 / 8D)); 
		}
		
		return new BigDecimal(digit).multiply(value);
	}
}
