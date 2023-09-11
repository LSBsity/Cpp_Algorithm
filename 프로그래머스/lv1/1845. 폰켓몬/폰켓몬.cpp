#include <vector>
#include <algorithm>
using namespace std;
int solution(vector<int> nums)
{
    int answer = 0;
    int a = nums.size() / 2;
    sort(nums.begin(), nums.end());
    nums.erase(unique(nums.begin(), nums.end()), nums.end());
    
    if (nums.size() <= a)
        answer = nums.size();
    else
        answer = a;

    return answer;
}