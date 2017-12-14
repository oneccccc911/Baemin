import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in))
        {
            int n = s.nextInt();

            int sPoint[] = new int[n];
            int ePoint[] = new int[n];

            for(int i = 0; i < n; i++)
            {
                int a = s.nextInt();
                int b = s.nextInt();

                //여기부터 작성해 주세요
                sPoint[i] = a;
                ePoint[i] = b;
            }
            int minPoint = sPoint[0];
            int maxPoint = ePoint[0];

            //전체구간 최솟값 찾기
            for(int i = 1 ; i < sPoint.length ; i++){
                if(sPoint[i] < minPoint) minPoint = sPoint[i];
            }

            //전체구간 최댓값 찾기
            for(int i = 1 ; i < ePoint.length ; i++){
                if(ePoint[i] > maxPoint) maxPoint = ePoint[i];
            }

            //짝수구간을 구별할 배열
            int arr[] = new int[maxPoint - minPoint + 1];

            for(int i = 0 ; i < arr.length ; i++){
                for(int j = 0; j < n ; j++){
                    if(i+minPoint >= sPoint[j] && i+minPoint <= ePoint[j]){
                        arr[i]++;
                    }
                }
            }

            int flag = 1; //괄호 열림 = 1, 닫힘 = 0;

            System.out.print("(-, ");
            for (int i = 0 ; i < arr.length ; i++){
                for (int j = 0; j < n ; j++){
                    if (arr[i]%2 == 0 && sPoint[j] == (minPoint + i) && flag == 0){
                        if(i != 0) System.out.print("[" + (minPoint + i) + ", ");
                        flag = 1;
                    }
                    else if (arr[i]%2 == 0 && ePoint[j] == (minPoint + i) && flag == 1){
                        if(i != arr.length -1) System.out.println((minPoint + i) + "]");
                        flag = 0;
                    }
                    else if (arr[i]%2 == 1 && ePoint[j] == (minPoint + i) && flag == 0){
                        System.out.print("(" + (minPoint + i) + ", ");
                        flag = 1;
                    }
                    else if (arr[i]%2 == 1 && sPoint[j] == (minPoint + i) && flag == 1){
                        System.out.println((minPoint + i) + ")");
                        flag = 0;
                    }
                }
            }
            System.out.print("+)");

        }
    }
}
