import java.util.*;

class Solution {
    
    static final int[] RATES = {10, 20, 30, 40};
    
    static int bestJoin = -1;
    static int bestSales = -1;
    
    static int[][] users;
    static int[] emoticons;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {-1, -1};
        this.users = users;
        this.emoticons = emoticons;
        
        go(emoticons.length, 0, new int[emoticons.length]);
        
        return new int[] {bestJoin, bestSales};
    }
    
    private void go(int n, int depth, int[] combi) {
        if (depth == n) {
            calculate(combi);
            return;
        }

        for (int rate : RATES) {
            combi[depth] = rate;
            go(n, depth + 1, combi);
        }
    }
    
    private void calculate(int[] rates) {
        int joined = 0;
        int totalSales = 0;
        
        for(int[] user : users) {
            int wantRate = user[0];
            int affordable = user[1];
            
            int sales = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (wantRate > rates[i]) continue;
                sales += emoticons[i] * (100 - rates[i]) / 100;
            }
            
            if (sales >= affordable) {
                joined++;
            } else {
                totalSales += sales;
            }
        }
        if (bestJoin < joined || (bestJoin == joined && totalSales > bestSales)) {
            bestJoin = joined;
            bestSales = totalSales;
        }
    }
}