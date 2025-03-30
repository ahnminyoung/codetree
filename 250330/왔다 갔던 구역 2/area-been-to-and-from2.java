import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] checked = new int [2001];
        int base = 1000;
        int pos = base;

        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            String dir = sc.next();

            if(dir.equals("L")){
                for (int j = pos - 1; j >= pos - count; j--) {
                    checked[j]++;
                }
                 pos -= count; 
            }else{
                //R일때
                for(int j = pos; j < pos + count; j++){
                    checked[j]++;
                }
                 pos += count;
            }
        }
        int answer = 0;
        for(int i = 0; i < checked.length; i++){
            if(checked[i] >= 2){
                answer++;
            }
        }

        System.out.println(answer);
    }
}