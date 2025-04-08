import java.util.*;
import java.util.stream.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public void permute(String numbers, boolean[] visited, String current) {
        if (!current.isEmpty()) {
            set.add(Integer.valueOf(current));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                this.permute(numbers, visited, current + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    public boolean check(int value) {
        if (value <= 1) return false;
        
        for (int i = 2; i <= (int)Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        this.permute(numbers, visited, "");

        return (int)set.stream()
            .mapToInt(i -> i)
            .filter(this::check)
            .count();
    }
}