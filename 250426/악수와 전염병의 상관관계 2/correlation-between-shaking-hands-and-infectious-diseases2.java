import java.util.*;
public class Main {
    static class Meeting implements Comparable<Meeting> {
        int time;
        int x;
        int y;

        Meeting(int time, int x, int y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Meeting other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 개발자 수
        int K = sc.nextInt(); // 최대 전염 가능 약속 수
        int P = sc.nextInt(); // 최초 감염자 (1부터 시작)
        int T = sc.nextInt(); // 약속 수

        int[] infected = new int[N];    // 감염 여부 (0: 감염X, 1: 감염O)
        int[] canInfect = new int[N];    // 남은 전염 가능 횟수

        infected[P - 1] = 1;   // P번 개발자 감염
        canInfect[P - 1] = K;  // P번 개발자는 전염 가능 K회

        List<Meeting> meetings = new ArrayList<>();

        // 약속 정보 저장
        for (int i = 0; i < T; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            meetings.add(new Meeting(t, x, y));
        }

        // 시간순으로 정렬
        Collections.sort(meetings);

        // 약속 하나씩 처리
        for (Meeting meeting : meetings) {
            int x = meeting.x;
            int y = meeting.y;

            // 먼저 감염 전파
            if (infected[x] == 1 && canInfect[x] > 0 && infected[y] == 0) {
                infected[y] = 1;
                canInfect[y] = K; // 새로 감염된 사람도 K 세팅
            }
            if (infected[y] == 1 && canInfect[y] > 0 && infected[x] == 0) {
                infected[x] = 1;
                canInfect[x] = K; // 새로 감염된 사람도 K 세팅
            }

            // 그리고 약속 참여한 감염자들은 전염 가능 횟수 감소
            if (infected[x] == 1 && canInfect[x] > 0) {
                canInfect[x]--;
            }
            if (infected[y] == 1 && canInfect[y] > 0) {
                canInfect[y]--;
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(infected[i]);
        }
    }
}