import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();        
        
        for (var move : moves) {
            int col = move - 1;
            for (int row = 0; row < board[0].length; row++) {
                if (board[row][col] != 0) {
                    stk.push(board[row][col]);
                    board[row][col] = 0;
                    break;
                }
            }
            if (stk.size() >= 2 && stk.get(stk.size() - 1) == stk.get(stk.size() - 2)) {
                stk.pop(); stk.pop();
                answer += 2;
            }
        }
        
        return answer;
    }
}