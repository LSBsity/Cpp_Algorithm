#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

int isPrime(int n)
{
    if (n <= 1) return 0;
    if (n % 2 == 0) return n == 2 ? 1 : 0;
    for (int i = 3; i <= sqrt(n); i += 2) if (n % i == 0) return 0;
    return 1;
}

int solution(vector<int> nums)
{
    int answer = 0;
    
    for (int i = 0; i < nums.size(); i++)
    {
        for (int j = i + 1; j < nums.size(); j++)
        {
            for (int z = j + 1; z < nums.size(); z++)
                if (isPrime(nums[i] + nums[j] + nums[z]) == 1) answer++;
        }
    }
    return answer;
}