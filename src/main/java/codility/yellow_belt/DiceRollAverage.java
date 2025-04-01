package codility.yellow_belt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceRollAverage {
    public static void main(String[] args) {
        DiceRollAverage diceRollAverage = new DiceRollAverage();
        int[] rolls = new int[]{6,6,6};
        int remainingThrows = 5;
        int targetAverage = 5;
        List<Integer> result = diceRollAverage.solution(rolls, remainingThrows, targetAverage);
        if(result == null) System.out.println("No possible result");
        else System.out.println(Arrays.toString(result.toArray()));
    }

    private List<Integer> solution(int[] previousRolls, int remainingThrows, int targetAverage) {
        int totalSoFar = 0;
        int throwsSoFar = previousRolls.length;
        for(int i=0;i<throwsSoFar;i++) totalSoFar+=previousRolls[i];

        int remainingTotal = (targetAverage * (throwsSoFar + remainingThrows)) - totalSoFar;

        if(remainingTotal < remainingThrows || remainingTotal > (remainingThrows*6)) return null;

        List<Integer> result = new ArrayList<Integer>();

        int baseValue = remainingTotal / remainingThrows;
        System.out.println("Base value = "+baseValue);
        int remainder = remainingTotal % remainingThrows;

        System.out.println("Remainder = "+remainder);

        for (int i = 0; i < remainingThrows; i++) {
            result.add(baseValue);
        }
        if(baseValue !=0 ){
             for (int i = 0; i < remainder; i++) {
                result.set(i, result.get(i) + 1);
            }
        }
        return result;
    }
}
