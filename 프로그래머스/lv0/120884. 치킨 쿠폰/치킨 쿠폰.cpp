#include <string>
#include <vector>

using namespace std;

int solution(int chicken)
{
    int answer = 0;
 
    while (chicken >= 10)
    {
        chicken -= 10;
        answer++;
        chicken += 1;
    }

    return answer;
}