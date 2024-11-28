import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	
	private static int X;
	private static int Y;
	
	private static final int[] dx = new int[]{0, 0, 1, -1};
	private static final int[] dy = new int[]{1, -1, 0, 0};
	
	private static int[][] box;
	
	private static int addedTomatoCount = 0;
	
	public static class Tomato {
		
		public int ripenDay;
		public int x;
		public int y;
		
		public Tomato(int ripenDay, int x, int y) {
			this.ripenDay = ripenDay;
			this.x = x;
			this.y = y;
		}
		
		public List<Tomato> getNextTomatos() {
			List<Tomato> nextTomatos = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < X && 0 <= ny && ny < Y && box[nx][ny] == 0) {
					nextTomatos.add(new Tomato(ripenDay + 1, nx, ny));
					box[nx][ny] = 1;
					addedTomatoCount++;
				}
			}
			return nextTomatos;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Tomato)) return false;
			Tomato tomato = (Tomato) o;
			return ripenDay == tomato.ripenDay && x == tomato.x && y == tomato.y;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(ripenDay, x, y);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] XY = br.readLine().split(" ");
		X = Integer.parseInt(XY[1]);
		Y = Integer.parseInt(XY[0]);
		
		box = new int[X][Y];
		
		int tomatoCountToAdd = 0;
		Queue<Tomato> ripenTomatos = new LinkedList<>();
		for (int i = 0; i < X; i++) {
			String[] inputs = br.readLine().split(" ");
			for (int j = 0; j < Y; j++) {
				int input = Integer.parseInt(inputs[j]);
				box[i][j] = input;
				if (input == 1) {
					ripenTomatos.offer(new Tomato(0, i, j));
				}
				if (input == 0) {
					tomatoCountToAdd++;
				}
			}
		}
		
		int day = 0;
		while(!ripenTomatos.isEmpty()) {
			Tomato currentTomato = ripenTomatos.poll();
			List<Tomato> nextTomatos = currentTomato.getNextTomatos();
			for (Tomato nextTomato : nextTomatos) {
				day = Math.max(nextTomato.ripenDay, day);
				ripenTomatos.offer(nextTomato);
			}
		}
		
		if (addedTomatoCount == tomatoCountToAdd) {
			System.out.print(day);
		} else {
			System.out.print(-1);
		}
	}
}