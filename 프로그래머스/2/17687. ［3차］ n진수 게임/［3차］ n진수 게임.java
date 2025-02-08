class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= t * m; i++) {
            sb.append(Integer.toString(i, n));
        }

        StringBuilder answer = new StringBuilder();
        for (int i = p - 1, idx = 0; idx < t && i < sb.length(); i += m, idx++) {
            char c = sb.charAt(i);
            if (Character.isAlphabetic(c)) {
                answer.append(Character.toUpperCase(c));
            } else {
                answer.append(c);
            }
        }

        return answer.toString();
    }
}