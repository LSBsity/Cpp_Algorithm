import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int n = nums.length / 2;
        int cnt = 0;
        
        if (map.size() >= n) {
            return n;
        }
        
        Set<Integer> set = new HashSet<>();
        while (cnt < n) {
            for (int key : map.keySet()) {
                if (map.get(key) == 0) {
                    continue;
                }
                
                map.put(key, map.get(key) - 1);
                set.add(key);
                cnt++;
                
                if (cnt == n) break;
            }    
        }
        
        
        return set.size();
    }
}