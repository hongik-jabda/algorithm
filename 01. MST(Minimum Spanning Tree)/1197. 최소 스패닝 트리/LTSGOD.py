import sys
from collections import deque

input = sys.stdin.readline

V, E = map(int, input().split())

edge = []
subset = [set([i]) for i in range(V+1)]
# print(subset)
# 노드의 루트 기록용
node = [i for i in range(V+1)]

for _ in range(E):
    a,b,v = map(int, input().split())

    edge.append([v,a,b])
edge.sort()
value = 0

def find(x):
    if x!= node[x]:
        node[x] = find(node[x])
    return node[x]
for e in edge:

    a = find(e[1])
    b = find(e[2])
    # 만약 루트 노드가 같지 않다면 서로 다른 트리
    if a != b:
        if a < b:
            node[b] = a
        else:
            node[a] = b
        value += e[0]
    # print(subset)
    # print(node)
print(value)
