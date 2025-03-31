package codility.yellow_belt;

/*
There is an array A of N integers and three tiles. Each tile can cover two neighbouring numbers from the array but cannot intersect with another tile. It also cannot be placed outside the array, even partially.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the maximum sum of numbers that can be covered using at most three tiles.

Examples:

Given A = [2, 3, 5, 2, 3, 4, 6, 4, 1], the function should return 25. There is only one optimal placement of tiles: (3, 5), (3, 4), (6, 4).

Given A = [1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1], the function should return 35. One of the three optimal placements of tiles is (5, 3), (6, 10), (4, 7).

Given A = [1, 2, 3, 3, 2], the function should return 10. There is one optimal placement of tiles: (2, 3), (3, 2). Only two tiles can be used because A is too small to contain another one.

Given A = [5, 10, 3], the function should return 15. Only one tile can be used.

Write an efficient algorithm for the following assumptions:

anges saved

• N is an integer within the range [2..100,000];
 */

public class MaxSumArrThreeTiles {
    public static void main(String[] args) {
        MaxSumArrThreeTiles maxSumArrThreeTiles = new MaxSumArrThreeTiles();
        int[] A = new int[]{2, 3, 5, 2, 3, 4, 6, 4, 1};
        // int[] A = new int[]{1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1};
        // int[] A = new int[]{1, 2, 3, 3, 2};
        // int[] A = new int[]{5, 10, 3};
        System.out.println("Max sum = "+maxSumArrThreeTiles.solution(A));
    }

    private int solution(int[] A) {        
        int n = A.length;        
        if (n < 6) {
            int max = 0;
            // If the array has only two elements, return their sum
             if(n == 2){ 
                return A[0] + A[1];
            }
            // If the array has three elements, return the maximum of the sums of the two possible pairs.
            if(n == 3){ 
                 max = Math.max(max,A[0]+A[1]);
                 max = Math.max(max,A[1]+A[2]);
                 return max;
            }
            // If the array has four elements, return max between the sum of all elements or just 2 pairs
            if(n==4){ 
                return Math.max(A[0] + A[1]+ A[2] + A[3] ,Math.max(A[0] + A[1], A[2]+A[3]));
            }
             if(n==5){
                int sum1 = A[0]+A[1];
                int sum2 = A[1]+A[2];
                int sum3= A[2]+A[3];
                int sum4= A[3]+A[4];
                 return Math.max(sum1+sum3,sum2+sum4);
            }
           
            //for the cases n is bigger than 3 but less than 6 will calculate the max between pairs.
            for (int i = 0; i < n - 1 ; i++) {
                max = Math.max(max, A[i] + A[i + 1]);
            }
            
            return max;
        }

        int[] leftMax = new int[n];
        leftMax[0] = 0;
        leftMax[1] = A[0] + A[1];
        for (int i = 2; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i - 1] + A[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = 0;
        rightMax[n - 2] = A[n - 2] + A[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i] + A[i + 1]);
        }
        int maxSum = 0;
        for(int i=1; i<n-4; i++){            
           
            int sum1 = A[i]+A[i+1];            
            if(n==5)
                return Math.max(A[0]+A[1]+A[3]+A[4],Math.max(A[0]+A[1],A[2]+A[3]));
           
            int sum2 = leftMax[i-1];
            int sum3 = rightMax[i+2];
            maxSum = Math.max(maxSum, sum1+sum2+sum3);

        }

        return maxSum;

        
    }

   
    
}
