package codility.lessons;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StopWatch;

/*
 * Problem:
 * Lets say we have 3 items A,B,C
 * Sub Array possible = A | B | B | AB | AC | BC | ABC | {}
 * Now lets say weight of items A=1, B=2, C=3
 * And Price of items A=10, B=3, C= 4
 * 
 * And Max weight we can carry = 10
 */
/*
 * Given n items where each item has some weight and profit associated with it and also 
 * given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. 
 * The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible. 
 * Note: The constraint here is we can either put an item completely into the bag or cannot put it at all 
 * [It is not possible to put a part of an item into the bag].
 * Input:  W = 4, profit[] = [1, 2, 3], weight[] = [4, 5, 1]
 * Output: 3
 * Explanation: There are two items which have weight less than or equal to 4. 
 * If we select the item with weight 4, the possible profit is 1. 
 * And if we select the item with weight 1, the possible profit is 3. 
 * So the maximum possible profit is 3. 
 * Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.
 * 
 * Input: W = 3, profit[] = [1, 2, 3], weight[] = [4, 5, 6]
 * Output: 0
 */
public class KnapSackProblem {
    public static void main(String[] args) {
        int W = 5;
        int[] profit = {5,4,8,6,3,5,5,6,5,9,45};
        int[] weight = {1,2,4,5,3,3,2,2,1,1,22};

        KnapSackProblem knapSackProblem  = new KnapSackProblem();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int maxProfit = knapSackProblem.solution(W, profit, weight, 0);
        stopWatch.stop();
        System.out.println("Max profit = "+maxProfit+". Calculated in Time = "+stopWatch.lastTaskInfo().getTimeNanos());

        Map<Integer,Map<Integer,Integer>> memoryMap = new HashMap<>();
        stopWatch.start();
        int maxProfitDP = knapSackProblem.solutionDP(W, profit, weight, 0, memoryMap);
        stopWatch.stop();
        System.out.println("Max profit DP = "+maxProfitDP+". Calculated in Time = "+stopWatch.lastTaskInfo().getTimeNanos());

        Map<Integer,Map<Integer,Integer>> memoryMap2 = new HashMap<>();
        stopWatch.start();
        int maxProfitTab = knapSackProblem.solutionTabulation(W, profit, weight, memoryMap2);
        stopWatch.stop();
        System.out.println("Max profit DP = "+maxProfitTab+". Calculated in Time = "+stopWatch.lastTaskInfo().getTimeNanos());
    }

    private int solution(int remainingWeight, int[] profit, int[] weight, int pos) {
        if(pos == profit.length-1) {
            if(remainingWeight >= weight[pos]) return profit[pos];
            else return 0;
        }
        int result = 0;
        int keepItem = 0;
        if(remainingWeight >= weight[pos]) {
         keepItem = profit[pos] + solution(remainingWeight - weight[pos], profit, weight, pos+1);
        } 
        int doNotKeepItem = solution(remainingWeight, profit, weight, pos+1);

        result = Math.max(keepItem, doNotKeepItem);
        return result;
    }

    private int solutionDP(int remainingWeight, int[] profit, int[] weight, int pos, Map<Integer,Map<Integer,Integer>> memoryMap) {
        if(pos == profit.length-1) {
            if(remainingWeight >= weight[pos]) return profit[pos];
            else return 0;
        }
        if(memoryMap.get(pos) != null && memoryMap.get(pos).get(remainingWeight) != null) return memoryMap.get(pos).get(remainingWeight);
        int result = 0;
        int keepItem = 0;
        if(remainingWeight >= weight[pos]) {
         keepItem = profit[pos] + solutionDP(remainingWeight - weight[pos], profit, weight, pos+1, memoryMap);
        }
        int doNotKeepItem = solutionDP(remainingWeight, profit, weight, pos+1, memoryMap);

        result = Math.max(keepItem, doNotKeepItem);
        if(memoryMap.get(pos) == null) {
            memoryMap.put(pos, new HashMap<>());
        }
        memoryMap.get(pos).put(remainingWeight, result);
        return memoryMap.get(pos).get(remainingWeight);
    }

    private int solutionTabulation(int remainingWeight, int[] profit, int[] weight, Map<Integer, Map<Integer,Integer>> memoryMap) {
        int pos = profit.length-1;
        memoryMap.put(pos, new HashMap<>());

        if(remainingWeight >= weight[pos]) {
            memoryMap.get(pos).put(remainingWeight, profit[pos]);
        } else {
            memoryMap.get(pos).put(remainingWeight, 0);
        }
        
        for(int i=profit.length-2;i>=0;i--) {
            int include = 0;
            memoryMap.put(i, new HashMap());
            if(remainingWeight >= weight[i]) {
                include = profit[i] + memoryMap.get(i+1).get(remainingWeight);
            }
            int exclude = memoryMap.get(i+1).get(remainingWeight);
            
            if(include >= exclude) {
                memoryMap.get(i).put(remainingWeight-weight[i], include);
                remainingWeight -= weight[i];
            } else {
                memoryMap.get(i).put(remainingWeight, exclude);
            }
        }
        memoryMap.keySet().stream().forEach(kk->memoryMap.get(kk).entrySet().stream().forEach(mm->System.out.println(kk +" : "+mm)));
        return 0;
    }
}
