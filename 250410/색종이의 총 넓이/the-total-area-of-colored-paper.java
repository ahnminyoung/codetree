import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int offset = 100;
        int max_r = 200;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]cheked = new int [max_r + 1][max_r + 1];
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();

            x1[i] += offset;
            y1[i] += offset;
        }
        for(int i = 0; i < n; i++){
            for(int x = x1[i]; x < x1[i] + 8; x++){
                for(int y = y1[i]; y < y1[i] + 8; y++){
                    cheked[x][y]++;
                }
            }
        }

        int area = 0;
        for(int x = 0; x <= max_r; x++){
            for(int y = 0; y <= max_r; y++){
                if(cheked[x][y] >= 1){
                    area++;
                }
            }
        }
        
        System.out.print(area);

        // Please write your code here.
    }
}