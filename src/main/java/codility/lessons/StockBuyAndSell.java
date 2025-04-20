package codility.lessons;


import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StopWatch;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr = {1,5,3,8,12};
        int[] arr2 = {7,1,5,3,6,4};
        StockBuyAndSell stockBuyAndSell = new StockBuyAndSell();
        
        StopWatch stopwatch = new StopWatch();

        stopwatch.start();
        System.out.println("Eff Profit for "+Arrays.toString(arr) + " = " + stockBuyAndSell.buyAndSell(arr));
        System.out.println("Eff Profit for "+Arrays.toString(arr2)+ " = " + stockBuyAndSell.buyAndSell(arr2));
        stopwatch.stop();
        System.out.println(stopwatch.lastTaskInfo().getTimeNanos());
        

        stopwatch.start();
        System.out.println("Rec Profit for "+Arrays.toString(arr) + " = " + stockBuyAndSell.buyAndSellRec(arr, 0, true));
        System.out.println("Rec Profit for "+Arrays.toString(arr2)+ " = " + stockBuyAndSell.buyAndSellRec(arr2, 0, true));
        stopwatch.stop();
        System.out.println(stopwatch.lastTaskInfo().getTimeNanos());

        // Create DP Array
        stopwatch.start();
        Map<Integer,Integer> memoryMap = new HashMap<>();
        System.out.println("DP Profit for "+Arrays.toString(arr) + " = " + stockBuyAndSell.buyAndSellDP(arr, 0, true, memoryMap));
        Map<Integer,Integer> memoryMap2 = new HashMap<>();
        System.out.println("DP Profit for "+Arrays.toString(arr2)+ " = " + stockBuyAndSell.buyAndSellDP(arr2, 0, true, memoryMap2));
        stopwatch.stop();
        System.out.println(stopwatch.lastTaskInfo().getTimeNanos());
    }

    private int buyAndSell(int[] arr) {
        int profit =0;
        for(int i=1; i<arr.length;i++) {
            if(arr[i] > arr[i-1]) {
                profit += arr[i] - arr[i-1];
            }
        }
        return profit;
    }


    private int buyAndSellRec(int[] arr, int pos, boolean isBuyAllowed) {
        if(pos>=arr.length) return 0;
        int profit = 0;
        if(isBuyAllowed) {
            int buy = -arr[pos] + this.buyAndSellRec(arr, pos+1, false);
            int notBuy = this.buyAndSellRec(arr, pos+1, true); 
            profit = Math.max(buy, notBuy);
        } else {
            int sell = this.buyAndSellRec(arr, pos+1, true) + arr[pos];
            int notSell = this.buyAndSellRec(arr, pos+1, false); 
            profit = Math.max(sell, notSell);
        }
        return profit;
    }

    private int buyAndSellDP(int[] arr, int pos, boolean isBuyAllowed, Map<Integer,Integer> memoryMap) {
        if(pos>=arr.length) return 0;
        if(memoryMap.get(pos) != null) return memoryMap.get(0);
        int profit = 0;
        if(isBuyAllowed) {
            int buy = -arr[pos] + this.buyAndSellRec(arr, pos+1, false);
            int notBuy = this.buyAndSellRec(arr, pos+1, true); 
            profit = Math.max(buy, notBuy);
        } else {
            int sell = this.buyAndSellRec(arr, pos+1, true) + arr[pos];
            int notSell = this.buyAndSellRec(arr, pos+1, false); 
            profit = Math.max(sell, notSell);
        }
        memoryMap.put(pos, profit);
        return memoryMap.get(pos);
    }
    
}
