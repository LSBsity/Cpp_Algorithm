class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = chars[j] - 'A';    
            }
        }
        
        while (true) {
            boolean[][] v = new boolean[m][n];
            boolean erased = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] == -1) continue;
                    if (arr[i][j] == arr[i][j + 1] && 
                        arr[i][j + 1] == arr[i + 1][j + 1] && 
                        arr[i + 1][j + 1] == arr[i + 1][j]) {
                        v[i][j] = v[i][j + 1] = v[i + 1][j] = v[i + 1][j + 1] = true;
                        erased = true;
                    }
                }
            }
            
            if (!erased) {
                break;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (v[i][j]) {
                        arr[i][j] = -1;
                    }
                }
            }
            
            for (int j = 0; j < n; j++) {
                int empty = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (arr[i][j] != -1) {
                        arr[empty][j] = arr[i][j];
                        if (empty != i) arr[i][j] = -1;
                        empty--;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == -1) answer++;
            }
        }
        
        return answer;
    }
}