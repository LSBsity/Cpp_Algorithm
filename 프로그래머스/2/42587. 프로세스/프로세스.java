import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<int[]> q = new LinkedList<>();        
        
        int idx = 0;
        for (int p : priorities) {
            q.offer(new int[] {p, idx++});
        }
        
        int answer = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int process = cur[0];
            int processIdx = cur[1];
            
            boolean check = true;
            for (int i = 0; i < q.size(); i++) {
                int next = q.get(i)[0];
                
                if (next > process) {
                    q.offer(cur);
                    check = false;
                    break;
                }
            }
             
            if (check) {
                if (processIdx == location) {
                   return answer;
                }
                
                answer++;
            }
            
            
        }
         
    
        return -1;
    }
}