class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            int[] part = parts[i];
            sb.append(my_strings[i].substring(part[0], part[1] + 1));
        }
        
        return sb.toString();
    }
}