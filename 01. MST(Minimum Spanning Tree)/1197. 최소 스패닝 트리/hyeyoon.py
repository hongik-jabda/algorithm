import sys
input = sys.stdin.readline

v, e = map(int, input().split())

matrix = []
parent = [i for i in range(v+1)]
 
for i in range(e):
    matrix.append(list(map(int, input().split())))


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    
    if a > b:
        parent[b] = a
    else:
        parent[a] = b
    return

matrix.sort(key=lambda x: x[2])


answer = 0

for a, b, cost in matrix:
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent,a,b)
        answer += cost

print(answer)
