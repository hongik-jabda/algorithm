import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static final int INF = 10_000_000;
	private static int N;
	private static int[][] cost;
	private static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cost = new int[N][N];
		dp = new int[N][1 << N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		// 도시 0에서 시작하여 도시 0으로 돌아오는 최적 경로 탐색
		System.out.print(solution(0, 1));
	}
	
	private static int solution(int current, int visited) {
		// 모든 도시를 방문한 경우 (비트가 다 차있으면)
		if (visited == (1 << N) - 1) {
			// 시작점으로 돌아가는 비용이 없으면 INF
			return cost[current][0] == 0 ? INF : cost[current][0];
		}
		
		// 이미 계산한 경우
		if (dp[current][visited] != -1) {
			return dp[current][visited];
		}
		
		dp[current][visited] = INF;
		
		// 모든 도시를 탐방
		for (int next = 0; next < N; next++) {
			// 방문하지 않았고 이동 가능하다면 업데이트 가능
			if ((visited & (1 << next)) == 0 && cost[current][next] != 0) {
				dp[current][visited] = Math.min(
						dp[current][visited],
						cost[current][next] + solution(next, visited | (1 << next))
				);
			}
		}
		
		return dp[current][visited];
	}
}
