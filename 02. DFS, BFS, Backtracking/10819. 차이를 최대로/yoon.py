import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))

answer = 0
visited = [False] * n
candidate = []

def backtrack(depth):
    global answer
    if depth == n:
        total = 0
        for i in range(n-1):
            total += abs(candidate[i]-candidate[i+1])
        answer = max(answer, total)
        return
    
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            candidate.append(li[i])
            backtrack(depth+1)
            candidate.pop()
            visited[i] = False

backtrack(0)

print(answer)
