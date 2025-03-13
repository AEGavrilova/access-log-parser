public class Range {
    public static boolean isInRange(int a, int b, int num) {
        return (num >= a && num <= b) || (num <= a && num >= b);
    }
    public static void main(String[] args) {
        System.out.println(isInRange(5,1,3));
    }
}
