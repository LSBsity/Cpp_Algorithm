#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(long long n)
{
    string s = to_string(n);
    sort(s.rbegin(), s.rend());
    
    return stoll(s);
}