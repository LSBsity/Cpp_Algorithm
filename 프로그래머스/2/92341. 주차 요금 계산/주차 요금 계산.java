import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> feeMap = new TreeMap<>();
        
        for (String record : records) {
            String[] split = record.split(" ");
        
            int converted = convert(split[0]);
            
            if (split[2].equals("IN")) {
                map.put(split[1], converted);
            } else {
                int inTime = map.get(split[1]);
                int outTime = convert(split[0]);
            
                feeMap.put(split[1], feeMap.getOrDefault(split[1], 0) + outTime - inTime);
                map.remove(split[1]);
            }
            
        }
        
        for (String no : map.keySet()) {
            int outTime = convert("23:59");
            int inTime = map.get(no);
            
            feeMap.put(no, feeMap.getOrDefault(no, 0) + outTime - inTime);
        }
        
        int[] answer = new int[feeMap.size()];
            
        int idx = 0;
        for (Integer time : feeMap.values()) {
            if (time <= fees[0]) {
                answer[idx++] = fees[1];
            } else {
                int val = fees[1] + (int) Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
                answer[idx++] = val;
            }
        }
        
        return answer;
    }
    
    public int convert(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}