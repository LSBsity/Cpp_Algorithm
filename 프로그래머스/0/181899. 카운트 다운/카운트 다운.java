class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[start_num - end_num + 1];
        
        int idx = 0;
        while (start_num >= end_num) {
            answer[idx++] = start_num--;
        }
        
        return answer;
    }
}