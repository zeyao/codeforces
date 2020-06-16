import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//https://codeforces.com/contest/1360
public class Polygon {
    public static void main(String[] args) {	
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int m = scanner.nextInt();
        while (m > 0) {
            int r = scanner.nextInt();
            char[][] mat = new char[r][r];
            for (int i = 0 ;i < r; i++) {
                String line = scanner.next();
                for (int j = 0 ; j < r; j++) {
                    mat[i][j] = line.charAt(j);
                    
                }
            }
            if (find(mat)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
            m--;
        }
    }

    private static boolean find(char[][] mat) {
        //从下右两行 bfs 找1 mark 2;
        //只可以上 左
        //不能右剩下的1；

        int[][] dirs = {{-1, 0}, {0, -1}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (mat[i][n-1] == '1') {
                queue.offer(new int[]{i, n-1});
                mat[i][n-1] = '2';
            }
        }
        for (int j = 0; j < n; j++) {
            if (mat[m-1][j] == '1') {
                queue.offer(new int[]{m-1, j});
                mat[m-1][j] = '2';
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] dir : dirs) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                if (mat[x][y] == '1') {
                    queue.offer(new int[]{x, y});
                    mat[x][y] = '2';
                }
            }
        }

        for (int i = 0 ; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if (mat[i][j] == '1') {
                    return false;
                }
            }
        }
        return true;
    }
}