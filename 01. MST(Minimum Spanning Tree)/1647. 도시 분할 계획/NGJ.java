import java.io.*;
import java.util.*;

public class NGJ {
	
	public static int N;
	public static int M;
	public static int[][] graph;
	public static int[] parent;
	public static int cost;
	public static int last;
	
	public static class com implements Comparator<int[]> {
		@Override
		public int compare(int[] arr1, int[] arr2) {
			return Integer.compare(arr1[2], arr2[2]);
		}
	}
			
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/mst1/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[M][3];
		parent = new int[N];
		cost = 0;
		last = 0;
		HashMap<Integer, Integer> nodeMap = new HashMap<>();
		int ix = 0;
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
			if (nodeMap.containsKey(graph[i][0])) {
				graph[i][0] = nodeMap.get(graph[i][0]);
			}
			else {
				nodeMap.put(graph[i][0], ix);
				graph[i][0] = ix;
				ix++;
			}
			if (nodeMap.containsKey(graph[i][1])) {
				graph[i][1] = nodeMap.get(graph[i][1]);
			}
			else {
				nodeMap.put(graph[i][1], ix);
				graph[i][1] = ix;
				ix++;
			}
		}
		
		for (int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		Arrays.sort(graph, new com());
		
		for (int i=0; i<M; i++) {
			int[] cur = graph[i];
			int nodeA = cur[0];
			int nodeB = cur[1];
			int parentA = find(nodeA);
			int parentB = find(nodeB);
			if (parentA != parentB) {
				union(parentA, parentB);
				cost += cur[2];
				last = cur[2];
			}
		}
		
		System.out.println(cost-last);
		
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
