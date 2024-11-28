import java.util.*;
import java.io.*;

class Main {
	
	public static class Pokemon {
		public String name;
		public int number;
		
		public Pokemon(String name, int number) {
			this.name = name;
			this.number = number;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		List<Pokemon> pokemonSortByNumber = new ArrayList<>();
		List<Pokemon> pokemonSortByName = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			Pokemon pokemon = new Pokemon(br.readLine(), i);
			pokemonSortByNumber.add(pokemon);
			pokemonSortByName.add(pokemon);
		}
		pokemonSortByNumber.sort(Comparator.comparing(pokemon -> pokemon.number));
		pokemonSortByName.sort(Comparator.comparing(pokemon -> pokemon.name));
		
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (Character.isDigit(input.charAt(0))) {
				// 도감 번호로 입력이 주어진 경우
				int targetNumber = Integer.parseInt(input);
				int start = 0;
				int end = N - 1;
				while(start <= end) {
					int middle = (start + end) / 2;
					Pokemon currentPokemon = pokemonSortByNumber.get(middle);
					if (currentPokemon.number == targetNumber) {
						answer.append(currentPokemon.name).append("\n");
						break;
					} else if (currentPokemon.number < targetNumber) {
						start = middle + 1;
					} else {
						end = middle - 1;
					}
				}
			} else {
				// 이름으로 입력이 주어진 경우
				String targetName = input;
				int start = 0;
				int end = N - 1;
				while(start <= end) {
					int middle = (start + end) / 2;
					Pokemon currentPokemon = pokemonSortByName.get(middle);
					if (currentPokemon.name.compareTo(targetName) == 0) {
						answer.append(currentPokemon.number).append("\n");
						break;
					} else if (currentPokemon.name.compareTo(targetName) < 0) {
						start = middle + 1;
					} else {
						end = middle - 1;
					}
				}
			}
		}
		
		System.out.print(answer);
	}
}