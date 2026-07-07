import java.util.*;

class Solution {
    
    static Map<String, String> map = new HashMap<>();
    
    public String[] solution(String[] records) {  
        int cnt = 0;
        
        for (String record : records) {
            String[] split = record.split(" ");
            
            String cmd = split[0];
            
            if (cmd.equals("Enter")) {
                map.put(split[1], split[2]);
                cnt++;
            } else if (cmd.equals("Change")) {
                map.put(split[1], split[2]);
            } else if (cmd.equals("Leave")) {
                cnt++;
            }
        }
        
        String[] answer = new String[cnt];   
        
        int idx = 0;
        for (String record : records) {
            String[] split = record.split(" ");

            String cmd = split[0];
            
            if (cmd.equals("Enter")) {
                answer[idx++] = String.format("%s님이 들어왔습니다.", map.get(split[1]));
            } else if (cmd.equals("Leave")) {
                answer[idx++] = String.format("%s님이 나갔습니다.", map.get(split[1]));
            }
        }
        
        return answer;
    }
}