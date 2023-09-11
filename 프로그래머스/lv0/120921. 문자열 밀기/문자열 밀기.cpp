#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int solution(string A, string B)
{
    int answer = 0;
    if (A == B)
        return 0;
    
    for (int i = 0; i < A.length(); i++)
    {
        rotate(A.rbegin(), A.rbegin() + 1, A.rend());
        answer++;
        if (A == B)
            return answer;
    }

    return -1;
}