import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for (String id : id_list) {
            result.put(id, 0);
        }
        
        for (int i = 0; i < report.length;i ++) {
            String[] split = report[i].split(" ");
            String reporter = split[0];
            String reported = split[1];
            
            if (!map.containsKey(reported)){
                Set<String> set = new HashSet<>();
                set.add(reporter);
                map.put(reported, set);
            } else {
                Set<String> set = map.get(reported);
                set.add(reporter);
                map.put(reported, set);
            }
    
        }
        
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() < k) continue;
            
            for (String reporter : entry.getValue()) {
                result.put(reporter, result.get(reporter) + 1);
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            int cnt = result.get(id_list[i]);
            answer[i] = cnt;
        }
        
        
        return answer;
    }
}