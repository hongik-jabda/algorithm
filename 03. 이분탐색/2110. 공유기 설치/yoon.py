n, c = map(int, input().split())
x = []

for i in range(n):
    x.append(int(input()))

x.sort()
start = 1
end = max(x) - min(x)

while start <= end:
    mid = (start+end) // 2
    count = 1
    last_installed = x[0]
    for i in range(1, n):
        if x[i] >= last_installed + mid:
            count += 1
            last_installed = x[i]
    if count >= c:
        start = mid + 1
    else:
        end = mid - 1
print(end)
