import sys
input = sys.stdin.readline

n = int(input())
num = list(map(int, input().split()))
m = int(input())
q = []
for i in range(m):
    q.append(list(map(int, input().split())))

dp = [[False] * n for _ in range(n)]

for i in range(n):
    dp[i][i] = True

for i in range(n-1):
    if num[i] == num[i+1]:
        dp[i][i+1] = True


for i in range(3,n+1):
    for j in range(n-i+1):
        k = j + i - 1
        if num[j] == num[k] and dp[j+1][k-1]:
            dp[j][k] = True

for s, e in q:
    print(1 if dp[s-1][e-1] else 0)
