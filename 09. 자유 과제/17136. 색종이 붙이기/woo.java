import java.util.*;
import java.io.*;

public class Main {
	static boolean[][] visit;  // 방문 여부를 저장하는 배열 (색종이가 붙여진 영역 표시)
	static int[][] board;      // 10x10 격자 배열(1 or 0)
	static int[] paper;        // 크기별 색종이 사용 개수

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		visit = new boolean[10][10];  // 방문 여부 배열(모두 false로 초기화)
		board = new int[10][10];
		paper = new int[5];

		// 10x10 보드 입력(1or0)
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		DFS(0, 0);

		// 색종이를 붙일 수 없는 경우 -1 출력, 종료
		if(answer == Integer.MAX_VALUE) {  // answer의 갱신흔적 x -> 붙일 수 없다.
			System.out.println(-1);
			return;
		}

		// 최소 색종이 개수 출력
		System.out.println(answer);
	}

	// depth: 현재 탐색 위치, cnt: 사용한 전체 색종이 개수
	static void DFS(int depth, int cnt) {
		if(depth == 100) {  // board 전체 탐색시
			answer = Math.min(answer, cnt);  // 최소 색종이 개수 갱신
			return;
		}

		int r = depth / 10;  // 현재 탐색 위치의 행
		int c = depth % 10;  // 열

		// 현재 위치가 0이거나 이미 방문한 경우, 다음 위치로 이동
		if(board[r][c] == 0 || visit[r][c]) {
			DFS(depth + 1, cnt);  // 다음 칸으로 이동
		} else {
			// 1x1 ~ 5x5 시도
			for(int i = 1; i <= 5; i++) {
				// 색종이를 붙일 수 있다면 시도
				if(check(r, c, i, true)) {  
					DFS(depth + 1, cnt + 1);  // 다음 칸 탐색 (색종이 사용 개수 증가)
					check(r, c, i, false);   // 백트래킹 (색종이 다시 제거)
				}
			}
		}
	}

	// 색종이를 붙이거나 제거하는 함수
	// 시작위치(r, c), 색종이 크기(num x num), flag: true(붙이기) / false(제거)
	static boolean check(int r, int c, int num, boolean flag) {
		if(flag) {  // 색종이를 붙이는 경우
			// 해당 크기의 색종이를 모두 사용
			if(paper[num - 1] == 5)
				return false;
      // 
			for(int i = r; i < r + num; i++) {
				for(int j = c; j < c + num; j++) {
					// 범위를 벗어나거나 이미 방문했거나 1이 아닌 경우 불가능
					if(i >= 10 || j >= 10 || visit[i][j] || board[i][j] == 0)
						return false;
				}
			}
			// 사용한 색종이 개수 증가
			paper[num - 1]++;
		} else {  // 색종이를 제거하는 경우
			paper[num - 1]--;
		}

		// 색종이 붙이거나 떼기 (방문 여부 변경)
		for(int i = r; i < r + num; i++) {
			for(int j = c; j < c + num; j++) {
				visit[i][j] = flag;  // true면 방문 처리, false면 해제
			}
		}

		return true;  // 성공적으로 붙였거나 제거한 경우
	}
}
