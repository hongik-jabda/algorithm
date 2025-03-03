# 곱하기 2
# 1을 가장 오른쪽에 추가

from collections import deque
a, b = map(int, input().split())


def bfs(a, b):
    queue = deque([(b,1)])
    visited = set()

    while queue:
        v, cnt = queue.popleft()

        if v == a:
            return cnt
        if v % 2 == 0 and v//2 not in visited:
            queue.append((v//2, cnt+1))
            visited.add(v//2)

        if v%10 == 1 and (v-1)//10 not in visited:
            queue.append(((v-1)//10, cnt+1))
            visited.add((v-1)//10)
    return -1

print(bfs(a,b))
