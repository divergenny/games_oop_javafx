package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 1 && (monoHorizontal(board, index) || monoVertical(board, index))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static boolean monoHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int cellItr = 0; cellItr < board.length; cellItr++) {
            if(board[row][cellItr] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean monoVertical(int[][] board, int cell) {
        boolean result = true;
        for (int rowItr = 0; rowItr < board.length; rowItr++) {
            if(board[rowItr][cell] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
