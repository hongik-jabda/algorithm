n = int(input())

def get_primes(n):
    is_prime = [True] * (n+1)
    primes = []
    for i in range(2, n+1):
        if is_prime[i]:
            primes.append(i)
            for j in range(i*i, n+1, i):
                is_prime[j] = False
    return primes

primes = get_primes(n)

i, j = 0, 0
answer = 0
current_sum = 0

while j < len(primes):
    if current_sum < n:
        current_sum += primes[j]
        j += 1
    elif current_sum == n:
        answer += 1
        current_sum -= primes[i]
        i += 1
    else:
        current_sum -= primes[i]
        i += 1

if n in primes:
    print(answer+1)
else:
    print(answer)
