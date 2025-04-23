import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int max_t = 1000000;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] posA = new int[max_t + 1];
        int [] posB = new int[max_t + 1];

        //A의 위치계산
        int timeA = 1;
        for(int i = 0; i < n; i++){
            int v = sc.nextInt(); //속도
            int t = sc.nextInt(); //시간
            while(t-- > 0){
                posA[timeA] = posA[timeA - 1] + v;
                timeA++;//다음초로이동
            }
        }

           // --------------------------
        // B의 위치 계산
        // --------------------------
        int timeB = 1;
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            while (t-- > 0) {
                posB[timeB] = posB[timeB - 1] + v;
                timeB++;
            }
        }

            // --------------------------
        // 선두 바뀐 횟수 세기
        // --------------------------

        int leader = 0, ans = 0;
        for(int i = 1; i < timeA; i++) {
            if(posA[i] > posB[i]) {
                // 기존 리더가 B였다면
                // 답을 갱신합니다.
                if(leader == 2)
                    ans++;
                
                // 리더를 A로 변경합니다.
                leader = 1; 
            }
            else if(posA[i] < posB[i]) {
                // 기존 리더가 A였다면
                // 답을 갱신합니다.
                if(leader == 1)
                    ans++;
                
                // 리더를 B로 변경합니다.
                leader = 2; 
            }
        }
        System.out.print(ans);
        // Please write your code here.
    }
}