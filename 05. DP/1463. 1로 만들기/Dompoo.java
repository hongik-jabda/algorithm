import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		int[] dp = new int[number + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[number] = 0;
		
		for (int i = number; i >= 1; i--) {
			if (i % 3 == 0) {
				dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
			}
			if (i % 2 == 0) {
				dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
			}
			dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
		}
		
		System.out.print(dp[1]);
	}
}
