class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        
        int idx = 0;
        for (String str : strlist) {
            answer[idx++] = str.length();
        }
        
        return answer;
    }
}