import java.time.*;
import java.util.*;

class Solution {
    public String solution(int a, int b) {
        DayOfWeek dayOfWeek = LocalDate.of(2016, a, b).getDayOfWeek();
        return dayOfWeek.toString().substring(0, 3);
    }
}