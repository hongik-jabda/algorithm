n, m = map(int, input().split())
a = list(map(int, input().split()))
sum_li = [0] # 누적합 배열
for i in range(n):
    sum_li.append(sum_li[-1]+a[i])


cnt = [0] * m
cnt[0] = 1
answer = 0
for i in range(1,n+1):
    sub_mod = sum_li[i]%m
    answer += cnt[sub_mod]
    cnt[sub_mod] += 1

print(answer)
