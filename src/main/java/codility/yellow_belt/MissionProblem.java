package codility.yellow_belt;
/**
 * 
 * 
In order to finish a game, a player has to complete N missions. The missions are numbered from 0 to N−1. The K-th mission has an integer D[K] assigned, representing its difficulty level.

During a day, you can perform any number of missions given the following two rules:

Missions should be performed in the specified order, i.e., a mission can be undertaken only if all of the missions preceding it have already been completed.
The difference between the difficulty levels of any two missions performed on the same day should not be greater than an integer X.
Write a function:

class Solution {
    public int solution(int[] D, int X) {
        // write your code in Java SE 8
    }
}
that, given an array D of N integers and an integer X, returns the minimum number of days required to complete all of the missions in the game.

Examples:

Given D=[5,8,2,7] and X=3, your function should return 3. The first two missions can be performed on the first day, the third mission on the second day, and the last mission on the third day. It is not possible to complete all of the missions in fewer days.
Given D=[2,5,9,2,1,4] and X=4, your function should return 3. The first two missions can be performed on the first day, the third mission on the second day, and all of the remaining missions on the third day. Note that it is possible to perform the first mission on the first day and the next two missions on the second day. In both of these cases, the minimum number of days required to complete all of the missions is 3.
Given D=[1,12,10,4,5,2] and X=2, your function should return 4. The first mission can be performed on the first day, the next two missions on the second day, the fourth and fifth missions on the third day, and the last remaining mission on the fourth day. It is not possible to complete all of the missions in fewer days.
Write an efficient algorithm for the following assumptions:

N is an integer within the range [1,200,000).
X is an integer within the range [0,1,000,000,000).
Each element of array D is an integer within the range [1,1,000,000,000].
 * 
 * 
 */
public class MissionProblem {
    public static void main(String[] args) {
        int[] D = {5,8,2,7};
        int[] D1= {2,5,9,2,1,4};
        int[] D2 = {1,12,10,4,5,2};
        int X = 3;
        int X1 = 4;
        int X2 = 2;
        System.out.println(new MissionProblem().solution(D, X));
        System.out.println(new MissionProblem().solution(D1, X1));
        System.out.println(new MissionProblem().solution(D2, X2));

    }

    private int solution(int[] D, int X) {
        int result = 1;
        int minDiff = D[0];
        int maxDiff = D[0];

        for(int i=1;i<D.length;i++) {
            if((Math.abs(D[i] - minDiff) <= X) && (Math.abs(D[i]-maxDiff) <= X)) {
                minDiff = Math.min(minDiff, D[i]);
                maxDiff = Math.max(maxDiff, D[i]);
            } else {
                result++;
                minDiff = D[i];
                maxDiff = D[i];
            }
        }
        return result;
    }
}
