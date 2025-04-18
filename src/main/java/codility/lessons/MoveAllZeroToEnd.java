package codility.lessons;

public class MoveAllZeroToEnd {
    public static void main(String[] args) {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		int n = arr.length;
        MoveAllZeroToEnd moveAllZeroToEnd = new MoveAllZeroToEnd();
        moveAllZeroToEnd.moveZeroesToEnd(arr, n);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

// Suggested code may be subject to a license. Learn more: ~LicenseLog:683431753.
    private void moveZeroesToEnd(int[] arr, int n) { 
        int countOfNonZero = 0;
        for(int i=0;i<n;i++) {
            if(arr[i] != 0) {
                arr[countOfNonZero] = arr[i];
                countOfNonZero++;
            }
        }
        while (countOfNonZero < n) {
            arr[countOfNonZero] = 0;
            countOfNonZero++;
        }
    }
}
