import java.io.*;
import java.util.StringJoiner;

class Main {
	
	private static int DAY;
	private static int[] STOCKS;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringJoiner sj = new StringJoiner("\n");
		int testcase = Integer.parseInt(br.readLine());
		
		while (testcase-- > 0) {
			// 데이터 입력
			DAY = Integer.parseInt(br.readLine());
			STOCKS = new int[DAY];
			String[] stocks = br.readLine().split(" ");
			for (int i = 0; i < DAY; i++) {
				STOCKS[i] = Integer.parseInt(stocks[i]);
			}
			
			// 계산 및 결과 추가
			long result = solution();
			sj.add(String.valueOf(result));
		}
		
		// 결과 출력
		System.out.print(sj);
	}
	
	/*
	전체 최대 이익은 각 날짜 최대 이익의 합이다.
	각 날짜 최대 이익은 각 날짜 이후 날짜 중 가장 주식이 높은 날짜에서 판 이익이다.
	 */
	private static long solution() {
		long result = 0;
		
		int maxStock = STOCKS[DAY - 1];
		for (int i = DAY - 2; i >= 0; i--) {
			if (maxStock < STOCKS[i]) {
				maxStock = STOCKS[i];
			} else {
				result += (maxStock - STOCKS[i]);
			}
		}
		
		return result;
	}
}