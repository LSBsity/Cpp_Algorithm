class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int[] ints = new int[26];

        for (char c : s.toCharArray()) {
            ints[c - 97]++;
        }
        
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) {
                sb.append((char) (i + 97));
            }
        }
        
        return sb.toString();
    }
}