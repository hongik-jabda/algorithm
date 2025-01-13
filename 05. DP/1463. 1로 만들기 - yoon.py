n = int(input())

dp = [0 for i in range(n+3)]
dp[1] = 0
dp[2] = 1
dp[3] = 1

for i in range(4, n+1):
    nanugi3 = 10**9
    nanugi2 = 10**9

    if i%3 == 0:
        nanugi3 = dp[i//3]
    if i%2 == 0:
        nanugi2 = dp[i//2]

    dp[i] = min(nanugi3, nanugi2, dp[i-1]) + 1

print(dp[n])
