#include <iostream>

using namespace std;
int solution(int n)
{
    int answer = 0;
    string A = to_string(n);

    for (int i = 0; i < A.length(); i++)
        answer += A[i] - '0';
    
    return answer;
}