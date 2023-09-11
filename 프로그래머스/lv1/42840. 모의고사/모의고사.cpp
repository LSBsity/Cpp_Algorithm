#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> a = {1, 2, 3, 4, 5};
vector<int> b = {2, 1, 2, 3, 2, 4, 2, 5};
vector<int> c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

vector<int> solution(vector<int> answers)
{
    vector<int> answer1;
    vector<int> scores(3);


    for (int i = 0; i < answers.size(); i++)
    {
        if (answers[i] == a[i % a.size()])
            scores[0]++;
        if (answers[i] == b[i % b.size()])
            scores[1]++;
        if (answers[i] == c[i % c.size()])
            scores[2]++;
    }

    int max = *max_element(scores.begin(), scores.end());

    for (int i = 0; i < 3; i++)
    {
        if (scores[i] == max)
            answer1.push_back(i + 1);
    }

    return answer1;
}