import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    static final int MAX = 1000;
    static int[][] graph = new int[MAX][MAX];
    static boolean[] visited = new boolean[MAX];

    static void bfs(int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for (int i = 0; i < n; i++) {
                if (graph[curr][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, start;
        System.out.print("Enter number of vertices: ");
        n = scanner.nextInt();
        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Enter starting vertex: ");
        start = scanner.nextInt();
        bfs(start, n);
        System.out.println();
    }
}
