import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        List<String> arr = new ArrayList<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            arr.add(players[i]);
        }
     
        for (String call : callings) {
            int idx = map.get(call);
            String overName = arr.get(idx - 1);
            
            arr.remove(idx);
            arr.add(idx - 1, call);

            map.put(call, idx - 1);
            map.put(overName, idx);
        }
        
        return arr.stream().toArray(String[]::new);
    }
}