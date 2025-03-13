public class Age {
    public static void main(String[] args) {
        System.out.println(age(31));
    }

    public static String age(int x) {
        String old = "";
        int z = x % 10;
        boolean isExclusion = (x % 100 >= 11) && (x % 100 <= 14);
        if (z == 1)
            old = "год";
        else if(z == 0 || z >= 5 && z <= 9)
            old = "лет";
        else if(z >= 2 && z <= 4)
            old = "года";
        if (isExclusion)
            old = "лет";
        return x + " " + old;
    }
}
