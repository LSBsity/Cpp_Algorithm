#include <string>
#include <vector>
#include <map>
using namespace std;

vector<string> solution(vector<string> p, vector<string> c) {
    vector<string> answer;
    map<string, int> m;
    
    for (int i = 0; i < p.size(); i++)
        m[p[i]] = i;

    for (int i = 0; i < c.size(); i++) {
        int called = m[c[i]];
        m[p[called - 1]]++;
        m[p[called]]--;
        swap(p[called - 1], p[called]);
    }
    
    return p;
}