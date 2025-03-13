public class Divider {
    public static boolean isDivisor (int a, int b){
        return a % b == 0 || b % a == 0;
    }
    public static void main(String[] args) {
        System.out.println(isDivisor(2,15));
    }
}
