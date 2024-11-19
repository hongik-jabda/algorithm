import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2 4
CAAB
ADCB
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] HW = br.readLine().split(" ");
		H = Integer.parseInt(HW[0]);
		W = Integer.parseInt(HW[1]);
		board = new char[H][W];
		for (int x = 0; x < H; x++) {
			String input = br.readLine();
			for (int y = 0; y < W; y++) {
				board[x][y] = input.charAt(y);
			}
		}
		
		boolean[] passedAlphabet = new boolean['Z' - 'A' + 1];
		passedAlphabet[board[0][0] - 'A'] = true;
		dfs(0, 0, 1, passedAlphabet);
		
		System.out.print(maxMoves);
	}
	
	public static int maxMoves = Integer.MIN_VALUE;
	public static char[][] board;
	public static int H;
	public static int W;
	
	public static int[] dx = new int[]{0, 0, 1, -1};
	public static int[] dy = new int[]{1, -1, 0, 0};
	
	public static void dfs(int x, int y, int moves, boolean[] passedAlphabet) {
		maxMoves = Math.max(maxMoves, moves);
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < H && 0 <= ny && ny < W && !passedAlphabet[board[nx][ny] - 'A']) {
				passedAlphabet[board[nx][ny] - 'A'] = true;
				dfs(nx, ny, moves + 1, passedAlphabet);
				passedAlphabet[board[nx][ny] - 'A'] = false;
			}
		}
	}
}
