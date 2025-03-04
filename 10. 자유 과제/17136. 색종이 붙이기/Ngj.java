import java.io.*;
import java.util.*;

public class Ngj {
	public static int[][] paper;
	public static ArrayList<int[]> needColors;
	public static int minCount;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		paper = new int[10][10];
		minCount = Integer.MAX_VALUE;
		needColors = new ArrayList<>();
		
		for (int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if (paper[i][j] == 1) {
					needColors.add(new int[]{i, j});
				}
			}
		}
		
		boolean[][] visited = new boolean[10][10];
		int[] remColors = new int[5];
		Arrays.fill(remColors, 5);
		
		dfs(visited, remColors, 0, 0, 0);
		
		if (minCount < Integer.MAX_VALUE) {
			System.out.println(minCount);
		}
		else {
			System.out.println(-1);
		}
	}
	
	public static void dfs(boolean[][] visited, int[] remColors, int curX, int curY, int curCount) {
		
		if (curY == 10) {
		    curX++;
		    curY = 0;
		    if (curX == 10) {  
		        minCount = Math.min(minCount, curCount);
		        return;
		    }
		}
		
		if (curCount >= minCount) {
			return;
		}
		
		if (paper[curX][curY] == 1 && !visited[curX][curY]) {
//			System.out.println(curX + " " + curY + " ================");
			int size = checkSize(curX, curY, visited);
//			System.out.println("가능 최대 사이즈 : " + size);
			
			for (int s=size; s>0; s--) {
				if (remColors[s-1] > 0) {
					matchColor(s, curX, curY, visited);
					remColors[s-1]--;
					dfs(visited, remColors, curX, curY+1, curCount+1);
					restoreColor(s, curX, curY, visited);
					remColors[s-1]++;
				}
			}
		} 
		else {
			dfs(visited, remColors, curX, curY+1, curCount);
		}
	}
	
	public static void restoreColor(int size, int x, int y, boolean[][] visited) {
		for (int i=x; i<x+size; i++) {
			for (int j=y; j<y+size; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	public static void matchColor(int size, int x, int y, boolean[][] visited) {
		for (int i=x; i<x+size; i++) {
			for (int j=y; j<y+size; j++) {
				visited[i][j] = true;
			}
		}
	}
	
	
	public static int checkSize(int x, int y, boolean[][] visited) {
		for (int size=5; size>0; size--) {
			boolean flag = false;
			for (int i=x; i<x+size; i++) {
				for (int j=y; j<y+size; j++) {
					if (i>=0 && i<10 && j>=0 && j<10) {
						if (paper[i][j] == 0 | visited[i][j]) {
							flag = true;
							break;
						}
					}
					else {
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				return size;
			}
		}
		return 0;
	}
}
