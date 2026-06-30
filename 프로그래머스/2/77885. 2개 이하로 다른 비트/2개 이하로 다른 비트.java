class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int idx = 0;
        for (long number : numbers) {
            long prev = number;
            
            if ((prev & 1) == 0) {
                number = prev + 1;
            } else {
                number = prev + ((~prev & (prev + 1)) >> 1);
            }
            
            answer[idx++] = number;
        }
        
        return answer;
    }
}