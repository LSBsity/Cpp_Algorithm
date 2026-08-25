import java.util.*;

class Solution {
    
    static int K = 5;
    static int answer;
    static int[][] queries;
    static int[] answers;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        queries = q;
        answers = ans;
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        
        go(arr, new boolean[n], 0, n, K);
        
        return answer;
    }
    
    private void go(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            if (check(arr, visited)) {
                answer++;
            }
            return;
        } 

        for(int i = start; i < n; i++) {
            visited[i] = true;
            go(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    
    private boolean check(int[] arr, boolean[] visited) {
        int[] code = new int[K];
        for (int i = 0, idx = 0; i < arr.length; i++) {
            if (visited[i]) code[idx++] = arr[i];
        }
        
        for (int k = 0; k < queries.length; k++) {
            int[] query = queries[k];
            int ansCnt = answers[k];
            
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (code[j] == query[i]) {
                        cnt++;
                    }
                }
            }
            
            if (ansCnt != cnt) {
                return false;
            }
        }
        
        return true;
    }
}