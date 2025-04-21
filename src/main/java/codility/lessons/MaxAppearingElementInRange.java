package codility.lessons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays L[ ] and R[ ] of size N where L[i] and R[i] (0 ? L[i], R[i] < 106) denotes a range of numbers, the task is to find the maximum occurred integer in all the ranges. If more than one such integer exists, print the smallest one. 
 * Examples: 

Input: L[ ] = {1, 4, 3, 1}, R[ ] = {15, 8, 5, 4}
Output: 4

Explanation: Overall ranges are: {1,2,3,4,5,6,7,8,9,10,11,12,13,14 15}, {4,5,6,7,8}, {3,4,5}, {1,2,3,4}. 

In all these ranges, 4 appears the most times.

Input: L[ ] = {1, 5, 9, 13, 21}, R[ ] = {15, 8, 12, 20, 24}
Output: 5
Explanation: Overall Ranges are: {1,2,3,4,5,6,7,8,9,10,11,12,13,14 15}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16,17,18,19,20},{21,22,23,24}
In these ranges, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 all appear 2 times. The smallest number among all are 5.
 * 
 */
public class MaxAppearingElementInRange {
    public static void main(String[] args) {
        MaxAppearingElementInRange maxAppearingElementInRange = new MaxAppearingElementInRange();
        int[] L1 = new int[]{1, 4, 3, 1};
        int[] R1 = new int[]{15, 8, 5, 4};

        int[] L2 = new int[]{1, 5, 9, 13, 21};
        int[] R2 = new int[]{15, 8, 12, 20, 24};

        System.out.println("Max appearing element in range = "+maxAppearingElementInRange.solveEff(L1, R1));

        System.out.println("Max appearing element in range = "+maxAppearingElementInRange.solveEff(L2, R2));
        
    }

    private int solveEff(int[] L, int[] R) {
        // Initialising all element of array to 0.
		int[] arr = new int[1000000];
        int n= L.length;
		// Adding +1 at Li index and
		// subtracting 1 at Ri index.
		int maxi = -1;
		for (int i = 0; i < n; i++) {
			arr[L[i]] += 1;
			arr[R[i] + 1] -= 1;
			if (R[i] > maxi) {
				maxi = R[i];
			}
		}

		// Finding prefix sum and index
		// having maximum prefix sum.
		int msum = arr[0];
		int ind = 0;
		for (int i = 1; i < maxi + 1; i++) {
			arr[i] += arr[i - 1];
			if (msum < arr[i]) {
				msum = arr[i];
				ind = i;
			}
		}

		return ind;
    }
}
