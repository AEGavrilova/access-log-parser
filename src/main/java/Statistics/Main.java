package Statistics;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Statistics.addEntry(new LogEntry("/index.html", 200, "Chrome"));
        Statistics.addEntry(new LogEntry("/about.html", 404, "Firefox"));
        Statistics.addEntry(new LogEntry("/contact.html", 200, "Chrome"));
        Statistics.addEntry(new LogEntry("/old-page.html", 404, "Safari"));
        Statistics.addEntry(new LogEntry("/products.html", 200, "Chrome"));
        Statistics.addEntry(new LogEntry("/old-link.html", 404, "Chrome"));

        System.out.println("Non-existing pages: " + Statistics.getNonExistingPages());

        HashMap<String, Double> browserStats = Statistics.getBrowserStatistics();
        System.out.println("Browser statistics:");
        for (String browser : browserStats.keySet()) {
            System.out.printf("%s: %.2f%%\n", browser, browserStats.get(browser) * 100);
        }
    }
}

class Statistics {
    private static HashSet<String> nonExistingPages = new HashSet<>();
    private static HashMap<String, Integer> browserUsageCount = new HashMap<>();

    public static void addEntry(LogEntry entry) {
        if (entry.getStatusCode() == 404) {
            nonExistingPages.add(entry.getPath());
        }

        String browser = entry.getBrowser();
        browserUsageCount.put(browser, browserUsageCount.getOrDefault(browser, 0) + 1);
    }

    public static HashSet<String> getNonExistingPages() {
        return nonExistingPages;
    }

    public static HashMap<String, Double> getBrowserStatistics() {
        HashMap<String, Double> browserStatistics = new HashMap<>();

        int total = browserUsageCount.values().stream().mapToInt(Integer::intValue).sum();

        for (String browser : browserUsageCount.keySet()) {
            double ratio = (double) browserUsageCount.get(browser) / total;
            browserStatistics.put(browser, ratio);
        }

        return browserStatistics;
    }
}

class LogEntry {
    private String path;
    private int statusCode;
    private String browser;

    public LogEntry(String path, int statusCode, String browser) {
        this.path = path;
        this.statusCode = statusCode;
        this.browser = browser;
    }

    public String getPath() {
        return path;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBrowser() {
        return browser;
    }
}