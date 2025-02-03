import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    // 공백단위로 읽어들임
        
        int N = Integer.parseInt(st.nextToken());    // 읽어들인 N,M을 Integer로
        int M = Integer.parseInt(st.nextToken());
        // 오버플로우 방지를 위해 long으로 선언
        long result = 0;    // 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수
        long[] S = new long[N+1];    // 합배열
        long[] count = new long[M];    // 같은 나머지의 인덱스 카운트
        // 예를 들어 나머지 1인 애들끼리, 0인 애들끼리
        
        st = new StringTokenizer(br.readLine());
        S[0] = 0;
        for (int i=1; i<N+1; i++) {
            // 누적합 저장
            S[i] = (S[i-1] + Integer.parseInt(st.nextToken())) % M;
            if (S[i]==0) {
                result++;    // 누적합이 M으로 나누어떨어질 경우 바로 추가
            }
            count[(int)S[i]]++;
        }
        for (int i=0; i<M; i++) {
            if (count[i] > 1) {
                // combination(C) 계산 (count[i]개 중 두 개 뽑는 경우의 수)
                result += (count[i] * (count[i]-1)/2);
            }
        }
        System.out.println(result);
    }
}
