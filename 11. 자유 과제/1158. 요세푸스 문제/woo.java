import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        // N과 K 받아옴
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        Queue<Integer> q = new LinkedList<>();    // 큐로 구현
        
        // Queue에 1~N까지 offer(삽입)
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
     
        // < , , > 형태 만들기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        // Queue의 사이즈가 1일 때까지 반복
        while(q.size() != 1) {
            // K - 1번째까지는 처음에 있던 값을 맨 뒤로!!! -> 원모양처럼
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            // K번째 값은 poll(queue에서 삭제)한 후 출력
            sb.append(q.poll() + ", ");
        }
        
        // Queue의 사이즈가 1일 때는 단순히 poll(<>로 나옴)
        sb.append(q.poll() + ">");
 
        bw.write(sb.toString() + "\n");    // StringBuilder bw로 출력
        bw.flush();
        bw.close();
        br.close();
    }
}
