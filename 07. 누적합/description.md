# 누적합을 이용하여 구간합 빠르게 구하기

## 길이가 N인 int 배열에서 a번째 숫자부터 b번째 숫자까지의 합?
### 1. 반복문 - O(N)

```java
int sum = 0;
for (int i=a; i<b; i++) {
	sum += arr[i];
}
```

### 2. 구간합 - O(1)

![image1](https://github.com/user-attachments/assets/de22c2ba-1c9b-4185-a1dc-3eb24c7a7625)


### 1차원 배열 arr에서 i부터 j 까지의의 합

sum[j+1]-sum[i]

![image2](https://github.com/user-attachments/assets/048a1f3e-232a-4a17-b990-88d1cf324fd0)



## 2차원 일때

행 별로 더하고, 열 별로 더하면 sum[][] 만들어짐

![image3](https://github.com/user-attachments/assets/93665677-dd6f-427d-9466-07fb7bd390fd)


### arr[i][j] 부터 arr[a][b]까지 더하기

sum[a+1][b+1] - sum[i][b+1] - sum[a+1][j] + sum[i][j]

![image4](https://github.com/user-attachments/assets/ef4037b4-3e41-4735-9555-2b8b112ada14)
