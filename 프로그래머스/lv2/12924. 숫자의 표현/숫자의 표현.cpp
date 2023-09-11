#include <string>
#include <vector>

using namespace std;

int solution(int n)
{
    int answer = 0;
    int a = 1;
    while (n > 0)
    {
        if (n % a == 0) answer++;
        n -= a;
        a += 1;
    }
    return answer;
}