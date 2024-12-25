import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 데이터 입력
		String[] NM = br.readLine().split(" ");
		int plugHole = Integer.parseInt(NM[0]);
		int useCount = Integer.parseInt(NM[1]);
		String[] USES = br.readLine().split(" ");
		int[] uses = new int[useCount];
		for (int i = 0; i < useCount; i++) {
			uses[i] = Integer.parseInt(USES[i]) - 1;
		}
		
		// 계산 및 결과 출력
		int result = solution(plugHole, useCount, uses);
		System.out.print(result);
	}
	
	/*
	전체 플러그 바꾸는 횟수를 최소화 하려면 각 교체 상황에서 최선의 선택을 해야 한다.
	각 교체 상황에서의 최선의 선택은 미래에 가장 늦게 사용되는(또는 사용되지 않는) 플러그를 뽑는 것이다.
	 */
	private static int solution(int holeSize, int useCount, int[] uses) {
		int switchCount = 0;
		Set<Integer> multiTap = new HashSet<>();
		
		for (int i = 0; i < useCount; i++) {
			int current = uses[i];
			
			// 이미 멀티탭에 꽂혀있는 경우
			if (multiTap.contains(current)) {
				continue;
			}
			
			// 아직 비어있는 구멍 존재, 그냥 꼽기
			if (multiTap.size() < holeSize) {
				multiTap.add(current);
				continue;
			}
			
			// 비어있는 구멍도 없고, 이미 꽂혀있지도 않음 -> 뽑아서 바꿔줘야 함
			// 가장 나중에 사용되거나 더 이상 사용되지 않는 플러그 선택
			int plugToRemove = -1;
			int farthestUse = -1;
			for (int plug : multiTap) {
				int nextUse = Integer.MAX_VALUE;
				// 현재 플러그가 언제 사용되는지 조사
				for (int j = i + 1; j < useCount; j++) {
					if (uses[j] == plug) {
						nextUse = j;
						break;
					}
				}
				// 현재 플러그가 더 늦게 사용되는 플러그라면 업데이트
				if (nextUse > farthestUse) {
					farthestUse = nextUse;
					plugToRemove = plug;
				}
			}
			
			multiTap.add(current);
			multiTap.remove(plugToRemove);
			switchCount++;
		}
		
		return switchCount;
	}
}