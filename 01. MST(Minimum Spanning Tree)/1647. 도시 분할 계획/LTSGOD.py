import sys
from collections import deque

input = sys.stdin.readline

# 일단 크르수칼을 통해 MST를 만들고
# 그중 가장 큰 값 하나를 제거

N, M = map(int, input().split())

edge = []
root = [i for i in range(N+1)]

for _ in range(M):
    a, b, v = map(int, input().split())
    edge.append([a,b,v])

edge.sort(key=lambda x: x[2])

def find(x):
    if x != root[x]:
        return find(root[x])
    return x
result = []
for e in edge:
    
    aRoot = find(e[0])
    bRoot = find(e[1])

    if aRoot != bRoot:
        if aRoot < bRoot:
            root[bRoot] = aRoot
        else:
            root[aRoot] = bRoot
        result.append(e[2])

result.sort()
result.pop()
print(sum(result))
