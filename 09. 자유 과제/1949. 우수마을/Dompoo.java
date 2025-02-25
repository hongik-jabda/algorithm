import java.io.*;
import java.util.*;

public class 우수마을 {
    
    static int N;
    static int[] population;
    static Set<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        population = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        
        tree = new HashSet[N + 1];
        
        for (int i = 1; i <= N; i++) {
            tree[i] = new HashSet<>();
        }
        
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        
        
        
        
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        
        dfs(1);
        
        // A마을 선태갛는게 이득? 안선택하는게이득?
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    
    static void dfs(int node) {
        visited[node] = true;
        
        dp[node][1] = population[node];
        dp[node][0] = 0;
        
        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
                
                // 현재 마을을 선택하지 않은 경우, 인접 마을은 포함될 수도 있음
                dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                
                // 현재 마을을 선택한 경우, 인접 마을은 포함되지 않아야 함
                dp[node][1] += dp[child][0];
            }
        }
    }
}
