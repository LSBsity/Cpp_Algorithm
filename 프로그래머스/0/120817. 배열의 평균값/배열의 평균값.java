class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        for (int number : numbers) answer += number;
        
        return answer / numbers.length;
    }
}