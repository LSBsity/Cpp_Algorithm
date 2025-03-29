class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] chars = s.toCharArray();
        char x = chars[0];
        
        int idx = 0, first = 0, second = 0;
        while (true) {
            if (idx == chars.length - 1) {
                break;
            }
            
            if (chars[idx] == x) {
                first++;
            } else {
                second++;
            }
            
            idx++;
            if (first == second) {
                answer++;
                first = second = 0;
                x = chars[idx];
            }
            
        }
        
        return answer + 1;
    }
}