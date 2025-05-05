package StreamAPI.St2;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics();

        stats.logVisit(1620000000, "Mozilla/5.0 (Windows NT 10.0)", "192.168.1.1", "https://google.com/search");

        System.out.println("Пиковая посещаемость: " + stats.getPeakVisitsPerSecond());

        Set<String> referrers = stats.getReferringDomains();
        System.out.println("Рефереры:");
        referrers.forEach(System.out::println);

        System.out.println("Макс. посещений одним пользователем: " + stats.getMaxVisitsBySingleUser());
    }
}