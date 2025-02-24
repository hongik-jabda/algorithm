import sys
sys.setrecursionlimit(10**6)

n = int(input())
people = [0] + list(map(int, input().split()))
tree = [[] for i in range(n+1)]

for i in range(n-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

# dp[node][0] : 현재 노드가 우수 마을이 아닐 때 최대 인구 수
# dp[node][1] : 현재 노드가 우수 마을일 때 최대 인구 수
dp = [[0,0] for _ in range(n+1)]
visited = [False] * (n+1)

def dfs(node):
    visited[node] = True
    dp[node][1] = people[node]

    for child in tree[node]:
        if not visited[child]:
            dfs(child)

            dp[node][1] += dp[child][0]

            dp[node][0] += max(dp[child][0], dp[child][1])

dfs(1)

print(max(dp[1][0],dp[1][1]))
