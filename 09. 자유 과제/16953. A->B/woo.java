import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int A = Integer.parseInt(st.nextToken());
       int B = Integer.parseInt(st.nextToken());

       int answer = 1;
       while (B != A) {  // A가 B가 될 때까지 반복문 실행
           if( B < A ) {  // B가 A보다 작아지면 변환 불가능 판단, 종료
               System.out.println(-1);
               return;
           }
           String str = String.valueOf(B);
           if(B % 2 == 0) {  // B의 마지막 숫자가 짝수라면
               B /= 2;  // 2로 나누기
           } 
           else if(str.charAt(str.length() - 1) == '1') {  // B의 마지막 숫자가 1이라면
               str = str.substring(0, str.length() - 1);  // 마지막 숫자 제거 후
               B = Integer.parseInt(str);  // 정수로 변환하여 다시 B에 저장
           } 
           else {
             // B의 마지막 숫자가 짝수도 아니고 1도 아니라면 불가능***********
               System.out.println(-1); 
               return;
           }
           answer++;
       }
    // 어떻게든, A는 맨 끝자리에 그대로 남아있을 수가 없음.
       System.out.println(answer);
   }
}
