package codility.yellow_belt;

/*
 * You are given a string S consisting of N letters 'a' and/or 'b'. In one move, you can swap one letter for the other ('a' for 'b' or 'b' for 'a').

Write a function solution that, given such a string S, returns the minimum number of moves required to obtain a string containing no instances of three identical consecutive letters.

Examples:

Given S = "baaaaa", the function should return 1. The string without three identical consecutive letters which can be obtained in one move is "baabaa".

Given S = "baaabbaabbba", the function should return 2. There are four valid strings obtainable in two moves: for example, "bbaabbaabbaa".

Given S = "baabab", the function should return 0.

Write an efficient algorithm for the following assumptions:

•N is an integer within the range [0..200,000), string S is made only of the characters 'a' and/or 'b'.
 */
public class StringSwapConsecIdentAB {
    
    public static void main(String[] args) {
        StringSwapConsecIdentAB stringSwapConsecIdentAB = new StringSwapConsecIdentAB();
        String S = "baaaaa";
        String S1 = "baaabbaabbba";
        String S2 = "baabab";
        System.out.println("Min operations for "+S+" = "+stringSwapConsecIdentAB.solution(S));
        System.out.println("Min operations for "+S1+" = "+stringSwapConsecIdentAB.solution(S1));
        System.out.println("Min operations for "+S2+" = "+stringSwapConsecIdentAB.solution(S2));
    }

    public int solution(String S) {
        if (S == null || S.length() < 3) {
            return 0;
        }
        int moves = 0;
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) {
                moves+=1;
                i++;
                arr[i + 2] = (arr[i] == 'a' ? 'b' : 'a');
            }
        }
        return moves;
    }

    
}
