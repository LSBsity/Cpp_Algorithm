class Solution {
    public String solution(String s, int n) {
        char[] answer = s.toCharArray();
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == ' ') continue;
            
            char c = (char) ((int) answer[i] + (n % 26));
            if (Character.isUpperCase(answer[i]) && Character.isLowerCase(c) || !Character.isAlphabetic(c)) {
                c -= 26;
            }
            
            answer[i] = c;
        }
        
        return new String(answer);
    }
}