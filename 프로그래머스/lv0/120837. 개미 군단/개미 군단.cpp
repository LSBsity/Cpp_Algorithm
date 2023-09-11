#include <string>
#include <vector>

using namespace std;

int solution(int hp)
{
    int answer = 0;
    int remainHp = hp;

    if (remainHp >= 5)
    {
        answer += remainHp / 5;
        remainHp = remainHp % 5;
    }
    if (remainHp >= 3)
    {
        answer += remainHp / 3;
        remainHp = remainHp % 3;
    }
    if (remainHp >= 1 && remainHp < 3)
    {
        answer += remainHp;
    }    
    
    return answer;
}