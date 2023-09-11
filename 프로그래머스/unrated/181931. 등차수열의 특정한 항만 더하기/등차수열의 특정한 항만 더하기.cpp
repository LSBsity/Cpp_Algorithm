#include <string>
#include <vector>

using namespace std;

int solution(int a, int d, vector<bool> included) {
    int answer = 0;
    for (int i = 0; i < included.size(); i++)
    {
        if (included[i])
        {
            if (i == 0) answer += a;
            else answer += a + d * i;
        }
    }
    return answer;
}