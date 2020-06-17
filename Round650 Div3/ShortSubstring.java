import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ShortSubstring {
    public static void main(String[] args) {	
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            System.out.println(find(str));
        }
    }

    private static String find(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length() - 1; i+=2) {
            sb.append(str.charAt(i));
        }
        sb.append(str.charAt(str.length()-1));
        return sb.toString();
    }
}