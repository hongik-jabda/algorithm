import java.io.*;
import java.util.*;

public class 펠린드롬 {
    
    static int N;
    static int[] arr;
    static boolean[][] dp; // dp[i][j] i~j까지의 배열이 앞뒤똑?
    
    // 길이 1, 2짜리 앞뒤똑 구함
    // dp[i][i] = true
    // dp[1][2] => arr[1] == arr[2]
    //
    
    // 길이 3~ 앞뒤똑 구하고픔
    // dp[1][3]
    // dp[2][2] = true && arr[1] == arr[3]
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new boolean[N + 1][N + 1];
        
        fillDP();
        
        int M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] ? "1\n" : "0\n");
        }
        
        System.out.print(sb);
    }
    
    private static void fillDP() {
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }
        
        // 11 22 33
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        
        // 1~10
        // left = 1
        // right = 10
        // 2 9
        for (int len = 3; len <= N; len++) {
            for (int left = 1; left <= N - len + 1; left++) {
                int right = left + len - 1;
                if (arr[left] == arr[right] && dp[left + 1][right - 1]) {
                    dp[left][right] = true;
                }
            }
        }
    }
}
