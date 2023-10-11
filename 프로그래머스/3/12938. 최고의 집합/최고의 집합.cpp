#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;

    int base = s / n;
    int rem = s % n;

    if (base == 0) return {-1};

    for (int i = 0; i < n - rem; i++) 
        answer.push_back(base);
        
    for (int i = 0; i < rem; i++) 
        answer.push_back(base + 1);

    return answer;
}