
package codility.lessons;

class LargestSumSubArray {
    public static void main(String[] args) {
        int input1[] = {-3,-1,-2,-2,-5,-6};

        LargestSumSubArray largestSumSubArray = new LargestSumSubArray();
        System.out.println("Largest sum = "+largestSumSubArray.largestSum(input1, input1.length));
        System.out.println("Largest sum pos or neg = "+largestSumSubArray.largestSumPosOrNeg(input1));
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

    private int largestSumPosOrNeg(int[] a) {
        int max_so_far = a[0];
        int max_ending_here = a[0];

        for(int i=1;i<a.length;i++) {
            max_ending_here = Math.max(max_ending_here + a[i], a[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
