import java.io.*;
import java.util.*;

public class Ngj {
	public static int[][] dp;
	public static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		dp = new int[n][n];
		nums = new int[n];
		
		for (int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
			dp[i][i] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int check = recursion(s, e);
			if (check == 1) {
				sb.append("1\n");
			}
			else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int recursion(int s, int e) {
		if (s >= e) {
			return 1;
		}
		
		if (dp[s][e] >= 0) {
			return dp[s][e];
		}
		
		if (nums[s] != nums[e]) {
			return dp[s][e] = 0;
		}
		
		return dp[s][e] = recursion(s+1, e-1);
	}
}
