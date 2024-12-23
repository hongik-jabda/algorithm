import java.io.*;
import java.util.*;

public class Main {
	
	public static int T;
	public static int N;
	public static int M;
	public static int[][] map;
	public static Queue<int[]> q;
	public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = 0;
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		q = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					T++;
				}
				if (map[i][j] == 1) {
					q.offer(new int[] {i, j, 0});
				}
			}
		}
		
		bfs();
		
	}
	
	public static void bfs() {
		int day = 0;
		while (!q.isEmpty()) {
			if (T == 0) {
				System.out.println(day);
				return;
			}
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			int d = cur[2];
			
			for (int[] mv: move) {
				int afterX = curX + mv[0];
				int afterY = curY + mv[1];
				if (afterX >= 0 && afterX < N && afterY >= 0 && afterY < M) {
					if (map[afterX][afterY] == 0) {
						map[afterX][afterY] = 1;
						T--;
						q.offer(new int[] {afterX, afterY, d+1});
						day = d+1;
					}
				}
			}
			
		}
		System.out.println("-1");
		return;
	}
}
