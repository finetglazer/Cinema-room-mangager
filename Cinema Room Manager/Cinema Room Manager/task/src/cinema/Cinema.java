package cinema;
import java.util.Scanner;

public class Cinema {
    public static void 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row= scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int col = scanner.nextInt();
        int[][] mt = new int[105][105];
        System.out.println();
        System.out.println("Cinema:");
        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= col * 2; j++){
                if(i==0){
                    if(j==0){
                        mt[i][j] = -1;
                    } else if(j%2 == 0){
                        mt[i][j] = j/2;
                    } else {
                        mt[i][j] = -1;
                    }

                } else {
                    if (j==0) {
                        mt[i][j] = i;
                    } else {
                        if(j%2==0) {
                            mt[i][j] = 0;
                        } else {
                            mt[i][j] = -1;
                        }
                    }
                }
            }

        }
        for (int i = 0; i <= row; i++) {
            for (int j=0; j <= col * 2; j++) {
                if (mt[i][j] == -1) {
                    System.out.print(" ");
                } else if(mt[i][j] == 0){
                    System.out.print("S");
                } else {
                    System.out.print(mt[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("Enter a row number:");
        int dy = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int dx = scanner.nextInt();
        System.out.println();
        int ans = 0;
        if (row * col > 60) {
            ans = dy <= row / 2 ? 10 : 8;
        } else {
            ans = 10;
        }
        System.out.println("Ticket price: $" + ans);
        System.out.println();
        mt[dy][dx * 2] = -2;
        System.out.println("Cinema:");
        for (int i = 0; i <= row; i++) {
            for (int j=0; j <= col * 2; j++) {
                if (mt[i][j] == -1) {
                    System.out.print(" ");
                } else if(mt[i][j] == 0){
                    System.out.print("S");
                } else if (mt[i][j] == -2) {
                    System.out.print("B");
                } else {
                    System.out.print(mt[i][j]);
                }
            }
            System.out.println();
        }
    }

}
