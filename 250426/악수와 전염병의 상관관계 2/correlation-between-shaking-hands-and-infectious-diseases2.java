import java.util.*;
public class Main {
    static class Shake implements Comparable<Shake> {
        int time;
        int person1;
        int person2;
        
        public Shake(int time, int person1, int person2) {
            this.time = time;
            this.person1 = person1;
            this.person2 = person2;
        }

        @Override
        public int compareTo(Shake shake) {
            // 시간을 기준으로 오름차순으로 정렬합니다.
            return time - shake.time;
        }
    };

    public static void main(String[] args) {
        int MAX_T = 250;
        int MAX_N = 100;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();

        int[] shakeNum = new int[N];
        int[] infected = new int[N];

        infected[P - 1] = 1;

        List<Shake> shakes = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            shakes.add(new Shake(t, x, y));
        }

        Collections.sort(shakes);

        for (Shake shake : shakes) {
            int x = shake.person1;
            int y = shake.person2;

            // 감염 전파: 감염된 사람 -> 비감염자에게만
           if (infected[x] == 1) {
                shakeNum[x]++;
            }
            if (infected[y] == 1) {
                shakeNum[y]++;
            }


            // 악수한 감염자들의 전염 가능 횟수 감소
            if (infected[x] == 1 && shakeNum[x] <= K) {
                infected[y] = 1;
            }
            if (infected[y] == 1 && shakeNum[y] <= K) {
                infected[x] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(infected[i]);
        }
    }
}