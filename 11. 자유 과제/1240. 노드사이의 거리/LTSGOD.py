import sys

from collections import defaultdict, deque

def find_distance(n, edges, queries):

    tree = defaultdict(list)

    

    # 트리 구성

    for a, b, dist in edges:

        tree[a].append((b, dist))

        tree[b].append((a, dist))

    

    def bfs(start, end):

        queue = deque([(start, 0)])  # (현재 노드, 거리 합)

        visited = set()

        

        while queue:

            node, total_dist = queue.popleft()

            if node == end:

                return total_dist

            

            visited.add(node)

            

            for neighbor, distance in tree[node]:

                if neighbor not in visited:

                    queue.append((neighbor, total_dist + distance))

    

    results = []

    for a, b in queries:

        results.append(bfs(a, b))

    return results

if __name__ == "__main__":

    input = sys.stdin.read

    data = sys.stdin.read().split("\n")

    n, m = map(int, data[0].split())

    edges = [tuple(map(int, line.split())) for line in data[1:n]]

    queries = [tuple(map(int, line.split())) for line in data[n:n+m]]

    

    answers = find_distance(n, edges, queries)

    for ans in answers:

        print(ans)
