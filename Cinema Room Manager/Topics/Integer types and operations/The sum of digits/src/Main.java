import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int num = scanner.nextInt();
        int ans = 0;
        ans += num%10;
        num/=10;
        ans += num % 10;
        num /= 10;
        ans+=num%10;
        System.out.println(ans);
    }
}
