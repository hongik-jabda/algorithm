#include <iostream>
#include <queue>

using namespace std;

int board[1001][1001];
bool visited[1001][1001];
int dir_x[4] = {0, 0, -1, 1};
int dir_y[4] = {1, -1, 0, 0,};
int max_v = -1;
int M, N;
queue<pair<int, int>> q;

void bfs() {

    while (!q.empty()) {
        int current_x = q.front().first;
        int current_y = q.front().second;
        q.pop();

        if (visited[current_x][current_y]) {
            continue;
        }
        visited[current_x][current_y] = true;

        for (int i = 0; i < 4; i++) {
            int next_x = current_x + dir_x[i];
            int next_y = current_y + dir_y[i];

            if (next_x < 0 || next_y < 0 || next_x > N - 1 || next_y > M - 1) {
                continue;
            }

            if (!visited[next_x][next_y] && board[next_x][next_y] == 0) {
                board[next_x][next_y] = board[current_x][current_y] + 1;
                if (board[next_x][next_y] > max_v) {
                    max_v = board[next_x][next_y];
                }
                q.push(make_pair(next_x, next_y));
            }
        }
    }
}

int main() {

    cin >> M >> N;
    int count = 0;
    int tomato_num = M *N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];

            if (board[i][j] == 1) {
                q.push(make_pair(i, j));
                count++;
            } else if (board[i][j] == -1) {
                tomato_num--;
            }
        }
    }

    if (count == tomato_num) {
        cout << 0;
    } else {
        bfs();

        bool is_all_grow = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    is_all_grow = false;
                }
            }
        }

        if (!is_all_grow) {
            cout << -1;
        } else {
            cout << max_v - 1;
        }
    }

    // for (int i = 0; i < N; i++) {
    //     for (int j = 0; j < M; j++) {
    //         cout << board[i][j];
    //     }
    //     cout << "\n";
    // }
    

    return 0;
}
