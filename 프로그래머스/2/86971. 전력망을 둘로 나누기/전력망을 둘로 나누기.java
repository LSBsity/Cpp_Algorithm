import java.util.*;

class Solution {
    
    static int[] parents;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();       
        
        for (int i = 0; i < wires.length; i++) {
            
            parents = new int[n + 1];
            for (int k = 1; k <= n; k++) parents[k] = k;
            
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                
                int[] cur = wires[j];
                union(cur[0], cur[1]);
            }
            
            for (int j = 1; j <= n; j++) {
                int root = find(j);
                map.put(root, map.getOrDefault(root, 0) + 1);
            }
            
            int diff = 0;
            for (int value : map.values()) {
                diff = Math.abs(diff - value);
            }
            
            answer = Math.min(answer, diff);
            map.clear();
        }
        
        return answer;
    }
    
    private void union(int x, int y) {
        int findX = find(x);
        int findY = find(y);
        
        if (findX == findY) return;    
        if (findX < findY) {
            parents[findY] = findX;
            return;
        } 
    
        parents[findX] = findY;
    }
    
    private int find(int x) {
        if (parents[x] == x) return x;
        
        return parents[x] = find(parents[x]);
    }
}