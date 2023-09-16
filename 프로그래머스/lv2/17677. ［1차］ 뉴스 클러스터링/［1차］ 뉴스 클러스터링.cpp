#include <string>
#include <set>
#include <algorithm>

using namespace std;

int solution(string str1, string str2) {
    multiset<string> set1, set2, interSet, unionSet;
    
    transform(str1.begin(), str1.end(), str1.begin(), ::tolower);
    transform(str2.begin(), str2.end(), str2.begin(), ::tolower);
    
    if (str1 == str2) return 65536;
    
    for (int i = 0; i < str1.size() - 1; i++) {
        string temp = str1.substr(i, 2);
        if (isalpha(temp[0]) && isalpha(temp[1])) set1.insert(temp);
    }
    for (int i = 0; i < str2.size() - 1; i++) {
        string temp = str2.substr(i, 2);
        if (isalpha(temp[0]) && isalpha(temp[1])) set2.insert(temp);
    }
    
    set_intersection(set1.begin(), set1.end(), set2.begin(), set2.end(),
                     inserter(interSet, interSet.begin()));
    set_union(set1.begin(), set1.end(), set2.begin(), set2.end(),
              inserter(unionSet, unionSet.begin()));

    return (double)interSet.size() / (double)unionSet.size() * 65536;
}
