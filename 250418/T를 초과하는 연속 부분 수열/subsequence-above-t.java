import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        int cnt = 1;
        boolean found = false;
        for(int i = 1; i < n; i++){
            if((arr[i] > t && arr[i -1] > t) && (arr[i] > arr[i - 1])){
                cnt++;
                ans = Math.max(ans,cnt);
                 found = true;
            }else{
                cnt = 1;
            }
        }
         if (found) {
            System.out.print(ans);
        } else {
            System.out.print(0);
        }

    }
}