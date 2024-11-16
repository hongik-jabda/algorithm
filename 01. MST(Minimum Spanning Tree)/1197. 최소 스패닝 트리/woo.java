import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int V, E;
    static int[] parent;
    static int final_cost = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        if (V < 1 || V > 10000 || E < 0 || E > 100000) {
            return;
        }

        // 간선 정보를 간단히 저장 (배열 대신 정렬 가능한 간선 클래스 사용)
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            if (!(cost >= -1000000 && cost <= 1000000)) return;
            edges[i] = new Edge(u - 1, v - 1, cost);
        }

        // 부모 배열 초기화
        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        // 간선을 비용 기준으로 정렬
        Arrays.sort(edges, (o1, o2) -> Integer.compare(o1.cost, o2.cost));

        // 크루스칼 알고리즘 실행
        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                final_cost += edge.cost;
            }
        }

        // 결과 출력
        System.out.println(final_cost);
        sc.close();
    }

    // find 함수 - 경로 압축 최적화
    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    // union 함수
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

    // 간선 정보를 저장하는 클래스
    static class Edge {
        int u, v, cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
}
