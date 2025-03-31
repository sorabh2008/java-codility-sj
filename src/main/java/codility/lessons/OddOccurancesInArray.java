package codility.lessons;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
A non-empty array A consisting of N integers is given. 
The array contains an odd number of elements, 
and each element of the array can be paired with another element 
that has the same value, 
except for one element that is left unpaired.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, 
returns the value of the unpaired element.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.

 * For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7,
 */

public class OddOccurancesInArray {
    public static void main(String[] args) {
        OddOccurancesInArray occurancesInArray = new OddOccurancesInArray();
        int[] A = new int[]{9,3,9,3,9,7,9};
        int unpairedElement = occurancesInArray.solution(A);
        System.out.println("Unpaired element: " + unpairedElement);
    }
    public int solution(int[] A) {
		int n = A.length;
		int unpairedElement;

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (set.contains(A[i])) {
				set.remove(A[i]);
			} else {
				set.add(A[i]);
			}
		}
		unpairedElement = set.iterator().next();
		return unpairedElement;
	}
}
