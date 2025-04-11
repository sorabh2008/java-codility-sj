package codility.black_belt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
public class AllPossibleDenominations {
    public static void main(String[] args) {
        int num = 8;

        List<List<Integer>> result = getAllPossibleDenominations(num);
        result.stream().forEach(ll->{
            System.out.println(Arrays.toString(ll.toArray()));
        });

        // Get the max length
        Optional<Integer> maxLength = result.stream().map(List::size).max(Comparator.naturalOrder());
        List<List<Integer>> filteredResult = result.stream()
                .filter(list -> list.size() == maxLength.orElse(0))
                .collect(Collectors.toList());
        // Print the filtered result
        
        System.out.println("Maximal = " + Arrays.toString(filteredResult.get(0).toArray()));
        
        
    }

    /*
     * Function to get Array of all possible ways to get target integer by adding numbers.
     * E.g. if Target = 3;
     * Then to get to 3, possible ways are:
     * 3 = 1 + 2
     * 3 = 3
     * 
     * E.g. if Target = 5;
     * Possible ways to get 5 are:
     * 5 = 1 + 4
     * 5 = 2 + 3
     * 5 = 5
     * 
     * Make sure that the numbers do not repeat itself in the array.
     * 
     * Function should return List of Array of Integers
     * for target =3, it should return [ [1,2] , [3]]
     */
    public static List<List<Integer>> getAllPossibleDenominations(int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 0) {
            return new ArrayList<>(result);
        }

        List<Integer> currentCombination = new ArrayList<>();
        findCombinations(target, 1, currentCombination, result);

        // List<List<Integer>> sortedResult = new ArrayList<>(result);
        // for (List<Integer> combination : sortedResult) {
        //     Collections.sort(combination);
        // }
        
        return result;
    }

    private static void findCombinations(int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        if (target < 0) {
            return;
        }
        
        for (int i = start; i <= target; i++) {   
            if(i%2 != 0) {  // pick only odd ones
                currentCombination.add(i);
                findCombinations(target - i, i + 1, currentCombination, result);            
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
