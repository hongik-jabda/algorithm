n, k = map(int, input().split())

li = list(map(int, input().split()))

now = [] # 현재 멀티탭에 꽂혀있는 전기 용품 리스트
answer = 0
for i in range(k):
    if li[i] in now:
        continue

    if len(now) < n:
        now.append(li[i])
    else:
        far_use = -1
        idx_to_remove = -1
        # 자리가 없으면 앞으로 가장 늦게 사용되거나 아예 사용되지 않는 걸 뽑읍
        for idx, plug in enumerate(now):
            if plug not in li[i+1:]:
                idx_to_remove = idx
                break
            else:
                next_use = li[i+1:].index(plug)
                if next_use > far_use:
                    far_use = next_use
                    idx_to_remove = idx
        now[idx_to_remove] = li[i]
        answer += 1

print(answer)
