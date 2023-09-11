#include <string>
#include <vector>

using namespace std;

int array[31][31];

int solution(int balls, int share)
{
    int answer = 0;

    for (int i = 0; i < 31; i++)
        array[i][0] = array[i][i] = 1;

    for (int i = 2; i < 31; i++)
        for (int j = 1; j < i; j++)
            array[i][j] = array[i - 1][j] + array[i - 1][j - 1];

    answer = array[balls][share];

    return answer;
}
