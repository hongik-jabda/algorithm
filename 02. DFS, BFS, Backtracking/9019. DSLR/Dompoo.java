import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	
	static boolean[] visited;
	static String[] command;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			String[] splits = br.readLine().split(" ");
			int number = Integer.parseInt(splits[0]);
			int target = Integer.parseInt(splits[1]);
			
			visited = new boolean[10000];
			command = new String[10000];
			
			bfs(number, target);
			
			sb.append(command[target]).append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void bfs(int number, int target) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(number);
		visited[number] = true;
		command[number] = "";
		
		while (!queue.isEmpty()) {
			int current = queue.remove();
			
			int D = (current * 2) % 10000;
			int S = (current == 0) ? 9999 : current - 1;
			int L = (current % 1000) * 10 + (current / 1000);
			int R = (current % 10) * 1000 + (current / 10);
			
			if (!visited[D]) {
				visited[D] = true;
				command[D] = command[current] + "D";
				queue.add(D);
			}
			if (!visited[S]) {
				visited[S] = true;
				command[S] = command[current] + "S";
				queue.add(S);
			}
			if (!visited[L]) {
				visited[L] = true;
				command[L] = command[current] + "L";
				queue.add(L);
			}
			if (!visited[R]) {
				visited[R] = true;
				command[R] = command[current] + "R";
				queue.add(R);
			}
			
			if (visited[target]) return;
		}
	}
}