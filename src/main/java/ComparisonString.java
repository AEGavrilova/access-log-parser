public class ComparisonString {
    public static void main(String[] args) {
        System.out.println(makeDecision(8, 7));

    }

    public static String makeDecision(int x, int y) {
        if (x < y) {
            return (x + " < " + y);
        }
        if (x > y) {
            return (x + " > " + y);
        }
        return (x + " == " + y);
    }
}
