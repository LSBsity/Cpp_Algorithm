#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> sides)
{
    sort(sides.begin(), sides.end());
    return sides[2] < (sides[1] + sides[0]) ? 1 : 2;
}