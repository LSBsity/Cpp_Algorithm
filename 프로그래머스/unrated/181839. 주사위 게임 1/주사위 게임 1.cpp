#include <string>
#include <vector>
#include <math.h>
using namespace std;

int solution(int a, int b) {
    return a % 2 && b % 2 ? pow(a,2) + pow(b,2) : a % 2 || b % 2 ? (a + b) * 2 : abs(a - b);
}