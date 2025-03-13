public class RightTriangle {
    public static void main(String[] args) {
        rightTriangle(4);
    }

    public static void rightTriangle(int x) {
        for (int j = 1; j <= x; j++) {
            for (int i = 1; i <= x - j; i++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= j; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

