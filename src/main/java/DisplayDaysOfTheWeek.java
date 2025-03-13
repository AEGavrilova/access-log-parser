import java.util.Locale;

public class DisplayDaysOfTheWeek {
    public static void main(String[] args) {
        printDays("понедельник");
    }
    public static String printDays(String x) {
        switch (x.toLowerCase(Locale.ROOT)) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресение");
                break;
            default:
                System.out.println("это не день недели");
                break;
        }
        return x;
    }
}
