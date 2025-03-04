import java.io.*;
import java.util.*;

public class Ngj {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		set.add(2);
		
//		for (int num=3; num<=N; num+=2) {
//			set.add(num);
//		}
		
//		for (int num=3; num<=N; num+=2) {
//			int tmp = num;
//			
//			while (tmp <= N) {
//				tmp += (2 * num);
//				if (set.contains(tmp)) {
//					set.remove(tmp);
//				}
//			}
//		}
		
		for (int num=3; num<=N; num+=2) {
			boolean check = false;
			for (int div=3; div<=Math.sqrt(num); div+=2) {
				if (num%div == 0) {
					check = true;
					break;
				}
			}
			if (!check) {
				set.add(num);
			}
		}
//		System.out.println(set);
		
		int[] arr = new int[set.size()];
		int ix = 0;
		
		for (int num: set) {
			arr[ix] = num;
			ix++;
		}
//		Arrays.sort(arr);
		
		int i = 0;
		int j = 0;
		int cur = arr[0];
		int count = 0;
		
		while (i <= j) {
			if (cur >= N) {
				if (cur == N) {
					count++;
				}
				cur -= arr[i];
				i++;
			}
			else {
				j++;
				if (j >= arr.length) {
					break;
				}
				cur += arr[j];
			}
		}
		System.out.println(count);
	}

}
