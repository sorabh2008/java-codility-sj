package codility.yellow_belt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * patrolBoat = # subamire = ## destroyer = ###

Destroyer ships can also take an "L" shape in any direction. In the example below, there are 4 destroyer ships, 3 submarines and 2 patrolBoats

        ['.','#','#','.','#',"#"], r = 0
        ['.','.','#','.','.',"."], r = 1
        ['.','#','.','.','.',"#"], r = 2
        ['.','#','#','.','.',"#"], r = 3
        ['.','.','.','.','.',"."], r = 4
        ['.','#','#','.','#',"#"], r = 5
        ['.','#','.','.','.',"."], r = 6
        ['.','.','#','.','#',"."], r = 7
        ['.','#','#','.','.',"#"], r = 8
     c =  0   1   2   3   4   5
 */
public class BattleshipProblem {
    public static void main(String[] args) {
        char[][] battleShipBoard = {
            {'.', '#', '#', '.', '#', '#'},
            {'.', '.', '#', '.', '.', '.'},
            {'.', '#', '.', '.', '.', '#'},
            {'.', '#', '#', '.', '.', '#'},
            {'.', '.', '.', '.', '.', '.'},
            {'.', '#', '#', '.', '#', '#'},
            {'.', '#', '.', '.', '.', '.'},
            {'.', '.', '#', '.', '#', '.'},
            {'.', '#', '#', '.', '.', '#'}
        };
        System.out.println(Arrays.toString(new BattleshipProblem().solution(battleShipBoard)));
    }

    // Convert String[] to char[][]
    private char[][] convertStringTo2DArray(String[] str) {
        int rows = str.length;
        int cols = str[0].length();
        char[][] char2DArray = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String rowString = str[i];
            for (int j = 0; j < cols; j++) {
                char2DArray[i][j] = rowString.charAt(j);
            }
        }
        return char2DArray;
    }

    private int[] solution(char[][] board) {
        int length = board[0].length;
        int height = board.length;
        int[] result = new int[3];
        Map<String, Boolean> dp = new HashMap<>();
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < length; c++) {
                int size = this.getShips(r,c,board);            
                if(size == 3) {
                  
                    result[0]++;
                } else if(size == 2) {
                    result[1]++;
                } else if(size == 1) {
                    result[2]++;
                }
            }
        }
        return result;
    }

    private int getShips(int r, int c, char[][] board) {
        if(this.isDestroyer(r, c, board)) return 3;
        else if(this.isSub(r, c, board)) return 2;
        else if(this.isPatrol(r, c, board)) return 1;
        else return 0;
    }

    private boolean isDestroyer(int r, int c, char[][] board) {
        // Check ###
        if(c<board[0].length - 2) {
            if(board[r][c] == '#' && board[r][c+1] == '#' && board[r][c+2] == '#') {
                board[r][c] = '.';
                board[r][c+1] = '.';
                board[r][c+2] = '.';
                return true;
            }
        } 
        // Check    #
        //          #
        //          #
        if(r<board.length - 2) {
            if(board[r][c] == '#' && board[r+1][c] == '#' && board[r+2][c] == '#') {
                board[r][c] = '.';
                board[r+1][c] = '.';
                board[r+2][c] = '.';
                return true;
            }
        }
        /*
         * Check
         * # .
         * # #
         * 
         * . #
         * # #
         * 
         * # #
         * . #
         * 
         * # #
         * # .
         */
        if(r < board.length -1 && c<board[0].length - 1) {
            char c1 = board[r][c];
            char c2 = board[r+1][c];
            char c3 = board[r][c+1];
            char c4 = board[r+1][c+1];

            if(
                (c1=='#' && c2=='.' && c3=='#' && c4=='#')
                || (c1 == '.' && c2 == '#' && c3 == '#' && c4=='#')
                || (c1 =='#' && c2=='#' && c3=='.' && c4=='#')
                || (c1 =='#' && c2=='#' && c3=='#' && c4=='.')
                ) { 
                board[r][c] = '.';
                board[r+1][c] = '.';
                board[r][c+1] = '.';
                board[r+1][c+1] = '.';
                return true;
            }
        }
        
        return false;
    }

    private boolean isSub(int r, int c, char[][] board) {
        // # #
        if(c<board[0].length - 1) {
            if(board[r][c] == '#' && board[r][c+1] == '#') {
                board[r][c] = '.';
                board[r][c+1] = '.';
                return true;
            }
        }
        
        // #
        // #
        if(r<board.length - 1) {
            if(board[r][c]=='#' && board[r+1][c]=='#') {
                board[r][c] = '.';
                board[r+1][c] = '.';
                return true;
            }
        }
        return false;
    }

    private boolean isPatrol(int r, int c, char[][] board) {
        if(board[r][c]=='#'){
            board[r][c]='.';
            return true;
        }
        return false;
    }


}
