import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dompoo {
	/*
	  1 2 3 1 2
	  0 1 3 6 7 9
	  1 0 0 1 0
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		long[] nujeokhapRemain = new long[M];
		nujeokhapRemain[0] = 1;
		
		long nujeokhap = 0;
		String[] ARR = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nujeokhap = (nujeokhap + Integer.parseInt(ARR[i])) % M;
			nujeokhapRemain[(int) nujeokhap]++;
		}
		
		long count = 0;
		for (int i = 0; i < M; i++) {
			count += ((nujeokhapRemain[i] * (nujeokhapRemain[i] - 1)) / 2);
		}
		
		System.out.print(count);
	}
}
