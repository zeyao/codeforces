import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MinSquare {
    public static void main(String[] args) {	
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(findMinSquare(a, b));
        }
    }
    
    private static int findMinSquare(int a, int b) {
        if (a == b) return 2 * a * 2 * b;
        if (a < b) {
            int len = Math.max(2 * a, b);
            return len * len;
        }
        else {
            int len = Math.max(2 * b, a);
            return len * len;
        }
    }
}