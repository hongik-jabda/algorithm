import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
6
20 1 15 8 4 10
 */
public class Main {
	
	public static int maxResult = Integer.MIN_VALUE;
	public static int N;
	public static int[] arr;
	public static boolean[] used;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		used = new boolean[N];
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		
		int[] scrambledArr = new int[N];
		scrambleAndCalculate(scrambledArr, 0);
		
		System.out.print(maxResult);
	}
	
	public static void scrambleAndCalculate(int[] scrambledArr, int scrambleIndex) {
		if (scrambleIndex == N) {
			// 다 섞였다면 해당 배열에 대하여 값을 구하고, 최대값을 업데이트하기
			maxResult = Math.max(calculate(scrambledArr), maxResult);
		} else {
			// 덜 섞였다면 더 섞기
			for (int i = 0; i < N; i++) {
				if (!used[i]) {
					scrambledArr[scrambleIndex] = arr[i];
					used[i] = true;
					scrambleAndCalculate(scrambledArr, scrambleIndex + 1);
					used[i] = false;
				}
			}
		}
	}
	
	private static int calculate(int[] scrambledArr) {
		int result = 0;
		for (int i = 0; i < N - 1; i++) {
			result += Math.abs(scrambledArr[i] - scrambledArr[i + 1]);
		}
		return result;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
6
20 1 15 8 4 10
 */
public class Main {
	
	public static int maxResult = Integer.MIN_VALUE;
	public static int N;
	public static int[] arr;
	public static boolean[] used;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		used = new boolean[N];
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		
		int[] scrambledArr = new int[N];
		scrambleAndCalculate(scrambledArr, 0);
		
		System.out.print(maxResult);
	}
	
	public static void scrambleAndCalculate(int[] scrambledArr, int scrambleIndex) {
		if (scrambleIndex == N) {
			// 다 섞였다면 해당 배열에 대하여 값을 구하고, 최대값을 업데이트하기
			maxResult = Math.max(calculate(scrambledArr), maxResult);
		} else {
			// 덜 섞였다면 더 섞기
			for (int i = 0; i < N; i++) {
				if (!used[i]) {
					scrambledArr[scrambleIndex] = arr[i];
					used[i] = true;
					scrambleAndCalculate(scrambledArr, scrambleIndex + 1);
					used[i] = false;
				}
			}
		}
	}
	
	private static int calculate(int[] scrambledArr) {
		int result = 0;
		for (int i = 0; i < N - 1; i++) {
			result += Math.abs(scrambledArr[i] - scrambledArr[i + 1]);
		}
		return result;
	}
}
