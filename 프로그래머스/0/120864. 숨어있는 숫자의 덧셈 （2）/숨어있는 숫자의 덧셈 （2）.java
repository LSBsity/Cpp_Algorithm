class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        char[] chars = my_string.toCharArray();
        int idx = chars.length - 1;
        
        while (idx >= 0) {
            int sum = 0;
            int d = 1;
            
            while (idx >= 0 && Character.isDigit(chars[idx])) {
                int digit = chars[idx] - '0';
                sum += digit * d;
                d *= 10;
                idx--;
            }
            
            answer += sum;
            idx--;
        }
        
        return answer;
    }
}