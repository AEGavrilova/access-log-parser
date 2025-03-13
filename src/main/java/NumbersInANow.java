public class NumbersInANow {
    public static void main(String[] args) {
        String res = listNums(5);
        System.out.println(res);
    }
    public static String listNums(int x) {
        String res = " ";
        for (int i = 0; i <= x; i++) {
            res += i + " ";
        }
        return res;
    }
}
