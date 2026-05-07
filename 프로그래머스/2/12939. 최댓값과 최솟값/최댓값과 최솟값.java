import java.util.*;

class Solution {
    public String solution(String s) {
        String[] splits = s.split(" ");
        Arrays.sort(splits, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
        
        return splits[0] + " " + splits[splits.length - 1];
    }
}