import java.io.*;
import java.util.*;

public class Main {
	
	public static int result;
	public static int R;
	public static int C;
	public static String[][] map;
	public static HashSet<String> set;
	public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		result = 0;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		set = new HashSet<>();
		
		for (int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			map[i] = str.split("");
		}
		
		set.add(map[0][0]);

		dfs(0, 0, 1);
		System.out.println(result);
		
	}
	
	
	public static void dfs(int curX, int curY, int d) {
		for (int[] mv: move) {
			int afterX = curX + mv[0];
			int afterY = curY + mv[1];
		
			if (afterX >= 0 && afterX < R && afterY >= 0 && afterY < C) {
				if (!set.contains(map[afterX][afterY])) {
//					System.out.println(map[afterX][afterY] + " " + d);
					set.add(map[afterX][afterY]);
					dfs(afterX, afterY, d+1);
					set.remove(map[afterX][afterY]);
				}
			}
		}
		result = Math.max(result, d);
	}
}
