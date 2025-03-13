public class TripleAmount {
    public static void main(String[] args) {
        System.out.println(sum3(8, 1, 4));
    }
    public static boolean sum3(int x, int y, int z){
        if (x == y + z) return true;
        if (y == x + z) return true;
        if (z == x + y) return true;
        return false;
    }
}
