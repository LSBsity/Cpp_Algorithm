class Solution {
    
    static char[] chars = {'A', 'E', 'I', 'O', 'U'};
    static int cnt = 0;
    static int answer = 0;
    
    public int solution(String word) {
        go(new StringBuilder(), word);
        return answer;
    }
    
    private static void go(StringBuilder sb, String target) {
        if (sb.length() > 5) return;
        
        if (sb.toString().equals(target)) {
            answer = cnt;
            return;
        }

        cnt++;
        for (int i = 0; i < 5; i++) {
            sb.append(chars[i]);
            go(sb, target);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}