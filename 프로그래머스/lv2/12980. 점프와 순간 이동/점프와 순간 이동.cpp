#include <iostream>
#include <bitset>
using namespace std;

int solution(int n)
{
    int answer = bitset<30>(n).count();

    return answer;
}