import java.util.*;

class Solution {
    
    static final int DONE = 0;
    static final int LOST = 1;
    static final int RESERVE = 2;
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[31];
        
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]] = LOST;            
        }
        for (int i = 0; i < reserve.length; i++) {
            if (arr[reserve[i]] == LOST) arr[reserve[i]] = DONE;
            else arr[reserve[i]] = RESERVE;
        }
        
        for (int i = 1; i <= n; i++) {
            if (arr[i] == RESERVE) {
                if (arr[i - 1] == 1) arr[i - 1] = DONE;
                else if (arr[i + 1] == 1) arr[i + 1] = DONE;
                
                arr[i] = 0;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (arr[i] == DONE || arr[i] == RESERVE) answer++;
        }
        
        return answer;
    }
}