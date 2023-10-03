#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<string> v) {
    priority_queue<int> pqMax;
    priority_queue<int, vector<int>, greater<int>> pqMin;

    for (int i = 0; i < v.size(); i++) {
        if (v[i][0] == 'I') {
            pqMax.push(stoi(v[i].substr(2)));
            pqMin.push(stoi(v[i].substr(2)));
        } else if ((!pqMax.empty() && !pqMin.empty()) &&
                   (pqMax.top() == pqMin.top())) {
            while (!pqMax.empty()) pqMax.pop();
            while (!pqMin.empty()) pqMin.pop();
        } else if (v[i].substr(0, 4) == "D -1" && !pqMin.empty()) {
            pqMin.pop();
        } else if (v[i].substr(0, 4) == "D 1" && !pqMax.empty()) {
            pqMax.pop();
        }
    }

    return (pqMin.empty() && pqMax.empty()) || (pqMin.top() == pqMax.top())
               ? vector<int>(2, 0)
               : vector<int>{pqMax.top(), pqMin.top()};
}