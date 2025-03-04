import java.util.*;
import java.io.*;

public class Ngj {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			long[] arr = new long[n];
			for (int i=0; i<n; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int i = 0;
			int j = n-1;
			long min = Long.MAX_VALUE;
			int count = 0;
			
			while (i < j) {
				long sum = arr[i] + arr[j];
				long diff = Math.abs(sum - k);
				//System.out.println(i + "번째 + " + j + "번째 " + sum);
				
				if (diff < min) {
					min = diff;
					count = 1;
				}
				else if (diff == min) {
					count++;
				}
				
				if (sum < k) {
					i++;
				}
				else {
					j--;
				}
			}
			System.out.println(count);
		}
		
	}
		
}
