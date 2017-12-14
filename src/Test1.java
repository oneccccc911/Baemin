import java.util.Scanner;

public class Test1 {
    public static void main(String args[]){
        try(Scanner s = new Scanner(System.in))
        {
            int n = s.nextInt();
            int d = s.nextInt();
            int k = s.nextInt();
            int j = s.nextInt();

            //여기부터 작성해 주세요

            int baezzang[] = new int[n];
            int startP = 0; //시작점
            int tCount = 0;  //탈락자수
            int findCount = 0;

            if(d==1){
                //시계방향
                while(tCount != n-1){
                    //탈락자가 n-1명일 때까지
                    while(findCount < k) {
                        if(baezzang[(++startP)%n]==0) findCount++;
                    }
                    baezzang[startP % n] = 1;
                    tCount++;
                    findCount = 0;
                    k = k+j;
                }
            }
            else{
                //반시계방향
                while(tCount != n-1){
                    //탈락자가 n-1명일 때까지
                    while(findCount < k) {
                        if(startP == 0) startP = n;
                        if(baezzang[(--startP)%n]==0) findCount++;
                    }
                    baezzang[startP % n] = 1;
                    tCount++;
                    findCount = 0;
                    k = k+j;
                }
            }

            for(int i = 0 ; i < baezzang.length ; i++){
                if(baezzang[i] == 0){
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
