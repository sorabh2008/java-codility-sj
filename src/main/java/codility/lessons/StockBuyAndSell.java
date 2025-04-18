package codility.lessons;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr = {1,5,3,8,12};
        StockBuyAndSell stockBuyAndSell = new StockBuyAndSell();
        int profit = stockBuyAndSell.buyAndSell(arr);
        System.out.println("Profit = "+profit);

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

    
}
