t = int(input())
answer = []

def getProfit(n, day):
    max_price = 0
    profit = 0
    for price in day[::-1]:
        if price > max_price:
            max_price = price
        else:
            profit += max_price - price
    return profit

for i in range(t):
    n = int(input())
    day = list(map(int, input().split()))
    answer.append(getProfit(n, day))

for i in range(t):
    print(answer[i])
