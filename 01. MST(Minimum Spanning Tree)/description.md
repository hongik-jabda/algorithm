# MST(최소 신장 트리, Minimum Spanning Tree)

- 광케이블 깔기 문제 예시

![image](https://github.com/user-attachments/assets/adacb816-21fe-4fb3-ae13-9dd714030339)


- 노드: 아파트 빌딩
- 변 : 광선을 깔 수 있는 경로
- 변의 가중치: 거리 = 설비 가격
- 목표 : 모든 노드를 연결하는 변 찾기, but 비용은 최소

## 신장 트리(Spanning Tree)

- 어떤 그래프 안에 있는 모든 노드를 연결하는 트리
- 여러 개 있을 수 있음.

## MST 알고리즘 개념

- 순환(cycle) : 시작노드와 끝노드가 같은 것


- 컷(cut) : 어떤 그래프를 서로소(disjoint)인 두 하위 조합으로 나누는 행위
- 두 그래프를 두 그룹으로 분리
- 컷-세트(cut-set) : 두 그룹을 연결하는 변들의 집합

![image](https://github.com/user-attachments/assets/49db402d-445e-4c38-9a20-1269308e6907)


![image](https://github.com/user-attachments/assets/ef82ffc8-c701-406f-af0b-85d0c1247f58)


- 컷 세트에 가중치가 다른 여러 그래프가 있다면 MST에 포함되는 것은 가장 가중치가 작은 변

- 알고리즘 순서
1. 그래프에 있는 노드 중 한 변 확인
2. 이 변에 MST에 들어가야 하는 지 검사
    1. 이 때 cut property 사용
    2. 들어가야 하면 MST에 추가, 아니면 무시
3. MST 의 모든 변을 찾지 못했다면 1로 돌아감

어떤 알고리즘과 비슷한가?

## 크루스칼 알고리즘

1. 그래프의 각 노드마다 그 노드만 포함하는 트리 만듦
2. 모든 변을 가중치의 오름차순으로 정렬 → S배열
3. S가 비거나 MST가 완성될 때까지 다음 과정을 반복
    1. S에서 가중치가 가장 적은 변을 제거해서 고려
    2. 이변이 두 트리를 연결하는지 검사
        1. 그렇다면 MST에 추가
        2. 아니라면 버림

![image](https://github.com/user-attachments/assets/00516b93-18f1-414a-844e-83adfd2792d4)

