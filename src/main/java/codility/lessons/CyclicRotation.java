package codility.lessons;

import java.util.Arrays;

/*
 * For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
		
		int[] rotatedArray = A.clone();
		if (A.length > 1) {
			if (K > 0) {
				for (int i = 0; i < K; i++) {
					rotatedArray = rotateArray(rotatedArray);
				}
			}
		}
		
		return rotatedArray;
	}

	private int[] rotateArray(int[] array) {
		int[] rotatedArray = new int[array.length];
		int lastValue = array[array.length - 1];
		for (int j = 1; j < array.length; j++) {
			rotatedArray[j] = array[j-1];
		}
		rotatedArray[0] = lastValue;
		return rotatedArray;
	}
    public static void main(String[] args) {
		System.out.println("Starting");
        int[] A = new int[]{3,8,9,7,6};
        int K = 3;
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] rotatedArray = cyclicRotation.solution(A, K);
        System.out.println(Arrays.toString(rotatedArray));
    }
}
