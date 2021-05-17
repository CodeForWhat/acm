package indi.lean.acm.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Problem20 {
    private static final Map<Character, Character> BRACKETS_MAP = new HashMap<>();
    static {
        BRACKETS_MAP.put('(', ')');
        BRACKETS_MAP.put('[', ']');
        BRACKETS_MAP.put('{', '}');
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char character = s.charAt(i);
            if (BRACKETS_MAP.containsKey(character)) {
                stack.push(character);
            } else if (BRACKETS_MAP.containsValue(character)) {
                if (stack.isEmpty()) {
                    return false;
                }

                Character mustMatchCharacter = stack.pop();
                if (!Objects.equals(BRACKETS_MAP.get(mustMatchCharacter), character)) {
                    return false;
                }
            }
            i++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(]"));
    }
}
