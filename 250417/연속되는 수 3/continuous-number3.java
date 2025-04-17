import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int ans = 1;
        int cnt = 1;
        for(int i = 1; i < n; i++){
            if ((arr[i] < 0 && arr[i - 1] < 0) || (arr[i] > 0 && arr[i - 1] > 0)) {
                cnt++;
            } else {
                cnt = 1;  
            }
            ans = Math.max(ans,cnt);
        }
        System.out.print(ans);
    }
}