class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int idx1 = 0;
        int idx2 = 0;
        while(true) {
            if (idx1 < str1.length())
                answer += str1.charAt(idx1++);
            if (idx2 < str2.length())
                answer += str2.charAt(idx2++);
            if (idx1 >= str1.length() && idx2 >= str2.length())
                break;
        }
        return answer;
    }
}