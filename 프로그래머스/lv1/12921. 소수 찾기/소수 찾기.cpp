#include <string>
#include <vector>
#include <cmath>

using namespace std;

int isPrime(int n)
{
    if (n <= 1) return 0;

    if (n % 2 == 0) return n == 2 ? 1 : 0;

    for (int i = 3; i <= sqrt(n); i += 2)
        if (n % i == 0) return 0;

    return 1;
}

int solution(int n)
{
    vector<int> ans;
    for (int i = 1; i <= n; i++)
        if (isPrime(i) == 1) ans.push_back(i);
        
    return ans.size();
}