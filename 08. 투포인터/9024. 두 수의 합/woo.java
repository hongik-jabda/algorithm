import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());    // 테스트케이스 수
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());    // n개의 정수 중
			int k = Integer.parseInt(st.nextToken());    // 합이 k에 가장 가까운 조합 찾기

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}    // n개의 정수 배열에 담기

			Arrays.sort(arr);    // DualPivotQuickSort(오?)
			int start = 0;    // 이중포인터 시작
			int end = arr.length - 1;    // 끝
			int minGap = (int)(2 * 10e8);    // 조건에서 나올 수 있는 '최대' minGap으로 초기화
			int count = 1;    // 반드시 하나의 조합은 최소를 가지게 됨

			while (true) {
				int sum = arr[start] + arr[end];

				if (Math.abs(sum - k) == minGap) {
                    // 현재 minGap값과 동일한 조합 찾을시 count++
					count++;
				} 
                else if (Math.abs(sum - k) < minGap) {
                    // 새로운 minGap 찾았으면
					count = 1;    // count와 minGap 각각 초기화
					minGap = Math.abs(sum - k);
				}
                // 다음 조합 찾기 위한 준비
				if (sum == k) {    // minGap 찾았으므로 둘 다 조정
					start++;
					end--;
				} 
                else if (sum < k) {    // start를 ++함으로써 값 증가
					start++;
				} 
                else {     // end를 --함으로써 값 감소
					end--;
				}

                // start end 역전시 해당 테스트케이스 종료
				if (start >= end) {    
                    break;
				}
			}

			System.out.println(count);
		}
	}
}
