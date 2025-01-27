class Solution {

    public String solution(String my_string, String overwrite_string, int s) {
        char[] chars = my_string.toCharArray();
        for (int i = s, idx = 0; idx < overwrite_string.length(); i++, idx++) {
            chars[i] = overwrite_string.charAt(idx);
        }
        return new String(chars);
    }
}
