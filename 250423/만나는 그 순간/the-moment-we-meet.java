import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         int MAX_T = 1000000;
         int n,m;
         int [] posA = new int[MAX_T +1];
         int [] posB = new int[MAX_T +1];

        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();

        int timeA = 1;
        for(int i = 0; i < n; i++){
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            while(t-- > 0){
                if(d == 'R'){
                    posA[timeA] = posA[timeA - 1] +1;
                }else{
                    posA[timeA] = posA[timeA - 1] - 1;
                }
                timeA++;
            }
        }

        int timeB = 1;
        for(int i = 0; i < m; i++){
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            while(t-- > 0){
                if(d == 'R'){
                    posB[timeB] = posB[timeB - 1] +1;
                }else{
                    posB[timeB] = posB[timeB - 1] - 1;
                }
                timeB++;
            }
        }
        
        int ans = -1;
        for(int i = 1; i < timeA; i++){
            if(posA[i] == posB[i]){
                ans = i;
                break;
            }
        }
        System.out.print(ans);
        
        // Please write your code here.
    }
}