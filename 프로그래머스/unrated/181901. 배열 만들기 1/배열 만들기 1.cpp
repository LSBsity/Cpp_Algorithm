#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int k) {
    vector<int> answer;
    int i = 1;
    while(i <= n)
    {
        if (i % k == 0) answer.push_back(i);
        i++;
    }
    return answer;
}