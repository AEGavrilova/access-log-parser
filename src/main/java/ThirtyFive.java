public class ThirtyFive {
    public static void main(String[] args) {
        System.out.println(is35(8));
    }

    public static boolean is35(int x) {
        if ((x% 3 == 0) && (x % 5 == 0)){
            return false;
            }
        if ((x % 3 == 0) || (x % 5 == 0)) {
            return true;
        }
        return false;
    }
}