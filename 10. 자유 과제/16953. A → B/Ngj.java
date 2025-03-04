import java.io.*;
import java.util.*;

public class Ngj {
	public static int minValue;
	public static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		minValue = Integer.MAX_VALUE;
		flag = false;
		
		BtoA(b, a, 0);
		if (flag) {
			System.out.println(minValue+1);
		}
		else {
			System.out.println("-1");
		}
	}
	
	public static void BtoA(int b, int a, int count) {
		if (flag) {
			return;
		}
		if (b == a) {
			minValue = count;
			flag = true;
			return;
		}
		if (b < a) {
			return;
		}
		if (b % 2 == 0) {
			BtoA(b/2, a, count+1);
		}
		String strB = String.valueOf(b);
		
		if (strB.charAt(strB.length()-1) == '1') {
			BtoA((b-1)/10, a, count+1);
		}
	}
}
