import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 원소 개수
        int t = sc.nextInt();   // 기준값

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;   // 최장 길이
        int len = 0;   // 현재 구간 길이

        for (int x : arr) {
            if (x > t) {    // 조건 충족 → 구간 계속
                len++;
                ans = Math.max(ans, len);
            } else {        // 조건 깨짐 → 구간 종료
                len = 0;
            }
        }

        System.out.print(ans);  // ans==0이면 조건 만족 구간이 없음
    }
}