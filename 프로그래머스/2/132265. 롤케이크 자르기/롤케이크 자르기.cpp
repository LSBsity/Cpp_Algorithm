#include <string>
#include <vector>
#include <unordered_set>
using namespace std;


int solution(vector<int> v) {
    int answer = 0;

    int arr[10001] = {0,};
    unordered_set<int> s;
    for (int i = 0; i < v.size(); i++) {
        s.insert(v[i]);
        arr[v[i]]++;
    }
    unordered_set<int> a;
    for (int i = 0; i < v.size(); i++) {
        if (arr[v[i]] >= 2) {
            arr[v[i]]--;
        } else {
            arr[v[i]]--;
            s.erase(v[i]);
        }
        a.insert(v[i]);

        if (a.size() == s.size())
            answer++;
    }

    return answer;
}