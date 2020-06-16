import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//https://codeforces.com/contest/1360
public class BuyingShovels {
    public static void main(String[] args) {	
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int m = scanner.nextInt();
        for (int i = 0 ; i < m; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(min(n, k));
        }
    }

    private static int min(int n, int k) {
        if (k >= n) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && n / i <= k) {
                return i;
            }
        }
        return -1;
    }
}