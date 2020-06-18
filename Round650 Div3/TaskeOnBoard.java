import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
public class TaskeOnBoard {
    public static void main(String[] args) {	
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            String str = scanner.next();
            int len = scanner.nextInt();
            int[] arr = new int[len];
            for (int j = 0 ; j < len; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(find(str, arr));
        }
    }
 
    private static String find(String str, int[] arr) {
        //arr[i] = 0 说明当前位子没有比这个数更大的了；
        //只需要给arr[i] = 0 的位置放最大的，其他的位置会变成 arr[j] -= abs(i - j);
        //然后pick up arr[i] = 0 直到 所有的index 都被assign
        //思想类似于拓扑排序
        Map<Character, Integer> dic = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!dic.containsKey((c))) {
                dic.put(c, 1);
            }
            else {
                dic.put(c, dic.get(c)+1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey()- a.getKey());
        for (Map.Entry<Character, Integer> entry : dic.entrySet()) {
            pq.offer(entry);
        }
        
 
        char[] strArr = new char[arr.length];
        boolean exist = false;
        while (!exist) {
            List<Integer> zeroindexs = new ArrayList<>();
            for (int i = 0 ; i < arr.length; i++) {
                if (arr[i] == 0) {
                    zeroindexs.add(i);
                }
            }
            if (zeroindexs.size() == 0) {
                break;
            }
            while (!pq.isEmpty() && pq.peek().getValue() < zeroindexs.size()) {
                pq.poll();
            }
 
            char key = pq.poll().getKey();
            for (int i : zeroindexs) {
                strArr[i] = key;
                arr[i] = -1;
            }
            //其他的位置会变成 arr[j] -= abs(i - j);
            for (int i = 0 ; i < arr.length; i++) {
                for (int j : zeroindexs) {
                    arr[i] -= Math.abs(i-j);
                }
            }
        }
        return new String(strArr);
    }
}