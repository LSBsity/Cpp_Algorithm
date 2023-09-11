#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> sides)
{
    int answerA = 0;
    int answerB = 0;

    sort(sides.begin(), sides.end());

    for (int i = 0; i <= sides[1]; i++)
    {
        if (sides[0] + i >= sides[1])
            answerA++;
    }

    for (int i = sides[1]; i < sides[0] + sides[1]; i++)
    {
        if (sides[0] + sides[1] >= sides[1])
            answerB++;
    }


    return answerA + answerB - 2;
}