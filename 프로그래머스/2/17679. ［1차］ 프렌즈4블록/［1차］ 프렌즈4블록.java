class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = chars[j];
            }
        }
        
        while (true) {
            boolean[][] v = new boolean[m][n];
            boolean check = false;
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] == arr[i][j + 1] &&
                        arr[i][j + 1] == arr[i + 1][j + 1] &&
                        arr[i + 1][j + 1] == arr[i + 1][j] &&
                        arr[i][j] != -1) {
                        v[i][j] = v[i][j + 1] = v[i + 1][j + 1] = v[i + 1][j] = true;
                        check = true;
                    }
                }
            }

            if (!check) {
                for (int i = 0; i < m; i++) { 
                    for (int j = 0; j < n; j++) { 
                        if (arr[i][j] == -1) answer++;
                    }
                }
                return answer;
            }
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (v[i][j]) arr[i][j] = -1;
                }
            }
            
            for (int j = 0; j < n; j++) {
                int emptyRow = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (arr[i][j] != -1) {
                        arr[emptyRow][j] = arr[i][j];
                        if (emptyRow != i) arr[i][j] = -1;
                        emptyRow--;
                    }
                }
            }
        }
    }
    
}