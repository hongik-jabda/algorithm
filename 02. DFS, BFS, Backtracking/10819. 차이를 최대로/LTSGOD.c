#include <stdio.h>
#include <stdbool.h>

int calculate_sum();
void recursion(int depth);
 
static int N;
static int A[10];
static int result[10];
static bool visited[10] = {0, };
static int max = -1;

int main() {

    scanf("%d", &N);

    for (int i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }

    recursion(0);

    printf("%d\n", max);
    
    return 0;
}

void recursion(int depth) {
    // 탈출조건
    if (depth == N) {

        // 식계산
        int candidate = calculate_sum();

        if (candidate > max) {
            max = candidate;
        }

        return;
    }

    for (int i = 0; i < N; i++) {

        if (!visited[i]) {
            visited[i] = true; // 방문체크
            result[depth] = A[i];
            recursion(depth + 1); // 재귀
            visited[i] = false; // 방문해제
        }
    }
}

int calculate_sum() {
    int sum = 0;

//  공식
    for (int i = 0; i < N - 1; i++) {
        // 절댓값 구하기
        int abs = result[i] > result[i+1] ? result[i] - result[i+1] : result[i+1] - result[i];
        sum += abs;
    }

    return sum;
}
