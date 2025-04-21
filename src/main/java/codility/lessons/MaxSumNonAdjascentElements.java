package codility.lessons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StopWatch;

public class MaxSumNonAdjascentElements {
    public static void main(String[] args) {
        MaxSumNonAdjascentElements maxSumNonAdjascentElements = new MaxSumNonAdjascentElements();
        StopWatch stopWatch = new StopWatch();

        int[] array1 = {9,9,8,2,1,0,-4,99,1,-34,-100,-999};
        int[] array2 = {9,9,8,2};
        stopWatch.start();
        System.out.println("For array = "+Arrays.toString(array1)+", Result = "+maxSumNonAdjascentElements.solveRec(array1, 0));
        stopWatch.stop();
        System.out.println("Time taken = "+stopWatch.lastTaskInfo().getTimeNanos());
        stopWatch.start();
        System.out.println("For array = "+Arrays.toString(array2)+", Result = "+maxSumNonAdjascentElements.solveRec(array2, 0));
        stopWatch.stop();
        System.out.println("Time taken = "+stopWatch.lastTaskInfo().getTimeNanos());

        Map<Integer,Integer> memoryMap1 = new HashMap<>();
        Map<Integer,Integer> memoryMap2 = new HashMap<>();
        stopWatch.start();
        System.out.println("For array = "+Arrays.toString(array1)+", Result = "+maxSumNonAdjascentElements.solveDP(array1, 0, memoryMap1));
        stopWatch.stop();
        System.out.println("Time taken = "+stopWatch.lastTaskInfo().getTimeNanos());
        stopWatch.start();
        System.out.println("For array = "+Arrays.toString(array2)+", Result = "+maxSumNonAdjascentElements.solveDP(array2, 0, memoryMap2));
        stopWatch.stop();
        System.out.println("Time taken = "+stopWatch.lastTaskInfo().getTimeNanos());
    }

    private int solveRec(int[] arr, int pos) {
        if(pos >= arr.length) return 0;
        
        int include = arr[pos] + solveRec(arr, pos+2);
        int exclude = solveRec(arr, pos+1);

        return Math.max(include, exclude);

    }
    private int solveDP(int[] arr, int pos, Map<Integer, Integer> memoryMap) {
        if(pos >= arr.length) return 0;
        if(memoryMap.get(pos) != null) return memoryMap.get(pos);
        
        int include = arr[pos] + solveRec(arr, pos+2);
        int exclude = solveRec(arr, pos+1);

        int result = Math.max(exclude, include);
        memoryMap.put(pos, result);
        return memoryMap.get(pos);

    }
}
