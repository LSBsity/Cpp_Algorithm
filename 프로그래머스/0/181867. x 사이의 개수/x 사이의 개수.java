class Solution {
    public int[] solution(String myString) {
        String[] split = myString.split("x", -1);
        
        int[] answer = new int[split.length];
        int idx = 0;
        for (String str : split) {
            answer[idx++] = str.length();
        }
        
        return answer;
    }
}