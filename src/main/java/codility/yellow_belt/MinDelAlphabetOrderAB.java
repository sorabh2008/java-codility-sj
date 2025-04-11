package codility.yellow_belt;

/**
 * String consis of only A and/or B.
 * Obtain String in format A...AB...B
 * all A should occur before all B
 * by deleting some letters.
 * 
 * Given
 * S = "BAAABAB", Should return 2 and final S = "AAABB"
 * S = "BBABAA". return 3, S="AAA" or S="BBB"
 * S = "AABBBB", return 0
 * 
 * S = "BAAABAB"
 * Iteration 1: BAAABAB, index=0
 * if I keep B Iteration 2 = BAAABAB, index=1; S[1] = A; Return False; So cannot keep B.
 * 
 * If I do not keep B;
 * Iteration 2 = AAABAB; S[1] = A; All good so far.
 * Iteration 3 = KEEP A and not need to remove A since it is first occurance.
 * Iteration 4 = AAABAB; S[3] = A; All Good.
 * Iteration 5 = AAABAB; S[4] = B; now again 2 options - keep or delete.
 * Keep Iteration 6 = AAABAB; S[5] = A; NO PROGRESS.
 * Remove, Iteration 7 = AAAAB; S[5] = A; All good.
 * similarly remianing calculations.
 * 
 * Final result can be:
 * Result 1 = AAABB; This is by removing S[0]=B and S[5]=A
 * Result 2 = AAAAB; This is by removing S[0]=B and S[4]=B
 * Both results are fine.
 */
public class MinDelAlphabetOrderAB {
    public static void main(String[] args) {
        MinDelAlphabetOrderAB minDelAlphabetOrderAB = new MinDelAlphabetOrderAB();
        String S1 = "BAAABAB";
        String S2 = "BBABAA";
        String S3 = "AABBBB";
        System.out.println("Min Count for "+ S1 + " = "+minDelAlphabetOrderAB.solution(S1));
        System.out.println("Min Count for "+ S2 + " = "+minDelAlphabetOrderAB.solution(S2));
        System.out.println("Min Count for "+ S3 + " = "+minDelAlphabetOrderAB.solution(S3));
    }
    
    public String solution(String S) {
        int n = S.length();
        int[] prefixA = new int[n + 1]; // prefixA[i] = number of A's from 0 to i-1
        int[] suffixB = new int[n + 1]; // suffixB[i] = number of B's from i to end

        // Build prefixA
        for (int i = 0; i < n; i++) {
            prefixA[i + 1] = prefixA[i] + (S.charAt(i) == 'A' ? 1 : 0);
        }

        // Build suffixB
        for (int i = n - 1; i >= 0; i--) {
            suffixB[i] = suffixB[i + 1] + (S.charAt(i) == 'B' ? 1 : 0);
        }

        // Find the max (A's before i) + (B's from i)
        int maxSortedLength = 0;
        int bestIndex = 0;
        for (int i = 0; i <= n; i++) {
            int sortedLength = prefixA[i] + suffixB[i];
            if (sortedLength > maxSortedLength) {
                maxSortedLength = sortedLength;
                bestIndex = i;
            }
        }

        // Build the final string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bestIndex; i++) {
            if (S.charAt(i) == 'A') result.append('A');
        }
        for (int i = bestIndex; i < n; i++) {
            if (S.charAt(i) == 'B') result.append('B');
        }

        return result.toString();
    }
    
    

   
}
