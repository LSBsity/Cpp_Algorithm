import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        LinkedHashMap<String, Boolean> cache = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
                return size() > cacheSize;
            }
        };

        int answer = 0;
        for (String city : cities) {
            String key = city.toLowerCase();
            if (cache.containsKey(key)) {
                answer += 1;
                cache.get(key); 
            } else {
                answer += 5;
                cache.put(key, Boolean.TRUE);
            }
        }
        return answer;
    }
}