import java.util.*;

class Solution {
    
    public void combi(char[] chars, List<Character> temp, int depth, int start, Set<String> result) {
        if (temp.size() == depth) {
            List<Character> sorted = new ArrayList<>(temp);
            Collections.sort(sorted);
            StringBuilder sb = new StringBuilder();
            for (char c : sorted) sb.append(c);
            result.add(sb.toString());
            return;
        }
        
        for (int i = start; i < chars.length; i++) {
            temp.add(chars[i]);
            this.combi(chars, temp, depth, i + 1, result);
            temp.remove(temp.size() - 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> combiCount = new HashMap<>();
                
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            for (int len : course) {
                Set<String> result = new HashSet<>();
                this.combi(chars, new ArrayList<>(), len, 0, result);
                for (String s : result) {
                    combiCount.put(s, combiCount.getOrDefault(s, 0) + 1);
                }
            }
        }
        
        List<String> answerList = new ArrayList<>();
        for (int len : course) {
            int max = 2;
            List<String> candidates = new ArrayList<>();
            for (var entry : combiCount.entrySet()) {
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
            answerList.addAll(candidates);
        }
        
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }
}