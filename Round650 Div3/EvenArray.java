import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//https://codeforces.com/contest/1367/problem/B
public class EvenArray {
    public static void main(String[] args) {	
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            int m = scanner.nextInt();
            int[] arr = new int[m];
            for (int j = 0 ; j < m; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(find(arr));
        }
    }

    private static int find(int[] arr) {
        //In one move, you can take any two elements of the array and swap them
        //find mind swap to make i % 2 =  arr[i] % 2;
        int even = 0;
        int odd = 0;
        for (int i = 0 ; i < arr.length; i++) {
            if (i % 2 == arr[i] % 2) {
                continue;
            }
            if (i % 2 == 1) {
                even++;
            }
            else {
                odd++;
            }
        }

        if (even != odd) {
            return -1;
        }
        return even;
    }
}