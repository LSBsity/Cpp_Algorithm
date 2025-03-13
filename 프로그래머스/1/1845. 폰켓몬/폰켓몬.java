import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed()
            .collect(Collectors.toSet());
        
        return Math.min(nums.length / 2, set.size());
    }
}