t = int(input())
n = []
k = []
li = []
for i in range(t):
    a, b = map(int, input().split())
    n.append(a)
    k.append(b)
    li.append(sorted(list(map(int, input().split()))))


def two_sum(arr, k):
    i, j = 0, len(arr)-1
    gap = 10**9
    cnt = 0

    while i<j:
        current_sum = arr[i] + arr[j]

        if abs(k - current_sum) < gap:
            gap = abs(k - current_sum)
            cnt = 1
        elif abs(k - current_sum) == gap:
            cnt += 1

        if current_sum > k:
            j -= 1
        else:
            i += 1
    return cnt
answer = []
for i in range(t):
    print(two_sum(li[i], k[i]))
