package leetcode.structure;

import java.util.Stack;

public class BracketIsValid {
    public boolean isValid(String s) {
        Stack<Character> res = new Stack<>();
        char[] temp = s.toCharArray();
        if (temp.length > 1 && temp[0] != '(' && temp[0] != '[' && temp[0] != '{')
            return false;
        for (char c : temp) {
            try {
                switch (c) {
                case '(':
                    res.push(c);
                    break;
                case '[':
                    res.push(c);
                    break;
                case '{':
                    res.push(c);
                    break;
                case ')':
                    if (res.peek() == '(') {
                        res.pop();
                        break;
                    } else
                        return false;
                case ']':
                    if (res.peek() == '[') {
                        res.pop();
                        break;
                    } else
                        return false;
                case '}':
                    if (res.peek() == '{') {
                        res.pop();
                        break;
                    } else
                        return false;
                }
            } catch (Exception e) {
                return false;
            }

        }
        return res.empty();
    }

    public static void main(String[] args) {
        BracketIsValid bracket = new BracketIsValid();
        System.out.println(bracket.isValid("({})"));
        System.out.println(bracket.isValid("({}"));
    }
}