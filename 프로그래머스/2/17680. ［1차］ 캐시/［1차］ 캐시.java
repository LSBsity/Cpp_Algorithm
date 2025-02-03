import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();

        int time = 0;
        for (String cityName : cities) {
            String convertedCityName = cityName.toLowerCase();

            if (queue.remove(convertedCityName)) {
                time += 1;
            } else {
                time += 5;
            }
            
            queue.add(convertedCityName);
            if (queue.size() > cacheSize) {
                queue.poll();
            }
        }

        return time;
    }
}