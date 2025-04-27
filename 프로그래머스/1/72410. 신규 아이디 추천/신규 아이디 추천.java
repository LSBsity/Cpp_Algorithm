class Solution {

    public String solution(String new_id) {
        String id = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (char ch : id.toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                sb.append(ch);
            }
        }

        StringBuilder sb2 = new StringBuilder();
        boolean dot = false;
        for (char ch : sb.toString().toCharArray()) {
            if (ch == '.') {
                if (!dot) {
                    sb2.append(ch);
                    dot = true;
                }
            } else {
                sb2.append(ch);
                dot = false;
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
            if (sb2.charAt(sb2.length() - 1) == '.') {
                sb2.deleteCharAt(sb2.length() - 1);
            }
        }

        while (sb2.length() < 3) {
            sb2.append(sb2.charAt(sb2.length() - 1));
        }

        return sb2.toString();
    }
}
