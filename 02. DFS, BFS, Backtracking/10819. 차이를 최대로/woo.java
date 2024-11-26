import java.util.*;

public class Main {
	static int maxSum = 0;	// 식 결과의 최대값 저장
	static boolean[] visited;	// 방문 체크 배열
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 입력 처리
		int N = scanner.nextInt();	// 스캐너 객체 선언
		int[] A = new Int[N];	// 정수 입력받을 배열
		for (int i=0; i<N; i++) {
			A[i] = scanner.nextInt();
		}

		visited = new boolean[N];	// 방문 배열 초기화
		List<Integer> currentPath = new ArrayList<>();	// 현재 순열 저장

		backtrack(A, currentPath, 0);

		System.out.println(maxSum);
	}

	public static void backtrack(int[] A, List<Integer> currenPath, int currentSum) {
		// 모든 숫자를 선택한 경우
		if (currentPath.size() == A.length) {
			maxSum = Math.max(maxSum, currentSum);	// 최대값 갱신
			return;
		}

		// 모든 숫자에 대해 선택
		for (int i=0; i<A.length; i++) {
			if (!visited[i]) {	// 아직 선택하지 않은 숫자일 경우
				visited[i] = true;	// 방문표시하고
				currentPath.add(A[i]);	// 현재 순열에 추가
				
				// 이전 숫자와 차이를 계산(경로 두 개 이상인 경우)
				// |A[N-2] - A[N-1]| 의 점진적 계산
				int addedValue = 0;
				if (currentPath.size() > 1) {	// 값이 두 개 이상일 때부터 시행
					int lastIndex = currentPath.size() - 1;
					addedValue = Math.abs(currentPath.get(lastIndex) 
								- currentPath.get(lastIndex - 1));	// 절대값 계산

				backtrack(A, currentPath, currentSum + addedValue);

				// 백트래킹
				visited[i] = false;	// 다음 탐색을 위해, 이번 탐색시 사용된 알파벳 반납
				currentPath.remove(currentPath.size() - 1);
			}	// 사실 모든 경우의 수(순열)를 시도해보기 때문에 백트래킹이 큰 이점은 없다.
				// 가지치기의 조건이 없는 것이 이유
		}
	}
}
