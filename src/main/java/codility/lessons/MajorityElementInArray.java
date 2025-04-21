package codility.lessons;
/**
 * In a realm where numbers hold secrets, a captivating challenge awaits, which is, Majority Element !!!

Our Task: Find the majority element in the array. A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element). 


What is a majority element?
A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element). 
 * 
 * 
 * Examples : 

Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
Output : 4
Explanation: The frequency of 4 is 5 which is greater than the half of the size of the array size. 

Input : {3, 3, 4, 2, 4, 4, 2, 4}
Output : No Majority Element
Explanation: There is no element whose frequency is greater than the half of the size of the array size.
 * 
 */
public class MajorityElementInArray {
    public static void main(String[] args) {
        int[] input1 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int[] input2 = {3, 3, 4, 2, 4, 4, 2, 4};

        MajorityElementInArray majorityElementInArray = new MajorityElementInArray();
        int result1 = majorityElementInArray.solution(input1);
        int result2 = majorityElementInArray.solution(input2);
        System.out.println("Result 1 = "+result1);
        System.out.println("Result 2 = "+result2);

        int resultRec1 = majorityElementInArray.solveRec(input1);
        int resultRec2 = majorityElementInArray.solveRec(input2);
        System.out.println("Result 1 = "+resultRec1);
        System.out.println("Result 2 = "+resultRec2);

    }

    private int solution(int[] arr) {
        int n = arr.length;
        int count = 1;
        int element = 0;
        for(int i=1; i<n;i++) {
            if(arr[i] == arr[element]) {
                count ++;
            } else {
                count --;
            }
            if(count ==0) {
                count =1;
                element = i;
            }
        }
        int actualCount = 0;
        if(count > 0) {
            for(int i=0;i<n;i++) {
                if(arr[i] == arr[element]) {
                    actualCount ++;
                }
            }
        }
        if(actualCount > (n/2)) {
            return arr[element];
        } else {
            return -1;
        }
    }

    private int solveRec(int[] arr) {
        return solveRecLogic(arr, 0, 1, 0);
    }

    private int solveRecLogic(int[] arr, int pos, int count, int element) {
        if(pos == arr.length-1) return arr[element];
        if(count == 0) {
            return solveRecLogic(arr, pos+1, 1, pos);
        } else {
            if(arr[pos] == arr[element]) {
                return solveRecLogic(arr, pos+1, count+1, pos);
            } else {
                return solveRecLogic(arr, pos+1, count-1, pos+1);
            }
        }
    }
}
