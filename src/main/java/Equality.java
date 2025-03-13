public class Equality {
    public static boolean isEqual (int a, int b, int c){
        return (a == b) && (a == c);
    }
    public static void main(String[] args) {
        System.out.println(isEqual(3,3,3));
    }
}
