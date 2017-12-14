import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in))
        {
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            int x3 = s.nextInt();
            int y3 = s.nextInt();
            int x4 = s.nextInt();
            int y4 = s.nextInt();
            int x5 = s.nextInt();
            int y5 = s.nextInt();
            int x6 = s.nextInt();
            int y6 = s.nextInt();

            //여기부터 작성해 주세요

            //우측 상단 x최댓값
            int maxX = x2;
            if(x4 > x6){
                if(x4 > maxX) maxX = x4;
            }
            else{
                if(x6 > maxX) maxX = x6;
            }

            //우측 상단 y최댓값
            int maxY = y2;
            if(y4 > y6){
                if(y4 > maxY) maxY = y4;
            }
            else{
                if(y6 > maxY) maxY = y6;
            }

            //전체를 포함하는 사각형 만들기
            int graph[][] = new int[maxX][maxY];

            for(int i = x1; i < x2; i++) {
                for(int j = y1; j < y2; j++) {
                    graph[i][j] = 1;
                }
            }

            for(int i = x3; i < x4; i++) {
                for(int j = y3; j < y4; j++) {
                    graph[i][j] = 0;
                }
            }

            for(int i = x5; i < x6; i++) {
                for(int j = y5; j < y6; j++) {
                    graph[i][j] = 0;
                }
            }

            int sum = 0;
            for(int i = x1; i < x2; i++) {
                for(int j = y1; j < y2; j++) {
                    sum += graph[i][j];
                }
            }
            System.out.println(sum);
        }
    }
}
