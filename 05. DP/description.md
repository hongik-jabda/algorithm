# DP(Dynamic Programmin')란?
> 복잡한 문제를 더 작은 하위 문제로 나누어 해결하는 알고리즘 설계 기법
>
> '기억하면서 풀기'
## DP는 왜 필요한가?
1. 메모리(기억, 유사 캐쉬)을 사용하여 중복 연산을 줄인다
2. 중복 연산을 줄여 수행 시간을 줄인다.
## 예제1: 정수 삼각형
![image](https://github.com/user-attachments/assets/436c3685-e53e-4ca9-b6d2-0708507040e9)
- 원래였으면 처음부터 끝까지 계속해서 계산하여 max와 비교하는 방식 -> 중복 연산 발생
- DP를 이용하여 단계별로 계산하기(위의 연산은 저장하여 중복 X)
## 예제2: 피보나치 수열 계산
![image](https://github.com/user-attachments/assets/6e285e86-1374-48b0-a330-50d9c33cb205)
- return f(n) = f(n-1) + f(n-2); // 단순 재귀함수 호출
```
public class Fibonacci01 {
    public static void main(String[] args) {
        System.out.println(recur(26));
    }

    public static int recur(int num){
        if(num == 1){
            return 1;
        }
        if(num == 2){
            return 1;
        }
        int result = recur(num-1) + recur(num-2);
        return result;
    }
}
```
![image](https://github.com/user-attachments/assets/da5a8dd9-e3d7-4895-94d2-50bd766e647d)
- 밑에서부터 시작하면 중복 계산 줄일 수 있음(Top-Down도 DP 가능하긴 함!!!!)
- 어쨌든 핵심은, 연산한 결과를 배열에 저장하는 것(메모리)
```
public class Fibonacci {
    static int[] dp = new int[100];

    public static void main(String[] args) {
        System.out.println(fibo(26));
    }

    public static int fibo(int num){
        //첫번째, 두번째 수열에 1 저장
        dp[0] = 1;
        dp[1] = 1;
        
        //반복문을 돌며 3번째 수열부터 차례로 값을 채워넣는다
       for(int i = 2; i < num; i++){
           dp[i] = dp[i - 1] + dp[i - 2];
       }
        return dp[num - 1];
    }
}
```
## DP 문제인지 알아보는 법?
1. DFS/BFS로 풀 수 있지만 경우의 수가 너무 많은 문제
  - 주로 DFS/BFS는 경로 탐색, DP는 최적값 계산에 적합
2. 중복된 연산이 많은 경우
  - 각 위치까지 올 수 있는 죄적의 조합만 남겨두고 나머지는 버림

### 출처
- https://www.youtube.com/watch?v=0bqfTzpWySY
- https://www.google.com/url?sa=i&url=https%3A%2F%2Fhongjw1938.tistory.com%2F47&psig=AOvVaw1cq79OREW7eP9vKKtqPCvE&ust=1735615370114000&source=images&cd=vfe&opi=89978449&ved=0CBcQjhxqFwoTCPDc1J_FzooDFQAAAAAdAAAAABAZ
- https://www.google.com/url?sa=i&url=https%3A%2F%2Fvelog.io%2F%40ssokeem%2FDynamic-Programming&psig=AOvVaw1cq79OREW7eP9vKKtqPCvE&ust=1735615370114000&source=images&cd=vfe&opi=89978449&ved=0CBcQjhxqFwoTCPDc1J_FzooDFQAAAAAdAAAAABAh
- https://eunjk.tistory.com/6
