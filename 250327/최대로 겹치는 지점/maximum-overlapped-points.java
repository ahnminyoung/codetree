import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 100;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        int [] checked = new int[max]; 
        for(int i = 0; i < n; i++){
            for(int j = start[i] - 1; j < end[i]; j++){
                checked[j]++;
            }
        }

        int value = 0;
        for(int i = 0; i < checked.length; i++){
            if(checked[i] > value){
                value = checked[i];
            }
        }
        System.out.print(value);


    
    }
}