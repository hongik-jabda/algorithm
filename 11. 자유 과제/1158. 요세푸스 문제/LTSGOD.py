N, K = map(int, input().split())

a = [i for i in range(1, N+1)]

index = (K - 1) % len(a)

print("<", end="")
while (a):

    c = a.pop(index)
    print(c, end="") 
    if not a:
        break
    index = (index + K - 1) % len(a)
    print(", ", end="")

print(">")
# for i in range(len(a)):
#     print(a[i], end=" ")
