package codility.lessons;

import java.util.HashSet;
import java.util.Set;

/*
 * A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.
 */
public class PermutationCheck {
    public static void main(String[] args) {
        PermutationCheck permutationCheck = new PermutationCheck();
        int[] A = new int[]{4,1,3,2};
        System.out.println("Is it perm = "+permutationCheck.solution(A));
    }

    private int solution(int[] A) {
        Set<Integer> X = new HashSet<>();

        for(int i=1; i <= A.length; i++) {
            X.add(i);
        }

        for(int i=0;i<A.length;i++) {
            if(X.contains(A[i]))
                X.remove(A[i]);
        }
        if(X.size() == 0)
            return 1;
        else
            return 0;
    
    }
}
