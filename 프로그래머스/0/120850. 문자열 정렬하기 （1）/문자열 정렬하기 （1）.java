import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Character> list = new ArrayList<>();
        
        char[] chars = my_string.toCharArray();
        Arrays.sort(chars);
        
        for (char c : chars) {
            if (c - '0' < 10) list.add(c);
        }
        
        return list.stream().mapToInt(i -> i - '0').toArray();
    }
}