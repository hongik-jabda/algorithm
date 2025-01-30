class Dompoo {
	
	public int solution(int[][] board, int[][] skill) {
		int N = board.length;
		int M = board[0].length;
		int[][] sum = new int[N + 1][M + 1];
		
		for (int[] curSkill : skill) {
			int r1 = curSkill[1];
			int c1 = curSkill[2];
			int r2 = curSkill[3];
			int c2 = curSkill[4];
			int value = curSkill[0] == 1 ? - curSkill[5] : curSkill[5];
			
			sum[r2 + 1][c2 + 1] += value;
			sum[r1][c2 + 1] -= value;
			sum[r2 + 1][c1] -= value;
			sum[r1][c1] += value;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < M; j++) {
				sum[i][j] += sum[i][j - 1];
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum[i][j] += sum[i - 1][j];
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] + sum[i][j] > 0) answer++;
			}
		}
		return answer;
	}
}
