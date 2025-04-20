package codility.lessons;

public class MaxLengthEvenOddSubArray {
    public static void main(String[] args) {
        int input[] = {5,10,20,6,3,8};

        MaxLengthEvenOddSubArray maxLengthEvenOddSubArray = new MaxLengthEvenOddSubArray();
        System.out.println("Max length using Naive = "+maxLengthEvenOddSubArray.SolutionNaive(input));
        System.out.println("Max length using Efficient = "+maxLengthEvenOddSubArray.SolutionEfficient(input));
    }

    private int SolutionEfficient(int[] arr) {
        int result = 1;
        int currentCount = 1;
        for(int i=1;i<arr.length;i++) {
            if((arr[i] % 2 == 0 && arr[i-1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i-1] % 2 == 0)) {
                currentCount++;
                result = Math.max(currentCount, result);
            } else {
                currentCount = 1;
            }
        }
        return result;
    }

    private int SolutionNaive(int[] arr) {
        int result =1;

        for(int i=0;i<arr.length;i++) {
            int count = 1;
            for(int j=i+1;j<arr.length;j++) {
                if(( ((arr[j] & 1) == 0) && (arr[j-1] & 1) != 0)) {
                    count++;
                } else if(((arr[j] & 1) != 0 && (arr[j-1] & 1) == 0)) {
                    count++;
                } else {
                    break;
                }
            }
            if(count > result) {
                result = count;
            }
        }

        return result;
    }
}
