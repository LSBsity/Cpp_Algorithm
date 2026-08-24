class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        String color = board[h][w];
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (board[nx][ny].equals(color)) answer++;
        }
        
        
        return answer;
    }
}