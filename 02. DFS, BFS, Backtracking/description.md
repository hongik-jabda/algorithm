# 그래프 생성 - 이중 인접 리스트

```java
class Graph {
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // 무방향 그래프
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
    }
}
```

# DFS - 깊이 우선 탐색

```java
class GraphDFS {
    private List<List<Integer>> adjList;
    private boolean[] visited;

    public GraphDFS(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[vertices];
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // 무방향 그래프
    }

    public void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.print("DFS 방문 순서: ");
        graph.dfs(0); // 시작 정점
    }
}
```

# BFS - 너비 우선 탐색

```java
class GraphBFS {
    private List<List<Integer>> adjList;
    private boolean[] visited;

    public GraphBFS(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[vertices];
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.print("BFS 방문 순서: ");
        graph.bfs(0); // 시작 정점
    }
}
```

# 백트래킹(Backtracking)

1. DFS를 사용
2. 가지치기
3. 다시 되돌아가서 탐색

```java
class GraphAllPaths {
    private List<List<Integer>> adjList;

    public GraphAllPaths(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // 무방향 그래프
    }

    // 모든 경로를 찾는 메서드
    public void findAllPaths(int start, int end) {
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[adjList.size()];
        path.add(start);
        findAllPathsUtil(start, end, visited, path);
    }

    private void findAllPathsUtil(int current, int end, boolean[] visited, List<Integer> path) {
        if (current == end) {
            System.out.println(path);  // 경로 출력
            return;
        }

        visited[current] = true; //방문 표시 

        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                path.add(neighbor); //경로에 추가 
                findAllPathsUtil(neighbor, end, visited, path);
                path.remove(path.size() - 1);  // 백트래킹: 경로에서 제거
            }
        }

        visited[current] = false;  // 다른 경로를 위해 방문 표시 해제
    }

    public static void main(String[] args) {
        GraphAllPaths graph = new GraphAllPaths(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("0에서 3까지의 모든 경로:");
        graph.findAllPaths(0, 3);
    }
}
```

# 문제

10819

1987
