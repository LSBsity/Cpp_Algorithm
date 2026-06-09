import java.util.*;

class Solution {
    public int solution(int[] citations) {      
        Arrays.sort(citations);
        
        for (int h = citations.length; h >= 0; h--) {
            int cnt = 0;
            
            for (int j = citations.length - 1; j >= 0; j--) {
                if (citations[j] >= h) cnt++;
                else break;
            }
            
            if (h <= cnt) return h;
        
        }
        
        
        return 0;
    }
}