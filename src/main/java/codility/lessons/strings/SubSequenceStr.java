package codility.lessons.strings;

/**
 * Check if a String is Subsequence of Other 
 * 
 * Input S1 = "ABCD"
 * S2 = "AC"
 * 
 * Output = Yes
 */
public class SubSequenceStr {
    public static void main(String[] args) {
        String S1 = "ABCD";
        String S2 = "AD";
        SubSequenceStr subSequenceStr = new SubSequenceStr();
        boolean isSubsequence = subSequenceStr.solution(S1, S2);
        System.out.println("Is subsequence = "+isSubsequence);
    }

    private boolean solution(String S1, String S2) {
        int len1 = S1.length();
        int len2 = S2.length();
        int j=0;
        for(int i=0; i<len1 && j<len2; i++) {
            if(S1.charAt(i) == S2.charAt(j))
                j++;
        }
        return j == len2;
    }


}
