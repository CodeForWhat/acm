package indi.lean.acm.leetcode;

public class IntegerToRoman {
    private static final String[][] array = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
    };

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        roman.append(array[3][num / 1000]);
        roman.append(array[2][(num / 100) % 10]);
        roman.append(array[1][(num / 10) % 10]);
        roman.append(array[0][num % 10]);
        return roman.toString();
    }
}
