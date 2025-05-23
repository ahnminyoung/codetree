import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int MAX_TIME = 1000000;
        int [] posA = new int[MAX_TIME + 1];
        int [] posB = new int[MAX_TIME + 1];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            while(t-- > 0){
                if(d == 'R'){
                    posA [timeA] = posA[timeA - 1] + 1;
                }else{
                    posA [timeA] = posA[timeA -1] - 1;
                }
                timeA++;
            }
    
        }

        int timeB = 1;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            while(t-- > 0) {
                if(d == 'R'){
                    posB[timeB] = posB[timeB - 1] + 1;
                }else{
                    posB[timeB] = posB[timeB - 1] - 1;
                }
                timeB++;
            }
        }

        if(timeA < timeB) {
            for(int i = timeA; i < timeB; i++) {
                posA[i] = posA[i - 1];
            }
        }
        else if(timeA > timeB) {
            for(int i = timeB; i < timeA; i++) {
                posB[i] = posB[i - 1];
            }
        }

        int cnt = 0;
        int timeMax = 0;
        if(timeA < timeB){
            timeMax = timeB;
        }else{
            timeMax = timeA;
        }

        for(int i = 1; i < timeMax; i++){
            if(posA[i] == posB[i] && posA[i - 1] != posB[i -1]){
                cnt++;
            }
        }
        System.out.print(cnt);

        
        // Please write your code here.
    }
}