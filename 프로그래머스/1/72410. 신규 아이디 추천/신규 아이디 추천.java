class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase();
        StringBuilder sb1 = new StringBuilder();
        
        for (char ch : id.toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
              sb1.append(ch);  
            } 
        }
        
        boolean check = false;
        StringBuilder sb2 = new StringBuilder();
        for (char ch : sb1.toString().toCharArray()) {
            if (ch == '.') {
                if (!check) {
                    sb2.append(ch);
                }
                check = true;
            } else {
                sb2.append(ch);
                check = false;
            }
        }
        
        if (sb2.length() > 0 && sb2.charAt(0) == '.') {
            sb2.deleteCharAt(0);
        }
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        if (sb2.length() == 0) {
            sb2.append('a');
        }
        
        if (sb2.length() >= 16) {
            sb2.setLength(15);
            if (sb2.charAt(14) == '.') {
                sb2.deleteCharAt(14);
            }
        }
        
        while (sb2.length() < 3) {
            sb2.append(sb2.charAt(sb2.length() - 1));
        }
        
        return sb2.toString();
    }
}