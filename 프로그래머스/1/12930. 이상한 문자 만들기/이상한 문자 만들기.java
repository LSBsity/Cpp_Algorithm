class Solution {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        char[] chars = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (i == 0 && chars[i] == ' ') {
                    continue;
                }
                answer.append(idx % 2 == 0 ?
                        Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]));
                idx++;
            } else if (chars[i] == ' ') {
                answer.append(' ');
                idx = 0;
            }
        }

        return answer.toString();
    }
}