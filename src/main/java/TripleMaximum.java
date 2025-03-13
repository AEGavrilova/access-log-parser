public class TripleMaximum {
    public static void main(String[] args) {
        System.out.println(max3(8, 1, 4));
    }
    public static int max3(int x, int y, int z){
        if (x >= y && x >= z) {
            return x;
        }
        if (y >= x && y >= x) {
            return y;
        }
        return z;
    }
}
