#include <string>
#include <vector>

using namespace std;

int solution(vector<int> box, int n)
{
    int answer;

    int a = box[0] / n;
    int b = box[1] / n;
    int c = a * b;
    answer = c * (box[2] / n);

    return answer;
}