import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
2 4
CAAB
ADCB
 */
public class Main {
	
	public static char[][] board;
	public static int H;
	public static int W;
	
	public static int[] dx = new int[]{0, 0, 1, -1};
	public static int[] dy = new int[]{1, -1, 0, 0};
	
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
		
		boolean[] used = new boolean[26];
		used[board[0][0] - 'A'] = true;
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(0, 0, used, 1));
		
		int maxMoves = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			Position currentPosition = queue.poll();
			maxMoves = Math.max(maxMoves, currentPosition.moves);
			for (Position nextPosition : currentPosition.getNextPositions()) {
				queue.offer(nextPosition);
			}
		}
		
		System.out.print(maxMoves);
	}
	public static class Position {
		public final int x;
		public final int y;
		public final boolean[] used;
		public final int moves;
		
		public Position(int x, int y, boolean[] used, int moves) {
			this.x = x;
			this.y = y;
			this.used = used;
			this.moves = moves;
		}
		
		public List<Position> getNextPositions() {
			ArrayList<Position> positions = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < H && 0 <= ny && ny < W && !used[board[nx][ny] - 'A']) {
					boolean[] newUsed = Arrays.copyOf(used, 26);
					newUsed[board[nx][ny] - 'A'] = true;
					positions.add(new Position(nx, ny, newUsed, moves + 1));
				}
			}
			return positions;
		}
	}
}
