import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int offset = 1000;
        int max_r = 2000;
        int n = 2;
        int [] x1 = new int[n];
        int [] y1 = new int[n];
        int [] x2 = new int[n];
        int [] y2 = new int[n];

        int [][] checked = new int [max_r + 1][max_r + 1];

        for(int i = 0 ; i < n; i++){
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();

            x1[i] += offset;
            y1[i] += offset;
            x2[i] += offset;
            y2[i] += offset;
        }

        for(int i = 0; i < n; i++){
            for(int x = x1[i]; x < x2[i]; x++){
                for(int y = y1[i]; y < y2[i]; y++){
                    checked[x][y] = i + 1; //첫번째는 1로채우고 두번째는 2로채우기
                }
            }
        }

        int minX = max_r; 
        int maxX = 0; 
        int minY = max_r; 
        int maxY = 0;
        boolean firstRectExist = false;
        for(int x = 0; x <=max_r; x++){
            for(int y =0; y <=max_r; y++){
                if(checked[x][y] == 1) {
                    firstRectExist = true;
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }
        int area;
        if(!firstRectExist){
            area = 0;
        }else{
            area = (maxX - minX + 1) * (maxY - minY + 1);
        }
        System.out.print(area);

    }
}