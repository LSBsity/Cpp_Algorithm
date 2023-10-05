#include <string>
#include <vector>
#include <map>
using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
    map<string, int> m;

    int idx = 1;
    for (char i = 'A'; i <= 'Z'; i++)
        m[string(1, i)] = idx++;

    string temp = "";
    for (int i = 0; i < msg.size(); i++) {
        temp += msg[i];
        if (!m[temp]) {
            answer.push_back(m[temp.substr(0, temp.size() - 1)]);
            m[temp] = idx++;
            temp = "";
            i--;
        }
    }

    answer.push_back(m[temp]);
    return answer;
}
