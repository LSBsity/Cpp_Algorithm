class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int len = num2 - num1 + 1;
        
        int[] answer = new int[len];
        System.arraycopy(numbers, num1, answer, 0, len);
                         
        return answer;
    }
}