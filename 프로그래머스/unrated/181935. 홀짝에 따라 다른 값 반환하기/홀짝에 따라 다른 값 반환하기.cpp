#include <string>
#include <vector>
#include <math.h>

using namespace std;

int solution(int n) {
    int sum = 0;
    
    if (n % 2)
    {
        for (int i = 1; i <= n; i+=2)
            sum += i;
    }
    else
        for (int i = 0; i <= n; i+=2)
            sum += pow(i, 2);
    
    return sum;
}