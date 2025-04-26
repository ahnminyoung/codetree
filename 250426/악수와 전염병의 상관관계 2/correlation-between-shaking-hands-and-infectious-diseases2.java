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

        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();

        int[] infected = new int[N];
        int[] canInfect = new int[N];

        infected[P - 1] = 1;
        canInfect[P - 1] = K;

        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            meetings.add(new Meeting(t, x, y));
        }

        Collections.sort(meetings);

        for (Meeting meeting : meetings) {
            int x = meeting.x;
            int y = meeting.y;

            // 감염 전파: 감염된 사람 -> 비감염자에게만
            if (infected[x] == 1 && canInfect[x] > 0 && infected[y] == 0) {
                infected[y] = 1;
                canInfect[y] = K;
            }
            if (infected[y] == 1 && canInfect[y] > 0 && infected[x] == 0) {
                infected[x] = 1;
                canInfect[x] = K;
            }

            // 악수한 감염자들의 전염 가능 횟수 감소
            if (infected[x] == 1 && canInfect[x] > 0) {
                canInfect[x]--;
            }
            if (infected[y] == 1 && canInfect[y] > 0) {
                canInfect[y]--;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(infected[i]);
        }
    }
}