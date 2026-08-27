import java.util.*;

class Solution {
    
    static final int[] RATES = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {-1, -1};
         
        for (int[] combo : combinations(emoticons.length)) {
            int joinCount = 0;
            int sales = 0;
            
            for (int[] user : users) {
                int wantRate = user[0];
                int maxPrice = user[1];

                int total = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (combo[i] < wantRate) continue;
                    total += emoticons[i] * (100 - combo[i]) / 100;
                }
                
                if (total >= maxPrice) {
                    joinCount++;
                } else {
                    sales += total;
                }
            }
            
            if (joinCount > answer[0] || (joinCount == answer[0] && sales > answer[1])) {
                answer[0] = joinCount;
                answer[1] = sales;
            }
        }
        
        return answer;
    }
 
    public static List<int[]> combinations(int productCount) {
        List<int[]> result = new ArrayList<>();
        dfs(productCount, 0, new int[productCount], result);
        return result;
    }

    private static void dfs(int n, int depth, int[] picked, List<int[]> result) {
        if (depth == n) {
            result.add(picked.clone());
            return;
        }
        
        for (int rate : RATES) {
            picked[depth] = rate;
            dfs(n, depth + 1, picked, result);
        }
    }
}