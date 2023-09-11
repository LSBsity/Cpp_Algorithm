#include <string>
#include <vector>

using namespace std;

int solution(string my_string)
{
    int answer = 0;
    int A = 0;

    for (int i = 0; i < my_string.size(); i++)
    {
        if (my_string[i] >= '0' && my_string[i] <= '9')
            A = A * 10 + my_string[i] - 48;
        else
            answer += A, A = 0;
    }

    if (A != 0)
        answer += A;

    return answer;
}