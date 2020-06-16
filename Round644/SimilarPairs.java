import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//https://codeforces.com/contest/1360
public class SimilarPairs {
    public static void main(String[] args) {	
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            int m = scanner.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = scanner.nextInt();
            }
            if (findPair(arr)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    private static boolean findPair(int[] arr) {
        int odd = 0;
        int even = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                even++;
            }
            else {
                odd++;
            }
        }
        if (odd % 2 == 0 && even % 2 == 0) {
            return true;
        }
        if (odd % 2 == 0 || even % 2 == 0) {
            return false;
        }
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] == 1) {
                return true;
            }
        }

        return false;
    }
}