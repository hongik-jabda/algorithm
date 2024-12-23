#include <iostream>
#include <string>
#include <queue>
#include <set>

using namespace std;

string name = {"DSLR"};

int L(int source){
    return (source % 1000) * 10 + (source / 1000);
}

int R(int source) {
    return (source % 10) * 1000 + (source / 10);
}

int D(int source) {
    int num = source;
    num *= 2;
    num %= 10000;

    return num;
}

int S(int source) {

    source--;
    if (source < 0) {
        source = 9999;
    }

    return source;
}

int (*f_ptr[4])(int) = {D,S,L,R};

string bfs(int from, int to) {
    queue<pair<int, string>> q;
    bool visited[10001] = {false, };

    q.push(make_pair(from, ""));
    visited[from] = true; // 방문처리

    // for (int i = 0; i < 100; i++) {
    //     cout << visited[i] << " \n";
    // }

    while (!q.empty()) {

        int current_s = q.front().first;
        string result = q.front().second;

        // cout << "current " + current_s  + "reuslt " + result << "\n";

        // 종료조건
        if (current_s == to) {

            return result;
        }
        q.pop();

        for (int i = 0; i < 4; i++) {
            int next_s = f_ptr[i](current_s);


            if (!visited[next_s]) {
                q.push(make_pair(next_s, result + name[i]));
                visited[next_s] = true;
            }
        }
    }
}

int main() {

    int N;
    int from, to;
    string from_s, to_s;

    cin >> N;

    for (int i = 0; i < N; i++) {
            cin >> from >> to;

            string result = bfs(from, to);
            cout << result << "\n";
            
            // cout << L(from) <<" " << L(to) << endl;
    }

    return 0;
}
