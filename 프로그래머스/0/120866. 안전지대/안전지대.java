class Solution {

    private static final int[] dx = new int[]{0, -1, 0, 1, -1, -1, 1, 1};
    private static final int[] dy = new int[]{1, 0, -1, 0, 1, -1, 1, -1};

    public int solution(int[][] board) {
        int count = board.length * board.length;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    count--;
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < board.length && y >= 0 && y < board.length) {
                            if (board[x][y] != 1) {
                                if (board[x][y] != -1) {
                                    count--;
                                }
                                board[x][y] = -1;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}