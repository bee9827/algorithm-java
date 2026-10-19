import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int answer = 1;
        Deque<Pair> currNodes = new ArrayDeque<>();
        currNodes.add(new Pair(0, 0));
        int M = maps.length;
        int N = maps[0].length;

        boolean[][] visited = new boolean[M][N];

        while (!visited[M - 1][N - 1]) {
            currNodes = getNextNodes(maps, currNodes, visited);
            answer++;
            if(currNodes.isEmpty()) {
                answer = -1;
                break;
            }
        }


        return answer;
    }

    Deque<Pair> getNextNodes(int[][] maps, Deque<Pair> currNodes, boolean[][] visited) {
        Deque<Pair> nextNodes = new ArrayDeque<>();

        while (!currNodes.isEmpty()) {
            Pair node = currNodes.pop();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;

                if (outOfRange(nx, ny, visited) || visited[nx][ny] || maps[nx][ny] == 0) {
                    continue;
                }

                Pair next = new Pair(nx, ny);
                visited[nx][ny] = true;
                nextNodes.add(next);
            }
        }
        return nextNodes;
    }

    private boolean outOfRange(int nx, int ny, boolean[][] visited) {
        return nx < 0 || nx >= visited.length || ny < 0 || ny >= visited[0].length;
    }

    public static class Pair {
        final int x;
        final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
