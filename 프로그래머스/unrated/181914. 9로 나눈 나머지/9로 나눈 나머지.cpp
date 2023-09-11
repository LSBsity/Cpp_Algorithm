#include <string>
#include <vector>

using namespace std;

int solution(string number) {
    int sum = 0;
    
    for (int i = 0; i < number.size(); i++)
        sum += number[i] - '0';
    
    return sum % 9;
}