# 그리디 알고리즘(탐욕법, Greedy Algorithm) 은 무엇인가?

- **전체 최적의 값**을 구하기 위해 각 단계에서 할 수 있는 **부분 최적의 값**을 구하여 다음 단계에 적용하는 것
- 말로만 설명하면 어려우니, 직접 실습해보자.

## 노드에서 가장 합이 높은 방법을 구해보자

### 실제로 가장 높은 합

![실제 최대 합](<실제 최대 합.png>)

### 그리디 알고리즘을 통해 찾은 가장 높은 합

![그리디 최대 합](<그리디 최대 합.png>)

### 엥? 최대 값이 아니네요?

> 그렇다. 각 단계에서 최선이라고 생각하는 방법을 선택하는 것이다.
> 
> 때문에 사실 위 예시는 그리디 알고리즘을 적용하기 좋은 예시가 아니다. 왜냐하면 각 단계에서 **최적의 값**을 고르려고 해도, 그것이 **전체 최적의 값**이 아닐 수 있기 때문이다.
> 
> 그러면 그리디 알고리즘은 언제 적용하는 것이 좋을까?

## 그리디 알고리즘을 적용하는 기준

- 탐욕 선택 속성(Greedy Choice Property)
  - 각 단계에서 **최선의 선택**을 했을 때, 전체 문제에 대한 최적해를 구할 수 있는가?
  - 위 문제 같은 경우 각 단계에서 최선의 선택이 전체 문제에 대한 최선의 선택으로 이어지지 않는다. 따라서 그리디로 풀 수 없다.
- 최적 부분 구조(Optimal Structure)
  - 전체 문제가 **부분 문제의 최적해로 구성**될 수 있는가?

## 문제를 풀며 연습해보자.

- 연습 문제 : [회의실배정](https://www.acmicpc.net/problem/1931)
- 탐욕 선택 속성을 만족하는가? : 만족한다. 결론적으로 최대한 많은 회의를 듣고 싶은 거니까, 어떠한 시간 T에 대하여 가장 빨리 끝나는 회의를 선택하는 것이 최적이다.
- 최적 부분 구조를 만족하는가? : 만족한다. 어떠한 시간 T에 대하여 최대한 빨리 끝나는 회의를 듣고 난 후 시간이 T' 이라면, T'부터 다시 최대한 빨리 끝나는 회의를 선택하는 방식으로 구성할 수 있다.

```java
class Meeting implements Compareable<Meeting> {
	public final int start;
	public final int end;
	// ... 생성자

	// 끝나는 시간이 빠른 순으로 정렬, 같다면 시작 시간이 빠른 순으로 정렬
	@Override
	public int compareTo(Meeting o) {
		if(end != o.end) return end - o.end;
		return start - o.start;
	}
}

void run() {
	List<Meeting> meetings = new ArrayList<>();
	// meetings에 값을 넣는다.
	Collections.sort(meetings);
	/*
	1 4
	3 5
	0 6
	5 7
	3 8
	5 9
	6 10
	8 11
	8 12
	2 13
	12 14
	*/
	int count = 0;
	int lastEndTime = 0;
	for(Meeting meeting : meetings) {
		if(meeting.start >= lastEndTime) {
			count++;
			lastEndTime = meeting.end;
		}
	}
	System.out.print("정답 : " + count);
}
```

- 코드 자체는 정말 간단하다...
- 이 문제가 그리디 알고리즘이라는 것만 눈치챈다면 금방 풀 수 있다.
