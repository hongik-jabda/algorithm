from collections import deque
t = int(input())
tc = []

for i in range(t):
    tc.append(list(map(int, input().split())))

li = ['D', 'S', 'L', 'R']

def move(dir, n):
    if dir == 'D':
        return (n * 2) % 10000

    elif dir == 'S':
        if n == 0:
            return 9999
        else:
            return n-1

    elif dir == 'L':
        n = str(n).zfill(4)
        n = n[1:] + n[0]
        return int(n)

    elif dir == 'R':
        n = str(n).zfill(4)
        n = n[-1] + n[:-1]
        return int(n)


def bfs(a, b):
    queue = deque([(a, '')])
    visited = set()
    visited.add(a)

    while queue:
        v, route = queue.popleft()
        for dir in li:
            next_v = move(dir, v)
            if next_v == b:
                return route+dir
            if next_v not in visited:
                queue.append((next_v, route+dir))
                visited.add(next_v)

answer = []
for case in tc:
    answer.append(bfs(case[0], case[1]))

for i in range(t):
    print(answer[i])
