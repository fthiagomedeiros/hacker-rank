import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, Map<Integer, Map<Integer, Integer>> adjList, int source) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            Map<Integer, Integer> adj = adjList.get(current);

            for (Integer e : adj.keySet()) {
                if ((distance[e] > distance[current] + 6) && visited.get(e) == null) {
                    distance[e] = distance[current] + 6;
                    queue.add(e);
                }
            }

            visited.put(current, true);
        }

        return distance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int numOfNodes = Integer.parseInt(nm[0]);

            int numOfEdges = Integer.parseInt(nm[1]);

            Map<Integer, Map<Integer, Integer>> list = new HashMap<>();

            for (int f = 1; f <= numOfNodes; f++) {
                list.put(f, new HashMap<>());
            }

            for (int j = 1; j <= numOfEdges; j++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = 6;
                if (list.get(u).get(v) == null) {
                    list.get(u).put(v, w);
                    list.get(v).put(u, w);
                } else if (w < list.get(u).get(v)) {
                    list.get(u).put(v, w);
                    list.get(v).put(u, w);
                }

            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(numOfNodes, numOfEdges, list, s);

            for (int i = 1; i < result.length; i++) {

                if (i == s) {
                    continue;
                }

                if (result[i] == 2147483647) {
                    result[i] = -1;
                }

                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
