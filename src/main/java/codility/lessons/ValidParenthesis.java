package codility.lessons;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        String S1="()";
        String S2="([])";
        String S3="(])";
        String S4="[{(()[])}]";
        String S5="[]([)]";
        System.out.println("Validity for "+S1+" = "+validParenthesis.isValid(S1));
        System.out.println("Validity for "+S2+" = "+validParenthesis.isValid(S2));
        System.out.println("Validity for "+S3+" = "+validParenthesis.isValid(S3));
        System.out.println("Validity for "+S4+" = "+validParenthesis.isValid(S4));
        System.out.println("Validity for "+S5+" = "+validParenthesis.isValid(S5));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    
}
