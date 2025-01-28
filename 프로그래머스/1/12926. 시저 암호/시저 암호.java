class Solution {

    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                if (Character.isUpperCase(chars[i])) {
                    chars[i] += n;
                    if (!Character.isAlphabetic(chars[i]) || Character.isLowerCase(chars[i])) {
                        chars[i] -= 26;
                    }
                } else {
                    chars[i] += n;
                    if (!Character.isAlphabetic(chars[i]) || Character.isUpperCase(chars[i])) {
                        chars[i] -= 26;
                    }
                }
            }
        }

        return new String(chars);
    }
}
