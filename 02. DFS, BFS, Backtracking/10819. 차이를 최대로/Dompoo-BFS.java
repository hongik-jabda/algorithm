import javax.sound.sampled.EnumControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
6
20 1 15 8 4 10
 */
public class Main {
	
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		
		Queue<ScarambledArr> queue = new LinkedList<>();
		
		queue.offer(new ScarambledArr(new int[N], new boolean[N], 0));
		int maxResult = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			ScarambledArr currentArr = queue.poll();
			System.out.println(currentArr);
			
			if (currentArr.scarmbleIndex == N) {
				maxResult = Math.max(currentArr.calculate(), maxResult);
			} else {
				for (int i = 0; i < N; i++) {
					if (!currentArr.isUsed[i]) {
						boolean[] isUsed = Arrays.copyOf(currentArr.isUsed, N);
						isUsed[i] = true;
						int[] numbers = Arrays.copyOf(currentArr.numbers, N);
						numbers[currentArr.scarmbleIndex] = arr[i];
						
						queue.offer(new ScarambledArr(
								numbers,
								isUsed,
								currentArr.scarmbleIndex + 1
						));
					}
				}
			}
		}
		System.out.print(maxResult);
	}
	
	public static class ScarambledArr {
		public final int[] numbers;
		public final boolean[] isUsed;
		public final int scarmbleIndex;
		
		public ScarambledArr(int[] numbers, boolean[] isUsed, int scarmbleIndex) {
			this.numbers = numbers;
			this.isUsed = isUsed;
			this.scarmbleIndex = scarmbleIndex;
		}
		
		public int calculate() {
			int result = 0;
			for (int i = 0; i < N - 1; i++) {
				result += Math.abs(numbers[i] - numbers[i + 1]);
			}
			return result;
		}
		
		@Override
		public String toString() {
			return "ScarambledArr{" +
					"numbers=" + Arrays.toString(numbers) +
					", isUsed=" + Arrays.toString(isUsed) +
					", scarmbleIndex=" + scarmbleIndex +
					'}';
		}
	}
}
