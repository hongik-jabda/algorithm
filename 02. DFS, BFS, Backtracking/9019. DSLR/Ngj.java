import java.io.*;
import java.util.*;

public class Main {
	
	public static class Num {
		public int num;
		public String path;
		
		public Num(int num, String path) {
			this.num = num;
			this.path = path;
		}
	}
	
	public static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[10000];
			visited[A] = true;
			
			Queue<Num> q = new LinkedList<>();
			q.offer(new Num(A, ""));
			
			bfs(q, visited, B);
			
		}
	}
	
	public static void bfs(Queue<Num> q, boolean[] visited, int goal) {
		while(!q.isEmpty()) {
			Num cur = q.poll();
			if (cur.num == goal) {
				System.out.println(cur.path);
				return;
			}
			
			int r1 = cal_d(cur.num);
			if (!visited[r1]) {
				q.offer(new Num(r1, cur.path+"D"));
				visited[r1] = true;
			}
			
			int r2 = cal_s(cur.num);
			if (!visited[r2]) {
				q.offer(new Num(r2, cur.path+"S"));
				visited[r2] = true;
			}
			
			int r3 = cal_l(cur.num);
			if (!visited[r3]) {
				q.offer(new Num(r3, cur.path+"L"));
				visited[r3] = true;
			}
			
			int r4 = cal_r(cur.num);
			if (!visited[r4]) {
				q.offer(new Num(r4, cur.path+"R"));
				visited[r4] = true;
			}
			
		}

	}
	
	public static int cal_d(int num) {
		return (num*2)%10000;
	}
	
	public static int cal_s(int num) {
		if (num == 0) {
			return 9999;
		}
		return num-1;
	}
	
	public static int cal_l(int num) {
		int d1 = num/1000;
		
		return (num - (1000 * d1)) * 10 + d1;
	}
	
	public static int cal_r(int num) {
		int d4 = num%10;
		
		return (num - d4) / 10 + (1000 * d4);
	}

}
