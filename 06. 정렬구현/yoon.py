import heapq

def heap_sort(li):
    heapq.heapify(li)

    sorted_li = []
    for i in range(len(li)):
        sorted_li.append(heapq.heappop(li))
    return sorted_li

def bubble_sort(li):
    for i in range(len(li)):
        for j in range(len(li)-i-1):
            if li[j] > li[j+1]:
                li[j], li[j+1] = li[j+1], li[j]
    return li


def quick_sort(li):
    if len(li) <= 1:
        return li

    pivot = li[0]

    left, middle, right = [], [], []

    for i in range(len(li)):
        if li[i] < pivot:
            left.append(li[i])
        elif li[i] > pivot:
            right.append(li[i])
        else:
            middle.append(li[i])
    return quick_sort(left) + middle + quick_sort(right)


def merge_sort(li):
    if len(li) <= 1:
        return li
    mid = len(li) // 2
    left = merge_sort(li[:mid])
    right = merge_sort(li[mid:])

    sorted_li = []
    i, j = 0, 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            sorted_li.append(left[i])
            i += 1
        else:
            sorted_li.append(right[j])
            j += 1
    sorted_li.extend(left[i:])
    sorted_li.extend(right[j:])

    return sorted_li

n = int(input("정렬할 리스트의 길이를 입력하세요 : "))
li = list(map(int, input("정렬할 숫자를 공백으로 구분해 입력하세요 : ").split()))

print("버블 정렬 결과 :", bubble_sort(li[:]))
print("합병 정렬 결과 : ", merge_sort(li[:]))
print("퀵 정렬 결과 : ", quick_sort(li[:]))
print("힙 정렬 결과 : ", heap_sort(li[:]))
