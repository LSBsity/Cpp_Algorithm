class Solution {
    
    static String[] strs = {"C#", "D#", "F#", "G#", "A#"};
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxLen = Integer.MIN_VALUE;
        
        m = convert(m);
        for (String info : musicinfos) {
            String[] split = info.split(",");
            
            String converted = convert(split[3]);
            
            int start = getMinutes(split[0]);
            int end = getMinutes(split[1]);
            
            int playtime = end - start;
            String fullcode = getFullcode(playtime, converted);
            
            if (fullcode.contains(m) && playtime > maxLen) {
                answer = split[2];
                maxLen = end - start;
            }
        }
        
        return answer;
    }
    
    private String getFullcode(int minutes, String fullcode) {
        StringBuilder sb = new StringBuilder();
        int len = fullcode.length();
        
        for (int i = 0, idx = 0; i < minutes; i++) {
            sb.append(fullcode.charAt(idx));
            idx = (idx + 1) % len;
        }
        return sb.toString();
    }
    
    private int getMinutes(String str) {
        String[] split = str.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    private String convert(String code) {
        for (String s : strs) code = code.replaceAll(s, s.substring(0, 1).toLowerCase());
        return code;
    }
}