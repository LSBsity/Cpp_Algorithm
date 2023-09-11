#include <string>
#include <vector>

using namespace std;

int solution(vector<int> array, int n)
{
    int count = 0;
    for (int i = 0; i < array.size(); i++)
    {
        if (array[i] == n) 
        {
            count++;
        }

    }
    return count;
}