import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int ans = 0;     // 최댓값
        int len = 0;     // 현재 연속 길이

        for (int i = 0; i < n; i++) {
            if (arr[i] > t) {               // t 초과인 경우
                if (len == 0) {
                    // 새 구간 시작
                    len = 1;
                } else if (arr[i] > arr[i - 1]) {
                    // 같은 구간에서 오름차순 유지
                    len++;
                } else {
                    // t는 넘지만 오름차순 깨짐 → 길이 1로 재시작
                    len = 1;
                }
            } else {
                // t 이하를 만나면 구간 종료
                len = 0;
            }
            ans = Math.max(ans, len);        // 최대값 갱신
        }

        System.out.print(ans);               // ans가 0이면 조건 만족 구간이 없음
    }
}