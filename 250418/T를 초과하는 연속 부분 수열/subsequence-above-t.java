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
        int ans = 1;
        int cnt = 1;
        for(int i = 1; i < n; i++){
            if((arr[i] > t && arr[i -1] > t) && (arr[i] > arr[i - 1])){
                cnt++;
            }else{
                cnt = 1;
            }
            ans = Math.max(ans,cnt);
        }
        if(ans == 1){
            System.out.print(0); // 아무 연속 부분 수열 없음
        }else{
             System.out.print(ans);
        }

    }
}