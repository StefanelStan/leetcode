package com.ss.leetcode.LC2023.november;

public class CheckIfWordCanBePlacedInCrossword {
    // https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword
    /** Algorithm
        1. Due to the condition to check if word OR reverseWord can be placed, we will need to check if the word OR
            its reverse can be placed on the board.
        2. Use two methods: can place horizontally (line by line) and canPlaceVertically (column by column)
        3. Can Place Horizontally if word length is <= line length, then check each line
        4. Traverse each cell and apply the logic
        5  If the current cell is #
            - Then your next available cell could be index + 1. A word can only start from an available cell
            - If current index - last available cell == word.length && hasNoMismatches, then return true. You found
                a matching block. Else, reset your hasNoMismatches
        6. If your current cell is NOT empty, then check if the letter is matching its correct index in word
             word[index - lastAvailableCell]. Pay attention to edge cases when the empty block > word.length
        7. At the end, return hasNoMismatches && word.length == line.length - lastAvailable.
     */
    public boolean placeWordInCrossword(char[][] board, String word) {
        char[] wordChars = word.toCharArray();
        char[] reversed = new StringBuilder(word).reverse().toString().toCharArray();
        return canPlaceHorizontally(board, wordChars) || canPlaceVertically(board, wordChars)
            || canPlaceHorizontally(board, reversed) || canPlaceVertically(board, reversed);
    }

    private boolean canPlaceHorizontally(char[][] board, char[] word) {
        boolean canBePlaced = false;
        if (word.length > board[0].length) {
            return false;
        }
        for (int i = 0; i < board.length && !canBePlaced; i++) {
            canBePlaced = canBePlacedInLine(board[i], word);
        }
        return canBePlaced;
    }

    private boolean canPlaceVertically(char[][] board, char[] word) {
        if (word.length > board.length) {
            return false;
        }
        boolean canBePlaced = false;
        for (int j = 0; j < board[0].length && !canBePlaced; j++) {
            canBePlaced = canBePlacedInColumn(board, j, word);
        }
        return canBePlaced;
    }

    private boolean canBePlacedInColumn(char[][] board, int col, char[] word) {
        int emptySpace = 0;
        boolean matching = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '#') {
                if (matching && i - emptySpace == word.length) {
                    return true;
                }
                emptySpace = i + 1;
                matching = true;
            } else if (board[i][col] != ' ') {
                matching = matching && (i - emptySpace < word.length) && board[i][col] == word[i - emptySpace];
            }
        }
        return matching & board.length - emptySpace == word.length;
    }

    private boolean canBePlacedInLine(char[] line, char[] word) {
        int emptySpace = 0;
        boolean matching = true;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == '#') {
                if (matching && i - emptySpace == word.length) {
                    return true;
                }
                emptySpace = i + 1;
                matching = true;
            } else if (line[i] != ' ') {
                matching = matching && (i - emptySpace < word.length) && line[i] == word[i - emptySpace];
            }
        }
        return matching && line.length - emptySpace == word.length;
    }
}
