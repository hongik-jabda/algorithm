from collections import deque


n, k = map(int, input().split())
queue = deque(range(1, n+1))
result = []

while queue:
    queue.rotate(-(k-1))
    result.append(queue.popleft())

answer = "<"
for i in range(n-1):
    answer += str(result[i])
    answer += ", "
print(answer + str(result[-1]) + ">")
