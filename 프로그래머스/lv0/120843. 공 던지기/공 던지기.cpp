#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int k)
{
    int z = 0;
    int y = 1;
    while (y <= k)
    {
        numbers[z];
        if (z > numbers.size())
        {
            z -= numbers.size();
        }
        z+=2;
        y++;
    }
    return z - 1;
}