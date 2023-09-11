#include <string>
#include <vector>

using namespace std;

int solution(vector<int> dot)
{
    return dot[0] > 0 ? (dot[1] > 0 ? 1 : 4) : (dot[1] < 0 ? 3 : 2);

}
