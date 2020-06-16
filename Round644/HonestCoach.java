import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//https://codeforces.com/contest/1360
public class HonestCoach {
    public static void main(String[] args) {	
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            int m = scanner.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(minDif(arr));
        }
    }

    private static int minDif(int[] arr) {
        Arrays.sort(arr);
        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            dif = Math.min(dif, arr[i+1]- arr[i]);
        }
        return dif;
    }
}