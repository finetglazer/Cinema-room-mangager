package cinema;
import java.util.Scanner;

public class Cinema {
    public static void init(int[][] mt, int row, int col) {
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
    }
    public static void shows(int[][] mt, int row, int col) {
        System.out.println();
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
    public static void pick(int[][] mt, int row, int col) {
        Scanner scanner = new Scanner(System.in);
        int dx = 0;
        int dy = 0;
        boolean check = true;
        while (check) {
            System.out.println();
            System.out.println("Enter a row number:");
            dy = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            dx = scanner.nextInt();
            System.out.println();
            if (dx <= 0 || dx > col || dy <= 0 || dy > row) {
                System.out.println("Wrong input!");
                continue;
            } else if(mt[dy][dx * 2] == -2) {
                System.out.println("That ticket has already been purchased!");
                continue;
            }
            check = false;
        }
        int ans;
        if (row * col > 60) {
            ans = dy <= row / 2 ? 10 : 8;
        } else {
            ans = 10;
        }
        System.out.println("Ticket price: $" + ans);
        mt[dy][dx * 2] = -2;
    }
    public static void statis (int[][] mt, int row, int col) {
        System.out.println();
        int cnt = 0;
        int income = 0;
        int total = row * col <= 60 ? row * col * 10 : (row / 2) * col * 10 + (row - row / 2) * col * 8;
        for (int i=0; i <= row; i++) {
            for (int j = 0; j <= col * 2; j++) {
                if (mt[i][j] == -2) {
                    cnt ++;
                    if (row * col > 60) {
                        income += i <= row / 2 ? 10 : 8;
                    } else {
                        income += 10;
                    }
                }
            }
        }
        System.out.printf("Number of purchased tickets: %d%n", cnt);
        float percent = ((float)(cnt * 100) / (float)(row * col));
        System.out.printf("Percentage: %.2f", percent);
        System.out.println("%");
        System.out.printf("Current income: $%d%n", income);
        System.out.printf("Total income: $%d%n", total);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row= scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int col = scanner.nextInt();
        int[][] mt = new int[105][105];
        init(mt, row, col);
        int nums;
        boolean d = true;
        while (d) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            nums = scanner.nextInt();
            if (nums == 0) {
                d=false;
            } else if (nums == 1) {
                shows(mt, row, col);
            } else if (nums == 2) {
                pick(mt, row, col);
            } else {
                statis(mt, row, col);
            }
        }
    }

}
