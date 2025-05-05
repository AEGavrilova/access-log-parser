package StreamAPI;

import java.time.Instant;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class Statistics {
    private int totalVisits;
    private int errorRequests;
    private Set<String> uniqueUserIPs;
    private Instant earliestTime;
    private Instant latestTime;

    public Statistics() {
        this.totalVisits = 0;
        this.errorRequests = 0;
        this.uniqueUserIPs = new HashSet<>();
        this.earliestTime = null;
        this.latestTime = null;
    }

    public void addEntry(String logEntry) {
        LogEntry entry = parseLogEntry(logEntry);
        if (entry == null) return;

        updateTimePeriod(entry.getTimestamp());

        boolean isBot = entry.getUserAgent().toLowerCase().contains("bot");

        if (!isBot) {
            totalVisits++;
            uniqueUserIPs.add(entry.getIpAddress());
        }

        if (entry.getStatusCode() >= 400 && entry.getStatusCode() < 600) {
            errorRequests++;
        }
    }

    public double getAverageVisitsPerHour() {
        long hours = getTimePeriodHours();
        if (hours == 0) return 0.0;
        return (double) totalVisits / hours;
    }

    public double getAverageErrorRequestsPerHour() {
        long hours = getTimePeriodHours();
        if (hours == 0) return 0.0;
        return (double) errorRequests / hours;
    }

    public double getAverageVisitsPerUser() {
        if (uniqueUserIPs.isEmpty()) return 0.0;
        return (double) totalVisits / uniqueUserIPs.size();
    }

    private long getTimePeriodHours() {
        if (earliestTime == null || latestTime == null) return 0;
        return Duration.between(earliestTime, latestTime).toHours();
    }

    private void updateTimePeriod(Instant timestamp) {
        if (earliestTime == null || timestamp.isBefore(earliestTime)) {
            earliestTime = timestamp;
        }
        if (latestTime == null || timestamp.isAfter(latestTime)) {
            latestTime = timestamp;
        }
    }

    private LogEntry parseLogEntry(String logEntry) {
        try {
            String[] parts = logEntry.split(" ", 4);
            if (parts.length < 4) return null;

            return new LogEntry(
                    parts[0],
                    parts[1],
                    Integer.parseInt(parts[2]),
                    Instant.parse(parts[3])
            );
        } catch (Exception e) {
            System.err.println("Error parsing log entry: " + logEntry);
            return null;
        }
    }

    private static class LogEntry {
        private final String ipAddress;
        private final String userAgent;
        private final int statusCode;
        private final Instant timestamp;

        public LogEntry(String ipAddress, String userAgent, int statusCode, Instant timestamp) {
            this.ipAddress = ipAddress;
            this.userAgent = userAgent;
            this.statusCode = statusCode;
            this.timestamp = timestamp;
        }

        public String getIpAddress() { return ipAddress; }
        public String getUserAgent() { return userAgent; }
        public int getStatusCode() { return statusCode; }
        public Instant getTimestamp() { return timestamp; }
    }

    public static void main(String[] args) {
        Statistics stats = new Statistics();

        String[] sampleLogs = {
                "192.168.1.1 Chrome 200 2023-01-01T10:00:00Z",
                "192.168.1.2 Firefox 404 2023-01-01T11:00:00Z",
                "192.168.1.1 Chrome 200 2023-01-01T12:00:00Z",
                "192.168.1.3 bot 200 2023-01-01T12:30:00Z",
                "192.168.1.4 Safari 500 2023-01-01T13:00:00Z"
        };

        for (String log : sampleLogs) {
            stats.addEntry(log);
        }

        System.out.printf("Average visits per hour: %.2f%n", stats.getAverageVisitsPerHour());
        System.out.printf("Average error requests per hour: %.2f%n", stats.getAverageErrorRequestsPerHour());
        System.out.printf("Average visits per user: %.2f%n", stats.getAverageVisitsPerUser());
        System.out.println("Unique users: " + stats.uniqueUserIPs.size());
    }
}