class Solution {
    public boolean exist(char[][] board, String word) {
        boolean answer = false;
        Set<Pair<Integer, Integer>> seen = new HashSet<>();

        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    answer = dfs(board, word, i, j, 0, seen);
                    if(answer) {
                        return true;
                    }
                }
            }
        }
        return answer;

    }

    private boolean dfs(char[][] board, String word, int row, int col, int index, Set<Pair<Integer, Integer>> seen) {
        if(row < 0 || row == board.length) {
            return false;
        }

        if(col < 0 || col == board[0].length) {
            return false;
        }

        if(board[row][col] != word.charAt(index)) {
            return false;
        }

        if(seen.contains(new Pair<>(row, col))) {
            return false;
        }

        if(index == word.length()) {
            return false;
        }

        if(board[row][col] == word.charAt(index) && index == word.length()-1) {
            return true;
        }

        seen.add(new Pair<>(row, col));
        boolean answer = dfs(board, word, row+1, col, index + 1, seen) ||
        dfs(board, word, row-1, col, index + 1, seen) ||
        dfs(board, word, row, col-1, index + 1, seen) ||
        dfs(board, word, row, col+1, index + 1, seen);
        seen.remove(new Pair<>(row, col));

        return answer;
    }
}
