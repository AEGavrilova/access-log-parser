public class CapitalLetter {
    public static void main(String[] args) {
        System.out.println(isUpperCase('F'));
    }

    public static boolean isUpperCase(char ch){
        return ch>='A'&&ch<='Z';
    }
}
