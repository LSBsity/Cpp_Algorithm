#include <string>
#include <vector>

using namespace std;

int solution(int num)
{
    int answer = 0;
    long answer2 = num;

    while (answer2 != 1)
    {
        if (answer2 % 2 == 0)
        {
            answer2 /= 2;
            answer++;
        }
        else if (answer2 % 2 != 0)
        {
            answer2 *= 3;
            answer2 += 1;
            answer++;
        }
        if (answer >= 500)
            return -1;
    }

    return answer;
}