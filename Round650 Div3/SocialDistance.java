import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//https://codeforces.com/contest/1367/problem/C
public class SocialDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            int a = scanner.nextInt();
            int k = scanner.nextInt();
            String str = scanner.next();
            System.out.println(ans(str, k));
        }
    }

    private static int ans(String str, int k) {
        //当右指针是0；并且right - left - 1 == k,  说明右指针到左之间没有1，那么可以当作0 -> 1;  count++;
        //left -> right;
        //右指针继续，现在左指针是之前count+1的那个 右指针， 如果 right -> left 没有到 K distance right 就遇到了1 说明之前加的不算数了
        char[] arr = str.toCharArray();
        int count = 0;
        int left = -1 * k - 1;
        for (int right = 0 ; right < arr.length; right++) {
            if (arr[right] == '0') {
                if (right - left - 1 == k) {
                    count++;
                    left = right;
                }
            }
            else { //arr[right] == '1'
                if (left >= 0 && arr[left] == '0' && right - left - 1 < k) {
                    count--;
                }
                left = right;
            }
        }
        return count;
    }
}