import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean[] isPrime;    // 해당 인덱스 숫자가 소수인가?
	static List<Integer> PrimeList;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
        //if (n < 2) {
        //    System.out.println(0);
        //    return;
        //}
		PrimeList = new ArrayList<>();    // 소수 담을 ArrayList
		makePrime();    // 소수 리스트 생성완료

        // 이중포인터
		int start = 0;
		int end = 0;
		int sum = 0;    // sum은 0으로 시작
		int count = 0;
        
		while (end<PrimeList.size()){
            // start는 end 만나면 안됨, end는 ArrayList의 범위 넘어가면 안됨
			if (sum < n) {    // sum이 n보다 작다면
				sum += PrimeList.get(end++);    // end 증가시키고 sum에 더해줌
			} 
            else {
				if(sum == n) {    // sum이 n이라면 count 추가
					count++;
				}
                // sum >= n 이라면
				sum -= PrimeList.get(start++);    // start 증가시키고 sum에서 뺌
                // 같을 때는 왜? : 다음 경우의 수 찾으러 떠나야지.
			}
		}
		
		System.out.println(count);
	}
	
	static void makePrime() {
		isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);    // 일단 true로 초기화
        
		isPrime [0] = isPrime [1] = false;    // 0과 1은 합성수도 자연수도 아님
		for (int i=2; i*i<=n; i++){    // i*i까지 하는 이유는 j에서 확인가능
			if (isPrime[i]){    // 현재 i가 소수라면
				for(int j=i*i; j<=n; j+=i) {    // i의 모든 배수 제거
                    // i*i가 남은 숫자들 중 최초의 i의 배수일 것(나머지는 미리 제거)
					isPrime[j] = false;
				}
			}
		}    // 에라토스테네스의 체 알고리즘
		
		for (int i=2; i<=n; i++) {
			if (isPrime[i]) {
				PrimeList.add(i);
			}
		}
        PrimeList.add(0);
	}
	
}
