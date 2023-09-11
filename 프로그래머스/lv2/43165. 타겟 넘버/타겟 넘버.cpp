#include <string>
#include <vector>

using namespace std;

int answer = 0;

void solve(vector<int> numbers, int target, int sum, int idx)
{
    if (idx == numbers.size())
    {
        if (sum == target) answer++;
        return;
    }
    solve(numbers, target, sum + numbers[idx], idx + 1);
    solve(numbers, target, sum - numbers[idx], idx + 1);
}

int solution(vector<int> numbers, int target)
{
    solve(numbers, target, 0, 0);
    return answer;
}