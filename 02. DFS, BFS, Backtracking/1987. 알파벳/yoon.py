import sys
input = sys.stdin.readline

R, C = map(int, input().split())
board = []

# 상하좌우
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

for i in range(R):
    board.append(list(input().strip())) 

answer = 0

def dfs(x, y, count, visited):
    global answer
    answer = max(answer, count)

    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0<= nx < R and 0<= ny < C and board[nx][ny] not in visited:
            visited.add(board[nx][ny])
            dfs(nx, ny, count+1, visited)
            visited.remove(board[nx][ny])
    
visited = set()
visited.add(board[0][0])
dfs(0, 0, 1, visited)

print(answer)
