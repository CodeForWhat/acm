package indi.lean.acm.leetcode;

public class RomanToInteger {
    private static final int[] array = new int[26];
    static {
        array['I' - 'A'] = 1;
        array['V' - 'A'] = 5;
        array['X' - 'A'] = 10;
        array['L' - 'A'] = 50;
        array['C' - 'A'] = 100;
        array['D' - 'A'] = 500;
        array['M' - 'A'] = 1000;
    }
    public int romanToInt(String s) {
        int value = 0, i;
        char[] chars = s.toCharArray();
        for(i = 0; i < chars.length - 1; i++) {
           if(array[chars[i] - 'A'] < array[chars[i + 1] - 'A']) {
               value -= array[chars[i] - 'A'];
           } else {
               value += array[chars[i] - 'A'];
           }
        }
        value += array[chars[i] - 'A'];
        return value;
    }
}
