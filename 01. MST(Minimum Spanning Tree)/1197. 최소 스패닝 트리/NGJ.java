import java.io.*;
import java.util.*;

public class NGJ {
	
	public static int V;
	public static int E;
	public static int[][] graph;
	public static int[] parent;
	public static int cost;
	
	public static class com implements Comparator<int[]> {
		@Override
		public int compare(int[] arr1, int[] arr2) {
			return Integer.compare(arr1[2], arr2[2]);
		}
	}
			
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/mst2/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new int[E][3];
		parent = new int[V];
		cost = 0;
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken()) - 1;
			graph[i][1] = Integer.parseInt(st.nextToken()) - 1;
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<V; i++) {
			parent[i] = i;
		}
		
		Arrays.sort(graph, new com());
		
		for (int i=0; i<E; i++) {
			int[] cur = graph[i];
			int nodeA = cur[0];
			int nodeB = cur[1];
			int parentA = find(nodeA);
			int parentB = find(nodeB);
			if (parentA != parentB) {
				union(parentA, parentB);
				cost += cur[2];
			}
		}
		
		System.out.println(cost);
		
	}
	
	public static int find(int node) {
		if (parent[node] == node) {
			return node;
		}
		return parent[node] = find(parent[node]);
	}
	
	public static void union(int nodeA, int nodeB) {
		if (nodeA < nodeB) {
			parent[nodeB] = nodeA;
		}
		else {
			parent[nodeA] = nodeB;
		}
	}
}
