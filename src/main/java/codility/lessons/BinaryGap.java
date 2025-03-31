package codility.lessons;
/*
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
 */
public class BinaryGap {
    public int solution(int N) {
        boolean foundOne = false;
        int maxGap = 0, currentGap = 0;
        while(N>0) {
            int num = N & 1;
            if(num == 1) {
                foundOne = true;
                maxGap = Math.max(maxGap, currentGap);
                currentGap = 0;
            } else if(foundOne && num ==0) {
                currentGap++;
            }
            N >>= 1;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        BinaryGap gap = new BinaryGap();
        System.out.println("Gap  of 1041 = " + gap.solution(1041));
    }
}
