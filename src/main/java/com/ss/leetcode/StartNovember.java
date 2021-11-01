package com.ss.leetcode;

import com.ss.leetcode.november.SurroundedRegions;

import java.util.Arrays;

public class StartNovember {
    public static void main(String[] args) {
        StartNovember start = new StartNovember();

        start.surroundedRegions();
    }

    public void surroundedRegions() {
        SurroundedRegions sr = new SurroundedRegions();

        char[][] board1 = {{'X','X','X','X'}, {'X','O','O','X'},{'X','X','O','X'}, {'X','X','X','X'}};
        char[][] board2 = {{'O','O','O','O','X','X'}, {'O','O','O','O','O','O'}, {'O','X','O','X','O','O'},
            {'O','X','O','O','X','O'}, {'O','X','O','X','O','O'}, {'O','X','O','O','O','O'}};
        char[][] board3 = {{'X','O','X','O','O','O','O'}, {'X','O','O','O','O','O','O'}, {'X','O','O','O','O','X','O'},
            {'O','O','O','O','X','O','X'}, {'X','O','O','O','O','O','O'}, {'O','O','O','O','O','O','O'}, {'O','X','O','O','O','O','O'}};

//        sr.solve(board1);
//        sr.solve(board2);
        sr.solve(board3);
        System.out.println("[[X,X,X,X],[X,X,X,X],[X,O,X,X]] == " + Arrays.deepToString(board1));
        System.out.println("[[O,O,O,O,X,X],[O,O,O,O,O,O],[O,X,O,X,O,O],[O,X,O,O,X,O],[O,X,O,X,O,O], [O,X,O,O,O,O]] == " + Arrays.deepToString(board2));
        System.out.println("[[X,O,X,O,O,O,O],[X,O,O,O,O,O,O],[X,O,O,O,O,X,O], [O,O,O,O,X,O,X],[O,X,O,O,O,O,O],[O,O,O,O,O,O,O],[O,X,O,O,O,O,O]] == " + Arrays.deepToString(board3));

    }
}

