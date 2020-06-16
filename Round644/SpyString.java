import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//https://codeforces.com/contest/1360

public class SpyString {
    public static void main(String[] args) {	
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            int m = scanner.nextInt();
            int len = scanner.nextInt();
            List<String> list = new ArrayList<>();
            for (int j = 0 ; j < m; j++) {
                String str = scanner.next();
                list.add(str);
            }
            System.out.println(spystring(list));
        }
    }

    private static String spystring(List<String> list) {
        //要找可替换和每个string 都差别都只有一个，把第一个String每个字母替换
        //然后和每一个比较，差别看是不是只有一个
        String first = list.get(0);
        char[] arr = first.toCharArray();
        for (int i = 0 ; i < arr.length; i++) {
            char tmp = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                boolean find = true;
                for (int j = 1; j < list.size(); j++) {
                    char[] next = list.get(j).toCharArray();
                    int diff = 0;
                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k] != next[k]) {
                            diff++;
                        }
                    }
                    if (diff > 1) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    return new String(arr);
                }
            }
            arr[i] = tmp;
        }
        return "-1";
    }
}