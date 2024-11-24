import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NC = br.readLine().split(" ");
        int N = Integer.parseInt(NC[0]);
        int C = Integer.parseInt(NC[1]);
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        //이분탐색 시작
        int minLen = 1;
        int maxLen = 1_000_000_000;
        int result = 0;
        while(minLen <= maxLen) {
            int middle = (minLen + maxLen) / 2;
            //middle값으로 배치할 수 있는지 확인
            int count = 1;
            int lastPos = arr[0];
            for(int i = 1; i < N; i++) {
                if(arr[i] - lastPos >= middle) {
                    lastPos = arr[i];
                    count++;
                }
            }
            
            if(count >= C) {
                //해당 middle로 넣기 성공, 더 빡센 조건으로 시도
                minLen = middle + 1;
                result = middle;
            } else {
                //해당 middle로 넣기 실패, 더 완화된 조건으로 시도
                maxLen = middle - 1;
            }
        }
        
        //원하는 middle을 찾음
        System.out.print(result);
    }
}
