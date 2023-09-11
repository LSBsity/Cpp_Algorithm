#include <string>
#include <vector>

using namespace std;

int Euclid(int a, int b)
{
    int r = a % b;
    if (r == 0)
        return b;

    return Euclid(b, r);
}

int Lcm(int a, int b)
{
    return a * b / Euclid(a, b);
}

vector<int> solution(int n, int m)
{
    vector<int> answer;
    answer.push_back(Euclid(n, m));
    answer.push_back(Lcm(n, m));

    return answer;
}