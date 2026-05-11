import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (computers[i][j] == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                go(i, list, visited);
                answer++;    
            }
        }
        
        return answer++;
    }

    private static void go(int start, List<Integer>[] nodes, boolean[] visited) {
        if (visited[start]) return;
        visited[start] = true;
        
        for (int i : nodes[start]) {    
            go(i, nodes, visited);    
        }
    }    

}