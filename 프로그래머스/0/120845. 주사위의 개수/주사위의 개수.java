class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        
        int row = box[0];
        int col = box[1];
        int height = box[2];
        
        answer *= row / n;
        answer *= col / n;
        answer *= height / n;
        
        return answer;
    }
}