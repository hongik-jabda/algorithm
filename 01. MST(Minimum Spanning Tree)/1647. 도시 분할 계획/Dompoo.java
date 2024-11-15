import java.util.*;
import java.io.*;

class Dompoo {
	
	public static class Path implements Comparable<Path> {
		public int from;
		public int to;
		public int cost;
		
		public Path(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Path o) {
			return this.cost - o.cost;
		}
	}
	
	private static int[] parent;
	
	public static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	public static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		List<Path> paths = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String[] ABC = br.readLine().split(" ");
			paths.add(new Path(
					Integer.parseInt(ABC[0]),
					Integer.parseInt(ABC[1]),
					Integer.parseInt(ABC[2])
			));
		}
		
		Collections.sort(paths); //유지비 낮은 순 정렬
		
		int pathIndex = 0;
		int totalCost = 0;
		int connectionCount = 0;
		while(connectionCount != N - 2) {
			Path path = paths.get(pathIndex++);
			if (find(path.from) != find(path.to)) {
				union(path.from, path.to);
				totalCost += path.cost;
				connectionCount++;
			}
		}
		
		System.out.print(totalCost);
	}
}