#include <string>
#include <vector>
#include <sstream>

using namespace std;

int solution(string my_string)
{
    int answer = 0;
    stringstream stream(my_string);
    stream >> answer;

    int a;
    char b;

    while (stream >> b >> a)
    {
        if (b == '+')
            answer += a;
        else
            answer -= a;
    }

    return answer;
}