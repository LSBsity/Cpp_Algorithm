class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : my_string.toCharArray()) sb.append(c);
        
        return sb.reverse().toString();
    }
}