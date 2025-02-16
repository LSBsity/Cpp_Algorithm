import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> nicknameMap = new HashMap<>();
        List<Status> history = new ArrayList<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String cmd = split[0];

            if (cmd.equals("Enter")) {
                nicknameMap.put(split[1], split[2]);
                history.add(new Status(split[1], true));
            } else if (cmd.equals("Leave")) {
                history.add(new Status(split[1], false));
            } else {
                nicknameMap.put(split[1], split[2]);
            }
        }

        String[] answer = new String[history.size()];
        for (int i = 0, idx = 0, historySize = history.size(); i < historySize; i++, idx++) {
            Status status = history.get(i);
            String nickname = nicknameMap.get(status.uuid);

            answer[idx] = String.format("%s님이 %s습니다.",
                    nickname,
                    status.isIn ? "들어왔" : "나갔");
        }
        return answer;
    }

    static class Status {
        String uuid;
        boolean isIn;

        public Status(String uuid, boolean isIn) {
            this.uuid = uuid;
            this.isIn = isIn;
        }
    }
}
