class Solution {
    public int solution(String my_string) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                sb.append(" ");
            }
        }
        for (String value : sb.toString().split(" ")) {
            try {
                answer += Integer.parseInt(value);    
            } catch(Exception ignore) {}   
        }
        return answer;
    }
}