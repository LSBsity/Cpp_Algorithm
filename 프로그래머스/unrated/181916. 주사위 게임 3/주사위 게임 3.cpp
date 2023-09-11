#include <string>
#include <vector>
#include <math.h>
#include <algorithm>
using namespace std;

int solution(int a, int b, int c, int d) {
    vector<int> nogada;
    nogada.push_back(a);
    nogada.push_back(b);
    nogada.push_back(c);
    nogada.push_back(d);
    sort(nogada.begin(), nogada.end());

    
    if (a == b && a == c && a == d && b == c && b == d && c == d)
        return 1111 * a;
    else if (a != b && a != c && a != d && b != c && b != d && c != d) 
        return *min_element(nogada.begin(), nogada.end());
    else if ((nogada[0] == nogada[1] && nogada[2] == nogada[3]) && nogada[1] != nogada[2]) 
        return (nogada[1] + nogada[2]) * abs(nogada[1] - nogada[2]);
    else if (((nogada[0] == nogada[1] && nogada[1] == nogada[2]) || (nogada[1] == nogada[2] && nogada[2] == nogada[3])) && nogada[0] != nogada[3])
        return count(nogada.begin(), nogada.end(), nogada[0]) > count(nogada.begin(), nogada.end(), nogada[3]) ? (10 * nogada[0] + nogada[3]) * (10 * nogada[0] + nogada[3]) : (10 * nogada[3] + nogada[0]) * (10 * nogada[3] + nogada[0]);
    else if ((nogada[0] == nogada[1] && nogada[2] != nogada[3]) || (nogada[1] == nogada[2] && nogada[0] != nogada[4]) || (nogada[2] == nogada[3] && nogada[0] != nogada[1]))
        return nogada[0] == nogada[1] ? nogada[2] * nogada[3] : nogada[1] == nogada[2] ? nogada[0] * nogada[3] : nogada[0] * nogada[1];
}