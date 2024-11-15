import java.util.*;
import java.io.*;

class Dompoo {
	
	public static class Edge implements Comparable<Edge> {
		public int from;
		public int to;
		public int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
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
		int V = Integer.parseInt(NM[0]);
		int E = Integer.parseInt(NM[1]);
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			String[] ABC = br.readLine().split(" ");
			edges.add(new Edge(
					Integer.parseInt(ABC[0]),
					Integer.parseInt(ABC[1]),
					Integer.parseInt(ABC[2])
			));
		}
		
		Collections.sort(edges); //유지비 낮은 순 정렬
		
		int edgeIndex = 0;
		int addedEdgeCount = 0;
		int totalCost = 0;
		while(addedEdgeCount != V - 1) {
			Edge path = edges.get(edgeIndex++);
			if (find(path.from) != find(path.to)) {
				union(path.from, path.to);
				totalCost += path.cost;
				addedEdgeCount++;
			}
		}
		
		System.out.print(totalCost);
	}
}