import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int [] person = new int[n + 1];
        int[] penalizedPerson = new int[m];
       
       for(int i = 0; i < m; i++){
            penalizedPerson[i] = sc.nextInt();
        }

        int ans = -1;
        for(int i = 0; i < m; i++){
            int target = penalizedPerson[i];
            person[target]++;
            if(person[target] >= k){
                ans = target;
                break;
            }
        }

        System.out.print(ans);



        // Please write your code here.
    }
}