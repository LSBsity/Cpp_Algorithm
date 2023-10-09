#include <string>
#include <vector>
#include <queue>
using namespace std;


int solution(vector<int> v, int k) {
    int answer = 0;

    priority_queue<int, vector<int>, greater<int>> q(v.begin(), v.end());

    while (q.top() < k && q.size() >= 2) {
        int i = q.top();
        q.pop();
        int j = q.top();
        q.pop();

        q.push(i + j * 2);
        answer++;
    }

    return q.size() < 2 && q.top() < k ? -1 : answer;
}