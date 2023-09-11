#include <string>
#include <vector>
#include <cstdlib>
#include <limits.h>

using namespace std;


int solution(vector<int> array, int n)
{
    vector<int> answer = array;

    for (int i = 0; i < array.size(); i++)
        array[i] = abs(array[i] - n);

    int Min = INT_MAX;

    int MinIdx = 0;

    for (int i = 0; i < array.size(); i++)
    {
        if (array[i] < Min)
        {
            MinIdx = i;
            Min = array[i];
        }
        if (array[i] == Min)
        {
            if (answer[i] < answer[MinIdx])
                MinIdx = i;
            else if (answer[i] > answer[MinIdx])
                MinIdx = MinIdx;
        }
    }

    return answer[MinIdx];
}