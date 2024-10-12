class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (String string : s1) {
            for (String s : s2) {
                if (string.equals(s)) answer++;
            }
        }
        return answer;
    }
}