import sys
input = sys.stdin.readline
from collections import deque

m, n = map(int, input().split())

box = []

for i in range(n):
    box.append(list(map(int, input().split())))


queue = deque()

for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append((i, j))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

while queue:
    x, y = queue.popleft()

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0<= nx < n and 0 <= ny < m and box[nx][ny] == 0:
            box[nx][ny] = box[x][y] + 1
            queue.append((nx, ny))

result = 0

for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            print(-1)
            exit()
        result = max(result, box[i][j])

print(result-1)


import sys
input = sys.stdin.readline
from collections import deque

m, n = map(int, input().split())

box = []

for i in range(n):
    box.append(list(map(int, input().split())))


queue = deque()

for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append((i, j))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

while queue:
    x, y = queue.popleft()

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0<= nx < n and 0 <= ny < m and box[nx][ny] == 0:
            box[nx][ny] = box[x][y] + 1
            queue.append((nx, ny))

result = 0

for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            print(-1)
            exit()
        result = max(result, box[i][j])

print(result-1)
