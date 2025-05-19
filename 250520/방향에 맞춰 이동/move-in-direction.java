import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, y= 0;
        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, -1, 0, 1};
        int nx, ny;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            if(direction == 'N'){
                y += dy[3] * distance;
            }else if(direction == 'E'){
                x += dx[0] * distance;
            }else if(direction == 'S'){
                y += dy[1] * distance;
            }else{
                x += dx[2] * distance;
            }
        }
        nx = x;
        ny = y;
        System.out.println(nx + " " + ny);
    }
}