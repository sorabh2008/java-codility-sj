package codility.lessons;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StopWatch;

public class CombinationSumIVProblem {
    public static void main(String[] args) {
        CombinationSumIVProblem combinationSumIVProblem = new CombinationSumIVProblem();
        int[] nums = new int[]{1,2,3,4,5};
        int target = 6;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Using recursion = "+combinationSumIVProblem.SolutionUsingRecursion(nums, target));
        stopWatch.stop();
        System.out.println("Time taken = "+stopWatch.lastTaskInfo().getTimeNanos());

        Map<Integer,Integer> memoryMap = new HashMap<>();
        stopWatch.start();
        System.out.println("Using DP = "+combinationSumIVProblem.SolutionUsingDP(nums, target, memoryMap));
        stopWatch.stop();
        System.out.println("Time taken = "+stopWatch.lastTaskInfo().getTimeNanos());
    }   

    private int SolutionUsingRecursion(int[] nums, int target) {
        if(target == 0) return 1;
        if(target <0) return 0;

        int result =0;
        for(int i=0;i<nums.length;i++) {
            result += SolutionUsingRecursion(nums, target-nums[i]);
        }
        return result;
    
    }

    private int SolutionUsingDP(int[] nums, int target, Map<Integer,Integer> memoryMap) {
        if(target == 0) return 1;
        if(target <0) return 0;
        if(memoryMap.get(target) != null) return memoryMap.get(target);

        int result =0;
        for(int i=0;i<nums.length;i++) {
            result += SolutionUsingRecursion(nums, target-nums[i]);
        }
        memoryMap.put(target, result);
        return memoryMap.get(target);
    }
}
