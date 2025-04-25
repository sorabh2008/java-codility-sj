package codility.yellow_belt;

import java.util.HashMap;
import java.util.Map;

public class TransactionBankAccount {
    public static void main(String[] args) {
        TransactionBankAccount transactionBankAccount = new TransactionBankAccount();
        int[] A1={100,100,100,-10};
        int[] A2={180,-50,-25,-25};
        int[] A3={1,-1,0,-105,1};

        String[] S1={"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"};
        String[] S2={"2020-01-01", "2020-01-02", "2020-01-01", "2020-01-31"};
        String[] S3={"2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12"};
        System.out.println(transactionBankAccount.solution(A1, S1));
        System.out.println(transactionBankAccount.solution(A2, S2));
        System.out.println(transactionBankAccount.solution(A3, S3));

    }

    private int solution(int[] A, String[] S) {
        int totalAmount = this.calculateTotalAmount(A);
        int feeAmount = this.calculateFees(A,S);
        return totalAmount - feeAmount;
    }

    private int calculateTotalAmount(int[] A) {
        int totalAmount = 0;
        for(int amt: A) {
            totalAmount += amt;
        }
        return totalAmount;
    }

    private int calculateFees(int[] A, String[] S) {
        int feeAmount = 12*5;
        Map<String, Map<String, Integer>> feeMap = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            String dateStr = S[i].substring(0,6);
            if(feeMap.get(dateStr) == null) {
                Map<String,Integer> transMap = new HashMap<>();
                transMap.put("amount", 0);
                transMap.put("transaction", 0);
                feeMap.put(dateStr, transMap);
            } 
            if(A[i] < 0) {
                feeMap.get(dateStr).put("amount", feeMap.get(dateStr).get("amount") + A[i]);
                feeMap.get(dateStr).put("transaction", feeMap.get(dateStr).get("transaction") + 1);
            }
            
        }

        for(String dateStr: feeMap.keySet()) {
            Map<String, Integer> transMap = feeMap.get(dateStr);
            int amount = transMap.get("amount");
            int transaction = transMap.get("transaction");
            if(amount <= -100 && transaction >=3) feeAmount -= 5;
        }
        return feeAmount;
    }
        
    
}
