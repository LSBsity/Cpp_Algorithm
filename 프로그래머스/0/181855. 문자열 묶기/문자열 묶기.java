class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] arr = new int[31];
        
        for (String str : strArr) {
            arr[str.length()]++;
        }
        
        for (int i : arr) {
            answer = Math.max(answer, i);
        }
        
        return answer;
    }
}