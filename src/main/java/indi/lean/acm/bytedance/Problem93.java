package indi.lean.acm.bytedance;

import java.util.ArrayList;
import java.util.List;

public class Problem93 {
    public static void restore(String s, List<String> result, String tmpResult, int idx, int part) {
        if (part == 3) {
            if (s.charAt(idx) == '0' && idx != s.length() - 1) {
                return;
            }
            int lastPart = Integer.parseInt(s.substring(idx));
            if (lastPart <= 255) {
                result.add(tmpResult + "." + lastPart);
            }
            return;
        }

        for (int step = 1; step < s.length() - idx; step++) {
            if (s.charAt(idx) == '0') {
                String inter = tmpResult == null
                        ? "0"
                        : tmpResult + "." + 0;
                restore(s, result, inter, idx + step, part + 1);
                return;
            } else {
                int partNumber = Integer.parseInt(s.substring(idx, idx + step));
                if (partNumber > 255) {
                    return;
                }
                String inter = tmpResult == null
                        ? "" + partNumber
                        : tmpResult + "." + partNumber;
                restore(s, result, inter, idx + step, part + 1);
            }
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12) {
            return result;
        }

        restore(s, result, null, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("010010");
        System.out.println(strings);
    }
}
