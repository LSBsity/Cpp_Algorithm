#include <string>
#include <vector>

using namespace std;

int solution(int n, int k)
{
    int food = 0, beverage = 0, answer = 0;
    food = n * 12000;
    beverage = k * 2000;
    if ((n >= 10))
    {
        beverage =  beverage - (2000 * (n / 10));
    }
    answer = (food + beverage);   

    return answer;
}