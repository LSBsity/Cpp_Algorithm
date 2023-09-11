#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> numbers, string direction)
{
    vector<int> answer;
    if (direction == "left")
    {
        int temp = numbers[0];
        for (int i = 1; i < numbers.size(); i++)
            answer.push_back(numbers[i]);
        answer.push_back(temp);
    }
    if (direction == "right")
    {
        int temp = numbers[numbers.size()-1];
        for (int i = numbers.size()-2; i >= 0; i--)
            answer.insert(answer.begin(), numbers[i]);
        answer.insert(answer.begin(), temp);
        
    }

    return answer;
}
