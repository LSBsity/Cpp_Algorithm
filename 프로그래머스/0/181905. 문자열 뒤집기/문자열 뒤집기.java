class Solution {
    public String solution(String my_string, int s, int e) {
        String prefix = my_string.substring(0, s);
        String last = my_string.substring(e + 1);
        StringBuilder sb = new StringBuilder(my_string.substring(s, e + 1));
        StringBuilder reversed = sb.reverse();
        return prefix + reversed + last;
    }
}