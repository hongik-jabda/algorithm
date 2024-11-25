#include <iostream>
#include <set>

using namespace std;

bool has_duplicate(char target);
void recursion(int start_x, int start_y, int depth);
 
static int R, C;
static char board[21][21];
set<char> result;
static bool visited[26] = {0, };
static int max_value = 1;
static int dir[4][2] = {{0,1}, {1, 0}, {-1,0}, {0, -1}};

bool has_duplicate(char target) {

    // 지금까지 걸어온 길과 중복되는 것이 있다면 true반환

    if (result.find(target) != result.end()) return true;

    return false;
}

void recursion(int start_x, int start_y, int depth) {

    for (int i = 0; i < 4; i++) {
        int current_x = start_x + dir[i][0];
        int current_y = start_y + dir[i][1];

        // 범위 넘어가는거 예외처리
        if (current_x < 0 || current_x > R - 1 || current_y < 0 || current_y > C - 1) {
            continue;
        }

        // 아직 방문하지 않음 + 걸어온 길과 중복이 없다면
        if (!visited[board[current_x][current_y] - 'A']) {
            // visited[current_x][current_y] = true;
            visited[board[current_x][current_y] - 'A'] = true;
            recursion(current_x, current_y, depth + 1);
            // visited[current_x][current_y] = false;
            visited[board[current_x][current_y] - 'A'] = false;
        }
    }

    // 4방향 다 갈곳없으면 최대로 간것
    if (depth > max_value) {
        max_value = depth;
    }

}

int main() {

    cin >> R >> C;

    for (int i = 0; i < R; i++) {
        cin >> board[i];
    }

    result.insert(board[0][0]);
    visited[board[0][0] - 'A'] = true;

    recursion(0, 0, 1);

    cout << max_value << endl;

    return 0;
}
