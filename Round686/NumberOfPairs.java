import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class NumberOfPairs {
    //wrong answer
    public static void main(String[] args) {	
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int m = scanner.nextInt();
        for (int i = 0 ; i < m; i++) {
            int n = scanner.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                list.add(new int[]{a, b});
            }
            int res = find(list);
            System.out.println(res);
            total = 0;
        }
    }
    static int total = 0;
    private static int find(List<int[]> list) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] s : list) {
            int node1 = s[0];
            int node2 = s[1];
            if (!graph.containsKey(node1)) {
                graph.put(node1, new ArrayList<>());
            }
            if (!graph.containsKey(node2)) {
                graph.put(node2, new ArrayList<>());
            }
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        //dfs from start to end
        int max = 0;
        for (int key : graph.keySet()) {
            Set<Integer> visited = new HashSet<>();
            visited.add(key);
            dfs(graph, key, visited, 0);
            max = Math.max(max, total);
            total = 0;
        }
        return max;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited, int depth) {
        if (visited.size() == graph.size()) {
            return;
        }
        List<Integer> adj = graph.get(start);
        for (Integer next : adj) {
            if (visited.contains(next)) {
                continue;
            }
            visited.add(next);
            total += depth + 1;
            dfs(graph, next, visited, depth+1);
            visited.remove(next);
        }
    }
}
