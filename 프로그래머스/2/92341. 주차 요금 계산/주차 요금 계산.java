
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class Solution {

    public int[] solution(int[] fees, String[] records) {
        records = Arrays.stream(records).sorted(
                        (o1, o2) -> {
                            int i1 = Integer.parseInt(o1.substring(6, 10));
                            int i2 = Integer.parseInt(o2.substring(6, 10));
                            if (i1 < i2) {
                                return -1;
                            } else if (i1 > i2) {
                                return 1;
                            } else {
                                return 0;
                            }
                        })
                .toArray(String[]::new);

        Map<String, Long> map = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String record = records[i];
            String carNumber = this.getNumber(record);
            if (this.isIn(record)) {
                LocalTime outTime;
                if (i + 1 < records.length) {
                    outTime = carNumber.equals(this.getNumber(records[i + 1])) ? this.getTime(records[i + 1]) : LocalTime.of(23, 59, 0);
                } else {
                    outTime = LocalTime.of(23, 59, 0);
                }
                LocalTime inTime = this.getTime(record);
                Duration duration = Duration.between(inTime, outTime);
                map.put(carNumber, map.getOrDefault(carNumber, 0L) + duration.toMinutes());
            }

        }
        int[] answer = new int[map.size()];
        int idx = 0;
        for (Long value : map.values()) {
            int price = value > fees[0] ? fees[1] + (int) Math.ceil((double) (value - fees[0]) / fees[2]) * fees[3] : fees[1];
            answer[idx++] = price;
        }

        return answer;
    }

    private String getNumber(String str) {
        return str.substring(6, 10);
    }

    private LocalTime getTime(String str) {
        return LocalTime.of(Integer.parseInt(str.substring(0, 2)), Integer.parseInt(str.substring(3, 5)), 0);
    }

    private boolean isIn(String str) {
        return str.endsWith("IN");
    }

}