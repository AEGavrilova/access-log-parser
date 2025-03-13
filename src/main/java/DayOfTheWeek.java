public class DayOfTheWeek {
    public static void main(String[] args) {
        System.out.println(day(4));
    }
    public static String day(int x) {
        int day = x;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Понедельник";
                break;
            case 2:
                dayName = "Вторник";
                break;
            case 3:
                dayName = "Среда";
                break;
            case 4:
                dayName = "Четверг";
                break;
            case 5:
                dayName = "Пятница";
                break;
            case 6:
                dayName = "Суббота";
                break;
            case 7:
                dayName = "Воскресенье";
                break;
            default:
                dayName = "Неверный день";
                break;
        }
        return dayName;
    }
}
