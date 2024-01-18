package com.series.InterviewPrep2024.AppleInterviewQuestionBank;

/*
Given an m x n grid of characters board and a string word, return true if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Examples:

Example 1:
Input:
[
["A", "B", "C", "E"],
["S", "F", "C", "S"],
["A", "D", "E", "E"]
]
word = "ABCCED"
Output: true
Explanation: We can easily find the given word in the matrix.

 */
public class WordSearch {

    public static boolean searchWord(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        int index = 0;
        boolean[][] visited = new boolean[m][n];

        // First search the first character
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(index)) {
                    if (search(board, word, i, j, index, m, n, visited))
                        return true;
                }
            }
        }

        return false;
    }

    private static boolean search(char[][] board, String word, int i, int j, int index, int m, int n, boolean[][] visited) {

        // if index reaches at the end that means we have found the word
        if (index == word.length()) {
            return true;
        }

        if (i<0 || j<0 || i>=m || j>=n || index >word.length() || board[i][j] != word.charAt(index) || visited[i][j] == true) {
            return false;
        }


        char c = board[i][j];
        visited[i][j] = true;

        boolean top = search(board, word, i-1, j, index+1, m, n, visited);
        boolean left = search(board, word, i, j+1, index+1, m, n, visited);
        boolean right = search(board, word, i, j-1, index+1, m, n, visited);
        boolean bottom = search(board, word, i+1, j, index+1, m, n, visited);

        board[i][j] = c;

        return top || bottom || left || right;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(searchWord(board, word));
    }
}
