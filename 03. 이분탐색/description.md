> **이분 탐색** : 오름차순으로 정렬된 배열을 반복적으로 반으로 나누어 target이 선택될 때까지 탐색하는 알고리즘

![image](https://github.com/user-attachments/assets/bb266993-3c9a-4033-8180-9d2dc2455d61)

## 이분 탐색의 조건
- 무조건 **오름차순으로 정렬**된 상태에서 시작해야 함!!

## 이분 탐색 구현
- 시간 복잡도 : **O(logN)**
- **반복문**과 **재귀**로 구현 가능

1. 자료를 오름차순으로 정렬
2. 자료의 중간값(mid)이 찾고자 하는 값(target)인지 비교
3. `mid`가 `target`과 다르다면 대소 관계 비교해 탐색 범위를 좁힌다. `target`과 `mid`가 같을 때까지 아래 조건에 따라 2번과 3번을 반복한다.
  (1) `target` < `mid` 일 때 `end`를 `mid` 왼쪽 값으로 바꿔준다. (절반의 왼쪽 탐색)
  (2) `target` > `mid` 일 때 `start`를 `mid` 오른쪽 값으로 바꿔준다. (절반의 오른쪽 탐색)
  

### 반복문으로 구현
```python
def binary_search(target, data):
    data.sort()
    start = 0 # 맨 처음 위치
    end = len(data) - 1 # 맨 마지막 위치

    while start <= end:
        mid = (start + end) // 2 # 중간값

        if data[mid] == target:
            return mid # target 위치 반환

        elif data[mid] > target: # target이 작으면 왼쪽을 더 탐색
            end = mid - 1
        else: # target이 크면 오른쪽을 더 탐색
            start = mid + 1
    return
```

### 재귀로 구현
```python
def binary_search(target, start, end):
    if start > end: # 범위를 넘어도 못찾는다면 -1을 반환
        return -1

    mid = (start + end) // 2 # 중간값

    if data[mid] == target:	# 중간값의 데이터가 target과 같다면 mid를 반환
        return mid 

    elif data[mid] > target: # target이 작으면 왼쪽 탐색
        end = mid - 1
    else: # target이 크면 오른쪽 탐색
        start = mid + 1

    return binary_search(target, start, end) # 줄어든 범위를 더 탐색

def solution(target, data):
    data.sort()  # 정렬(필수)
    start = 0
    end = len(data) - 1
    return binary_search(target, start, end)
```

## 참고
https://code-angie.tistory.com/3

https://namu.wiki/w/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89 (사진 출처)
