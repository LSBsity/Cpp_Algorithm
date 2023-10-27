#include <string>
#include <vector>
#include <map>
#include <sstream>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<pair<string, string>> log;
    vector<string> answer;
    map<string, string> m;
    string command, uid, name;
    for (int i = 0; i < record.size(); i++) {
        stringstream ss(record[i]);
        ss >> command >> uid >> name;
    
        if (command == "Enter" || command == "Change")
            m[uid] = name;
        if (command == "Enter" || command == "Leave")
            log.emplace_back(uid, command);
    }

    for (int i = 0; i < log.size(); i++) {
        if (log[i].second == "Enter")
            answer.push_back(m[log[i].first] + "님이 들어왔습니다.");
        else
            answer.push_back(m[log[i].first] + "님이 나갔습니다.");
    }

    return answer;
}
