import java.util.*;
 
class Solution {
    
    private void go(char[] chars, List<Character> list, int depth, int start, Set<String> result) {
        if (list.size() == depth) {
            List<Character> temp = new ArrayList<>(list);
            StringBuilder sb = new StringBuilder();
            for (var c : temp) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }
        
        for (int i = start; i < chars.length; i++) {
            list.add(chars[i]);
            this.go(chars, list, depth, i + 1, result);
            list.remove(list.size() - 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        
        for (var order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);           
            for (var len : course) {
                Set<String> result = new HashSet<>();
                this.go(chars, new ArrayList<>(), len, 0, result);
                
                for (var str : result) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (var len : course) {
            List<String> candidates = new ArrayList<>();
            int max = 2;
            
            for (var entry : map.entrySet()) {
                if (entry.getKey().length() == len) {
                    if (entry.getValue() > max) {
                        candidates.clear();
                        candidates.add(entry.getKey());
                        max = entry.getValue();
                    } else if (entry.getValue() == max) {
                        candidates.add(entry.getKey());
                    }
                }
            }
            
            list.addAll(candidates);
        }        
        
        Collections.sort(list);

        return list.toArray(new String[0]);
    }
}