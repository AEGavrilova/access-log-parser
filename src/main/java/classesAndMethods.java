//public class classesAndMethods {
//    public static int sumLastNums(int x) {
//        return x + 1;
//    }
//    public static void main(String[] args) {
//        int x = 4568 % 10; // х будет иметь значение 8
//        int y = 4568 / 10; // у будет иметь значение 456
//        int z = x + y; //464
//        int sumOne = z % 10; //4
//        int sumTwo = z / 10; //46
//        System.out.println(sumOne + sumTwo); //50
//    }
//}

public class classesAndMethods {
    public static int sumLastNums(int x){
    int y= x%10;
    int z = (x/10)%10;
    return y+z;
    }
    public static void main(String[] args) {
        int x = 123;
        System.out.println(sumLastNums(x));
    }

}