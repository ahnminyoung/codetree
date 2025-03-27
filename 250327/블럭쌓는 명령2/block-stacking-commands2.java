import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] arr = new int[N];
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            if(A == B){
                arr[A - 1] += 1;
            }else{
                for(int j = A - 1; j < B; j++){
                    arr[j] += 1;
                }
            }
        }
        int max = arr[0]; 
        for (int i = 1; i < arr.length; i++) { 
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.print(max);

        // Please write your code here.
    }
}