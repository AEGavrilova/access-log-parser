public class TheMagicSix {
    public static void main(String[] args) {
        System.out.println(magic6(1, 6));
    }
    public static boolean magic6(int x, int y){
      if (x + y == 6) return true;
      if (x - y == 6) return true;
      if (y - x == 6) return true;
      if (x == 6) return true;
      if (y == 6) return true;
      return false;
    }
}
