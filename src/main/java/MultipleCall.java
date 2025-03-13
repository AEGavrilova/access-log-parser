import java.util.Scanner;

public class MultipleCall {
    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }
    public static void main(String[] args) {
        System.out.println(lastNumSum(lastNumSum(lastNumSum(lastNumSum(5, 11), 123), 14), 1));
    }
}
