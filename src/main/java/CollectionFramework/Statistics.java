package CollectionFramework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Statistics {
    private static final Set<String> existingPages = new HashSet<>();

    private static final Map<String, Integer> osFrequency = new HashMap<>();
    private static int totalEntries = 0;

    public static void addEntry(LogEntry entry) {
        if (entry.getStatusCode() == 200) {
            existingPages.add(entry.getPath());
        }

        String os = entry.getOperatingSystem();
        osFrequency.put(os, osFrequency.getOrDefault(os, 0) + 1);
        totalEntries++;
    }

    public static Set<String> getExistingPages() {
        return new HashSet<>(existingPages);
    }

    public static Map<String, Double> getOsStatistics() {
        Map<String, Double> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : osFrequency.entrySet()) {
            result.put(entry.getKey(), (double) entry.getValue() / totalEntries);
        }
        return result;
    }

    static class LogEntry {
        private final int statusCode;
        private final String path;
        private final String operatingSystem;

        public LogEntry(int statusCode, String path, String operatingSystem) {
            this.statusCode = statusCode;
            this.path = path;
            this.operatingSystem = operatingSystem;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getPath() {
            return path;
        }

        public String getOperatingSystem() {
            return operatingSystem;
        }
    }

    public static void main(String[] args) {
        LogEntry entry1 = new LogEntry(200, "/home", "Windows");
        LogEntry entry2 = new LogEntry(200, "/about", "Linux");
        LogEntry entry3 = new LogEntry(404, "/missing", "MacOS");
        LogEntry entry4 = new LogEntry(200, "/contact", "Windows");
        LogEntry entry5 = new LogEntry(200, "/home", "Android");

        addEntry(entry1);
        addEntry(entry2);
        addEntry(entry3);
        addEntry(entry4);
        addEntry(entry5);

        Set<String> pages = getExistingPages();
        Map<String, Double> osStats = getOsStatistics();

        System.out.println("Существующие страницы (status 200):");
        pages.forEach(System.out::println);

        System.out.println("\nСтатистика операционных систем:");
        osStats.forEach((os, proportion) ->
                System.out.printf("%s: %.2f (%.0f%%)%n",
                        os, proportion, proportion * 100));
    }
}