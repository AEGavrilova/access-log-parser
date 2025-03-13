public class NumbersInReverse{
    public static void main(String[] args) {
        String res = listNums(5);
        System.out.println(res);
    }
    public static String listNums(int x) {
        String res = " ";
        for (int i = 5; i >= 0; i--) {
            res += i + " ";
        }
        return res;
    }
}

