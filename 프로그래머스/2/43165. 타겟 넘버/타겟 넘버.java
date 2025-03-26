import java.util.*;

class Solution {

    int total;
    int target;
    int count = 0;

    public void combi(int[] numbers, List<Integer> combi, int start, int r) {
        if (combi.size() == r) {
            int sum = combi.stream().mapToInt(i -> i).sum() * 2;
            if (this.total - sum == this.target) {
                this.count++;
            }
            return;
        }
        
        for (int i = start; i < numbers.length; i++) {
            combi.add(numbers[i]);
            this.combi(numbers, combi, i + 1, r);
            combi.remove(combi.size() - 1);
        }
    }
    
    public int solution(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            this.total += numbers[i];
        }
        this.target = target;

        for (int i = 1; i <= numbers.length; i++) {
            List<Integer> combi = new ArrayList<>();
            combi(numbers, combi, 0, i);
        }
        
        return count;
    }
}