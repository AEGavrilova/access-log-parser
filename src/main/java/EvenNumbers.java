public class EvenNumbers {
    public static void main(String[] args) {
    String res = listNums(9);
    System.out.println(res);
}
    public static String listNums(int x) {
        String res = " ";
        for (int i = 0; i <= x; i+=2) {
            res += i + " ";
        }
        return res;
    }
}

