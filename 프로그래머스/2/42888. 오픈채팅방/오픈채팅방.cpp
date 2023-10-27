#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

vector<string> solution(vector<string> record) {
    string command, uid, name;
    vector<string> answer;
    map<string, string> m;
    vector<pair<string, string>> log;

    for (int i = 0; i < record.size(); i++) {
        stringstream ss;
        ss.str(record[i]);
        while (ss >> command >> uid >> name) {
        }
        if (command == "Enter") {
            m[uid] = name;
            log.push_back({uid, "Enter"});
        } else if (command == "Leave") {
            log.push_back({uid, "Leave"});
        } else {
            m[uid] = name;
        }
    }

    for (int i = 0; i < log.size(); i++) {
        if (log[i].second == "Enter")
            answer.push_back(m[log[i].first] + "님이 들어왔습니다.");
        else
            answer.push_back(m[log[i].first] + "님이 나갔습니다.");
    }

    return answer;
}