import java.util.*;

class Solution {

    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        char[] chars = numbers.toCharArray();
        visited = new boolean[numbers.length()];
        
        go(chars, "");
        
        int cnt = 0;
        for (Integer i : set) {
            if (check(i)) {
                cnt++;
                System.out.println(i);
            }
        }
        
        return cnt;
    }
    
    private static boolean check(int value) {
        if (value <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        
        return true;
    }
    
    private static void go(char[] chars, String current) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            go(chars, current + chars[i]);
            visited[i] = false;
        }
    }
}