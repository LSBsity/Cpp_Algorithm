#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<string> v) {
    priority_queue<int> max;
    priority_queue<int, vector<int>, greater<int>> min;

    for (int i = 0; i < v.size(); i++) {
        if (v[i][0] == 'I') {
            max.push(stoi(v[i].substr(2)));
            min.push(stoi(v[i].substr(2)));
        } else if (!max.empty() && !min.empty() && max.top() == min.top()) {
            while (!max.empty()) max.pop();
            while (!min.empty()) min.pop();
        } else if (v[i].substr(0, 4) == "D -1" && !min.empty()) {
            min.pop();
        } else if (v[i].substr(0, 4) == "D 1" && !max.empty()) {
            max.pop();
        }
    }

    return min.empty() && max.empty() || min.top() == max.top()
               ? vector<int>(2, 0)
               : vector<int>{max.top(), min.top()};
}