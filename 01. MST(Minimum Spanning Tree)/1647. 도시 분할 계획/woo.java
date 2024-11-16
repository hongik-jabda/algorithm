import java.util.Scanner;
import java.util.Arrays;


public class Main {
    static int V, E;
    static int[][] graph;
    static int[] parent;
    static int max1;
    static int final_cost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        if (V<1||V>100000||E<0||E>1000000){
            return;
        }
        graph = new int[E][3];
        for (int i = 0; i < E; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
            graph[i][2] = sc.nextInt();
            if (!(graph[i][2]>=1&&graph[i][2]<=1000)) return;
            sc.nextLine();
        }

        parent = new int[V];

        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        max1 = 0;
        for (int i = 0; i < E; i++) {
            if (find(graph[i][0]-1) != find(graph[i][1]-1)) {
                union(graph[i][0] - 1, graph[i][1] - 1);
                final_cost += graph[i][2];
                if (max1<graph[i][2]) max1 = graph[i][2];
            }
        }

        final_cost -= max1;
        System.out.println(final_cost);
        sc.close();
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);    // 재귀함수
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b)
            parent[a] = b; // 더 작은 걸로.
        else
            parent[b] = a;
    }
}
