class Solution {
    boolean solution(String s) {
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else {
                if (count == 0) return false;
                count--;
            }
        }
        
        return count == 0;
    }
}