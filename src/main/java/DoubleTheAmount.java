public class DoubleTheAmount {
    public static void main(String[] args) {
        System.out.println(sum2(5, 7));
    }
    public static int sum2(int x, int y){
        if((x+y)>=10 && (x+y)<=19) return 20;
        return x + y;
    }
}
