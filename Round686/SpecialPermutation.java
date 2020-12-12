import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class SpecialPermutation {
    public static void main(String[] args) {	
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int m = scanner.nextInt();
        for (int i = 0 ; i < m; i++) {
            int n = scanner.nextInt();
            int[] res = find(n);
            StringBuilder sb = new StringBuilder();
            for (int a : res) {
                sb.append(a).append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }

    private static int[] find(int n) {
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i-1] = n - i + 1;
        }
        if (n % 2 != 0) {
            int midIndex = n / 2;
            int tmp = res[0];
            res[0] = res[midIndex];
            res[midIndex] = tmp;
        }
        return res;
    }
}