#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<int> solution(int n, vector<string> words)
{
    vector<int> answer;
    vector<string> usedWords;
    int count = 1;
    int turn = 0;
    for (int i = 0; i < words.size(); i++)
    {
        turn++;
        if (turn > n)
            turn = 1;
        if (find(usedWords.begin(), usedWords.end(), words[i]) != usedWords.end())
        {
            answer.push_back(turn);
            answer.push_back(count);
            break;
        }
        if (i >= 1 && words[i - 1].back() != words[i].front())
        {
            answer.push_back(turn);
            answer.push_back(count);
            break;
        }
        usedWords.push_back(words[i]);
        if ((i + 1) % n == 0)
            count++;
    }

    if (answer.size() == 0)
    {
        answer.push_back(0);
        answer.push_back(0);
    }
    return answer;
}