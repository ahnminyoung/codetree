import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int max_n = 100;
        int max_r = 200;
        int offset = 100;
        int [] x1 = new int [max_n];
        int [] x2 = new int [max_n];
        int []checked = new int [max_r + 1];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();

            x1[i] += offset;
            x2[i] += offset;
        }

        for(int i = 0; i < n; i++){
            for(int j = x1[i]; j < x2[i]; j++){
                checked[j]++;
            }
        }

        int max = 0;
        for(int i = 0; i <= max_r; i++){
            if(checked[i] > max){
                max = checked[i];
            }
        }
        System.out.print(max);
        

        // Please write your code here.
    }
}