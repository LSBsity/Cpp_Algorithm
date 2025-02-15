class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int answerIdx = 0;
        for (long number : numbers) {
            long start = 1;
            if ((number & start) == 0) {
                answer[answerIdx++] = ++number;
            } else {
                number++;
                while ((number & start) == 0) {
                    start *= 2;
                }
                answer[answerIdx++] = number + start / 2 - 1;
            }
        }
        return answer;
    }
}