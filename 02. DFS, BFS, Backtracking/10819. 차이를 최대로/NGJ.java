import java.io.*;
import java.util.*;

public class Main {
	
	public static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		result = 0;
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(N, arr, new int[N], new boolean[N], 0);
		
		System.out.println(result);
	
	}
	
	public static void perm(int n, int[] arr, int[] out, boolean[] visited, int depth) {
		if (depth == n) {
			int tmp = cal(out);
//			System.out.println(Arrays.toString(out));
			result = Math.max(result, tmp);
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				out[depth] = arr[i];
				visited[i] = true;
				perm(n, arr, out, visited, depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static int cal(int[] out) {
		int sum = 0;
		for (int i=0; i<out.length-1; i++) {
			sum += Math.abs(out[i] - out[i+1]);
		}
		return sum;
	}
}
