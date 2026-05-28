import java.util.*;

class Solution {

    static int[] arr, result;
    static boolean[] visited;
    static int len;
    static int max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        len = dungeons.length;
        arr = new int[len];
        result = new int[len];
        visited = new boolean[len];
        
        for (int i = 0; i < len; i++) {
            arr[i] = i;
        }
        
        perm(0, dungeons, k);

        return max;
    }
    
    private static void perm(int depth, int[][] dungeons, int k) {
        if (depth == len) {
            go(dungeons, k);
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                perm(depth + 1, dungeons, k);
                visited[i] = false;
            }
        }
    }
    
    private static void go(int[][] dungeons, int k) {
        int val = k;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int need = dungeons[result[i]][0];
            int sub = dungeons[result[i]][1];
            
            if (val >= need) val -= sub;
            else break;
                
            cnt++;
        }
        
        max = Math.max(max, cnt);
    }
}