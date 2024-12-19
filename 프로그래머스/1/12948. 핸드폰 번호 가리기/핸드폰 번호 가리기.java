class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        
        int len = phone_number.length();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(i >= len - 4 ? phone_number.charAt(i) : "*");
        }

        return sb.reverse().toString();
    }
}
