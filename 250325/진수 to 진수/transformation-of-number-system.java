import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        int value = 0;

        for(int i = 0; i < N.length(); i++){
            value = value * A + (N.charAt(i) - '0');
        }


        int cnt = 0;
        int [] result  = new int[20];
        while (value > 0) {
            result[cnt++] = value % B;
            value /= B;
        }
        for (int i = cnt - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }


}
