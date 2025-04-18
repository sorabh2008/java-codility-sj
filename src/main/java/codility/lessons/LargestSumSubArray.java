
package codility.lessons;

class LargestSumSubArray {
    public static void main(String[] args) {
        
    }

    private int largestSum(int[] a, int n) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for(int i=0;i<n;i++) {
            max_ending_here += a[i];
            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if(max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
}
