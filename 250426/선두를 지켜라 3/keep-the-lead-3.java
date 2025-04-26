import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = n * 1000;

        int [] posA = new int [max + 1];
        int [] posB = new int [max + 1];

        int timeA = 1;
        for(int i =  0; i < n; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();
            while(t-- > 0){
                posA[timeA] = posA[timeA - 1] + v;
                timeA++;
            }
        }

        int timeB = 1;
        for(int i =  0; i < m; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();
            while(t-- > 0){
                posB[timeB] = posB[timeB - 1] + v;
                timeB++;
            }
        }

        int leader = 0;
        int ans = 0;
        for(int i = 1; i < timeA; i++){
            int nowleader = 0;
            if(posA[i] > posB[i]){
                nowleader = 1;
            } else if(posA[i] < posB[i]) {
                nowleader = 2;
            }else{
                //동점
                nowleader = 0;
            }
            if(leader != nowleader){
                ans++;
                leader = nowleader;
            }
        }           
        System.out.print(ans);
    }
}