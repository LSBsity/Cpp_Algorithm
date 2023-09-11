#include <string>
#include <vector>

using namespace std;

int arr[201];

int solution(vector<vector<int>> lines)
{
    int answer = 0;
    int startP = 100;
    int endP = -100;

    for (int i = 0; i < lines.size(); i++)
    {
        for (int j = 0; j < 2; j++)
        {
            if (lines[i][j] < startP)
                startP = lines[i][j];
            else if (lines[i][j] > endP)
                endP = lines[i][j];
        }
    } 
    if (startP < 0)
    {
        for (int i = 0; i < 3; i++)
        {
            lines[i][0] += abs(startP);
            lines[i][1] += abs(startP);
        }
    }
    
    for (int i = 0; i < 3; i++)
    {
        for (int j = lines[i][0]; j < lines[i][1]; j++)
            arr[j] += 1;
    }

    for (int i = 0; i < endP - startP; i++)
    {
        if (arr[i] >= 2)
            answer++;
    }
    
    return answer;
}