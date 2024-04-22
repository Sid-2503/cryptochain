import java.util.Scanner;
import java.util.Stack;

public class DFS {
    static final int MAX = 1000;
    static int[][] graph = new int[MAX][MAX];
    static boolean[] visited = new boolean[MAX];

    static void dfs(int start, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                for (int i = 0; i < n; i++) {
                    if (graph[curr][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
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
        dfs(start, n);
        System.out.print("DFS traversal: ");
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
