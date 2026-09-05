class Solution {
    public String solution(String n_str) {
        StringBuilder sb = new StringBuilder();
        
        boolean flag = false;
        for (char c : n_str.toCharArray()) {
            if (c != '0') flag = true;
            
            if (flag) sb.append(c);
        }
        
        return sb.toString();
    }
}