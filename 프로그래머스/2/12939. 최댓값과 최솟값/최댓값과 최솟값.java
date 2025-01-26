class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for (String str : s.split(" ")) {
            int parsed = Integer.parseInt(str);
            if (parsed > max) {
                max = parsed;
            }
            if (parsed < min) {
                min = parsed;
            }
        }
        
        return String.format("%d %d", min, max);
    }
}